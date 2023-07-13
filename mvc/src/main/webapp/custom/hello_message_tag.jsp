<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.xyz/mvc/custom"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - AnyAttribute And NoBody</h1>
	<hr>
	<%-- 커스텀 태그의 속성을 생략한 경우 태그 클래스의 생성자에서 설정한 기본값을 속성값으로 사용 --%>
	<%-- => 커스텀 태그의 속성을 필수로 설정한 경우 속성 생략시 에러 발생 --%>
	<%-- <simple:helloMessage/> --%>

	<%-- 커스텀 태그의 속성을 사용하여 속성값을 변경한 경우 태그 클래스의 Setter 메소드 자동 호출 --%>
	<%-- => 커스텀 태그의 속성값을 저장하기 위한 필드의 Setter 메소드가 없는 경우 에러 발생 --%>	
	<simple:helloMessage name="홍길동"/>
	<simple:helloMessage name="임꺽정"/>
</body>
</html>