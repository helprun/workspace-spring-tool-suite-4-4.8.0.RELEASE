package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Course;
import com.mybatis3.domain.Student;

public class CourseDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.CourseMapper.";
	
	public CourseDao() {
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
	
	/*
	 <!--  resultMap: [courses + student 조인] -->
	 */
	public Course findCourseByIdWithStudents(Integer courseId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Course findCourse = sqlSession.selectOne(NAMESPACE + "findCourseByIdWithStudents", courseId);
		sqlSession.close();
		return findCourse;
	}
	public Course findCourseByIdWithStudentsAndAddr(Integer courseId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Course findCourse = sqlSession.selectOne(NAMESPACE + "findCourseByIdWithStudentsAndAddr", courseId);
		sqlSession.close();
		return findCourse;
	}
	

}









