<%@ page language="java" contentType="text/html; charset=UTF-8 "
    pageEncoding="UTF-8"%>
<%--@ taglib uri="http://www.itwill.co.kr/jsp/simpleTag"  
		   prefix="simple"--%>
<%@ taglib uri="/WEB-INF/simpleTag.tld" prefix="simple"%>
<%
	session.setAttribute("sUserId", "guard");
	session.setAttribute("irum", "고소미");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>custom tag[사용자 정의 태그]</h1><hr/>
----------------------hello--------------------<br>
<simple:hello/>
<simple:hello/>
----------------------helloAttr--------------------<br>
<simple:helloAttr/>
<simple:helloAttr name="권순수"/>
<simple:helloAttr name="장동건"/>
<simple:helloAttr name="${irum}"/>
----------------------if tag[body]--------------------<br>
<simple:if test= "true">
	반드시 실행<br>
</simple:if>
<simple:if test= "false">
	반드시 안실행
</simple:if>

<simple:if test="${sUserId!=null}">
	${sUserId}님 안녕하세요!!!<br>
</simple:if>
<simple:if test="${sUserId==null}">
	GUEST님 안녕하세요!!!<br>
</simple:if>

<simple:if test="${sUserId != null}">
	<a href="logout.jsp">${sUserId}님 로그아웃</a>
</simple:if>
<simple:if test="${sUserId == null}">
	<a href="login_form.jsp">로그인</a>
</simple:if>


</body>
</html>