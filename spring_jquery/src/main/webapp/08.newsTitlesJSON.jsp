<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/*
	1.tag selector
	*/
	h1{
		color: blue;
		text-align: center;
	}
	ul{
		list-style: none;
		padding-left: 0px;
	}
	/*
	2. class selector
	*/
	.titleBackClass{
		background-color: yellow;
	}
	/*
	3.id selector
	*/
	#content{
		display: block;
		border: 1px solid black;
		background-color: silver;
		width: 800px;
		margin-left: auto;
		margin-right: auto;
		padding:  20px 20px 20px 20px;
	}
	#newsDiv{
		padding-left: 10%;
		border: 1px solid blue;
		font-size: 13pt;
		background: orange;
	}
	
</style>
<!-- 
<script type="text/javascript" src="httpRequest.js"></script>
 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function showNewsDiv() {
		document.getElementById("newsDiv").style.display = 'block';
	}
	function hideNewsDiv() {
		document.getElementById("newsDiv").style.display = 'none';
	}
	
	function requestNews() {
		$.ajax({
			url : '08.newsTitlesJSON',
			method : 'GET',
			dataType : 'json', //없으면 응답의 header를 보고 parsing한다
			success : function(jsonObject) { //json object로 알아서 parsing해준다
				if (jsonObject.count == 0) {
					return;
				}
				var newsJsonArray = jsonObject.data;
				var html = "<ul>";
				for (var i = 0; i < newsJsonArray.length; i++) {
					var newsJsonObject = newsJsonArray[i];
					var titleStr = newsJsonObject.newsTitle;
					var companyStr = newsJsonObject.company;
					var dateStr = newsJsonObject.date;
					html += "<li>" + titleStr + "[" +companyStr + "(" + dateStr + ") ] JSON </li>";
				}
				html += "</ul>";
				document.querySelector('#newsDiv').innerHTML = html;
			}
		})
	}
	
	$(function() {
		setInterval(requestNews, 2000);
		//hideNewsDiv();
	});
	
</script>
</head>
<body>
<div id="content">
	<h1 class="titleBackClass" >실시간늬우스[JSON]</h1><hr>
	<div id="newsDiv">
		<ul>
			<li>뉴스1[조상일보]2019-10-07</li>		
			<li>뉴스2[동앙일보]2019-10-07</li>		
			<li>뉴스3[중상일보]2019-10-07</li>		
		</ul>
	</div>
</div>
</body>
</html>