<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 게시글(새글 또는 답글) 정보를 입력받기 위한 JSP 문서 --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%-- => [글저장] 태그를 클릭한 경우 [review/review_write_action.jsp] 문서 - 입력값(게시글정보) 전달 --%>

<%-- 새글 : [review_list.jsp] 문서에 의해 [review_writer.jsp] 문서를 요청한 경우 - 전달값 : X --%>    
<%-- 답글 : [review_detail.jsp] 문서에 의해 [review_writer.jsp] 문서를 요청한 경우 - 전달값 : O --%>    
<%-- => [review_detail.jsp] 문서에서 부모 게시글 관련 정보(ref, restep, relevel, pageNum) 전달--%>

<%-- 비로그인 상태의 사용자가 JSP 문서를 요청한 경우 에러페이지로 이동되도록 응답 처리 --%>
<%@include file="/security/login_check.jspf" %>
<%
	//전달값을 반환받아 저장 - 전달값이 없는 경우(새글) 변수에 초기값 저장
	String ref="0", restep="0", relevel="0", pageNum="1";
	if(request.getParameter("ref")!=null) {//전달값이 있는 경우 - 답글
		ref=request.getParameter("ref");
		restep=request.getParameter("restep");
		relevel=request.getParameter("relevel");
		pageNum=request.getParameter("pageNum");
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
<% if(ref.equals("0")) {//새글인 경우 %>
	<h1>새글쓰기</h1>
<% } else {//답글인 경우 %>
	<h1>답글쓰기</h1>
<% } %>
<%-- 파일을 입력받아 전달하기 위해 반드시 enctype 속성값을 [multipart/form-data]로 설정 --%>
<form action="<%=request.getContextPath() %>/review/review_write_action.jsp" 
	method="post" enctype="multipart/form-data" id="reviewForm">
	<input type="hidden" name="ref" value="<%=ref%>">
	<input type="hidden" name="restep" value="<%=restep%>">
	<input type="hidden" name="relevel" value="<%=relevel%>">
	<input type="hidden" name="pageNum" value="<%=pageNum%>">
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="40">
				<input type="checkbox" name="secret" value="2">비밀글
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="7" cols="60" name="content" id="rContent"></textarea>
			</td>
		</tr>
		<tr>
			<th>리뷰이미지</th>
			<td>
				<input type="file" name="reviewimg">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">글저장</button>
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
