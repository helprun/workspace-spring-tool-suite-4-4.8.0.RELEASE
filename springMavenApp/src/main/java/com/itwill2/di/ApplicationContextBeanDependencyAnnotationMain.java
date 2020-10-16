package com.itwill2.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserService;
import com.itwill.user.annotation.UserAnnotation;
import com.itwill.user.exception.UserNotFoundException;

public class ApplicationContextBeanDependencyAnnotationMain {

	public static void main(String[] args) throws Exception{
		
		/*
		 * ApplicationContext객체생성
		 * 	- BeanFactory객체 생성
		 * 	- Spring Container객체 생성
		 */
		System.out.println("---------------- Spring Container 초기화 시작 ---------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill2/di/2.bean-dependency-annotation.xml");
		System.out.println("------------ Spring Container 초기화 끝 -----------");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.findUser(null);
		
		UserAnnotation userAnnotation = 
				(UserAnnotation) applicationContext.getBean("userAnnotation");
		System.out.println("### " + userAnnotation);
	}

}
