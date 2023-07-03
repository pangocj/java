<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 글번호를 전달받아 REVIEW 테이블에 저장된 게시글을 검색하여 입력태그의 초기값으로 설정하고
사용자로부터 게시글 변경값을 입력받기 위한 JSP 문서--%>
<%-- => 로그인 상태의 사용자 중 게시글 작성자이거나 관리자인 경우에만 요청 가능한 JSP 문서 --%>
<%-- => [글변경] 태그를 클릭한 경우 [review/remove_modify_action.jsp] 문서 요청 - 입력값(게시글) 전달 --%>    
<%-- 비로그인 상태의 사용자가 JSP 문서를 요청할 경우 에러페이지로 이동하여 응답 처리 --%>
<%@include file="/security/login_check.jspf"%>
<%
	if(request.getParameter("num")==null) {//전달값이 없는 경우 - 비정상적인 요청
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;		
	}
	
	//전달값을 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	String search=request.getParameter("search");
	String keyword=request.getParameter("keyword");
	
	//글번호를 전달받아 REVIEW 테이블에 저장된 게시글을 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
	ReviewDTO review=ReviewDAO.getDAO().selectReview(num);
	
	if(review==null) {//검색된 게시글이 없는 경우 - 비정상적인 요청
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;	
	}
	
	//로그인 상태의 사용자가 게시글 작성자 및 관리자가 아닌 경우 - 비정상적인 요청
	if(!loginMember.getId().equals(review.getReviewid()) && loginMember.getMemberStatus()!=9) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}
%>
<style type="text/css">
table {
	margin: 0 auto;
}

th {
	width: 100px;
	font-weight: bold;
}

td {
	text-align: left;
}
</style>
	<h1>게시글변경</h1>
<%-- 파일을 입력받아 전달하기 위해 반드시 enctype 속성값을 [multipart/form-data]로 설정 --%>
<form action="<%=request.getContextPath() %>/review/review_modify_action.jsp" 
	method="post" enctype="multipart/form-data" id="reviewForm">
	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="pageNum" value="<%=pageNum%>">
	<input type="hidden" name="search" value="<%=search%>">
	<input type="hidden" name="keyword" value="<%=keyword%>">
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="40" value="<%=review.getSubject()%>">
				<input type="checkbox" name="secret" value="2" 
					<%if(review.getStatus()==2) { %>checked="checked"<% } %>>비밀글
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="7" cols="60" name="content" id="rContent"><%=review.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<th>리뷰이미지</th>
			<td>
				<input type="file" name="reviewimg">
				<div style="color: red;">이미지를 변경할 경우에만 파일을 입력해 주세요.</div>
				<% if(review.getReviewimg()!=null) { %>
					<img src="<%=request.getContextPath()%>/review_images/<%=review.getReviewimg()%>" width="200">
				<% } %>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">글변경</button>
				<button type="reset" id="resetBtn">다시쓰기</button>
			</th>
		</tr>
	</table>
</form>
<div id="message" style="color: red;"></div>

<script type="text/javascript">
$("#subject").focus();

$("#reviewForm").submit(function() {
	if($("#subject").val()=="") {
		$("#message").text("제목을 입력해 주세요.");
		$("#subject").focus();
		return false;
	}
	
	if($("#rContent").val()=="") {
		$("#message").text("내용을 입력해 주세요.");
		$("#rContent").focus();
		return false;
	}
});

$("#resetBtn").click(function() {
	$("#subject").focus();
	$("#message").text("");
});
</script>
