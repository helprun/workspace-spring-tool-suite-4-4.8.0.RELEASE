<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("sUserId", "guard1");
	request.setAttribute("name", "김경호");
	request.setAttribute("age", new Integer(34));
	request.setAttribute("married", new Boolean(true));
	request.setAttribute("weight", new Double(56.89));
	double height = 175.23;
	String address = "경기도민";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL String, Wrapper객체출력</h1><hr/>
<ol>
	<li>${sUserId}</li>
	<li>${name}</li>
	<li>${name.substring(1)}</li>
	<li>${age+12}</li>
	<li>${married}</li>
	<li>${weight}</li>
	<li>--EL사용불가능[속성객체가 아니므로]--</li>
	<li>${height}</li>
	<li>${address}</li>
	<li><%=height %></li>
	<li><%=address %></li>
	
</ol>
</body>
</html>