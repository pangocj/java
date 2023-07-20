<%@page import="xyz.itwill.dto.MyReplyUser"%>
<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyCommentReplyUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("commentNo")==null) {//전달값(게시글번호)이 없는 경우
		//게시글목록을 출력하는 페이지로 이동
		response.sendRedirect("commentUserListSelect2.jsp");
		return;
	}

	//전달값(게시글번호)을 반환받아 저장
	int commentNo=Integer.parseInt(request.getParameter("commentNo"));
	
	//게시글번호를 전달받아 MYCOMMENT 테이블에 저장된 게시글과 MYREPLY 테이블에 저장된 
	//댓글목록을 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
	MyCommentReplyUser commentReplyUser=MyCommentDAO.getDAO().selectCommentReplyUser(commentNo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 3px;
}

.no { width: 100px; }
.name { width: 150px; }
.content { width: 300px; }
.date { width: 200px; }
.comment { width: 100px; }
</style>
</head>
<body>
	<h1>게시글과 댓글목록</h1>
	<hr>
	<%-- 게시글 출력 --%>
	<table>
		<tr>
			<td width="200">게시글번호</td>
			<td width="300"><%=commentReplyUser.getCommentNo() %></td>
		</tr>
		<tr>
			<td width="200">게시글작성자</td>
			<td width="300"><%=commentReplyUser.getUser().getUserName()%>[<%=commentReplyUser.getCommentId() %>]</td>
		</tr>
		<tr>
			<td width="200">게시글내용</td>
			<td width="300"><%=commentReplyUser.getCommentContent() %></td>
		</tr>
		<tr>
			<td width="200">게시글작성일</td>
			<td width="300"><%=commentReplyUser.getCommentDate() %></td>
		</tr>
	</table>
	<br>
	
	<%-- 댓글목록 출력 --%>
	<table>
		<tr>
			<td class="no">댓글번호</td>
			<td class="name">댓글작성자</td>
			<td class="content">댓글내용</td>
			<td class="date">댓글작성일</td>
			<td class="comment">게시글번호</td>
		</tr>
		<% if(commentReplyUser.getReplyUserList().isEmpty()) { %>
			<tr>
				<td colspan="5">댓글이 존재하지 않습니다.</td>
			</tr>
		<% } else { %>
			<% for(MyReplyUser replyUser : commentReplyUser.getReplyUserList()) { %>
			<tr>
				<td><%=replyUser.getReply().getReplyNo() %></td>
				<td><%=replyUser.getUser().getUserName() %>[<%=replyUser.getReply().getReplyId() %>]</td>
				<td><%=replyUser.getReply().getReplyContent() %></td>
				<td><%=replyUser.getReply().getReplyDate() %></td>
				<td><%=replyUser.getReply().getReplyCommentNo() %></td>
			</tr>
			<% } %>
		<% } %>
	</table>
</body>
</html>

