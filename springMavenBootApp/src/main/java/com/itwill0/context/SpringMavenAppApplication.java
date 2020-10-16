package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMavenAppApplication {

	public static void main(String[] args) {
		/************** spring이 제어(제어역행/IoC) *****************/
		System.out.println("-------------------Spring Container 초기화 시작----------------------");
		ApplicationContext applicationContext = 
				SpringApplication.run(SpringMavenAppApplication.class, args);
		System.out.println("-------------------Spring Container 초기화 끝----------------------");
		System.out.println(applicationContext);
		
		ProductService productService = 
				(ProductService) applicationContext.getBean("productService");
		productService.list();
		/************ 개발자가 제어를 한다 *************
		ProductDao productDao = new ProductDao();
		ProductService productService = new ProductService();
		productService.setProductDao(productDao);
		productService.list();
		************************************************/
	}

}
