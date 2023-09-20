<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		
		<button type="submit">제출</button>
	</form>
</body>
</html>