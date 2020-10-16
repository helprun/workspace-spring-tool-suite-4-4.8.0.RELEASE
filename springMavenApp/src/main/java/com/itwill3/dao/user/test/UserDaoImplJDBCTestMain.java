package com.itwill3.dao.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.user.UserDao;

public class UserDaoImplJDBCTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/user-dao-jdbc.xml");
		UserDao userDao = applicationContext.getBean(UserDao.class);
		System.out.println(userDao.findUserList());
		System.out.println(userDao.existedUser("b"));
//		System.out.println(userDao.update(new User("b", "newB", "newB", "b@BBB.com")));
//		System.out.println(userDao.create(new User("spring", "1111", "spring", "spring@naver.com")));
		System.out.println(userDao.findUser("spring"));
//		System.out.println(userDao.remove("b"));
//		System.out.println(userDao.findUser("b"));
	}

}
