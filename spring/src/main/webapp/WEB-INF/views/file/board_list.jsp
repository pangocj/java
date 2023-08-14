<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 2px;
}
</style>
</head>
<body>
	<h1>자료실(출력페이지)</h1>
	<hr>
	<table>
		<tr>
			<th width="50">번호</th>
			<th width="100">작성자</th>
			<th width="300">제목</th>
			<th width="350">파일명</th>
			<th width="100">다운로드</th>
			<th width="100">삭제</th>
		</tr>
		
		<c:forEach var="fileBoard" items="${fileBoardList }">
		<tr>
			<td align="center">${fileBoard.idx }</td>
			<td align="center">${fileBoard.writer }</td>
			<td>${fileBoard.subject }</td>
			<td>${fileBoard.origin }</td>
			<td align="center">
				<button type="button" onclick="fileDownload(${fileBoard.idx });">다운로드</button> 
			</td>
			<td align="center">
				<button type="button" onclick="fileDelete(${fileBoard.idx });">삭제</button> 
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<p>
		<button type="button" onclick="location.href='<c:url value="/file/write"/>';">업로드</button>
	</p> 
	
	<script type="text/javascript">
	function fileDownload(idx) { 
		//질의문자열(QueryString)를 이용하여 자료실 번호 전달
		location.href="<c:url value="/file/download"/>?idx="+idx;
	}
	
	function fileDelete(idx) {
		if(confirm("자료를 정말로 삭제 하시겠습니까?")) {
			location.href="<c:url value="/file/delete"/>?idx="+idx;
		} 
	}
	</script>
</body>
</html>
