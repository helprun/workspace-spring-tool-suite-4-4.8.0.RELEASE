package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class GuestMainController implements Controller{
	
	public String handleRequest(HttpServletRequest request,
								HttpServletResponse response) {
		/********************guest_main.do********************/
		String forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}

}
