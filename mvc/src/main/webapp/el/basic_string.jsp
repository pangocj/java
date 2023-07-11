<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext.setAttribute(String attributeName, Object attributeValue)
	// => pageContext 내장객체에 속성명(문자열)과 속성값(객체)를 전달받아 저장하는 메소드 - page Scope
	//page Scope : 스코프 속성값을 저장한 웹프로그램에서만 속성값을 객체를 반환받아 사용 가능
	pageContext.setAttribute("name", "홍길동");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<p>EL : 스코프(Scope) 객체의 속성값으로 저장된 객체를 제공받아 출력 처리하기 위한 언어</p>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//pageContext.getAttribute(String attributeName) : pageContext 내장객체에 저장된
		//스코프 속성값을 속성명을 이용하여 객체로 반환하는 메소드
		// => Object 타입의 객체로 반환하므로 반드시 명시적 객체 형변환하여 사용
		String name=(String)pageContext.getAttribute("name");
		
		//매개변수로 전달받은 속성명에 대한 속성값이 없는 경우 null 반환
		String pageName=(String)pageContext.getAttribute("pageName");
	%>
	<%-- 반환받은 객체는 JSP 표현식(Expression)를 이용하여 출력 처리 --%>
	<p>이름(name) = <%=name %></p>
	<%-- 반환받은 객체가 [null]인 경우 JSP 표현식은 "null" 문자열로 변환되어 출력 처리 --%>
	<p>이름(pageName) = <%=pageName %></p>
	<%-- if 구문을 사용하여 반환받은 객체가 [null]이 아닌 경우에만 JSP 표현식으로 출력 처리 --%>
	<p>이름(pageName) = <% if(pageName!=null) { %><%=pageName %><% } %></p>
	<hr>
	<h2>EL 사용</h2>
	<%-- ${속성명} : EL 표현식으로 스코프 객체의 속성명을 사용하면 속성값을 제공받아 출력 처리 --%>
	<%-- => getAttribute() 메소드를 호출하지 않아도 스코프 속성값을 제공받아 출력 처리 가능 --%>
	<%-- => EL 표현식을 사용하여 스코프 속성명으로 값을 제공받아 출력 처리 --%>	
	<p>이름(name) = ${name}</p>
	<%-- EL 표현식에서 사용한 스코프 객체의 속성명에 대한 속성값이 없는 경우 EL 미실행 - 속성값 미출력 --%>
	<p>이름(pageName) = ${pageName}</p>
</body>
</html>
