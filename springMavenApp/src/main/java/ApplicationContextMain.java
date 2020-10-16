

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) {
		
		/*
		 * ApplicationContext객체생성
		 * 	- BeanFactory객체 생성
		 * 	- Spring Container객체 생성
		 */
		System.out.println("---------------- Spring Container 초기화 시작 ---------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill0/context/0.applicationContext.xml");
		System.out.println("------------ Spring Container 초기화 끝 -----------");
		
	}

}
