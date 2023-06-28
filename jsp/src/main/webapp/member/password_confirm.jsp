<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보변경 또는 회원탈퇴를 위한 비밀번호를 입력받기 위한 JSP 문서 --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf" %>
<%
	//전달값(페이지 이동 관련 정보)을 반환받아 저장
	// => 비밀번호를 입력받은 후 페이지 이동 관련 정보 반환 
	String action=request.getParameter("action");
	
	//전달값이 없거나 잘못된 경우 - 비정상적인 요청
	if(action==null || !action.equals("modify") && !action.equals("remove")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}
	
	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		session.removeAttribute("message");
	}
%> 
<% if(action.equals("modify")) { %>
	<p>회원정보변경을 위해 회원의 비밀번호를 입력 주세요.</p>
<% } else { %>
	<p>회원탈퇴를 위해 회원의 비밀번호를 입력 주세요.</p>
<% } %>
<form method="post" name="passwordForm">
	<input type="password" name="passwd">
	<button type="button" onclick="submitCheck();">입력완료</button>
</form>
<p id="message" style="color: red;"><%=message %></p>

<script type="text/javascript">
passwordForm.passwd.focus();

function submitCheck() {
	if(passwordForm.passwd.value=="") {
		document.getElementById("message").innerHTML="비밀번호를 반드시 입력해 주세요.";
		passwordForm.passwd.focus();
		return;
	}
	
	<%-- 전달값에 의해 form 태그로 요청하는 JSP 문서를 구분하여 실행 --%>
	<% if(action.equals("modify")) {//[회원정보변경]인 경우 %>
		passwordForm.action="<%=request.getContextPath()%>/index.jsp?group=member&worker=member_modify";
	<% } else {//[회원탈퇴]인 경우 %>
		passwordForm.action="<%=request.getContextPath()%>/member/member_remove_action.jsp";
	<% } %>
	
	passwordForm.submit();
}
</script>








