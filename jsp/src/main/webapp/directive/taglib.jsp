<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib Directive를 사용하여 태그 라이브러리 파일을 포함하여 커스텀 태그 사용 --%>
<%-- prefix 속성 : 커스텀 태그를 사용하기 위한 접두사(NameSpace)를 속성값으로 설정 --%>
<%-- uri 속성 : 태그 라이브러리 파일(TLD)의 식별자를 속성값으로 설정 --%>    
<%@taglib prefix="custom" uri="http://www.itwill.xyz/custom" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>taglib Directive</h1>
	<hr>
	<p>JSP 문서에 태그 라이브러리 파일(TLD)을 포함하여 커스텀 태그를 제공하는 지시어</p>
	<p>태그 라이브러리 파일 : 태그 클래스를 커스텀 태그로 등록하기 위한 XML 파일</p>
	<p>커스텀 태그 : 태그 클래스를 이용하여 만들어진 Java 태그</p>
	<hr>
	<custom:display/>
	<custom:display/>
	<custom:display/>
</body>
</html>