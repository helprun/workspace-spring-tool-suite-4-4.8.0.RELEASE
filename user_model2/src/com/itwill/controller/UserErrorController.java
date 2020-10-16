package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserErrorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse respoonse) {
		return "forward:/WEB-INF/views/user_errpr.jsp";
	}

}
