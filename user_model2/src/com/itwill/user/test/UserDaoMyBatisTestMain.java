package com.itwill.user.test;

import com.itwill.user.User;
import com.itwill.user.UserDaoMyBatis;

public class UserDaoMyBatisTestMain {

	public static void main(String[] args) {
		UserDaoMyBatis userDao = new UserDaoMyBatis();
//		System.out.println(userDao.findAllUsers());
//		userDao.updateUser(new User("guard4", "4444수정", "김경호4수정", "update4@naver.com"));
		userDao.remove("guard4");
		System.out.println(userDao.findUserList());
		System.out.println(userDao.findUser("pure1"));
		System.out.println(userDao.existedUser("pure1"));
	}

}
