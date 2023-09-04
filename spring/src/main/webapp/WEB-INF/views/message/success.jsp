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
</body>
</html>