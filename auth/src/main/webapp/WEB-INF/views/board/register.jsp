<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>게시글 쓰기</h1>
	<hr>
	<form action="<c:url value="/board/register"/>" method="post" id="registerForm">
	<sec:csrfInput/>
	<input type="hidden" name="writer" value="<sec:authentication property="principal.userid"/>">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="5" cols="60" name="content" id="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">글저장</button></td>
		</tr>		
	</table>		
	</form>
	
	<script type="text/javascript">
	$("#registerForm").submit(function() {
		if($("#subject").val()=="") {
			alert("제목을 입력해 주세요");
			return false;
		}
		
		if($("#content").val()=="") {
			alert("내용을 입력해 주세요");
			return false;
		}
	});
	</script>
</body>
</html>
