package com.itwill1.bean.annotation;

import org.springframework.stereotype.Component;

@Component("createBean3")
public class CreateBean3 {
	public CreateBean3() {
		System.out.println("### CreateBean3() 기본생성자");
	}
	public void method1()	{
		System.out.println("### CreateBean3()method1()메쏘드호출");
	}
}
