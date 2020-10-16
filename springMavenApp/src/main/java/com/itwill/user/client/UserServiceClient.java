package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserServiceClient {
	public static void main(String[] args) throws Exception{		
		ApplicationContext factory = 
			new ClassPathXmlApplicationContext("com/itwill/user/client/99.user.xml");
		UserService userService = (UserService)factory.getBean("userService");
		userService.findUser("id");
		userService.remove("id");
		userService.findUserList();
		
	}
}
