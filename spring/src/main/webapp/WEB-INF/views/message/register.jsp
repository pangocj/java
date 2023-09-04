<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSPRING</title>
</head>
<body>
	<h1>제품등록</h1>
	<hr>
	<form:form action="<c:url value="/msg/register"/>" method="post" modelAttribute="product">
	<table>
		<tr>
			<td>제품코드</td>
			<td>
				<form:input path="productCode"/>
				<form:errors path="productCode" element="span"/>
			</td>	
		</tr>
		<tr>
			<td>제품명</td>
			<td>
				<form:input path="productName"/>
				<form:errors path="productName" element="span"/>
			</td>	
		</tr>
		<tr>
			<td>제품수량</td>
			<td>
				<form:input path="productQuantity"/>
				<form:errors path="productQuantity" element="span"/>
			</td>	
		</tr>
		<tr>
			<td colspan="2"><form:button>등록</form:button></td>
		</tr>
	</table>	
	</form:form>
</body>
</html>