package com.itwill.simpleTag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	public HelloTag() {
		System.out.println("1.HelloTag() 기본생성자");
	}
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("2.doStartTag()");
		JspWriter out = pageContext.getOut();
		HttpSession session = pageContext.getSession();
		String sUserId = (String)session.getAttribute("sUserId");
		if (sUserId == null) {
			sUserId = "GUEST";
		}
		try {
			out.println(sUserId + " 님 안녕하세요<br>");
			
		} catch (Exception e) {
			
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("3.doEndTag()");
		JspWriter out = pageContext.getOut();
		try {
			out.println("<hr>");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return super.doEndTag();
	}
}

