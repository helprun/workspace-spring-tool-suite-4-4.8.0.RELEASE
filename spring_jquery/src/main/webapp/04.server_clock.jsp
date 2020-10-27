<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function requestServerTime(){
		//sendRequest('04.server_clock.jsp', null, responseServerTime, 'GET');
		$.ajax({
			url: '04.server_clock',
			method: 'GET',
			success: function(serverTimeStr) {
				$('#serverTimeSpan').text(serverTimeStr);
			}
		})
	}
	
	$(function(){
		/******************window.setInterval[반복실행]********************/
		//requestServerTime();
		/* var timerId = window.setInterval(function() {
			requestServerTime();
		}, 1000); */
		window.setInterval(requestServerTime, 1000);
		
		//window.clearInterval(timerId); 반복실행 중지  
		
		/**************************************************/
		/******************window.setTimeout[한번실행]******************
		
		***************************************/
	});
</script>
</head>
<body>
<h1>clock[window.setTimeout,window.setInterval]</h1><hr/>
<div>현재서버의시간은 <span id='serverTimeSpan'>12:45:45</span></div>
</body>
</html>


