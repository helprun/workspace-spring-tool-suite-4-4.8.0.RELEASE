package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDaoDynamicSql {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapperDynamicSql.";
	
	public StudentDaoDynamicSql() {
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
	
	public List<Student> findStudents (Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> students = sqlSession.selectList(NAMESPACE + "findStudents", student);
		sqlSession.close();
		return students;
	}
	public List<Student> findStudensOrder (String columnName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> students = sqlSession.selectList(NAMESPACE + "findStudensOrder", columnName);
		sqlSession.close();
		return students;
	}
	
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int updateRowCount = sqlSession.update(NAMESPACE + "updateStudentById", updateStudent);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	
}












