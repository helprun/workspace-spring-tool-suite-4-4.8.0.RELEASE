package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestModifyFormController implements Controller {
	private GuestService guestService;
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:guest_main.do";
		} else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				Guest guest= guestService.selectByNo(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
			} catch (Exception e) {
				forwardPath = "redirect:guest_error.do";
				e.printStackTrace();
			}
		}
		mv.setViewName(forwardPath);
		return mv;
	}

}
