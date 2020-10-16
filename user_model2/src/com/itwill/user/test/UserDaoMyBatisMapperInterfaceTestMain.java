package com.itwill.user.test;

import com.itwill.user.User;
import com.itwill.user.UserDaoMyBatisMapperInterface;

public class UserDaoMyBatisMapperInterfaceTestMain {

	public static void main(String[] args) {

		UserDaoMyBatisMapperInterface userDao = new UserDaoMyBatisMapperInterface();
		System.out.println(userDao.findAllUsers());
		System.out.println(userDao.findUserById("pure1"));
		System.out.println(userDao.existedUser("pure1"));
//		System.out.println(userDao.create(new User("pure2", "pure2", "pure2", "pure2")));
//		System.out.println(userDao.update(new User("pure2", "2222", "권퓨어2", "권퓨어2")));
//		System.out.println(userDao.remove("pure2"));
//		System.out.println(userDao.findUserById("pure2"));
	}

}
