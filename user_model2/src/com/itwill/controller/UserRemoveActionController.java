package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;

public class UserRemoveActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:user_main.do";
		}
		try{
			HttpSession session = request.getSession();
			String sUserId = (String)session.getAttribute("sUserId");
			String userId=request.getParameter("userId");
			UserService userService=new UserService();
			int removeRowCount=userService.remove(userId);
			if(userId.equals(sUserId)){
				//로그인 한사람일경우 로그아웃
				forwardPath = "forward:user_logout_action.do";
			}else{
				forwardPath = "redirect:user_list.do";
			}
		}catch(Exception e){
			e.printStackTrace();
			forwardPath = "redirect:user_error.do";
		}	
		return forwardPath;
	}

}
