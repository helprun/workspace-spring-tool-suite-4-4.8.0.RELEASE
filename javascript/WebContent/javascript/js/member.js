/**
 * 
 */
function load_focus(){
		//var h1E = document.getElementById("joinfrm_title");
		//window.document.joinFrm.id.focus();
		document.getElementById("id").focus();
	}
	
	function join_form_submit_button(){
		var f = document.getElementById("joinFrm");
		if (is_null(f.id.value)) {
			alert('아이디를 입력하세요');
			f.id.focus();
			return false;	
		}
		
		if (f.password.value == null || f.password.value=='') {
			alert('패스워드를 입력하세요');
			f.password.focus();
			return false;	
		}
		if (f.repassword.value == null || f.repassword.value == '') {
			alert('패스워드확인을 입력하세요');
			f.repassword.focus();
			return false;	
		}
		if (f.name.value == null || f.name.value == '') {
			alert('이름을 입력하세요');
			f.name.focus();
			return false;	
		}
		if (f.address.value == null || f.address.value == '') {
			alert('주소를 입력하세요');
			f.address.focus();
			return false;	
		}
		
		if (!isSame(f.password.value, f.repassword.value)) {
			alert('비밀번호와 비밀번호 확인은 일치해야 합니다.');
			f.repassword.select();
			return false;	
		}
		if (f.id.value.length < 5 || f.id.value.length >10) {
			alert("아이디의 길이는 5~10자 사이여야 합니다");
			f.id.select();
			return false;
		}
		for (var i = 0; i < id.value.length; i++) {
			if ((f.id.value.charAt(i) >= 'a' && f.id.value.charAt(i) <= 'z') || 
				(f.id.value.charAt(i) >= 'A' && f.id.value.charAt(i) <= 'Z') ||
				(f.id.value.charAt(i) >= 0 && f.id.value.charAt(i) <= 9)) {
			} else {
				alert("아이디는 알파벳 대문자, 소문자, 숫자만 가능합니다.");
				f.id.select();
				return false;
			}
		}
		if (f.id.value.charAt(0) >= 0 && f.id.value.charAt(0) <= 9) {
			alert("아이디는 숫자로 시작할 수 없습니다.");
			f.id.select();
			return false;
		}
		
		return true;
	}
	
	function join_form_button() {
		var id = document.getElementById('id').value
		if (id==null || id=='') {
			alert('아이디를 입력하세요');
			document.getElementById('id').focus();
			return;	
		}
		var password = document.getElementById('password').value
		if (password==null || password=='') {
			alert('패스워드를 입력하세요');
			document.getElementById('password').focus();
			return;	
		}
		var repassword = document.getElementById('repassword').value
		if (repassword == null || repassword == '') {
			alert('패스워드확인을 입력하세요');
			document.getElementById('repassword').focus();
			return;	
		}
		var name = document.getElementById('name').value
		if (name == null || name == '') {
			alert('이름을 입력하세요');
			document.getElementById('name').focus();
			return;	
		}
		var address = document.getElementById('address').value
		if (address == null || address == '') {
			alert('주소를 입력하세요');
			document.getElementById('address').focus();
			return;	
		}
		
		if (password != repassword) {
			alert('비밀번호와 비밀번호 확인은 일치해야 합니다.');
			document.getElementById('repassword').select();
			return;	
		}
		
		/*  
		1.아이디는 5~10자여야 한다
		2.영문알파벳 대문자, 소문자,숫자만 가능 
		3.숫자로 시작할 수 없다
		*/
		if (id.length < 5 || id.length >10) {
			alert("아이디의 길이는 5~10자 사이여야 합니다");
			document.getElementById('id').select();
			return;
		}
		for (var i = 0; i < id.length; i++) {
			if ((id.charAt(i) >= 'a' && id.charAt(i) <= 'z') || 
				(id.charAt(i) >= 'A' && id.charAt(i) <= 'Z') ||
				(id.charAt(i) >= 0 && id.charAt(i) <= 9)) {
				
			} else {
				alert("아이디는 알파벳 대문자, 소문자, 숫자만 가능합니다.");
				document.getElementById('id').select();
				return;
			}
		}
		if (id.charAt(0) >= 0 && id.charAt(0) <= 9) {
			alert("아이디는 숫자로 시작할 수 없습니다.");
			document.getElementById('id').select();
			return;
		}
		
		
		document.getElementById('joinFrm').action='../4.join.jsp';
		document.getElementById('joinFrm').method='post';
		document.getElementById('joinFrm').submit();
		
		return;
		
		
	}
	