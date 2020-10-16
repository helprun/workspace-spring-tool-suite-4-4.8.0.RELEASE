package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestViewController implements Controller {
	private GuestService guestService;
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String guest_noStr = request.getParameter("guest_no");
		String forwardPath = "";
		if(guest_noStr==null||guest_noStr.equals("")){
			forwardPath = "redirect:guest_list.do";
		} else {
			
			try {
				Guest guest= guestService.selectByNo(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
			} catch (Exception e) {
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
				e.printStackTrace();
			}
		}
		mv.setViewName(forwardPath);
		return mv;
	}

}
