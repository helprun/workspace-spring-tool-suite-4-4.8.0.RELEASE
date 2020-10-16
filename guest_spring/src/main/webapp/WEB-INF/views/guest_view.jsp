<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <fmt:setLocale value="${pageContext.request.locale.language }"/>
<fmt:setBundle basename="messages/guest"/> --%>
<html>
<head>
<title><s:message code="title.main"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">
<script	src="js/guest.js"></script>
<script type="text/javascript">
	function guestRemoveAction() {
		if (window.confirm("<fmt:message key="javascript.msg.remove"/>")) {
			document.f.action = "guest_remove_action";
			document.f.method='POST';
			document.f.submit();
		}
	}
	function guestList() {
		f.action = "guest_list";
		f.submit();
	}

	function guestModifyForm() {
		document.f.action = "guest_modify_form";
		document.f.method='POST';
		document.f.submit();
	} 
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
		<!-- include_common_top.jsp start-->
		<jsp:include page="include_common_top.jsp"/>	
		<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper content start -->
		<div id="wrapper">
			



<div id="content">
	<table border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<!--contents--> <br />
				<table style="padding-left: 10px" border=0 cellpadding=0
					cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b><s:message code="title.view"/> </b></td>
					</tr>
				</table> <!-- view Form  -->
				<form name="f" method="post">
					<input type="hidden" name="guest_no" value="${guest.guest_no}" />
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><s:message code="view.label.no"/></td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${guest.guest_no}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><s:message code="view.label.name"/></td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${guest.guest_name}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><s:message code="view.label.date"/></td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${guest.guest_date.substring(0,10)} </td>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><s:message code="view.label.homepage"/></td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${guest.guest_homepage}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22"><s:message code="view.label.title"/></td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${guest.guest_title}</td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="110"><s:message code="view.label.content"/></td>
							<td width=490 bgcolor="ffffff" align="left"
								style="padding-left: 10px">${guest.guest_content}</td>
						</tr>
					</table>
				</form> <br />
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center>
						<input type="button" value="<s:message code='view.button.label.modify'/>" onClick="guestModifyForm();"> &nbsp; 
						<input type="button" value="<s:message code='view.button.label.delete'/>" onClick="guestRemoveAction();"> &nbsp; 
						<input type="button" value="<s:message code='view.button.label.list'/>" onClick="guestList()"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>


		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<%@include file="include_common_bottom.jspf" %>
			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>
