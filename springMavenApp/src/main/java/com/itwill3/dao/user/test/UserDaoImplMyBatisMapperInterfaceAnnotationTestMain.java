package com.itwill3.dao.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.user.User;
import com.itwill3.dao.user.UserDao;

public class UserDaoImplMyBatisMapperInterfaceAnnotationTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext
				("com/itwill3/dao/user/user-dao-mybatis-mapper-interface-annotation.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoImplMyBatisMapperInterface");
//		System.out.println(userDao.findUserList());
//		System.out.println(userDao.update(new User("pure1", "4321", "aaaa", "수정")));
//		System.out.println(userDao.findUser("pure1"));
//		System.out.println(userDao.create(new User("새아이디", "1111", "새아이디", "새이메일")));
//		System.out.println(userDao.findUser("새아이디"));
//		System.out.println(userDao.remove("새아이디"));
//		System.out.println(userDao.findUser("새아이디"));
	}

}
