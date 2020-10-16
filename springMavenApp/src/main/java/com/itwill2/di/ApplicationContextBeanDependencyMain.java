package com.itwill2.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserService;
import com.itwill.user.exception.UserNotFoundException;

public class ApplicationContextBeanDependencyMain {

	public static void main(String[] args) throws Exception{
		
		/*
		 * ApplicationContext객체생성
		 * 	- BeanFactory객체 생성
		 * 	- Spring Container객체 생성
		 */
		System.out.println("---------------- Spring Container 초기화 시작 ---------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill2/di/2.bean-dependency.xml");
		System.out.println("------------ Spring Container 초기화 끝 -----------");
		System.out.println("-------- Constructor Injection ----------");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.create(null);
		userService.findUser(null);
		System.out.println(applicationContext.getBean("constructorUser1"));
		
		System.out.println("--------- Setter Injection ---------");
		UserService setUserService = (UserService) applicationContext.getBean("setUserService");
		userService.create(null);
		userService.findUser(null);
		System.out.println(applicationContext.getBean("setUser2"));
		
		CollectionMapInjectionBean cmibean = 
				(CollectionMapInjectionBean) applicationContext.getBean("collectionMapInjectionBean");
		cmibean.print();
		
	}

}
