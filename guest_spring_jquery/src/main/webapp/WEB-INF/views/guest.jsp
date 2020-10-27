<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>WELCOME TO JQUERY</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="guest.css" type="text/css" media="screen" />
<style type="text/css">
input.error, textarea.error {
	border: 1px solid red;
}

label.error {
	margin-left: 10px;
	color: orange;
}

.valid {
	border: 1px solid green;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script type="text/javascript">
	/*****browser locale[navigator.language] 에따른message 동적설정***/
</script>
<script type="text/javascript">
	/**********방명록리스트 ajax요청[html]************/
	function guest_list_html_function() {
		$.ajax({
			url:'guest_list_html',
			method:'GET',
			dataType:'html',
			data:null,
			success:function(htmlData){
				$('#guest_list').html(htmlData);
			}
			
		});
	}
	/**********방명록리스트 ajax요청[JSON]************/
	function guest_list_json_function() {
		$.ajax({
			url: 'guest_list_json',
			method:'GET',
			dataType:'json',
			success:function(jsonArray){
				/*
				<div class="guest_item">
					<h3 class="guest_title"  guest_no="1"><a href=''>방명록 사용법1[JSON]</a></h3>
				</div>
				*/
				var html='';
				$.each(jsonArray, function(i, guest) {
					html+="<div class=\"guest_item\">";
					html+="<h3 class=\"guest_title\"  guest_no=\""+guest.guest_no+"\"><a href=\"\">"+guest.guest_title+"[JSON]</a></h3>";
					html+="</div>";
				});
				$('#guest_list').html(html);
				
			}
		});
	}
	/**********방명록리스트 ajax요청[XML]************/
	function guest_list_xml_function() {
		/*
		<guest_list>
			<guest>
				<guest_no>169</guest_no>
				<guest_name>jQuery연습3</guest_name>
				<guest_date>2020-10-22 16:57:06</guest_date>
				<guest_email>asdg</guest_email>
				<guest_homepage>asdg</guest_homepage>
				<guest_title>asdg</guest_title>
				<guest_content>asdg</guest_content>
			</guest>
		</guest_list>
		
		<div class="guest_item">
			<h3 class="guest_title"  guest_no="1"><a href=''>방명록 사용법1[XML]</a></h3>
		</div>
		*/
		$.ajax({
			url : 'guest_list_xml',
			method : 'GET',
			dataType : 'xml',
			success : function(xmlDoc) { //xml Document가 들어온다
				var $jqXmlDoc = $(xmlDoc); // 앞에 $가 붙으면 jQueryWrapper객체
				var html = '';
				
				$jqXmlDoc.find('guest').each(function(i, guestE) { 
					// guest를 찾아서 guest마다 no와 title을 찾는다 //guestE == 표준객체
					var guest_no = $(guestE).find('guest_no').text();
					var guest_title = $(guestE).find('guest_title').text();

					html += "<div class=\"guest_item\">";
					html += "<h3 class=\"guest_title\"  guest_no=\""+
							 guest_no +"\"><a href=''>"+ 
							 guest_title +"[XML]</a></h3>";
					html += "</div>";
				});
				
				$('#guest_list').html(html);
				
			}
		})
	}
	/*********방명록 쓰기폼로드 ajax요청*****************/
	function guest_insert_form_load_function() {
		$('#guest_list').load('guest_insert_form.html');
	}

	/**********방명록상세보기[HTML]************/
	function guest_detail_html_function(h3E) {
		var guest_no = $(h3E).attr('guest_no');
		var params='guest_no='+guest_no;
		if($(h3E).parent().children().length > 1){
			//상세정보존재
			$(h3E).next().children().slideToggle(500);
			
		}else{
			//상세정보존재안함(ajax요청)
			$.ajax({
				url:'guest_detail_html',
				data:params,
				method:'GET',
				dataType:'html',
				success:function(htmlData){
					$(h3E).parent().append(htmlData);
					$(h3E).next().children().slideToggle(500);
					
				}
			});
		}
		
	}
	/**********방명록상세보기[JSON]************/
	function guest_detail_json_function(h3E) {
		var guest_no = $(h3E).attr('guest_no');
		var params='guest_no='+guest_no;
		if($(h3E).parent().children().length > 1){
			//상세정보존재
			$(h3E).next().children().slideToggle(500);
			
		}else{
			//상세정보존재안함(ajax요청)
			$.ajax({
				url:'guest_detail_json',
				data:params,
				method:'GET',
				dataType:'json',
				success:function(jsonArray){
					var html = "";
					$.each(jsonArray, function(i, guest) {
						html += "<div class = 'guest_detail'>";
						html += "<div class=\"guest_date\">";
						html += "날짜:" + guest.guest_date + "";
						html += "</div>";
						html += "<div class=\"guest_name\">";
						html += "이름:" + guest.guest_name + "";
						html += "</div>";
						html +="<div class=\"guest_email\">";
						html += "이메일:" + guest.guest_email + "";
						html += "</div>";
						html += "<div class=\"guest_homepage\">";
						html += "홈페이지:" + guest.guest_homepage + "";
						html += "</div>";
						html +="<div class=\"guest_content\">";
						html +="내용:" + guest.guest_content + "";
						html +="</div>";
						html +="<div class=\"guest_delete\">";
						html +="<input type=\"button\" value=\"삭제\" guest_no = \"" + guest.guest_no + "\">";
						html +="<input type=\"button\" value=\"수정\" guest_no = \"" + guest.guest_no + "\">";
						html +="</div>";
						html +="</div>";
					})
					
					$(h3E).parent().append(html);
					$(h3E).next().children().slideToggle(500);
					
				}
			});
		}
		
	}
	/**********방명록상세보기[XML]************/
	function guest_detail_xml_function(h3E) {
		var guest_no = $(h3E).attr('guest_no');
		var params='guest_no='+guest_no;
		if($(h3E).parent().children().length > 1){
			//상세정보존재
			$(h3E).next().children().slideToggle(500);
			
		}else{
			//상세정보존재안함(ajax요청)
			$.ajax({
				url:'guest_detail_xml',
				data:params,
				method:'GET',
				dataType:'xml',
				success:function(xmlDoc){
					var $jqXmlDoc = $(xmlDoc);
					var html = "";

					$jqXmlDoc.find('guest').each(function(i, guestE) {
						
						html += "<div class = 'guest_detail'>";
						html += "<div class=\"guest_date\">";
						html += "날짜:" + $(guestE).find('guest_date').text() + "";
						html += "</div>";
						html += "<div class=\"guest_name\">";
						html += "이름:" + $(guestE).find('guest_name').text() + "";
						html += "</div>";
						html +="<div class=\"guest_email\">";
						html += "이메일:" + $(guestE).find('guest_email').text() + "";
						html += "</div>";
						html += "<div class=\"guest_homepage\">";
						html += "홈페이지:" + $(guestE).find('guest_homepage').text() + "";
						html += "</div>";
						html +="<div class=\"guest_content\">";
						html +="내용:" + $(guestE).find('guest_content').text() + "";
						html +="</div>";
						html +="<div class=\"guest_delete\">";
						html +="<input type=\"button\" value=\"삭제\" guest_no = \"" + $(guestE).find('guest_no').text() + "\">";
						html +="<input type=\"button\" value=\"수정\" guest_no = \"" + $(guestE).find('guest_no').text() + "\">";
						html +="</div>";
						html +="</div>";
					})
					
					$(h3E).parent().append(html);
					$(h3E).next().children().slideToggle(500);
					
				}
			});
		}
	}

	/*********방명록 쓰기*****************/
	function guest_write_action_function() {
		console.log($('#guest_write_form').serialize());
		$.ajax({
			url:'guest/guest_insert_action.jsp',
			data:$('#guest_write_form').serialize(),
			method:'POST',
			dataType:'text',
			success:function(resultStr){
				if(resultStr.trim()=='true'){
					guest_list_html_function();
				}else if(resultStr=='false'){
					alert('insert fail');
				}
			},
			error:function(){
				
			}
		});
	}
	/*********방명록 쓰기[validator plugin]*****************/
	function guest_write_action_validation_function() {

	}
	/*********방명록 로그인*****************/
	function guest_login_action_function() {
		
	}
	
	/*%%%%%%%%%%%%%%%%%%%DOM트리로딩후 메뉴이벤트처리%%%%%%%%%%%%%%%%%%%%%%*/ 
	$(function() {
		guest_list_html_function();
		/************login logoutUI*************/
		/************login logout이벤트I*************/
		/**방명록리스트[html]이벤트처리**/
		$('#menu-a a').click(function(e){
			guest_list_html_function();
			e.preventDefault();
		});
		/**방명록리스트[JSON]이벤트처리**/
		$('#menu-b a').click(function(e){
			guest_list_json_function();
			e.preventDefault();
		});
		/**방명록리스트[XML]이벤트처리***/
		$('#menu-c a').click(function(e){
			guest_list_xml_function();
			e.preventDefault();
		});
		

		/**방명록쓰기이벤트처리[동적이벤트처리]******/
		// 현재DOM Tree에 동적이벤트추가에는 항상 상위엘레멘트의 참조가필요
		$('#guest_list').on('submit','#guest_write_form',function(e){
			guest_write_action_function();
			e.preventDefault();
		});
		/**방명록상세보기이벤트처리[동적이벤트처리]******/
		// 현재DOM Tree에 동적이벤트추가에는 항상 상위엘레멘트의 참조가필요
		$('#guest_list').on('click','.guest_title a',function(e){
			var h3E = e.target.parentNode;
			var guest_no = e.target.parentNode.getAttribute('guest_no');
			console.log('guest_no:'+guest_no);
			
			var titleStr=$(e.target).text();
			if(titleStr.endsWith('[HTML]')){
				guest_detail_html_function(h3E);
			}else if(titleStr.endsWith('[JSON]')){
				guest_detail_json_function(h3E);
			}else if(titleStr.endsWith('[XML]')){
				guest_detail_xml_function(h3E);
			}
			e.preventDefault();
		});
		/**방명록삭제(수정)이벤트처리[동적이벤트처리]******/
		$('#guest_list').on('click',".guest_delete input[value='삭제']",function(e){
			alert('삭제:'+this.getAttribute('guest_no'));
		});
		$('#guest_list').on('click',".guest_delete input[value='수정']",function(e){
			alert('수정폼:'+this.getAttribute('guest_no'));
		});
		/**방명록로그아웃이벤트처리******/
		

		/**방명록쓰기폼이벤트처리******/
		$('#menu-d a').click(function(e){
			guest_insert_form_load_function();
		});
		
		/**방명록로그인이벤트처리*******/
		
		/************form validator**************
		 https://jqueryvalidation.org/
		    1. .validate() function은 DOM tree loading시에 미리 호출되어있어야한다.
		    2. .validate() function은 DOM tree insert 될때 미리 호출되어있어야한다.
		 *****************************************/
		/**방명록로그인이벤트처리.validate() function 호출[validator plugin]**/

		/**방명록쓰기이벤트처리.validate() function 호출[validator plugin]**/

		/****************jQuery ajax global event handler************/
		$(document).ajaxStart(function(){
			console.log('div element jQuery wrapper:'+$("<div id='loading'>loading...</div>"));
			$("<div id='loading'>loading...</div>").insertBefore('#guest_list').show();
			/*
			<<< jQuery factory functin에 들어갈수있는인자>>>
	 			1 . $('#id')   		: css selector문자열
	 			2 . $(document)		: 표준객체
	 			3 . $(function(){})	: 함수
	 			4 . $('<div></div>'): 태그문자열
	 		    	div element jQuery wrapper객체생성
			*/
		});
		$(document).ajaxComplete(function(){
			$('#loading').hide();
			$('#loading').remove();
		});
		$(document).ajaxSuccess(function(){});
		$(document).ajaxError(function(){});
	});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>WELCOME TO JQUERY</h1>
		</div>
		<div id="sidebar">

			<h2>회원관리메뉴</h2>
			<div class="menus">
				<div class="menu" id="menu-a">
					<h3>
						<a href="test.jsp">방명록 리스트[html]</a>
					</h3>
				</div>
				<div class="menu" id="menu-b">
					<h3>
						<a href="#">방명록 리스트[json]</a>
					</h3>
				</div>
				<div class="menu" id="menu-c">
					<h3>
						<a href="#">방명록 리스트[xml]</a>
					</h3>
				</div>
				<div class="menu" id="menu-d">
					<h3>
						<a href="#">방명록 쓰기</a>
					</h3>
				</div>

				<div class="menu" id="menu-e">
					<h3>
						<a href="#">json</a>
					</h3>
				</div>

				<div class="menu" id="menu-f">
					<h3>
						<a href="#">xml</a>
					</h3>
				</div>

				<form id="guest_login_form" method="get" action="vfbfcv">
					<fieldset>
						<legend>로그인</legend>
						<p>
							<label for="guest_id">아이디:</label> <input type="text"
								placeholder="아이디" id="guest_id" name="guest_id" />
						</p>
						<p>
							<label for="guest_pass">패쓰워드:</label> <input type="text"
								placeholder="패쓰워드" name="guest_pass" id="guest_pass" />
						</p>
						<p>
							<input type="submit" name="write" value="로그인" id="write" /> <input
								type="reset" name="cancle" value="취소" id="cancle" />

						</p>
						<div id="msg"></div>
					</fieldset>
				</form>
				<form id="guest_logout_form">
					<div>
						<span id="idSpan"></span>님 로그인<br /> <a href='#'>로그아웃</a>
					</div>
				</form>
			</div>
		</div>
		<div id="content">
			<div id="guest_list">
				
			</div>
		</div>
		<div id="footer">
			<p>This page was built for jquery demonstration purposes.</p>
		</div>

	</div>

</body>
</html>
