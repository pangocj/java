<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 검색어를 전달받아 SUGGEST 테이블에 저장된 제시어 관련 정보를 검색하여 XML 데이타로 응답하는 JSP 문서 --%>    
<%
	request.setCharacterEncoding("utf-8");

	String keyword=request.getParameter("keyword");
	
	//
%>