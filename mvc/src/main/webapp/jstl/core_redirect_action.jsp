<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- formatter 태그 라이브러리를 JSP 문서에 포함  - 접두사로 [fmt] 사용 --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
	//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
	request.setCharacterEncoding("utf-8");
--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core -  URL 관리 태그</h1>
	<hr>
	<%-- requestEncoding 태그 : POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경하는 태그 --%>
	<%-- value 속성 : 변경할 문자형태(CharacterSet)에 대한 인코딩 방식을 속성값으로 설정 --%>
	<%-- <fmt:requestEncoding value="utf-8"/> --%>
	<c:choose>
		<c:when test="${!empty(param.name) }">
			<p>${param.name }님, 안녕하세요.</p>
		</c:when>
		<c:otherwise>
			<%-- redirect 태그 : 클라이언트에게 URL 주소를 전달하여 응답하는 태그 --%>
			<%-- => URL 주소를 응답받은 클라이언트는 브라우저의 URL 주소를 변경하여 요청 처리 --%>
			<%-- url 속성 : 클라이언트에게 전달할 URL 주소를 속성값으로 설정 --%>
			<c:redirect url="core_redirect_form.jsp"/>
		</c:otherwise>
	</c:choose>
</body>
</html>