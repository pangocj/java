<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- JavaScript(jQuery)를 이용하여 사용자 입력값의 검증 - 클라이언트 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>사원등록</h1>
	<hr>
	<c:url value="/valid/html" var="url"/>
	<form action="${url}" method="post" id="joinForm">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" id="id" value="${employee.id }">
				<span id="idMsg" class="error">${idMsg }</span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="passwd" id="passwd">
				<span id="passwdMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" id="name">
				<span id="nameMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="email" id="email">
				<span id="emailMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				남자<input type="radio" name="gender" value="남자" class="gender">&nbsp;&nbsp;
				여자<input type="radio" name="gender" value="여자" class="gender">
				<span id="genderMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">등록</button>
			</td>
		</tr>
	</table>
	</form>
	
	<script type="text/javascript">
	$("#joinForm").submit(function() {
		var submitResult=true;
		
		$(".error").hide();

		/*	
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if($("#id").val()=="") {
			$("#idMsg").html("아이디를 입력해 주세요.");
			
			submitResult=false;
		} else if(!idReg.test($("#id").val())) {
			$("#idMsg").html("아이디를 형식에 맞게 입력해 주세요.").show();
			submitResult=false;
		}
		*/
		
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if($("#passwd").val()=="") {
			$("#passwdMsg").html("비밀번호를 입력해 주세요.");
			submitResult=false;
		} else if(!passwdReg.test($("#passwd").val())) {
			$("#passwdMsg").html("비밀번호를 형식에 맞게 입력해 주세요.");
			submitResult=false;
		} 
		
		if($("#name").val()=="") {
			$("#nameMsg").html("이름을 입력해 주세요.");
			submitResult=false;
		}
		
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if($("#email").val()=="") {
			$("#emailMsg").html("이메일을 입력해 주세요.");
			submitResult=false;
		} else if(!emailReg.test($("#email").val())) {
			$("#emailMsg").html("이메일을 형식에 맞게 입력해 주세요.");
			submitResult=false;
		}
		
		if($(".gender").filter(":checked").length == 0) {
			$("#genderMsg").html("성별을 선택해 주세요.");
			submitResult=false;
		}
		
		$(".error").show();
		
		return submitResult;
	});
	</script>
</body>
</html>
