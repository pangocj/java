<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%-- 회원목록을 제공받아 출력하는 JSP 문서 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<c:forEach var="member" items="${memberList}">
		<p>아이디 = ${member.id }, 이름 = ${member.name }, 주소 = ${member.address }</p>
	</c:forEach>
</body>
</html>