package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:guest_write_form.do";
		} else {
			try{
				GuestService guestService = new GuestService();
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
				Guest guest=
						new Guest(-999,guest_name,
								null,guest_email,
								guest_homepage,guest_title,
								guest_content);
				int insertRowCount=
						guestService.insertGuest(guest);
				forwardPath = "redirect:guest_list.do";
			}catch(Exception e){
				e.printStackTrace();
				forwardPath = "redirect:guest_error.do";
			}
		}
		return forwardPath;
	}

}
