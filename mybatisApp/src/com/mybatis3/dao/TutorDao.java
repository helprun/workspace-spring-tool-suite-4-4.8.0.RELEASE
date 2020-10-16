package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Tutor;

public class TutorDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.TutorMapper.";
	
	public TutorDao() {
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
	
	public Tutor findTutorByIdWithCoursesAndAddress(Integer tutorId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Tutor tutor = 
				sqlSession.selectOne(NAMESPACE + "findTutorByIdWithCoursesAndAddress", tutorId);
		sqlSession.close();
		return tutor;
	}
}













