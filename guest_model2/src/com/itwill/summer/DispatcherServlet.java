package com.itwill.summer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 모든 요청의 진입점(단일 Controller)
 
 */
public class DispatcherServlet extends HttpServlet {
	public DispatcherServlet() {
		System.out.println("0.DispatcherServlet 객체 생성자 호출");
	}
	/*
	 * Controller객체를 저장하는 맵
	 */
	private HashMap<String, Controller> controllerMap;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		controllerMap = new HashMap<String, Controller>();
		
		/*
		 * web.xml에 설정된 파라메타값가져오기
		 */
		String configFile = config.getInitParameter("configFile");
		String configFileRealPath = 
				this.getServletContext().getRealPath(configFile);
		try {
			FileInputStream pIn = new FileInputStream(configFileRealPath);
			Properties controllerMappingProperties = new Properties();
			controllerMappingProperties.load(pIn);
			Set commandkeySet = controllerMappingProperties.keySet();
			Iterator commandIterator = commandkeySet.iterator();
			while (commandIterator.hasNext()) {
				String command = (String)commandIterator.next();
				String controllerClassName = 
						controllerMappingProperties.getProperty(command);
				Class controllerClass = Class.forName(controllerClassName);
				Controller controllerObject = 
						(Controller) controllerClass.newInstance();
				System.out.println(command + "----->" + controllerObject);
				controllerMap.put(command, controllerObject);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
		controllerMap.put("/guest_error.do", new GuestErrorController());
		*/
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.클라이언트의 요청URI을 사용해서 요청분석(구분)
		 */
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		/*
		 * 2.클라이언트의 요청에 따른 업무실행(XXXService),forwardPath
		 */
		String forwardPath = "";
		Controller controller = controllerMap.get(command);
		forwardPath = controller.handleRequest(request, response);
		
		/*
		 * 3. JSP forward or redirect
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];
		if (forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
