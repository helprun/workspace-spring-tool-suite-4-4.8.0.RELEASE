package com.itwill3.dao;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataSourceApplicationContextMain {

	public static void main(String[] args) throws Exception {
		
		/*
		 * ApplicationContext객체생성
		 * 	- BeanFactory객체 생성
		 * 	- Spring Container객체 생성
		 */
		System.out.println("---------------- Spring Container 초기화 시작 ---------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-1.spring-datasource.xml");
		System.out.println("------------ Spring Container 초기화 끝 -----------");
		DataSource apacheDataSource = 
				(DataSource) applicationContext.getBean("apacheDataSource");
		System.out.println("### 1. ApacheDataSource: " + apacheDataSource);
		System.out.println("### 2. ApacheDataSource Connection: " + apacheDataSource.getConnection());
		
		DataSource springDataSource = 
				(DataSource) applicationContext.getBean("springDataSource");
		System.out.println("### 1. springDataSource: " + springDataSource);
		System.out.println("### 2. springDataSource Connection: " + springDataSource.getConnection());
	
		
	}

}
