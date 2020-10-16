package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	
	public HelloController() {
		System.out.println("### 1. HelloController()기본 생성자");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("### 2. HelloController.handleRequest()메쏘드 실행");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/views/hello.jsp");
		request.setAttribute("msg", "안녕하세요");
		return mv;
	}

}
