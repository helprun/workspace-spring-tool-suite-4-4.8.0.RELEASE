package com.itwill.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user_error")
	public String errorPage() {
		return "user_error";
	}
	
	@RequestMapping("/user_list")
	public String displayUserList(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		ArrayList<User> userList=userService.findUserList();
		request.setAttribute("userList", userList);
		forwardPath = "user_list";
		return forwardPath;
	}
	
	@RequestMapping("/user_main")
	public String userMain() {
		return "user_main";
	}
	
	@RequestMapping("/user_login_form")
	public String userLoginForm() {
		return "user_login_form";
	}
	
	@RequestMapping(value = "/user_login_action", method = RequestMethod.GET)	
	public String userLoginByGET() {
		return "redirect:user_login_form";
	}
	@RequestMapping(value = "/user_login_action", method = RequestMethod.POST)	
	public String userLoginByPOST(HttpServletRequest request, @RequestParam String userId, @RequestParam String password) {
			String forwardPath = "";
			try{
				User loginUser = userService.login(userId, password);
				HttpSession session = request.getSession();
				session.setAttribute("sUserId", userId);
				session.setAttribute("sUser", loginUser);
				forwardPath = "redirect:user_main";
			}catch(UserNotFoundException e){
				request.setAttribute("msg1", e.getMessage());
				request.setAttribute("fuser",new User(userId,password,"",""));
				forwardPath = "user_login_form";
			}catch(PasswordMismatchException e){
				request.setAttribute("msg2", e.getMessage());
				request.setAttribute("fuser",new User(userId,password,"",""));
				forwardPath = "user_login_form";
			}catch(Exception e){
				e.printStackTrace();
				forwardPath = "redirect:user_error";
			}
		
		return forwardPath;
		
	}
	@RequestMapping("/user_logout_action")
	public String logOut(HttpSession session) {
		String forwardPath = "";
		session.invalidate();
		forwardPath = "redirect:user_main";
		return forwardPath;
	}
	@RequestMapping(value = "/user_modify_form", method = RequestMethod.GET)
	public String accessingModifyFormByGET() {
		return "redirect:user_main";
	}
	@RequestMapping(value = "/user_modify_form", method = RequestMethod.POST)
	public String accessingModifyFormByPOST(HttpServletRequest request) {
		String forwardPath = "";
		try {
			String userId=request.getParameter("userId");
			User user=userService.findUser(userId);
			request.setAttribute("user", user);
			forwardPath = "user_modify_form";
		} catch (Exception e) {
			forwardPath = "redirect:user_error";
			e.printStackTrace();
		}
		return forwardPath;
	}
	@RequestMapping(value = "/user_modify_action", method = RequestMethod.GET)
	public String modifyUserByGET() {
		return "redirect:user_main";
	}
	
	@RequestMapping(value = "/user_modify_action", method = RequestMethod.POST)
	public String modifyUserByPOST(@ModelAttribute User user, Model model) {
		String forwardPath = "";
		try{
			/*
			 * String userId=request.getParameter("userId"); String
			 * password=request.getParameter("password"); String
			 * name=request.getParameter("name"); String
			 * email=request.getParameter("email"); User user=new
			 * User(userId,password,name,email);
			 */
			userService.update(user);
			model.addAttribute("userId", user.getUserId());
			forwardPath = "redirect:user_view";
		}catch(Exception e){
			e.printStackTrace();
			forwardPath = "redirect:user_error";
		}
		return forwardPath;
	}
	@RequestMapping("/user_view")
	public String viewUser(HttpServletRequest request) {
		String forwardPath = "";
		String userId = request.getParameter("userId");
		if(userId==null|| userId.equals("")){
			forwardPath = "redirect:user_main";
		}
		User user=null;
		try{
			user = userService.findUser(userId);
			request.setAttribute("user", user);
			forwardPath = "user_view";
		}catch(UserNotFoundException e){
			request.setAttribute("eMessage", e.getMessage());
			forwardPath = "user_view";
			e.printStackTrace();
		} catch (Exception e) {
			forwardPath = "redirect:user_error";
			e.printStackTrace();
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "/user_remove_action", method = RequestMethod.GET)
	public String removeUserByGET() {
		return "redirect:user_main";
	}
	
	@RequestMapping(value = "/user_remove_action", method = RequestMethod.POST)
	public String removeUserByPOST(HttpServletRequest request) {
		String forwardPath = "";
		try{
			HttpSession session = request.getSession();
			String sUserId = (String)session.getAttribute("sUserId");
			String userId=request.getParameter("userId");
			userService.remove(userId);
			if(userId.equals(sUserId)){
				//로그인 한사람일경우 로그아웃
				forwardPath = "forward:user_logout_action";
			}else{
				forwardPath = "redirect:user_list";
			}
		}catch(Exception e){
			e.printStackTrace();
			forwardPath = "redirect:user_error";
		}	
		return forwardPath;
	}
	@RequestMapping("/user_write_form")
	public String userWriteForm() {
		return "user_write_form";
	}
	
	@RequestMapping(value = "/user_write_action", method = RequestMethod.GET)
	public String writeUserByGET() {
		return "redirect:user_write_form";
	}
	
	@RequestMapping(value = "/user_write_action", method = RequestMethod.POST)
	public String writeUserByPOST(@ModelAttribute User user, HttpServletRequest request) {
		String forwardPath = "";
		
//			String userId=request.getParameter("userId");
//			String password=request.getParameter("password");
//			String name=request.getParameter("name");
//			String email=request.getParameter("email");
//			User newUser=null;
			try{
				userService.create(user);
				forwardPath = "redirect:user_login_form";
			}catch(ExistedUserException e){
				request.setAttribute("fuser", user);
				request.setAttribute("msg", e.getMessage());
				forwardPath = "user_write_form";
			}catch(Exception e){
				forwardPath = "redirect:user_error";	
				e.printStackTrace();
			}
		
		return forwardPath;
	}
}
