<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib 디렉티브를 사용하여 TLD 파일을 제공받아야 JSP 문서에서 커스텀 태그 사용 가능 --%>    
<%@taglib prefix="simple" uri="http://www.itwill.xyz/mvc/custom"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - NoAttribute And NoBody</h1>
	<hr>
	<%-- <simple:hello></simple:hello> --%>
	<%-- 태그내용이 없는 태그는 시작태그와 종료태그를 같이 표현 --%>
	<simple:hello/>
	<simple:hello/>
	<simple:hello/>
</body>
</html>