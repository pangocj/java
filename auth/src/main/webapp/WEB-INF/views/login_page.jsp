<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="<c:url value="/loginPage"/>" method="post" id="loginForm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" id="userid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">로그인</button></td>
		</tr>		
	</table>		
	<%-- CSRF 공격을 방어하기 위해 Spring Security에 의해 발급된 CSRF Token을 hidden 타입으로 전달 --%>
	<%-- => 서버에 전달된 요청이 실제 서버에서 허용된 요청이 맞는지를 확인하기 위해 CSRF Token 발행 --%>
	<%-- => 서버에서는 뷰페이지를 생성할 때마다 랜덤으로 토큰을 발행하여 세션에 저장하고 사용자가 서버에 
	페이지를 요청할 때 Hidden 타입으로 토큰을 서버에 전달하여 세션의 저장된 토큰과 비교히여 사용자를 확인 --%>
	<%-- CSRF(Cross-Site Request Forgery) 공격 : 사이트간 요청을 위조하는 공격  --%>
	<%-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"> --%>
	<%-- csrfInput : CSRF Token을 hidden 타입으로 서버에 전달하기 위한 태그 --%>
	<sec:csrfInput/>
	</form>
</body>
</html>








