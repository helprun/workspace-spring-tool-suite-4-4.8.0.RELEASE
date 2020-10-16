package com.itwill0.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productService")
public class ProductService {
	private ProductDao productDao;
	public ProductService() {
		System.out.println("### 2.ProductService기본생성자 " + this);
	}
	
	@Autowired
	public void setProductDao(ProductDao productDao) {
		System.out.println("### 3. ProductService,setProductDao("+productDao+")");
		this.productDao = productDao;
	}

	public void list() {
		System.out.println("### productService.list()메쏘드 호출");
		productDao.list();
	}
}
