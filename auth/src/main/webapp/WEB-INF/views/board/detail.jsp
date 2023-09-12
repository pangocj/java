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
			<td>${securityBoard.name }[${securityBoard.writer }]</td>
		</tr>
		<tr>
			<td>제목</td>
			<td style="text-align: left;">${securityBoard.subject }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td style="font-size: 16px; text-align: left;"><pre>${securityBoard.content}</pre></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${securityBoard.regdate }</td>
		</tr>
	</table>
	
	<div style="margin-top: 10px;">
		<form method="get" id="linkForm">
			<input type="hidden" name="pageNum" value="${search.pageNum }">
			<input type="hidden" name="column" value="${search.column }">
			<input type="hidden" name="keyword" value="${search.keyword }">
			<input type="hidden" name="idx" value="${securityBoard.idx }">
			<%-- 요청 처리 메소드에서 게시글 작성자에 대한 권한 처리를 위해 전달 --%>
			<input type="hidden" name="writer" value="${securityBoard.writer }">
			
			<button type="button" id="listBtn">목록</button>
			<sec:authorize access="isAuthenticated()">
				<%-- authorize 태그로 사용 권한이 있는 경우 var 속성으로 설정된 속성명에 [true]라는 속성값 저장 --%>
				<sec:authorize access="hasRole('ROLE_ADMIN')" var="adminRole"/>
				<%-- authentication 태그를 사용하여 현재 로그인 사용자의 정보를 var 속성으로 설정된 속성명의 속성값으로 저장 --%>
				<sec:authentication property="principal" var="pinfo"/>	
				<%-- 로그인 사용자가 관리자이거나 게시글 작성자인 경우에만 태그를 포함하여 제공 --%>
				<c:if test="${adminRole || pinfo.userid eq securityBoard.writer}">
					<button type="button" id="modifyBtn">수정</button>
					<button type="button" id="removeBtn">삭제</button>
				</c:if>
			</sec:authorize>
		</form>
	</div>
	<hr>

	<%-- 댓글을 입력받거나 댓글 목록을 출력하는 태그 --%>
	<sec:authorize access="isAuthenticated()">
	<div>
		<textarea rows="3" cols="60" id="content"></textarea>
		<button type="button" id="addBtn">댓글쓰기</button>
	</div>
	</sec:authorize>
	<div id="replyList"></div>	
		
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
	
	function replyDisplay() {
		$.ajax({
			type: "get",
			url: "<c:url value="/reply/list"/>/"+${securityBoard.idx },
			dataType: "json",
			success: function(result) {
				if(result.length == 0) {
					var html="<div style='width: 600px; border-bottom: 1px solid black;'>";
					html+="댓글이 하나도 없습니다.";
					html+="</div>";
					$("#replyList").html(html);
					return;
				}
				
				var html="";
				$(result).each(function() {
					html+="<div style='width: 600px; border-bottom: 1px solid black;'>";
					html+="["+this.idx+"]"+this.name+"<br>";	
					html+="<pre>"+this.content+"</pre>("+this.regdate+")";	
					html+="</div>";			
				})
				$("#replyList").html(html);
			},
			error: function(xhr) {
				alert("에러 = "+xhr.status);
			}
		});
	}
	
	replyDisplay();
	
	//현재 로그인 사용자의 아이디를 자바스크립트 변수에 저장
	// => Spring Security 태그를 자바스크립트에서 사용 가능
	var writer=null;
	<sec:authorize access="isAuthenticated()">
		writer='<sec:authentication property="principal.userid"/>';
		//alert("writer = "+writer);
	</sec:authorize>
	
	//CSRF 토큰 관련 정보를 자바스트립트 변수에 저장 
	var csrfHeaderName="${_csrf.headerName}";
	var csrfTokenValue="${_csrf.token}";
	
	//ajaxSend() 메소드를 호출하여 페이지에서 Ajax 기능으로 요청하는 모든 웹프로그램에게 CSRF 토큰 전달
	// => Ajax 요청시 beforeSend 속성을 설정 불필요
	$(document).ajaxSend(function(e, xhr) {
		xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	});
	
	$("#addBtn").click(function() {
		var content=$("#content").val();
		if(content == "") {
			alert("댓글 내용을 입력해 주세요.");
			return;
		}
		$("#content").val("");
		
		$.ajax({
			type: "post",
			url: "<c:url value="/reply/register"/>",
			contentType: "application/json",
			data: JSON.stringify({"writer": writer, "content": content, "boardIdx": ${securityBoard.idx}}),
			//beforeSend 속성 : 페이지 요청전에 실행될 명령을 저장된 함수를 속성값으로 설정
			// => 매개변수로 XMLHttpRequest 객체를 제공받아 사용 가능
			/*
			beforeSend: function(xhr) {
				//XMLHttpRequest 객체의 요청 메세지의 머릿부에 CSRF 토큰을 저장하여 전달
				xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
			},
			*/
			dateType: "text",
			success: function(result) {
				if(result=="success") {
					replyDisplay();
				}
			},
			error: function(xhr) {
				alert("에러 = "+xhr.status);
			}
		});
	});
	</script>
</body>
</html>











