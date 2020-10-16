package com.itwill1.bean.annotation;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component("createBean2")
@DependsOn("createBean3")
public class CreateBean2 {
	public CreateBean2() {
		System.out.println("### CreateBean2()기본생성자");
	}
	public void method1() {
		System.out.println("### CreateBean2.method1()메쏘드호출");
	}
}
