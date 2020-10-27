<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>WELCOME TO JQUERY</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="guest.css" type="text/css" media="screen" />
<style type="text/css">
input.error, textarea.error {
	border: 1px dotted red;
}

label.error {
	margin-left: 10px;
	color: orange;
}

.valid {
	border: 1px dotted blue;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"/> <!-- 순서가 중요하다(jQuery다음) -->
<script type="text/javascript" src="js/additional-methods.js"/>
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
			url:'guest_insert_action',
			data:$('#guest_write_form').serialize(),
			method:'POST',
			dataType:'text',
			success:function(resultStr){
				if(resultStr.trim()=='true'){
					
					//guest_list_html_function();
					$('#guest_list').text('');
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
		$.ajax({
			url : 'guest_login_action',
			method : 'POST',
			data : $('#guest_login_form').serialize(),
			dataType : 'text',
			success : function(textData) {
				if(textData.trim() == 'success') {
					location.reload();
				} else if(textData.trim() == 'fail') {
					$('#msg').html('로그인 실패').css('color', 'red');
					$('#guest_login_form #guest_id').select(); //포커스를 준다
				}
			}/*,
			statusCode: function() {
				200:function(){console.log('200')},
				500:function(){console.log('500')},
				404:function(){console.log('404')},
				403:function(){console.log('403')}
			}  */
		 });
	}

	/*********방명록 로그아웃*****************/
	function guest_logout_action_function(){
		$.ajax({
			url : 'guest_logout_action',
			method : 'POST',
			success: function(){
				location.reload();
			}
		})
	}
	
	/*%%%%%%%%%%%%%%%%%%%DOM트리로딩후 메뉴이벤트처리%%%%%%%%%%%%%%%%%%%%%%*/ 
	$(function() {
		<c:if test='${!empty user_id}'>
			$('#guest_login_form').hide();
			$('#guest_logout_form').show();
			guest_list_html_function();
			/************login UI 이벤트*************/
	
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
	
			
			/**방명록쓰기이벤트처리[동적이벤트처리]******/
			// 현재DOM Tree에 동적이벤트추가에는 항상 상위엘레멘트의 참조가필요
			/* $('#guest_list').on('submit','#guest_write_form',function(e){
				guest_write_action_function();
				e.preventDefault();
			}); */

			/**방명록로그아웃이벤트처리******/
			$('#guest_logout_form a').click(function(e) {
				guest_logout_action_function();
				e.preventDefault();
			});
		</c:if>
		
		
		<c:if test='${empty user_id}'>
			$('#guest_logout_form').hide();
			$('#guest_login_form').show();
			$('#menu-a a, #menu-b a, #menu-c a').click(function(e) {
				alert('로그인하세요!!');
				$('#guest_id').select();
				e.preventDefault();
				
			});
		</c:if>
		/************logoutUI 이벤트 *************/
		/**방명록쓰기폼이벤트처리******/
		$('#menu-d a').click(function(e){
			guest_insert_form_load_function();
		});
		
		/**방명록 로그인 폼 이벤트처리******
		$('#guest_login_form').on('submit', function(e) {
			guest_login_action_function(e);
			e.preventDefault();
		})
		*/
		
		/************form validator**************
		 https://jqueryvalidation.org/
		    1. .validate() function은 DOM tree loading시에 미리 호출되어있어야한다.
		    2. .validate() function은 DOM tree insert 될때 미리 호출되어있어야한다.
		validate()
		validate( { options } )
		- debug: true일 경우 validation 후 submit을 수행하지 않음. (default: false)
		- onfocusout: onblur 시 해당항목을 validation 할 것인지 여부 (default: true)
		- rules: 각 항목1 별로 validation rule을 지정한다.
		- messages: rules에서 정의된 조건으로 validation에 실패했을 때 화면에 표시할 메시지를 지정한다.
		- errorPlacement: validator는 기본적으로 validation 실패 시 
						  실패한 노드 우측에 실패 메시지를 표시하게 되어있다. 
						  작동을 원하지 않으면 내용이 없는 errorPlacement를 선언한다.
		- invalidHandler: validation 실패 시의 핸들러를 정의한다. 
						  위의 경우 실패 메시지를 alert으로 표시하도록 되어 있다.
		- submitHandler: 유효성 검사가 완료된 뒤 수행할 핸들러를 정의한다. 
						 주의 할 점은 이 옵션을 명시할 경우 'submit' 이벤트만 발생하며 
						 실제 FORM 전송은 일어나지 않는다는 것이다. 만약 submitHandler를 명시하지 않으면 유효성 검사 후 온전한 submit을 수행한다.

		rules
			required 	:입력 필수 항목설정. text, password, select, radio, checkbox type에 사용된다.  ex) required: true
			remote   	:외부 URL을 이용한 validation이 필요한 경우 사용한다.
			equalTo  	:다른 FORM 항목과 동일한 값인지 체크한다.
			minlength	:최소 길이 체크. ex) minlength: 3
			maxlength	:최대 길이 체크. ex) maxlength: 10
			rangelength :길이 범위 체크. ex) rangelength[2, 6] (2글자 이상 6글자 이하)
			min			:숫자의 최솟값 체크. ex) min: 13 (13보다 작을 경우 false)
			max			:숫자의 최댓값 체크. ex) max: 5  (5보다 클 경우 false)
			range		:숫자의 범위 체크. ex) range: [13, 24] (13보다 작거나 24보다 클 경우 false)
			email		:이메일 형식의 값인지 체크. ex) email: true
			url			:유효한 url 형식인지 체크. ex) url: true
			date		:유효한 날짜 형식의 값인지 체크
			dateISO		:유효한 국제표준 날짜 형식인지 체크. ex) dateISO: true
			number		:유효한 숫자인지 체크. ex) number: true
			digits		:유효한 digit 값인지 체크. 
						 number와 다른점은 양의 정수만 허용한다. 즉, 소수와 음수일 경우 false
			creditcard	:유효한 카드번호 형식인지 체크. 
						 공식페이지에서는 creditcard rule을 그대로 적용하지 말고 
						 현지 사정에 맞게 수정하라고 권장한다. ex) creditcard: true
		 *****************************************/
		 /*****************************************/
		/**방명록로그인이벤트처리.validate() function 호출[validator plugin]**/
		$('#guest_login_form').validate({
			rules:{
				guest_id: {
					required: true,
					minlength: 3,
					maxlength: 10,
					remote: {
						url: 'guest_existed_id_check',
						type: "GET",
						data: { //param data
							guest_id: function() { //param key값 - param 밸류
								return $('#guest_id').val();
							}
						}
					}
				},
				guest_pass: {
					required: true,
					minlength: 3,
					maxlength: 10
				}
			},
			messages:{
				guest_id: {
					required: '아이디를 입력하세요',
					minlength: '아이디는 {0}글자 이상입니다',
					maxlength: '아이디는 {0}글자 이하입니다',
					remote: '{0}은 회원 아이디가 아닙니다' // 유효성 통과를 못할때 나온다
				},
				guest_pass: {
					required: '비밀번호를 입력하세요',
					minlength: '비밀번호는 {0}글자 이상입니다',
					maxlength: '비밀번호는 {0}글자 이하입니다'
				}
			},
			submitHandler:function(){
				//유효성을 통과하면 호출
				guest_login_action_function();
			},
			errorClass: 'error',
			validClass: 'valid'


		});
		/**방명록쓰기이벤트처리.validate() function 호출[validator plugin]**/
		$(document).on('DOMNodeInserted', '#guest_write_form',function(e) { //DOMNodeInserted 이밴트가 발생할때 guest_write_form에 validate()메써드를 실행한다
			/*
			  -	이메일중복체크 
			  -	제목과 내용일치(equlTo)
			*/
			$('#guest_write_form').validate({});
		})
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

				<form id="guest_login_form" name ="guest_login_form" method="get" action="vfbfcv">
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
						<span id="idSpan">${user_id}</span>님 로그인<br /> <a href='#'>로그아웃</a>
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
