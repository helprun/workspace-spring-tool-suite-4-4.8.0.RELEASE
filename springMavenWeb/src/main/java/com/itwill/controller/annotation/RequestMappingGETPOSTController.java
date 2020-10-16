package com.itwill.controller.annotation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestMappingGETPOSTController {
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login_form_get() {
		return "/WEB-INF/views/get_login_form.jsp";
	}
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login_action_post(HttpSession session, @RequestParam String id, @RequestParam("password") String pass) {
		System.out.println("### id parameter: " + id);
		System.out.println("### password parameter: " + pass);
		boolean isLogin = true;
		if (isLogin) {
			session.setAttribute("sUserId", id);
		}
		return "/WEB-INF/views/post_login_result.jsp";
	}
}
