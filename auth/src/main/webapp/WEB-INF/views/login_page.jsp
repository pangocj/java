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
			<td><input type="text" name="userid" id="userid" value="${userid }"></td>
			<c:remove var="userid"/>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">로그인</button></td>
		</tr>		
	</table>
	
	<input type="checkbox" name="remember-me">자동 로그인
			
	<%-- CSRF 공격을 방어하기 위해 Spring Security에 의해 발급된 CSRF Token을 hidden 타입으로 전달 --%>
	<%-- => 서버에 전달된 요청이 실제 서버에서 허용된 요청이 맞는지를 확인하기 위해 CSRF Token 발행 --%>
	<%-- => 서버에서는 뷰페이지를 생성할 때마다 랜덤으로 토큰을 발행하여 세션에 저장하고 사용자가 서버에 
	페이지를 요청할 때 Hidden 타입으로 토큰을 서버에 전달하여 세션의 저장된 토큰과 비교히여 사용자를 확인 --%>
	<%-- => 일치 여부를 확인한 토큰은 삭제하고 새로운 뷰에 대한 토큰을 다시 발행 --%>
	<%-- CSRF(Cross-Site Request Forgery) 공격 : 사이트간 요청을 위조하는 공격  --%>
	<%-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"> --%>
	<%-- csrfInput : CSRF Token을 hidden 타입으로 서버에 전달하기 위한 태그 --%>
	<sec:csrfInput/>
	</form>
	
	<%-- SPRING_SECURITY_LAST_EXCEPTION : Spring Security에 의해 마지막에 발생된 예외(Exception 객체)가 
	세션의 속성값으로 저장된 세션의 속성명 --%>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		<hr>
		<%-- <h3 style="color: red;">아이디 또는 비밀번호가 맞지 않습니다.</h3> --%>
		<h3 style="color: red;">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }</h3>
		<%-- 예외가 저장된 세션의 속성값 삭제 --%>
		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION"/>
	</c:if>
	
	<img alt="네이버로그인" src="<c:url value="/resources/images/naverBtn.png"/>" width="200"
		onclick="location.href='<c:url value="/naver/login"/>';">	
	<hr>
	<h3><a href="<c:url value="/"/>">메인으로</a></h3>
	
	<script type="text/javascript">
	$("#loginForm").submit(function() {
		if($("#userid").val()=="") {
			alert("아이디를 입력해 주세요.");
			return false;
		}
		
		if($("#passwd").val()=="") {
			alert("비밀번호를 입력해 주세요.");
			return false;
		}
	});
	</script>
</body>
</html>
