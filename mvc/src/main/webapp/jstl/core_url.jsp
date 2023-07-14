<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core -  URL 관리 태그</h1>
	<hr>
	<%-- 웹자원의 경로를 상대경로로 표현하여 제공 --%>
	<%-- 상대경로 : 요청 웹프로그램의 경로를 기준으로 웹자원의 경로를 표현하는 방법 --%>
	<%-- 문제점)MVC 디자인 패턴을 이용한 JSP Model-2 방식의 웹프로그램 작성시 요청 웹프로그램
	(컨트롤러)의 경로과 응답 웹프로그램(뷰)의 경로가 다른 경우 404 에러 발생 --%>
	<%-- 해결법)웹자원의 경로를 절대경로로 표현하여 제공 --%>
	<img src="images/Koala.jpg" width="200">
	
	<%-- 웹자원의 경로를 절대경로로 표현하여 제공 --%>
	<%-- 절대경로 : 최상위 디렉토리를 기준으로 웹자원의 경로를 표현하는 방법 --%>
	<%-- 문제점)컨텍스트의 이름을 변경될 경우 컨텍스트 경로가 변경되어 404 에러 발생 --%>
	<%-- 해결법)컨텍스트 경로를 제공받아 웹자원의 경로를 절대경로로 표현하여 제공 --%>
	<img src="/mvc/jstl/images/Koala.jpg" width="200">
	
	<%-- request.getContextPath() 메소드를 호출하여 컨텍스트 경로를 반환받아 절대경로로 표현  --%>
	<img src="<%=request.getContextPath() %>/jstl/images/Koala.jpg" width="200">
	
	<%-- EL 표현식에서 pageContext 내장객체를 사용하여 컨텍스트 경로를 제공받아 절대경로로 표현 --%>
	<img src="${pageContext.request.contextPath}/jstl/images/Koala.jpg" width="200">
	
	<%-- url 태그 : 컨텍스트 경로가 포함된 웹자원의 절대경로를 제공하는 태그 --%>
	<%-- value 속성 : 컨텍스트 경로를 제외한 웹자원의 절대경로를 속성값으로 설정 --%>
	<img src="<c:url value="/jstl/images/Koala.jpg"/>" width="200">
</body>
</html>
