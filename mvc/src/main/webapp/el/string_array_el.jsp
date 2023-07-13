<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Array</h1>
	<hr>
	<%-- <p>${nameArray }</p> --%>
	<ul>
		<%-- 스코프 객체의 속성값이 배열인 경우 배열 요소값을 제공받아 출력하기 위해 첨자 사용 --%>
		<%-- => EL 표현식에서 . 연산자로 첨자를 사용하여 표현한 경우 ELException 발생 --%>
		<%-- <li>${nameArray.0 }</li> --%>
		
		<%-- 배열의 요소값을 제공받아 출력하기할 때 EL 표현식에서 . 연산자 사용 불가능 --%> 
		<%-- => EL 표현식에서 . 연산자 대신 [] 연산자를 사용 --%>
		<%-- <li>${nameArray["0"] }</li> --%>	
		
		<%-- 첨자는 " " 기호 생략 가능 --%>
		<li>${nameArray[0] }</li>	
		<li>${nameArray[1] }</li>	
		<li>${nameArray[2] }</li>	
		<li>${nameArray[3] }</li>	
		<li>${nameArray[4] }</li>
		<%-- EL 표현식에서 배열의 첨자가 범위를 벗어난 경우 EL 미실행 - 값 미출력 --%>	
		<li>${nameArray[5] }</li>	
	</ul>
</body>
</html>








