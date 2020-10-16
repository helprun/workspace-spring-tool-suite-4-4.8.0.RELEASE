package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestModifyActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:guest_main.do";
		} else {
			try{
				GuestService guestService = new GuestService();
				String guest_noStr=request.getParameter("guest_no");
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
				int updateRowCount=
						guestService.updateGuest(
									new Guest(Integer.parseInt(guest_noStr),
										guest_name,null,
										guest_email,guest_homepage,
										guest_title,guest_content));
				forwardPath = "redirect:guest_view.do?guest_no="+guest_noStr;
//				forwardPath = "redirect:guest_view.do";
			}catch(Exception e){
				e.printStackTrace();
				forwardPath = "redirect:guest_error.do";
			}
		}
		return forwardPath;
	}
}