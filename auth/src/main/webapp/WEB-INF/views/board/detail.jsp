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
			<td>${securityBoard.name }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td style="text-align: left;">${securityBoard.subject }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td style="font-size: 16px; text-align: left;"><pre >${securityBoard.content}</pre></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${securityBoard.regdate }</td>
		</tr>
	</table>
	
	<div style="margin-top: 10px;">
		<sec:authentication property="principal" var="pinfo"/>	
		<form method="get" id="linkForm">
			<input type="hidden" name="pageNum" value="${search.pageNum }">
			<input type="hidden" name="column" value="${search.column }">
			<input type="hidden" name="keyword" value="${search.keyword }">
			<input type="hidden" name="idx" value="${securityBoard.idx }">
			<%-- 요청 처리 메소드에게 게시글 작성자를 권한 처리에 사용되도록 전달 --%>
			<input type="hidden" name="writer" value="${securityBoard.writer }">
			
			<button type="button" id="listBtn">목록</button>
		
			<sec:authorize access="isAuthenticated()">
				<%-- authorize 태그로 사용 권한이 있는 경우 속성명의 속성값으로 [true] 저장 --%>
				<sec:authorize access="hasRole('ROLE_ADMIN')" var="adminRole"/>			
				<%-- 로그인 사용자가 관리자이거나 게시글 작성자인 경우에만 태그를 포함하여 제공 --%>
				<c:if test="${adminRole || pinfo.userid eq securityBoard.writer}">
					<button type="button" id="modifyBtn">수정</button>
					<button type="button" id="removeBtn">삭제</button>
				</c:if>
			</sec:authorize>
		
		</form>
	</div>
	
	<script type="text/javascript">
	$("#listBtn").click(function() {
		$("#linkForm").attr("action", "<c:url value="/board/list"/>").submit();
	});
	
	$("#modifyBtn").click(function() {
		$("#linkForm").attr("action", "<c:url value="/board/modify"/>").submit();
	});
	
	$("#removeBtn").click(function() {
		if(confirm("게시글을 삭제 하시겠습니까?")) {
			$("#linkForm").attr("action", "<c:url value="/board/remove"/>").submit();
		}
	});
	</script>
</body>
</html>











