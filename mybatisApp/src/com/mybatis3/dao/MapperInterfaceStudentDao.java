package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MapperInterfaceStudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	
	public MapperInterfaceStudentDao() {
		InputStream mybatisConfigInputStream;
		try {
			mybatisConfigInputStream =
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			sqlSessionFactory = ssfb.build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.findAllStudents();
		sqlSession.close();
		return students;
	}
	
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student findStudent = studentMapper.findStudentById(studId);
		/*
		Student findStudent = 
				sqlSession.selectOne(NAMESPACE + "findStudentById",studId);
		*/
		sqlSession.close();
		return findStudent;
	}
	 
	
}
