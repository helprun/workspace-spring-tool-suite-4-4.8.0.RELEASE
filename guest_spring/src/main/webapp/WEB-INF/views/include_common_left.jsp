<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <fmt:setLocale value="${pageContext.request.locale.language }" scope="session"/>
<fmt:setBundle basename="messages/guest"/> --%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<p>
	<strong><s:message code="menu.title"/></strong>
</p>
<ul>
	<li><a href="guest_list"><s:message code="menu.list"/></a></li>
	<li><a href="guest_write_form"><s:message code="menu.write"/></a></li>

</ul>