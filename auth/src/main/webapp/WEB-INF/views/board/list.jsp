<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<style type="text/css">
#container {
	width: 1000px;

}

table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	text-align: center;
	padding: 5px;
}

.idx { width: 150px; }
.writer { width: 200px; }
.subject { width: 450px; text-align: center; }
.regdate { width: 200px; }
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr>
	<div id="container">
		<sec:authorize access="isAuthenticated()">
			<div style="text-align: right; margin-bottom: 10px;">
				<button type="button" onclick="location.href='<c:url value="/board/register"/>';">글쓰기</button>
			</div>
		</sec:authorize>
		<table>
			<tr>
				<th class="idx">글번호</th>
				<th class="writer">작성자</th>
				<th class="subject">제목</th>
				<th class="regdate">작성일</th>
			</tr>
			<c:choose>
				<c:when test="${empty result.securityBoardList}">
					<tr>
						<td colspan="4">검색된 게시글이 없습니다.</td>
					</tr>	
				</c:when>		
				<c:otherwise>
					<c:forEach var="securityBoard" items="${result.securityBoardList}">
						<tr>
							<td>${securityBoard.idx}</td>
							<td>${securityBoard.name}</td>
							<td><a href="<c:url value="/board/detail"/>?idx=${securityBoard.idx }&pageNum=${search.pageNum}&column=${search.column}&keyword=${search.keyword}">${securityBoard.subject}</a></td>
							<td>${securityBoard.regdate}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	
		<div style="text-align: center;">
			<c:choose>
				<c:when test="${result.pager.startPage > result.pager.blockSize }">
					<a href="<c:url value="/board/list"/>?pageNum=${pager.prevPage}&column=${search.column}&keyword=${search.keyword}">[이전]</a>
				</c:when>
				<c:otherwise>
					[이전]
				</c:otherwise>
			</c:choose>	
			
			<c:forEach var="i" begin="${result.pager.startPage }" end="${result.pager.endPage }" step="1">
				<c:choose>
					<c:when test="${result.pager.pageNum != i  }">
						<a href="<c:url value="/board/list"/>?pageNum=${i}&column=${search.column}&keyword=${search.keyword}">[${i }]</a>
					</c:when>
					<c:otherwise>
						[${i }]
					</c:otherwise>
				</c:choose>	
			</c:forEach>
			<c:choose>
				<c:when test="${result.pager.endPage != result.pager.totalPage }">
					<a href="<c:url value="/board/list"/>?pageNum=${pager.nextPage}&column=${search.column}&keyword=${search.keyword}">[이전]</a>
				</c:when>
				<c:otherwise>
					[다음]
				</c:otherwise>
			</c:choose>	
		</div>
	
		<div style="text-align: center;">
			<form action="<c:url value="/board/list"/>" method="post">
				<select name="column">
					<option value="name">작성자</option>
					<option value="subject">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="keyword">
				<sec:csrfInput/>
				<button type="submit">검색</button>
			</form>	
		</div>	
	</div>	
</body>
</html>
