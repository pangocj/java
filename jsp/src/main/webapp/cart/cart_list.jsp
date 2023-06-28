<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//바인딩된 세션에서 권한 관련 정보의 속성값을 객체(로그인 상태의 사용자정보)로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비로그인 상태의 사용자가 JSP 문서를 요청한 경우 - 비정상적인 요청
	if(loginMember==null) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=member&worker=member_login'");
		out.println("</script>");
		return;
	}
%>
<h1>장바구니 목록</h1>