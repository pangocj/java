<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.getProtocol() : 웹프로그램을 요청할 때 사용한 통신규약(Protocol)을 반환하는 메소드
	String protocol=request.getProtocol();

	//프로토콜을 구분하여 브라우저 캐싱 기능을 사용하지 않도록 설정
	if(protocol.equals("HTTP/1.0")) {
		response.setDateHeader("Expires", -1);//캐싱 만료기간 설정
		response.setHeader("Pragma", "no-cache");//캐싱 기능 비활성화 설정
	} else if(protocol.equals("HTTP/1.1")) {
		response.setHeader("Cache-control", "no-cache");//캐싱 기능 비활성화 설정
	}

	Date now=new Date();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 M월 d일 H시 m분 s초");
	String displayTime=dateFormat.format(now);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control" content="no-cache">
<title>AJAX</title>
</head>
<body>
	<%=displayTime %>
</body>
</html>