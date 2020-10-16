<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${pageContext.request.locale.language}"/>
<fmt:setBundle basename="com/itwill/i18n/guest"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>I18N[Internationalization] JSTL</h1><br>
<ol>
	<li><fmt:message key="title.main"/></li>
	<li><fmt:message key="title.list"/></li>
	<li><fmt:message key="title.view"/></li>
	<li><fmt:message key="title.write"/></li>
	<li>
		<fmt:message key="error.msg" >
			<fmt:param value="guard"/>
		</fmt:message>
	</li>
	<li>
		<fmt:message key="nv.bc">
			<fmt:param value="제품"/>
			<fmt:param value="제품상세"/>
		</fmt:message>
	</li>
</ol>
</body>
</html>