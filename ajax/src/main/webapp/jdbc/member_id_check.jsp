<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 AJAX_MEMBER 테이블에 저장된 회원정보를 검색하여 아이디 사용 가능
여부를 XML 데이타로 응답하는 JSP 문서 --%>
<%
	String id=request.getParameter("id");

	if(id==null || id.equals("")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//아이디를 전달받아 AJAX_MEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는
	//DAO 클래스의 메소드 호출
	

%>
