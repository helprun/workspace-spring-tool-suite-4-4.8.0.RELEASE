<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function ajaxRequestIdCheck() {
		var idStr = document.f.id.value;
		if (idStr.length == 0 || idStr.trim() == '') {
			return;
		}

		var paramString = $('#f').serialize();
		$.ajax({
			url : '02.ajaxRequest',
			async : true,
			method : 'GET',
			dataType : 'text',
			data : paramString, //parameter
			beforeSend : function() { //요청을 보내기전에 beforeSend를 실행하고 보낸다
				document.getElementById('msg').innerHTML = 'loading...';
			},
			success : responseCallBack, //완전한 응답이 도착하고 성공했을때 (익명함수를 넣는다)
			error : function() {

			}
		});

	}
	/*
	응답이 성공적으로 완전히 도착했을때 실행되는 사용자정의 콜백함수
	 */
	function responseCallBack(responseText, textStatus, xhr) {

		document.getElementById('msg').innerHTML = responseText;
		//console.log(textStatus);
		//console.log(xhr.readyState);
	}
</script>
</head>
<body>
	<h1>ajax요청</h1>
	<hr />
	<form name="f" id="f" action="">
		아이디:<input type="text" name="id" id="id"
			onkeyup="ajaxRequestIdCheck();"> <span id="msg"></span>
	</form>
</body>
</html>







