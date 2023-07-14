<%@page import="xyz.itwill.jstl.Student"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib 디렉티브를 사용하여 JSTL의 Core 태그 라이브러리를 JSP 문서에 포함해야만
Core 태그 라이브러리의 커그텀 태그를 제공받아 사용 가능 --%>
<%-- => Core 태그 라이브러리의 prefix 속성값은 [c]로 설정 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - EL 지원 태그</h1>
	<hr>
	<%-- set 태그 : 스코프 객체의 속성값으로 객체를 저장(변경)하기 위한 태그 --%>
	<%-- var 속성 : 스코프 객체에 저장될 속성값을 구분하기 위한 속성명을 태그 속성값으로 설정 --%>
	<%-- value 속성 : 스코프 객체에 저장될 속성값(객체)을 태그 속성값으로 설정 --%>
	<%-- scope 속성 : 스코프 객체에 저장된 속성값의 사용범위를 태그 속성값으로 설정 --%>
	<%-- => page, request, session, application 중 하나를 속성값으로 설정 --%>
	<%-- => scope 속성를 생략하면 [page] 속성값을 기본값으로 사용 --%>
	<c:set var="su" value="10" scope="page"/>
	<p>su = ${su }</p>
	
	<%-- value 속성 대신 태그내용을 사용하여 스코프 객체에 저장될 속성값 설정 가능 --%>
	<%-- 스코프 객체의 속성명이 같은 경우 스코프 객체의 속성값 변경 처리 --%>
	<c:set var="su">20</c:set>
	<p>su = ${su }</p>
	
	<%-- set 태그의 value 속성값으로 EL를 이용하여 객체를 제공받아 속성값으로 저장 가능 --%>
	<%-- => EL 표현식에서 EL 연산자를 사용 가능 --%>
	<c:set var="tot" value="${su + 10}"/>
	<p>tot = ${tot }</p>
	
	<c:set var="name" value="홍길동"/>
	<p>name = ${name }</p>
	
	<c:set var="now" value="<%=new Date() %>"/>
	<%-- EL 표현식으로 제공받은 스코프 객체의 속성값을 Java 객체인 경우 자동으로 toString() 
	메소드를 호출하여 반환받은 문자열로 출력 처리 --%>
	<p>now = ${now }</p>
	<p>now.getTime() = ${now.getTime() }</p>
	<p>now.time = ${now.time }</p>
	
	<c:set var="student" value="<%=new Student() %>"/>
	<%-- Student 클래스의 toString() 메소드를 오버라이드 선언하지 않은 경우 Object 클래스의
	toString() 메소드 호출 - 객체의 메모리 주소(HashCode)를 문자열로 반환받아 출력 처리01 --%>
	<p>student= ${student }</p>
	<%-- EL 표현식에 의해 Java 객체의 필드값을 제공받아 출력 처리 - Getter 메소드 자동 호출 --%>
	<p>학번 = ${student.num }, 이름 = ${student.name }</p>
	
	<%-- set 태그를 사용하여 스코프 객체에 저장된 속성값(객체)의 필드값 변경 가능 - Setter 메소드 자동 호출 --%>
	<%-- target 속성 : 필드값을 변경할 객체를 태그 속성값으로 설정 --%> 
	<%-- => EL을 사용하여 스코프 객체의 속성값(객체)을 제공받아 사용 가능 --%>
	<%-- property : 필드값을 변경할 객체의 필드명을 태그 속성값으로 설정 --%>
	<%-- value : 필드에 저장(변경)될 객체를 태그 속성값으로 설정 --%>
	<c:set target="${student }" property="num" value="1000"/>
	<c:set target="${student }" property="name" value="홍길동"/>
	<p>학번 = ${student.num }, 이름 = ${student.name }</p>

	<%-- remove 태그 : 스코프 객체에 저장된 속성값을 삭제하는 태그 --%>	
	<c:remove var="student"/>
	<p>student = ${student }</p>
</body>
</html>
