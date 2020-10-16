package com.itwill.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoImplTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
		UserDao userDao = applicationContext.getBean(UserDao.class);
		System.out.println(userDao.findUserList());
//		System.out.println(userDao.existedUser("asdfqwerasd"));
//		System.out.println(userDao.update(new User("pure1", "수정수정", "수정수정", "수정수정")));
//		System.out.println(userDao.findUser("pure1"));
//		System.out.println(userDao.create(new User("hehe", "1234", "헤헤", "헤헤")));
//		System.out.println(userDao.remove("hehe"));
//		System.out.println(userDao.findUser("hehe"));
		
	}

}
