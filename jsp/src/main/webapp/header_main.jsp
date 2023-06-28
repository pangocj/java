<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//바인딩된 세션에서 권한 관련 정보의 속성값을 객체로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
%>    
<div id="profile">
	<% if(loginMember==null) {//비로그인 상태의 사용자인 경우 %>
	<a href="<%=request.getContextPath() %>/index.jsp?group=member&worker=member_login">로그인</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/index.jsp?group=member&worker=member_join">회원가입</a>&nbsp;&nbsp;
	<% } else {//로그인 상태의 사용자인 경우 %>
		<%=loginMember.getName() %>님, 환영합니다.&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/member/member_logout_action.jsp">로그아웃</a>&nbsp;&nbsp;
		<% if(loginMember.getMemberStatus()==1) {//로그인 사용자가 일반사용자인 경우 %>
			<a href="<%=request.getContextPath() %>/index.jsp?group=member&worker=member_mypage">마이페이지</a>&nbsp;&nbsp;
		<% } else if(loginMember.getMemberStatus()==9) {//로그인 사용자가 관리자인 경우 %>
			<a href="<%=request.getContextPath() %>/index.jsp?group=admin&worker=admin_main">관리자페이지</a>&nbsp;&nbsp;
		<% } %>
	<% } %>
	<a href="<%=request.getContextPath() %>/index.jsp?group=cart&worker=cart_list">장바구니</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/index.jsp?group=review&worker=review_list">제품후기</a>&nbsp;&nbsp;
</div>
<div id="logo"><a href="<%=request.getContextPath() %>/index.jsp">쇼핑몰</a></div>
<div id="menu">
	<a href="#">조립컴퓨터</a>
	<a href="#">중앙처리장치</a>
	<a href="#">메인보드</a>
	<a href="#">메모리</a>
	<a href="#">기타부품</a>
</div>
