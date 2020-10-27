package com.itwill.controller.annotation;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import com.itwill.dto.Guest;

@Controller
public class ResponseController {
	/************** forward view *****************/
	@RequestMapping("/response_view_name.do")
	public String response_view_name() {
		/* 
		 << 빈의 이름에 forward:가 없을경우 >>
		 
		  0 . view name[String(/WEB-INF/views/response_view_name.jsp)]을 반환받은 
		      DispatcherServlet은 InternalResourceViewResolver객체(디폴트)에 view name을 전달한다.
		  1 . InternalResourceViewResolver 객체는 InternalResourceView 객체를 생성한다. 
		  2 . InternalResourceViewResolver 객체는 
		      InternalResourceView 객체에 view name(/WEB-INF/views/response_view_name.jsp)을
		      URL로 설정한후에 DispatcherServlet에게 반환한다.
		      (설정XML에 prefix,sufix가 존재  하면 prefix,sufix가 설정된다)
		      (설정XML에 prefix,sufix가 존재안하면 prefix,sufix가 설정되지안는다)
		  3 . DispatcherServlet 은 반환받은 InternalResourceView 객체의 render()메쏘드를 호출한다.
		      결과로 /WEB-INF/views/response_view_name.jsp로 forward된다.
		      	
		  << 빈의 이름에 forward: 가있을경우 >> servlet --forward--> servlet
		      
		  0 . view name[String(forward:xxx.do)]을 반환받은 
		      DispatcherServlet은 InternalResourceViewr객체(디폴트)에 view name을 전달한다.
		  1 . InternalResourceViewResolver 객체는 InternalResourceView 객체를 생성한다. 
		  2 . InternalResourceViewResolver 객체는 
		      InternalResourceView 객체에 view name(/WEB-INF/views/response_view_name.jsp)을
		      URL로 설정한후에 DispatcherServlet에게 반환한다.
		      (설정XML에 prefix,sufix가 존재  해도 prefix,sufix가 설정되지앟는다)
		      (설정XML에 prefix,sufix가 존재안하면 prefix,sufix가 설정되지앟는다)
		  3 . DispatcherServlet 은 반환받은 InternalResourceView 객체의 render()메쏘드를 호출한다.
		      결과로 xxx.do 로 forward된다.     
		      
		*/
		/*
		web-application-context-view-resolver.xml
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/views/"/>
			<property name="suffix" value=".jsp"/>
		</bean>
		 */
//		return "forward:/WEB-INF/views/reponse_view_name.jsp"; forward가 붙으면 viewResolver를 타지 않는다
//		return "/WEB-INF/views/reponse_view_name.jsp";
		return "response_view_name";
	}
	
	@RequestMapping("/response_view_object.do")
	public View response_view_object() {
		InternalResourceView internalResourceView = new InternalResourceView();
		internalResourceView.setUrl("/WEB-INF/views/response_view_object.jsp");
		//String == forward:/WEB-INF/views/response_view_object.jsp
		/*
		 * DispatcherServlet이 View의 render라는 메쏘드를 호출
		 */
		return internalResourceView;
	}
	/************** redirect view *****************/
	@RequestMapping("response_redirect_view_name.do")
	public String response_redirect_view_name(Model model) {
		model.addAttribute("id", "guard");
		model.addAttribute("name", "KIM");
//		model 에 붙이면 query String으로 자동으로 붙여줌
		return "redirect:response_redirect_view_name.jsp";
	}
	
	@RequestMapping("response_redirect_view_object.do")
	public View response_redirect_view_object(Model model) {
		model.addAttribute("id", "guard");
		model.addAttribute("name", "KIM");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("response_redirect_view_object.jsp");
		return redirectView;
	}
	
	/***************** xml출력 View[XMLView] ********************/
	@RequestMapping("response_xml_view_object.do")
	public View response_xml_view_object(Model model) {
		ArrayList<String> friendsList = new ArrayList<String>();
		friendsList.add("김수미");
		friendsList.add("김우미");
		friendsList.add("김미미");
		friendsList.add("김양미");
		friendsList.add("김가미");
		
		model.addAttribute("friendsList", friendsList);
		
		XMLView xmlView = new XMLView();
		return xmlView;
	}
	
	@RequestMapping("response_xml_view_name.do")
	public String response_xml_view_name(Model model) {
		ArrayList<String> friendsList = new ArrayList<String>();
		friendsList.add("김수미");
		friendsList.add("김우미");
		friendsList.add("김미미");
		friendsList.add("김양미");
		friendsList.add("김가미");
		
		model.addAttribute("friendsList", friendsList);
		
		return "xmlView";
	}
	
	/*
	 *	Controller --> MessageConverter(String, XML, JSON) --> Client 
	 */
	@RequestMapping(value = "/response_string.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String responseString() { //responsebody를 붙이면 messageconverter가 응답
		return "string response body data[한글]";
	}
	
	@RequestMapping(value = "/response_html.do", produces = "text/html;charset=UTF-8")
	public @ResponseBody String responseHtml() { 
		return "<h3>string response body data[한글]</h3><hr/>";
	}
	
	@RequestMapping(value = "/response_xml.do", produces = "text/xml;charset=UTF-8")
	@ResponseBody
	public Guest responseXml() {
		Guest guest = new Guest(1, "KIM", "1993-03-20", "akiratksk@hotmail.com", "homepage", "title", "content");
		return guest;
	}
	
}
