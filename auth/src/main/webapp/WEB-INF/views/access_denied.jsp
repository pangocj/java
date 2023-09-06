<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>에러페이지</h1>
	<hr>
	<h3 style="color: red;">권한이 없어 페이지에 접근 불가능합니다. 관리자에게 문의해 주세요.</h3>
	<hr>
	<h3><a href="<c:url value="/"/>">메인으로</a></h3>
</body>
</html>