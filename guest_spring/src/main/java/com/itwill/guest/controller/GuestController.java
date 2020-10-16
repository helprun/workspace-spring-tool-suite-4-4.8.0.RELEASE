package com.itwill.guest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;

	@RequestMapping("/guest_error")
	public String guestError() {
		return "guest_error";
	}

	@RequestMapping("/guest_list")
	public String guestList(HttpServletRequest request) throws Exception {
		String forwardPath = "";
			ArrayList<Guest> guestList = guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "guest_list";
		return forwardPath;
	}

	@RequestMapping("/guest_main")
	public String guestMain() {
		return "guest_main";
	}

	@RequestMapping("/guest_view")
	public String guestView(HttpServletRequest request, @RequestParam String guest_no) throws Exception {
		String forwardPath = "";
//		String guest_noStr = request.getParameter("guest_no");
		if (guest_no == null || guest_no.equals("")) {
			forwardPath = "redirect:guest_list";
		} else {
				Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
				request.setAttribute("guest", guest);
				forwardPath = "guest_view";
		}
		return forwardPath;
	}

	@RequestMapping("/guest_write_form")
	public String guestWriteForm() {
		return "guest_write_form";
	}

	@RequestMapping(value = "/guest_write_action", method = RequestMethod.GET)
	public String guestWriteActionUsingGET() {
		return "redirect:guest_main";
	}

	@RequestMapping(value = "/guest_write_action", method = RequestMethod.POST)
	public String guestWriteActionUsingPOST(HttpServletRequest request, @ModelAttribute Guest guest) throws Exception {
		String forwardPath = "";
//			String guest_name = request.getParameter("guest_name");
//			String guest_email = request.getParameter("guest_email");
//			String guest_homepage = request.getParameter("guest_homepage");
//			String guest_title = request.getParameter("guest_title");
//			String guest_content = request.getParameter("guest_content");
			guestService.insertGuest(guest);
			forwardPath = "redirect:guest_list";
		return forwardPath;
	}

	@RequestMapping(value = "guest_remove_action", method = RequestMethod.GET)
	public String removeGuestUsingGET() {
		return "redirect:guest_list";
	}

	@RequestMapping(value = "guest_remove_action", method = RequestMethod.POST)
	public String removeGuestUsingPOST(HttpServletRequest request, @RequestParam String guest_no) throws Exception {
		String forwardPath = "";
			guestService.deleteGuest(Integer.parseInt(guest_no));
			// response.sendRedirect("guest_list.do");
			forwardPath = "redirect:guest_list";
		
		return forwardPath;
	}

	@RequestMapping(value = "/guest_modify_form", method = RequestMethod.GET)
	public String accessingGuestModifyFormUsingGET() {
		return "redirect:guest_main";
	}

	@RequestMapping(value = "/guest_modify_form", method = RequestMethod.POST)
	public String accessingGuestModifyFormUsingPOST(HttpServletRequest request, @RequestParam String guest_no)
			throws Exception {
		String forwardPath = "";
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
		request.setAttribute("guest", guest);
		forwardPath = "guest_modify_form";

		return forwardPath;
	}

	@RequestMapping(value = "/guest_modify_action", method = RequestMethod.GET)
	public String modifyGuestUsingGET() {
		return "redirect:guest_main";
	}

	@RequestMapping(value = "/guest_modify_action", method = RequestMethod.POST)
	public String modifyGuestUsingPOST(@ModelAttribute Guest guest, @RequestParam String guest_no, Model model)
			throws Exception {
		String forwardPath = "";
		model.addAttribute("guest_no", guest_no);

		// request.setCharacterEncoding("UTF-8");
//				String guest_noStr=request.getParameter("guest_no");
//				String guest_name=request.getParameter("guest_name");
//				String guest_email=request.getParameter("guest_email");
//				String guest_homepage=request.getParameter("guest_homepage");
//				String guest_title=request.getParameter("guest_title");
//				String guest_content=request.getParameter("guest_content");
		guestService.updateGuest(guest);
		forwardPath = "redirect:guest_view";

		return forwardPath;
	}

	@ExceptionHandler(Exception.class)
	public String guest_error_handle(Exception e) {
		return "guest_error";
	}
}
