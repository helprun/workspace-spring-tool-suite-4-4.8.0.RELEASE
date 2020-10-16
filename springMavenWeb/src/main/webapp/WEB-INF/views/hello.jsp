<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello.jsp</h1><hr/>
<ol>
	<li>클라이언트 /hello.do 요청</li>
	<li>DispatcherServlet이 HandlerMapping객체로부터 
	    요청url(/hello.do)에해당하는 HelloController객체얻기</li>
	<li>DispatcherServlet이 Controller객체 handleRequest(request,response)메쏘드 호출</li>
	<li>DispatcherServlet이 HelloController객체의 
	    handleRequest()메쏘드호출후 반환된 path(forward:/WEB-INF/views/hello.jsp)로 forwarding...</li>   
	<li>/WEB-INF/views/hello.jsp 응답</li>
	<li>msg: ${msg}</li>
</ol>
</body>
</html>