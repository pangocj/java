<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Security 태그 라이브러리를 JSP 문서에 포함 - Spring Security 태그 사용 가능 --%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>메인페이지</h1>
	<hr>
	<h3><a href="<c:url value="/user/page"/>">User</a></h3>
	<h3><a href="<c:url value="/manager/page"/>">Manager</a></h3>
	<h3><a href="<c:url value="/admin/page"/>">Administrator</a></h3>
	<hr>
	<%-- authorize : 권한을 비교하여 비교하여 태그의 포함 여부를 설정하기 위한 태그 --%>
	<%-- access 속성 : 권한(Role)을 속성값으로 설정 - SpEL 사용 가능 --%>
	<%-- 인증을 받지 않은 사용자인 경우 태그 포함되도록 설정 --%>
	<sec:authorize access="isAnonymous()">
		<h3><a href="<c:url value="/login"/>">로그인</a></h3>
	</sec:authorize>
	
</body>
</html>