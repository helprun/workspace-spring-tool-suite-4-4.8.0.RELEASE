package com.itwill3.dao.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;

public class GuestDaoImplJDBCTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/guest/guest-dao-jdbc.xml");
//		applicationContext.getBean(GuestDao.class);
		GuestDao guestDao = (GuestDao)applicationContext.getBean("guestDao");
		System.out.println(guestDao.selectAll());
//		System.out.println(guestDao.selectByNo(1));
//		System.out.println(
//				guestDao.updateGuest(
//						new Guest(62, "스프링수정", null, 
//								  "spring@naver.com", "스프링홈페이지", 
//								  "스프링제목", "스프링내용")));
//		System.out.println(guestDao.selectByNo(62));
//		System.out.println(guestDao.deleteGuest(62));
//		System.out.println(guestDao.selectByNo(62));
//		System.out.println(
//				guestDao.insertGuest(
//						new Guest(0, "스프링", 
//								  null, "스프링이메일", 
//								  "스프링홈페이지", 
//								  "스프링 제목", 
//								  "스프링 내용")));
		System.out.println(guestDao.selectAll());
		
	}

}
