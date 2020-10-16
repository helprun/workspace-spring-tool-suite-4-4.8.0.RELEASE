package com.itwill.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.user.mapper.UserMapper;

public class UserDaoMyBatisMapperInterface {
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoMyBatisMapperInterface() {
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
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int insertRowCount = userMapper.insertUser(user);
		return insertRowCount;
	}
	//read
	public ArrayList<User> findAllUsers() {
//		ArrayList<User> userList = (ArrayList<User>) sqlSessionFactory.openSession().getMapper(UserMapper.class).findAllUsers();
		ArrayList<User> users = new ArrayList<User>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		users = (ArrayList<User>) userMapper.findAllUsers();
		sqlSession.close();
		return users;
	}
	
	public User findUserById(String userId) {
		User findUser = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		findUser = userMapper.findUserById(userId);
		sqlSession.close();
		return findUser;
	}
	//update
	public int update(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int updateRowCount = userMapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	//delete
	public int remove(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int removeRowCount = userMapper.deleteUser(userId);
		sqlSession.close();
		return removeRowCount;
	}
	
	public boolean existedUser(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boolean isExistUser = false;
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int userCount = userMapper.existedUser(userId);
		if (userCount == 1) {
			isExistUser = true;
		}
		return isExistUser;
	}
}
