<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext,request, session, application
	pageContext.setAttribute("int1", 10);
	pageContext.setAttribute("int2", 20);
	pageContext.setAttribute("double1", 0.5);
	pageContext.setAttribute("double2", 3.14159);
	pageContext.setAttribute("String1", "KIM");
	pageContext.setAttribute("String2", "KYUNG HO");
	pageContext.setAttribute("married", true);
	pageContext.setAttribute("age", 30);
	pageContext.setAttribute("weight", 72.56214);
	
	Guest guest = null;
	Guest[] emptyArray = new Guest[0];
	String emptyStr = "";
	ArrayList emptyList = new ArrayList();
	HashMap emptyMap = new HashMap();
	
	pageContext.setAttribute("nullGuest", guest);
	pageContext.setAttribute("emptyArray", emptyArray);
	pageContext.setAttribute("emptyStr", emptyStr);
	pageContext.setAttribute("emptyList", emptyList);
	pageContext.setAttribute("emptyMap", emptyMap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL literal(변수), 연산자</h1><hr/>
<ul>
	<li>---------EL 변수--------</li>
	<li>${int1}</li>
	<li>${int2}</li>
	<li>${number}</li>
	<li>---------EL 리터럴(상수)--------</li>
	<li>${21484836}</li>
	<li>${5.69851}</li>
	<li>${'문자'}</li>
	<li>${"문자"}</li>
	<li>${'name'}</li>
	<li>${name}</li>
	<li>---------EL 연산자--------</li>
	<li>${int1 + int2 + 10}</li>
	<li>${int1 - int2}</li>
	<li>${int1/int2}</li>
	<li>${(int1*int2)/3 - 90}</li>
	<li>${1/2}</li>
	<li>${double1/double2}</li>
	<li>${age >= 30}</li>
	<li>${age < 30}</li>
	<li>${age gt 30}</li>
	<li>${age lt 30}</li>
	<li>${age le 30}</li>
	<li>${age ge 30}</li>
	<li>${age >= 30 && age <40}</li>
	<li>${age >= 30 and age <40}</li>
	<li>${(age >= 30 && age < 40) || (weight >= 70 && weight < 80)}</li>
	<li>---------empty--------</li>
	<li>${empty nullGuest}</li>
	<li>${empty emptyArray}</li>
	<li>${empty emptyStr}</li>
	<li>${empty emptyList}</li>
	<li>${empty emptyMap}</li>
	<li>${empty null}</li>
	<li>${empty ""}</li>
	<li>${empty ''}</li>
	<li>${not empty ''}</li>
	<li>${!empty ''}</li>
</ul>
</body>
</html>