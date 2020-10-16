package com.itwill1.bean.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singletonBean")
@Scope("singleton")
public class SingletonScopeBean {
	public SingletonScopeBean() {
		System.out.println("### SingletonBean()기본생성자:"+this);
	}
}
