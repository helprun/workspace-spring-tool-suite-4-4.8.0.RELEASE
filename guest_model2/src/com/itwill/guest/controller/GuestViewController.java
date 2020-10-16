package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String guest_noStr = request.getParameter("guest_no");
		String forwardPath = "";
		if(guest_noStr==null||guest_noStr.equals("")){
			forwardPath = "redirect:guest_list.do";
		} else {
			
			try {
				GuestService guestService = new GuestService();
				Guest guest= guestService.selectByNo(Integer.parseInt(guest_noStr));
				
				request.setAttribute("guest", guest);
				forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
			} catch (Exception e) {
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
				e.printStackTrace();
			}
		}
		return forwardPath;
	}

}
