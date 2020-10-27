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
h1 {
	color: blue;
	text-align: center;
}

ul {
	list-style: none;
	padding-left: 0px;
}
/*
	2. class selector
	*/
.titleBackClass {
	background-color: yellow;
}
/*
	3.id selector
	*/
#content {
	display: block;
	border: 1px solid black;
	background-color: silver;
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	padding: 20px 20px 20px 20px;
}

#newsDiv {
	padding-left: 10%;
	border: 1px solid blue;
	font-size: 13pt;
	background: orange;
}
</style>
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
			url : '07.newsTitlesXML',
			method : 'GET',
			dataType : 'XML',
			success : function(xmlDocument) {
				//XML에서 꺼내는 유일한 방법
				var countNodeList = xmlDocument.getElementsByTagName('count');
				var countElement = countNodeList.item(0);
				var countText = countElement.firstChild; //Object(TextNode)반환
				var countStr = countText.nodeValue;
				
				if (countStr.trim() == 0) {
					return;
				}
				
				var newsNodeList = xmlDocument.getElementsByTagName('news');
				var html = "<ul>"
				for (var i = 0; i < newsNodeList.length; i++) {
					var titleStr = newsNodeList.item(i).
								   getElementsByTagName('newsTitle').
								   item(0).
								   firstChild.nodeValue;
					
					var companyStr = newsNodeList.item(i)
									 .getElementsByTagName('company')
									 .item(0)
									 .firstChild
									 .nodeValue;
					
					var dateStr = newsNodeList.item(i)
									 .getElementsByTagName('date')
									 .item(0)
									 .firstChild
									 .nodeValue;
					html += "<li>" + titleStr + "[" + companyStr + "(" + dateStr + ")] XML </li>";
				}
				html += "</ul>";
				document.querySelector('#newsDiv').innerHTML = html;
			}
		});
	}
	$(function() {
		setInterval(requestNews, 2000);
		//hideNewsDiv();
	});
</script>
</head>
<body>
	<div id="content">
		<h1 class="titleBackClass">실시간늬우스[XML]</h1>
		<hr>
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