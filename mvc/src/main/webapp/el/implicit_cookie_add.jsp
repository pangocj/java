<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트에 쿠키를 저장하기 위해 Cookie 객체 생성
	// => Cookie 객체에 저장되는 쿠키명과 쿠키값은 영문자, 숫자, 일부 특수문자의 문자열만 사용 가능
	// => 영문자, 숫자, 일부 특수문자를 제외한 문자를 문자열에 포함할 경우 부호화 처리하여 저장
	Cookie cookie=new Cookie("userName","HongGilDong");
	cookie.setMaxAge(60*60);//쿠키의 지속시간(초) 변경
	response.addCookie(cookie);//response 객체에 Cookie 객체 추가 - 클라이언트에 쿠키가 전달되어 저장 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Cookie</h1>
	<hr>
	<p>클라이언트에게 쿠키를 전달하여 저장 하였습니다.</p>
	<p><a href="implicit_cookie_use.jsp">쿠키값 출력</a></p>
</body>
</html>