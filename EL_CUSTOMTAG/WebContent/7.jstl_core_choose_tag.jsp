<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//session.setAttribute("sUserId", "admin");
	session.setAttribute("sUserId", "guard");
	session.setAttribute("level", 1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core choose tag</h1><hr>
<c:choose>
	<c:when test="${sUserId =='admin'}">
		관리자<br>
	</c:when>
	<c:otherwise>
		일반유저<br>
	</c:otherwise>
</c:choose>
<hr>
<c:choose>
	<c:when test="${level == 1}">
		초보시군요 [${level}]<br>
	</c:when>
	<c:when test="${level == 2}">
		중수시군요[${level}]<br>
	</c:when>
	<c:when test="${level == 3}">
		고수시군요[${level}]<br>
	</c:when>
	<c:when test="${level > 3 && level <= 5}">
		초고수시군요[${level}]<br>
	</c:when>
	<c:otherwise>
		레벨은 1~5사이의 정수입니다.<br>
	</c:otherwise>
</c:choose>
<hr/>

<c:choose>
	<c:when test="${!empty sUserId }">
		<c:if test="${sUserId == 'admin' }">
			<a href="admin_logout.jsp">${sUserId}님 로그아웃</a><br>
			<a href="admin_product_delete.jsp">상품삭제</a><br>
		</c:if>
		<c:if test="${sUserId != 'admin' }">
			<a href="user_logout.jsp">${sUserId}님 로그아웃</a><br>
		</c:if>
	</c:when>
	<c:otherwise>
		<a href="user_login_form.jsp">로그인하세요</a><br>
	</c:otherwise>
</c:choose>

</body>
</html>