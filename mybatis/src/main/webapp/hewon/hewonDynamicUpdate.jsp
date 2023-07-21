<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MYHEWON 테이블에서 아이디가 [xxx]인 회원의 이름을 [홍경래]으로 변경
	MyHewon hewon=new MyHewon();
	hewon.setId("xxx"); 
	hewon.setName("홍경래");
	hewon.setPhone("010-1247-5411");
	
	MyHewonDAO.getDAO().updateDynamicHewon(hewon);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원정보 변경</h1>
	<hr>
	<h3>회원정보를 성공적으로 변경 하였습니다.</h3>
</body>
</html>