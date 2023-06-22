<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리 후 [login_form.jsp] 문서를 요청할 있는 URL 주소를 전달하여 응답 --%>
<%-- => 로그아웃 처리 : 권한 관련 정보가 저장된 객체를 세션에서 삭제 처리 --%>    
<%
	//session.removeAttribute("loginId");

	//session.invalidate() : 클라이언트의 정보(JSESSIONID 쿠키)로 바인딩된 세션(session)을
	//삭제하는 메소드 - 세션 언바인딩(Session UnBinding) 처리
	session.invalidate();
	
	response.sendRedirect("login_form.jsp");
%>