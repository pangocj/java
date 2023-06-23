<%@page import="xyz.itwill.bean.Hewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 내장객체에 저장된 속성값을 반환받아 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%
	/*
	//내장객체에 저장된 속성값이 없는 경우 - 비정상적인 요청
	if(session.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	} 

	//내장객체에 저장된 속성값을 반환받아 저장
	Hewon hewon=(Hewon)session.getAttribute("hewon");
	
	//JSP 문서에서 내장객체에 저장된 속성값을 사용하지 못하도록 삭제
	session.removeAttribute("hewon");
	*/
	
	//내장객체에 저장된 속성값이 없는 경우 - 비정상적인 요청
	if(request.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	} 

	//내장객체에 저장된 속성값을 반환받아 저장
	Hewon hewon=(Hewon)request.getAttribute("hewon");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<p>이름 = <%=hewon.getName() %></p>
	<p>전화번호 = <%=hewon.getPhone() %></p>
	<p>주소 = <%=hewon.getAddress() %></p>
</body>
</html>