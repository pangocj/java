<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 Userinfo 테이블의 회원정보로 삽입하고 [user_login.jsp] 문서로
이동하는 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}
%>