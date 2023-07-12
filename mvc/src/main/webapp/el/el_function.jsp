<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib 디렉티브를 사용하여 TLD 파일을 제공받아 TLD 파일에 등록된 EL 함수 또는 커스텀
태그를 JSP 문서에 사용할 있도록 설정 --%>
<%-- taglib Directive : TLD 파일을 제공받아 JSP 문서에 EL 함수 또는 커스텀 태그를 제공하는 지시어 --%>
<%-- prefix 속성 : EL 함수 또는 커스텀 태그를 사용하기 위한 접두사(식별자)를 속성값으로 설정 --%>    
<%-- uri 속성 : TLD 파일을 구분하기 위한 식별자(uri 엘리먼트값)를 속성값으로 설정 - 자동 완성 기능 사용 가능 --%>
<%@taglib prefix="elfun" uri="http://www.itwill.xyz/mvc/el"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL Function</h1>
	<hr>
	<p>EL 함수 : EL 표현식에서 사용하기 위한 함수</p>
	<p>EL 함수를 사용할 경우 호출될 메소드가 선언된 클래스를 작성하고 TLD 파일에서 EL 함수를
	등록 후 JSP 문서에서 taglib 디렉티브를 이용하여 TLD 파일을 제공받아	EL 함수 사용</p>
	<hr>
	<p>${elfun:hello("홍길동") }</p> 
	<p>${elfun:hello("임꺽정") }</p> 
	<p>${elfun:hello("전우치") }</p> 
</body>
</html>