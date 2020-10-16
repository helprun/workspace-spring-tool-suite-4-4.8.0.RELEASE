<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Guest g1 = new Guest(1, "KIM", "2020", "guard1@gmail.com", "naver.com", "타이틀1", "내용1");
	Guest g2 = new Guest(2, "SIM", "2021", "guard2@gmail.com", "oaver.com", "타이틀2", "내용2");
	Guest g3 = new Guest(3, "DIM", "2022", "guard3@gmail.com", "paver.com", "타이틀3", "내용3");
	
	ArrayList<Guest> guestList = new ArrayList<Guest>();
	guestList.add(g1);
	guestList.add(g2);
	guestList.add(g3);
	
	HashMap<String,Guest> guestMap = new HashMap<String,Guest>();
	guestMap.put("g1", g1);
	guestMap.put("g2", g2);
	guestMap.put("g3", g3);
	
	request.setAttribute("guestList", guestList);
	pageContext.setAttribute("i", 23);
	request.setAttribute("guestMap", guestMap);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL ArrayList(배열),Map, 배열객체출력</h1>
<ol>
	<li>----------ArrayList---------</li>
	<li>${guestList}</li>
	<li>${guestList[0]}</li>
	<li>${guestList[0].guest_no}</li>
	<li>${guestList[0].guest_name}</li>
	<li>${guestList[0].guest_email}</li>
	<li>${guestList[0].guest_homepage}</li>
	<li>${guestList[0].guest_title}</li>
	<li>${guestList[0].guest_content}</li>
	<li>${guestList[i]}</li>
	<li>${guestList[i].guest_no}</li>
	<li>${guestList[i].guest_name}</li>
	<li>${guestList[i].guest_email}</li>
	<li>${guestList[i].guest_homepage}</li>
	<li>${guestList[i].guest_title}</li>
	<li>${guestList[i].guest_content}</li>
	<%for(int j = 0; j < 3; j++) { 
		request.setAttribute("j", j);%>
		<li>${guestList[j].guest_no}</li>
	<%} %>
	<li>----------Map---------</li>
	<li>${guestMap}</li>
	<li>${guestMap[g1]}</li>
	<li>${guestMap['g1'].guest_no}</li>
	<li>${guestMap['g1'].guest_name}</li>
	
	<li>${guestMap}</li>
	<li>${guestMap[g2]}</li>
	<li>${guestMap['g2'].guest_no}</li>
	<li>${guestMap['g2'].guest_name}</li>
	
	<li>${guestMap.g3}</li>
	<li>${guestMap.g3.guest_no}</li>
	<li>${guestMap.g3.guest_name}</li>
</ol>
</body>
</html>