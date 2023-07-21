<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	//MYHEWON 테이블에서 아이디가 [xxx]인 회원의 이름을 [로빈훗]으로 변경
	MyHewon hewon=new MyHewon();//기본 생성자에 의해 생성된 객체의 필드에는 기본값 저장
	hewon.setId("xxx");
	hewon.setName("로빈훗");
	
	//DTO 객체를 전달받아 DAO 클래스의 메소드를 호출하여 회원정보를 변경 처리
	// => DTO 객체에는 아이디와 이름만 필드에 저장되어 있고 나머지 필드에는 기본값 저장
	// => MYHEWON 테이블에 저장된 회원정보가 비정상적으로 변경
	MyHewonDAO.getDAO().updateHewon(hewon);
	*/	

	//DTO 객체에 변경값외에 기존값을 객체 필드에 저장 
	MyHewon hewon=new MyHewon(); 
	hewon.setId("xxx");
	hewon.setName("로빈훗");
	hewon.setPhone("010-5678-2135");
	hewon.setEmail("xxx@itwill.xyz");
	hewon.setStatus(4);

	MyHewonDAO.getDAO().updateHewon(hewon);
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