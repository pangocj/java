<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 상태의 사용자정보(회원정보)를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
	//바인딩된 세션에서 권한 관련 정보의 속성값을 객체(로그인 상태의 사용자정보)로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
%>
<style type="text/css">

</style>
<h1>내정보</h1>
<div id="detail">
	<p>아이디 = <%=loginMember.getId() %></p>
	<p>이름 = <%=loginMember.getId() %></p>
	<p>이메일 = <%=loginMember.getId() %></p>
	<p>전화번호 = <%=loginMember.getId() %></p>
	<p>주소 = <%=loginMember.getId() %></p>
	<p>회원가입날짜 = <%=loginMember.getId() %></p>
	<p>마지막로그인 날짜 = <%=loginMember.getId() %></p>
</div>
