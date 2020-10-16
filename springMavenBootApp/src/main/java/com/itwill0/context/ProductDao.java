package com.itwill0.context;

import org.springframework.stereotype.Component;

@Component("productDao")
public class ProductDao {
	
	public ProductDao() {
		System.out.println("### 1.ProductDao()기본 생성자");
	}
	
	public void list() {
		System.out.println("### ProductDao.list()메쏘드 호출");
	}
}
