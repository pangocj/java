<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MYBATIS</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#id").focus();
	
	$("#submitBtn").click(function() {
		if($("#id").val()=="") {
			alert("아이디를 입력해 주세요");
			$("#id").focus();
			return;
		}
		
		if($("#name").val()=="") {
			alert("이름을 입력해 주세요");
			$("#name").focus();
			return;
		}
		
		if($("#phone").val()=="") {
			alert("전화번호를 입력해 주세요");
			$("#phone").focus();
			return;
		}
		
		if($("#email").val()=="") {
			alert("이메일을 입력해 주세요");
			$("#email").focus();
			return;
		}
		
		$("#input").attr("method","POST").attr("action"
				,"memberInputAction.jsp").submit();
	});
	
	$("#resetBtn").click(function() {
		$("#input").each(function() {
			this.reset();
		});
		$("#id").focus();
	});
	
	$("#displayBtn").click(function() {
		location.href="memberDisplay.jsp";
	});
});
</script>
</head>
<body>
	<h1 align="center">회원등록</h1>
	<form id="input">
	<table align="center" border="1" cellspacing="0" width="300">
		<tr>
			<th width="100">아이디</th>
			<td align="center" width="200">
				<input type="text" name="id" id="id">
			</td>
		</tr>
		<tr>
			<th width="100">이름</th>
			<td align="center" width="200">
				<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr>
			<th width="100">전화번호</th>
			<td align="center" width="200">
				<input type="text" name="phone" id="phone">
			</td>
		</tr>
		<tr>
			<th width="100">이메일</th>
			<td align="center" width="200">
				<input type="text" name="email" id="email">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="button" id="submitBtn">입력전송</button>
				<button type="button" id="resetBtn">다시입력</button>
				<button type="button" id="displayBtn">회원정보</button>
			</th>
		</tr>
	</table>	
	</form>
</body>
</html>