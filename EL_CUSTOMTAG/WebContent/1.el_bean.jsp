<%@page import="com.itwill.bean.Car"%>
<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Guest g = new Guest(1, "KIM", "2020", "guard@gmail.com", "naver.com", "타이틀", "내용");
 Student s = new Student(1, "LEE", 28, new Car(111, "SM5", "RED"));
 Date d = new Date();
 
 request.setAttribute("guest", g);
 request.setAttribute("student", s);
 request.setAttribute("date", d);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Bean객체 출력</title>
</head>
<body>
<h1>EL Bean객체 출력</h1>
<ul>
	<li>---------NO EL-------------</li>
	<li>
	<%
		Guest guest = (Guest)request.getAttribute("guest");
		out.println(guest);
	%>
	</li>
	<li><%=guest.getGuest_no() %></li>
	<li><%=guest.getGuest_name() %></li>
	<li><%=guest.getGuest_email()%></li>
	<li><%=guest.getGuest_homepage() %></li>
	<li><%=guest.getGuest_title() %></li>
	<li><%=guest.getGuest_content() %></li>
	
	<li>-------------EL------------</li>
	<li>${guest.getGuest_no()}</li>
	<li>${guest.getGuest_name()}</li>
	<li>${guest.getGuest_email()}</li>
	<li>${guest.getGuest_homepage()}</li>
	<li>${guest.getGuest_title()}</li>
	<li>${guest.getGuest_content()}</li>
	
	<li>-------------EL------------</li>
	<li>${guest.guest_no}</li>
	<li>${guest.guest_name}</li>
	<li>${guest.guest_email}</li>
	<li>${guest.guest_homepage}</li>
	<li>${guest.guest_title}</li>
	<li>${guest.guest_content}</li>
	
	<li><%-- ${guest.xxx}--%></li>
	<li>javax.el.PropertyNotFoundException: 타입 [com.itwill.bean.Guest]에서 프로퍼티 [xxx]을(를) 찾을 수 없습니다.</li>
	<li>----------Student------------</li>
	<li>${student.no}</li>
	<li>${student.irum}</li>
	<li>${student.age}</li>
	<li>${student.car}</li>
	<li>${student.car.no}</li>
	<li>${student.car.model}</li>
	<li>${student.car.color}</li>
	
	<li>----------date------------</li>
	<li>${date}</li>
	<li>${date.year + 1900}년</li>
	<li>${date.month + 1}월</li>
	<li>${date.day}일</li>
</ul>
</body>
</html>