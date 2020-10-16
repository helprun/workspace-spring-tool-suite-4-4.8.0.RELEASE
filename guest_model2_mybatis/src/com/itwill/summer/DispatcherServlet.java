package com.itwill.summer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

public class DispatcherServlet extends HttpServlet {
	public DispatcherServlet() {
		
	}
	/*
	 * Controller객체들을 저장하는 맵
	 */
	private HashMap<String, Controller> controllerMap;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		controllerMap=new HashMap<String, Controller>();
		/*
		 * web.xml에설정된 파라메타값가져오기
		 * <servlet>
				<servlet-name>controller</servlet-name>
				<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>configFile</param-name>
					<param-value>/WEB-INF/guest_controller_mapping.properties</param-value>
				</init-param>
			</servlet>
		 */
		String confileFile=config.getInitParameter("configFile");
		String configFileRealPath = 
				this.getServletContext()
				.getRealPath(confileFile);
		try {
			FileInputStream pIn=new FileInputStream(configFileRealPath);
			Properties controllerMappingProperties=new Properties();
			controllerMappingProperties.load(pIn);
			Set commandKeySet = 
					controllerMappingProperties.keySet();
			Iterator commandIterator=commandKeySet.iterator();
			System.out.println("-------------------------------------");
			while (commandIterator.hasNext()) {
				String command=(String)commandIterator.next();
				String controllerClassName = 
						controllerMappingProperties.getProperty(command);
				Class controllerClass = Class.forName(controllerClassName);
				Controller controllerObject =
						(Controller)controllerClass.newInstance();
				System.out.println(command+"="+controllerObject);
				controllerMap.put(command,controllerObject);
			}
			System.out.println("--------------------------------------");
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*
		controllerMap.put("/guest_main.do", new GuestMainController());
		controllerMap.put("/guest_write_action.do", new GuestWriteActionController());
		controllerMap.put("/guest_write_form.do", new GuestWriteFormController());
		controllerMap.put("/guest_list.do", new GuestListController());
		controllerMap.put("/guest_view.do", new GuestViewController());
		controllerMap.put("/guest_modify_form.do", new GuestModifyFormController());
		controllerMap.put("/guest_modify_action.do", new GuestModifyActionController());
		controllerMap.put("/guest_remove_action.do", new GuestRemoveActionController());
		controllerMap.put("/guest_errr.do", new GuestErrorController());
		*/
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		/*
		 * 1.클라이언트의 요청URI를  사용해서 요청분석(구분)
		 */
		String requestURI = request.getRequestURI();
		String contextPath= request.getContextPath();
		String command =requestURI.substring(contextPath.length());
		/*
		 * 2.클라이언트의 요청에따른 업무실행(XXService),forwardPath
		 */
		String forwardPath="";
		Controller controller=controllerMap.get(command);
		forwardPath=controller.handleRequest(request, response);
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




