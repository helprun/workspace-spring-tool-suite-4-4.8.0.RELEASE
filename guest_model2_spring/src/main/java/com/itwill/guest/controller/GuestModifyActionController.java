package com.itwill.guest.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

import oracle.sql.DATE;

public class GuestModifyActionController implements Controller {
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
			try{
				String guest_noStr=request.getParameter("guest_no");
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
				int updateRowCount=
						guestService.updateGuest(
									new Guest(Integer.parseInt(guest_noStr),
										guest_name,"",
										guest_email,guest_homepage,
										guest_title,guest_content));
				forwardPath = "redirect:guest_view.do?guest_no="+guest_noStr;
//				forwardPath = "redirect:guest_view.do";
			}catch(Exception e){
				e.printStackTrace();
				forwardPath = "redirect:guest_error.do";
			}
		}
		mv.setViewName(forwardPath);
		return mv;
	}
}