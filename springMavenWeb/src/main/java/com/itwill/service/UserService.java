package com.itwill.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
public class UserService {
	private MessageSource messageSource;
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public void create()  throws UserExistedException{
		/*
			user.existed.exception = {0} 는 존재하는 아이디 입니다.
			user.existed.exception = {0} User ID already exist.
		 */
//		Locale locale = Locale.getDefault(); real OS의 locale
		Locale locale=LocaleContextHolder.getLocale();
		String msg=messageSource.getMessage("user.existed.exception", 
				new Object[] {"xxx"}, locale);
		System.out.println("### UserService msg:"+msg);
		throw new UserExistedException(msg);
		
		
		
	}

	
}
