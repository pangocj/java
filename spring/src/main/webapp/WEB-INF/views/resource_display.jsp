<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>리소스 파일</h1>
	<hr>
	<%-- 리소스 파일(Resource File) : 클라이언트가 웹문서(HTML 문서)를 해석하여 실행하기 위해
	필요한 정보를 제공하기 위한 웹서버에 저장된 파일 --%>
	<%-- => CSS 파일, JavaScript Source 파일, 멀티미디어 파일 등 --%>
	<%-- => 웹문서(HTML 문서)를 해석할 때 리소스 파일이 없는 경우 404 에러코드 발생 - 비정상적인 응답 결과 출력 --%>
	<img src="/spring/WEB-INF/view/Koala.jpg" width="200">
</body>
</html>