<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- JSP 문서에 Spring 관련 태그를 사용할 수 있는 Spring 태그 라이브러리 포함 --%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSPRING</title>
</head>
<body>
	<h1>제품등록</h1>
	<hr>
	<c:url value="/msg/register" var="url"/>
	<form:form action="${url }" method="post" modelAttribute="product">
	<table>
		<tr>
			<%-- <td>제품코드</td> --%>
			<%-- message : MessageSource 객체를 사용하여 메세지를 제공받아 출력하는 태그 --%>
			<%-- code 속성 : Properties 파일에서 메세지를 제공하기 위한 식별자(이름)를 속성값 설정  --%>
			<td><spring:message code="product.code"/></td>
			<td>
				<form:input path="productCode"/>
				<form:errors path="productCode" element="span"/>
			</td>	
		</tr>
		<tr>
			<%-- <td>제품명</td> --%>
			<td><spring:message code="product.name"/></td>
			<td>
				<form:input path="productName"/>
				<form:errors path="productName" element="span"/>
			</td>	
		</tr>
		<tr>
			<%-- <td>제품수량</td> --%>
			<td><spring:message code="product.qty"/></td>
			<td>
				<form:input path="productQuantity" />
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