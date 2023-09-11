<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>게시글 변경</h1>
	<hr>
	<form action="<c:url value="/board/modify"/>" method="post" id="modifyForm">
	<sec:csrfInput/>
	<input type="hidden" name="pageNum" value="${search.pageNum }">
	<input type="hidden" name="column" value="${search.column }">
	<input type="hidden" name="keyword" value="${search.keyword }">
	<input type="hidden" name="idx" value="${securityBoard.idx }">
	<input type="hidden" name="writer" value="${securityBoard.writer }">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject" value="${securityBoard.subject }"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="5" cols="60" name="content" id="content">${securityBoard.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">글변경</button></td>
		</tr>		
	</table>		
	</form>
	
	<script type="text/javascript">
	$("#modifyForm").submit(function() {
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
