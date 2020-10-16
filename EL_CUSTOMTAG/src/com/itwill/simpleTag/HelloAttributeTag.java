package com.itwill.simpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloAttributeTag extends TagSupport{
	private String name;
	
	public HelloAttributeTag() {
		System.out.println("1.HelloAttributeTag() 생성자");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("1.HelloAttributeTag().setName("+name+")");
		this.name = name;
	}
	
	@Override
	public int doStartTag() throws JspException {
		String msg = "";
		if (name == null) {
			name = "GUEST";
		}
		if (name.equals("권순수")) {
			msg = "잘생긴 " + name + " 님 안녕하세요!!<br>";
		} else {
			msg = name + " 님 안녕하세요!<br>";
		}
		
		try {
			pageContext.getOut().println(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().println("<hr>");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return super.doEndTag();
	}
	
}
