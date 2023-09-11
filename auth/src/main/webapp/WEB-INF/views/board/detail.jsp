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
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	text-align: center;
	padding: 5px;
}
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>게시글</h1>
	<hr>
	<table>
		<tr>
			<td width="200">글번호</td>
			<td width="500">${securityBoard.idx }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${securityBoard.writer }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${securityBoard.subject }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${securityBoard.content}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${securityBoard.regdate }</td>
		</tr>
	</table>
	
	<div style="margin-top: 10px;">	
		<sec:authentication property="principal" var="pinfo"/>	
		
		<button type="button" id="listBtn">목록</button>
		
		<sec:authorize access="isAuthenticated()">
			<%-- 게시글 작성자인 경우에만 태그를 포함하여 제공 --%>
			<c:if test="${pinfo.userid eq securityBoard.writer}">
				<button type="button">수정</button>
				<button type="button">삭제</button>
			</c:if>
		</sec:authorize>
	</div>
	
	<script type="text/javascript">
	$("#listBtn").click(function() {
		location.href="<c:url value="/board/list"/>?pageNum=${search.pageNum}&column=${search.column}&keyword=${search.keyword}";
	});
	</script>
</body>
</html>











