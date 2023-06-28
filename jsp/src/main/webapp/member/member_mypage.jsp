<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 상태의 사용자정보(회원정보)를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%-- => [회원정보변경] 태그를 클릭한 경우 [member/password_confirm.jsp] 문서 요청 - 페이지 이동 관련 정보 전달 --%>
<%-- => [회원탈퇴] 태그를 클릭한 경우 [member/password_confirm.jsp] 문서 요청 - 페이지 이동 관련 정보 전달 --%>
<%--
	//바인딩된 세션에서 권한 관련 정보의 속성값을 객체(로그인 상태의 사용자정보)로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비로그인 상태의 사용자가 JSP 문서를 요청한 경우 - 비정상적인 요청
	if(loginMember==null) {
		//템플릿 페이지 몸체부에 포함되는 JSP 문서에서는 에러코드 및 URL 주소로 응답 처리 불가능
		//response.sendRedirect(request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		
		//자바스트립트를 이용하여 응답 처리
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}
--%>
<%@include file="/security/login_check.jspf" %>
<style type="text/css">
#detail {
	width: 500px;
	margin: 0 auto;
	text-align: left;
}

#link {
	font-size: 1.1em;
}

#link a:hover {
	color: white;
	background: black;
}
</style>
<h1>내정보</h1>
<div id="detail">
	<p>아이디 = <%=loginMember.getId() %></p>
	<p>이름 = <%=loginMember.getName() %></p>
	<p>이메일 = <%=loginMember.getEmail() %></p>
	<p>전화번호 = <%=loginMember.getMobile() %></p>
	<p>주소 = [<%=loginMember.getZipcode() %>]<%=loginMember.getAddress1() %> <%=loginMember.getAddress2() %></p>
	<p>회원가입날짜 = <%=loginMember.getJoinDate() %></p>
	<p>마지막로그인 날짜 = <%=loginMember.getLastLogin() %></p>
</div>

<div id="link">
	<a href="<%=request.getContextPath() %>/index.jsp?group=member&worker=password_confirm&action=modify">[회원정보변경]</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/index.jsp?group=member&worker=password_confirm&action=remove">[회원탈퇴]</a>&nbsp;&nbsp;
</div>








