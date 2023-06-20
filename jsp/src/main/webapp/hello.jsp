<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트가 JSP 문서를 요청하면 WAS 프로그램은 JSP 문서를 해석하여 JSP 문서에 대한 
서블릿 클래스를 생성하고 컴파일하여 객체를 생성한 후 요청 처리 메소드를 호출해 클라이언트
요청에 대한 처리와 실행결과를 저장한 파일을 생성하여 클라이언트에게 전달하여 응답 --%>    
<%-- => JSP 문서에 대한 서블릿 클래스가 이미 생성되어 있는 경우 객체를 이용하여 요청 처리 메소드 호출 --%>
<%-- => JSP 문서가 변경된 후 클라이언트에 의해 요청되면 JSP 문서를 해석하여 서블릿 클래스 생성 --%>
<%
	//Java 명령 작성
	Date now=new Date();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	String displayNow=dateFormat.format(now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
#displayDiv {
	width: 600px;
	margin: 0 auto;
	padding: 30px 0;
	font-size: 2em;
	font-weight: bold;
	text-align: center;
	border: 2px solid black;
}
</style>
</head>
<body>
	<h1>Hello, JSP!!!</h1>
	<hr>
	<!-- HTML 주석 : 주석문이 클라이언트에게 전달 - 소스보기 가능 : 웹디자이너 -->
	<%-- JSP 주석 : 주석문이 클라이언트에게 미전달 - 소스보기 불가능 : 웹프로그래머 --%>
	<p>JSP(Java Server Page) : 서블릿보다 쉽게 웹프로그램 작성하기 위한 기술
	- 스트립트 요소(Script Element), 지시어(Directive), 표준 액션 태그(Standard Action Tag)</p>
	<hr>
	<div id="displayDiv"><%=displayNow %></div>
	
	<script type="text/javascript">
	setInterval(function() {
		location.reload();
	}, 1000);
	</script>
</body>
</html>
