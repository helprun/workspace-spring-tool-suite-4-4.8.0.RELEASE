package com.itwill.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDaoMyBatis {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.itwill.user.mapper.UserMapper.";
	
	public UserDaoMyBatis() {
		try {
			InputStream myBatisInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			sqlSessionFactory = ssfb.build(myBatisInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//create
	public int create(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertRowCount = sqlSession.insert(NAMESPACE + "insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	//read
	public ArrayList<User> findUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> resultList = sqlSession.selectList(NAMESPACE + "findAllUsers"); 
		ArrayList<User> userList = (ArrayList<User>) resultList;
		sqlSession.close();
		return userList;
	}
	
	public User findUser(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User findUser = sqlSession.selectOne(NAMESPACE + "findUserById",userId);
		sqlSession.close();
		return findUser;
	}
	//update
	public int update(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateRowCount = sqlSession.update(NAMESPACE + "updateUser", user);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	//delete
	public int remove(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteRowCount = sqlSession.delete(NAMESPACE + "deleteUser", userId);
		sqlSession.commit();
		sqlSession.close();
		return deleteRowCount;
	}
	
	public boolean existedUser(String userId) {
		boolean isExistedUser = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int userCount = sqlSession.selectOne(NAMESPACE + "existedUser", userId);
		sqlSession.close();
		if (userCount == 1) {
			isExistedUser = true;
		}
		return isExistedUser;
	}
}
