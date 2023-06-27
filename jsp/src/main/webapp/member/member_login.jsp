<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
#space {
	height: 50px;
}    
.login_tag {
	margin: 5px auto;
	width: 300px;
}    

#login label {
	text-align: right;
	width: 100px;
	float: left;
}

#login ul li {
	list-style-type: none;
	margin-bottom: 10px;
}

#login input:focus {
	border: 2px solid aqua;
}

#login_btn {
	margin: 0 auto;
	padding: 5px;
	width: 300px;
	background-color: aqua;
	font-size: 1.2em;
	cursor: pointer;
	letter-spacing: 20px;
	font-weight: bold; 	 
}

#search {
	margin-top: 10px;	
	margin-bottom: 20px;	
}

#message {
	color: red;	
	font-weight: bold;
}

a:hover {
	background-color: orange;
}
</style>
<div id="space"></div>
<form id="login" name="loginForm" action="#" method="post">
	<ul class="login_tag">
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id">
		</li>
		<li>
			<label for="id">비밀번호</label>
			<input type="password" name="passwd" id="passwd">
		</li>
	</ul>
	<div id="login_btn">로그인</div>
	<div id="search">
		<a href="#">아이디 찾기</a> |
		<a href="#">비밀번호 찾기</a> 
	</div>
	<div id="message"></div>
</form>
<script type="text/javascript">
$("#id").focus();

$("#login_btn").click(function() {
	if($("#id").val()=="") {
		$("#message").text("아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}
	
	if($("#passwd").val()=="") {
		$("#message").text("비밀번호를 입력해 주세요.");
		$("#passwd").focus();
		return;
	}
	
	$("#login").submit();
});

</script>
