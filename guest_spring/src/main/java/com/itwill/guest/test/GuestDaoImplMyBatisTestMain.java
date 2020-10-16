package com.itwill.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.GuestDao;

public class GuestDaoImplMyBatisTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/application-context.xml");
		GuestDao guestDao = applicationContext.getBean(GuestDao.class);
		System.out.println(guestDao.selectAll());
	}

}
