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
	text-align: center;
	color: blue;
}

ul {
	list-style: none;
	padding-left: 0px;
}

/*
	2. class selector
	*/
h1.titleBackClass {
	background-color: yellow;
}

/*
	3.id selector
	*/
#content {
	border: 1px solid black;
	width: 80%;
	margin-top: 50px;
	margin-right: auto;
	margin-left: auto;
	margin-bottom: 50px;
	padding: 20px;
}

#newsDiv {
	padding-left: 9%;
	border: 1px solid blue;
	font-size: 13pt;
	background: orange;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function showNewsDiv() {
		document.querySelector('#newsDiv').style.display = 'block';
	}

	function hideNewsDiv() {
		document.querySelector('#newsDiv').style.display = 'none';

	}

	function requestNews() {
		$.ajax({
			url : '05.newsTitlesCSV',
			method : 'GET',
			dataType : 'text',
			success : function(newsCSV) {
				var newsCSVArray = newsCSV.split('#');
				var newsCount = newsCSVArray[0];
				if (newsCount.trim() == '0') {
					return;
				}
				var newsListArray = newsCSVArray[1].split('|'); // '|' = broken pipe
				var html = "<ul>";
				for (var i = 0; i < newsListArray.length; i++) {
					var newsArray = newsListArray[i].split(',');
					html += "<li>" + newsArray[0] + "[" + newsArray[1] + "("
							+ newsArray[2] + ")] CSV </li>";
				}
				html += "</ul>";
				document.querySelector('#newsDiv').innerHTML = html;
			}
		});
	}

	$(function() {
		hideNewsDiv();
		setInterval(requestNews, 2000);
	});
</script>
</head>
<body>
	<div id="content">
		<h1 class="titleBackClass" onmouseover="showNewsDiv();"
			onmouseout="hideNewsDiv();">실시간늬우스[CSV]</h1>
		<hr>
		<div id="newsDiv" class="titleBackClass">
			<!-- <ul>
			<li>뉴스1[조상일보]2019-10-07</li>		
			<li>뉴스2[동앙일보]2019-10-07</li>		
			<li>뉴스3[중상일보]2019-10-07</li>		
		</ul> -->
		</div>
	</div>
</body>
</html>