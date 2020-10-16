package com.itwill1.bean.create;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) throws Exception {
		
		/*
		 * ApplicationContext객체생성
		 * 	- BeanFactory객체 생성
		 * 	- Spring Container객체 생성
		 */
		System.out.println("---------------- Spring Container 초기화 시작 ---------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill1/bean/create/1.bean-create.xml");
		System.out.println("------------ Spring Container 초기화 끝 -----------");
		
		System.out.println("------------ scope[singleton] -----------");
		SingletonScopeBean singletonScopeBean1 = 
				(SingletonScopeBean) applicationContext.getBean("singletonBean");
		SingletonScopeBean singletonScopeBean2 = 
				(SingletonScopeBean) applicationContext.getBean("singletonBean");
		System.out.println(singletonScopeBean1);
		System.out.println(singletonScopeBean2);
		
		/*
		System.out.println("------------ scope[prototype] -----------");
		SingletonScopeBean prototypeScopeBean1 = 
				(SingletonScopeBean) applicationContext.getBean("prototypeBean");
		SingletonScopeBean prototypeScopeBean2 = 
				(SingletonScopeBean) applicationContext.getBean("prototypeBean");
		System.out.println(prototypeScopeBean1);
		System.out.println(prototypeScopeBean2);
		*/
		System.out.println("------------ init- method, destroy-method -----------");
		DisposableBean context = (DisposableBean) applicationContext;
		context.destroy();
		
	}
}
