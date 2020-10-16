package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestRemoveActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/********************guest_remove_action.do******************/
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("guest_main.do");
			forwardPath="redirect:guest_main.do";
		}else {
		    try{
			    String guest_noStr = request.getParameter("guest_no");
			    GuestService guestService=new GuestService();
			    guestService.deleteGuest(Integer.parseInt(guest_noStr));
			    //response.sendRedirect("guest_list.do");
			    forwardPath="redirect:guest_list.do";
		    }catch(Exception e){
		    	e.printStackTrace();
		    	//response.sendRedirect("guest_error.do");
		    	forwardPath="redirect:guest_error.do";
		    }
		}
		return forwardPath;
	}

}
