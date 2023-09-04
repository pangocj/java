<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>제품등록확인</h1>
	<hr>
	<p><spring:message code="product.code"/> : ${product.productCode }</p>
	<p><spring:message code="product.name"/> : ${product.productName }</p>
	<p><spring:message code="product.qty"/> : ${product.productQuantity }</p>
	<hr>
	<%-- arguments 속성 : 메세지의 표현식({정수값}) 대신 사용될 값을 속성값으로 설정 --%>
	<%-- => 표현식이 여러개인 경우 속성값을 ,로 구분하여 여러개 전달 가능  --%>
	<p><spring:message code="product.success" arguments="${product.productName},${product.productCode }"/></p>
</body>
</html>