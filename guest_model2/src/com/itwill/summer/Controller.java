package com.itwill.summer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 모든 컨트롤러가 구현해야 하는 인터페이스(규칙)
 * Controller 구현객체는 DispatcherServlet이 구현객체의 메쏘드를 호출해서 업무실행
 * Controller 구현객체는 DispatcherServlet에게 forwardPath를 바환
 */
public interface Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
