<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 제공받아 출력하는 JSP 문서 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원정보</h1>
	<hr>
	<p>아이디 = ${member.id }, 이름 = ${member.name }, 주소 = ${member.address }</p>
</body>
</html>
