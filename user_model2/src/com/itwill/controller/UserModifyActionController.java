package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equals("GET")){
			forwardPath = "redirect:user_main.do";
		}
		try{
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			User user=new User(userId,password,name,email);
			UserService userService=new UserService();
			int updateRowCount=userService.update(user);
			forwardPath = "redirect:user_view.do?userId="+userId;
		}catch(Exception e){
			e.printStackTrace();
			forwardPath = "redirect:user_error.do";
		}
		return forwardPath;
	}

}
