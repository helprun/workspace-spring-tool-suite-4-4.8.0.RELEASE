<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>


<%
	request.setAttribute("pt","page.title");
	request.setAttribute("id","guard");
	request.setAttribute("page","index.jsp");
%>
<%--
<fmt:setLocale value="en" />
<fmt:setBundle basename="messages/guest" />
<fmt:setBundle basename="messages/user" />
<fmt:setBundle basename="messages/messages"/>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring I18N[INTERNATIONALIZATION]국제화</h1><hr/>
<xmp>
	1. application-config.xml 에 messageSource빈설정 
	<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
		<property 	name="basenames" 
		  			value="messages/guest,messages/messages,messages/user"/>
	</bean>
</xmp>
<ol>
	<li><s:message code="page.title" /></li>
	<li><s:message code="${pt}"/></li>
	<li><s:message code="button.login"/></li>
	<!-- 
		exception.userexisted =  {0} 사용자가 존재합니다..!!
	 -->
	<li><s:message code="exception.userexisted" arguments="tomato"/></li>
	<li><s:message code="exception.userexisted" arguments="${id}"/></li>
	<li>
	<!-- 
		nv.bc={0}/{1}
	 -->
		<s:message code="nv.bc" 
			arguments="게스트,게스트 리스트" 
			argumentSeparator=","/>
	</li>
	<li>-----SPEL----</li>
	<li><s:message code="title.main"/> </li>
	<li><s:eval expression=
	"@messageSource.getMessage(
	'title.main',
	new Object[]{},
	new java.util.Locale('${pageContext.request.locale.language}','${pageContext.request.locale.country}'))"/> </li>
	
	<li><s:eval 
	expression=
	"@messageSource.getMessage(
	'user.existed.exception',
	new Object[]{'guard'},
	new java.util.Locale('${pageContext.request.locale.language}','${pageContext.request.locale.country}'))"/></li>
	<li>Controller에서생성한메세지:${user_existed_exception_controller_msg}</li>
	<li>Service에서생성한메세지:${user_existed_exception_service_msg}</li>

</ol>



</body>
</html>






