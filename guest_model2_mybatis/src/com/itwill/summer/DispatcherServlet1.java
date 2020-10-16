package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
/*
모든요청의 진입점(단일 Controller)
 	<<요청command>>
	/guest_main.do
	/guest_write_form.do
	/guest_write_action.do
	/guest_list.do
	/guest_view.do
	/guest_modify_form.do
	/guest_modify_action.do
	/guest_remove_action.do
	/guest_error.do
 */
public class DispatcherServlet1 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		/*
		<<요청command>>
		/guest_main.do
		/guest_write_form.do
		/guest_write_action.do
		/guest_list.do
		/guest_view.do
		/guest_modify_form.do
		/guest_modify_action.do
		/guest_remove_action.do
		/guest_error.do
		 */
		/*
		 * 1.클라이언트의 요청URI를  사용해서 요청분석(구분)
		 */
		String requestURI = request.getRequestURI();
		//System.out.println("requestURI:"+requestURI);
		String contextPath= request.getContextPath();
		//System.out.println("contextPath:"+contextPath);
		String command =requestURI.substring(contextPath.length());
		//System.out.println("command:"+command);
		/*
		 * 2.클라이언트의 요청에따른 업무실행(XXService),forwardPath
		 */
		String forwardPath="";
		/*################################################################*/
		if(command.equals("/guest_main.do")) {
			/********************guest_main.do***********************/
			forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		}else if(command.equals("/guest_write_form.do")) {
			/********************guest_write_form.do*****************/
			forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";
		}else if(command.equals("/guest_list.do")) {
			/********************guest_list.do***********************/
			try {
				GuestService guestService=new GuestService();
				ArrayList<Guest> guestList=guestService.selectAll();
				request.setAttribute("guestList", guestList);
				forwardPath="forward:/WEB-INF/views/guest_list.jsp";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}else if(command.equals("/guest_view.do")) {
			/********************guest_view.do***********************/
			String guest_noStr = request.getParameter("guest_no");
			if(guest_noStr==null||guest_noStr.equals("")){
				forwardPath="redirect:guest_list.do";
			}else {
				try {
					GuestService guestService=new GuestService();
					Guest guest=
							guestService.selectByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_view.jsp";
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
		}else if(command.equals("/guest_write_action.do")) {
			/********************guest_write_action.do******************/
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main.do";
			}else {
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				try {
					GuestService guestService = new GuestService();
					int insertRowCount = guestService
							.insertGuest(new Guest(0, guest_name, "", guest_email, guest_homepage, guest_title, guest_content));
					forwardPath="redirect:guest_list.do";
				}catch (Exception e) {
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
					e.printStackTrace();
				}
			}
		}else if(command.equals("/guest_remove_action.do")) {
			/********************guest_remove_action.do******************/
			if(request.getMethod().equalsIgnoreCase("GET")){
				//response.sendRedirect("guest_main.do");
				forwardPath="redirect:guest_main.do";
			}else {
			    try{
				    String guest_noStr = request.getParameter("guest_no");
				    GuestService guestService=new GuestService();
				    guestService.deleteGuest(Integer.parseInt(guest_noStr));
				    //response.sendRedirect("guest_list.do");
				    forwardPath="redirect:guest_list.do";
			    }catch(Exception e){
			    	e.printStackTrace();
			    	//response.sendRedirect("guest_error.do");
			    	forwardPath="redirect:guest_error.do";
			    }
			}
		}else if(command.equals("/guest_modify_form.do")) {
			/********************guest_modify_form.do******************/
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				try {
					String guest_noStr = request.getParameter("guest_no");
					GuestService guestService=new GuestService();
					Guest guest=
							guestService.selectByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
		}else if(command.equals("/guest_modify_action.do")) {
			/******************guest_modify_action.do******************/
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				try{
					//request.setCharacterEncoding("UTF-8");
					String guest_noStr=request.getParameter("guest_no");
					String guest_name=request.getParameter("guest_name");
					String guest_email=request.getParameter("guest_email");
					String guest_homepage=request.getParameter("guest_homepage");
					String guest_title=request.getParameter("guest_title");
					String guest_content=request.getParameter("guest_content");
					GuestService guestService=new GuestService();
					int updateRowCount=
							guestService.updateGuest(
										new Guest(Integer.parseInt(guest_noStr),
											guest_name,null,
											guest_email,guest_homepage,
											guest_title,guest_content));
					forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
					//forwardPath="forward:guest_view.do";
				}catch(Exception e){
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
					
				}
			}
		}else {
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		/*################################################################*/
		/*
		 * 3.JSP forward or redirect
		 */
		String [] pathArray = forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
	}
	

}
