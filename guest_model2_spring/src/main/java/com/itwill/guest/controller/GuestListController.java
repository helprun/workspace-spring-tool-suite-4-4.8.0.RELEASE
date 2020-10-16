package com.itwill.guest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestListController implements Controller {
	private GuestService guestService;
	public GuestListController() {
		System.out.println("### GuestListController: 기본생성자");
	}
	
	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestListController.setGuestService("+guestService+") 메쏘드 호출");
		this.guestService = guestService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String forwardPath = "";
		try {
			
			ArrayList<Guest> guestList = guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/views/guest_error.do";
			forwardPath = "redirect:guest_error.do";
			e.printStackTrace();
		}
		mv.setViewName(forwardPath);
		return mv;
	}
}
