package com.itwill1.bean.annotation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:com/itwill1/bean/annotation/1.bean-create-annotation.xml"})
public class SpringBootMavenApplication {

	public static void main(String[] args) {
		/***********spring이 제어를한다.[IOC]**********/
		System.out.println("-------------------Spring Container초기화시작------------------");
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootMavenApplication.class, args);
		System.out.println("-------------------Spring Container초기화끝------------------");
		/*************************************/
		
		
		
	}

}
