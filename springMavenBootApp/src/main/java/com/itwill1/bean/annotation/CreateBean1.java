package com.itwill1.bean.annotation;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("createBean1")
@DependsOn("createBean4")
public class CreateBean1 {
	public CreateBean1() {
		System.out.println("### CreateBean1()기본생성자");
	}
	public void method1() {
		System.out.println("### CreateBean1.method1()메쏘드호출");
	}
}
