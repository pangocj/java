<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비로그인 상태의 사용자인 경우 사용자로부터 로그인 처리에 필요한 인증정보(아이디와 비밀번호)를 입력받기 JSP 문서 --%>
<%-- => [로그인] 태그를 클릭한 경우 [login_action.jsp] 문서를 요청하여 페이지 이동 - 입력값(인증정보) 전달 --%>
<%-- 로그인 상태의 사용자인 경우 환영메세자를 전달하여 응답하는 JSP 문서 --%>
<%-- => [로그아웃] 태그를 클릭한 경우 [logout_action.jsp] 문서를 요청하여 페이지 이동 --%>
<%-- => [내정보] 태그를 클릭한 경우 [login_user.jsp] 문서를 요청하여 페이지 이동 --%>
<%
	//바인딩된 세션에서 권한 관련 정보가 저장된 객체를 반환받아 저장
	String loginId=(String)session.getAttribute("loginId");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<% if(loginId==null) {//비로그인 상태의 사용자인 경우 %>
	<% 
		/*
		//전달된 에러메세지를 반환받아 저장
		String message=request.getParameter("message");
		if(message==null) {//전달값이 없는 경우
			message="";//표현식으로 인해 null 문자열이 출력되는 것을 방지
		}
		*/
		
		//바인딩된 세션에 저장된 에러메세지를 반환받아 저장
		String message=(String)session.getAttribute("message");
		if(message==null) {
			message="";
		} else {
			//session.removeAttribute(String attributeName) : 클라이언트의 정보(JSESSIONID 쿠키)로 
			//바인딩된 세션(session)에서 매개변수로 전달된 속성명의 속성값(객체)을 삭제하는 메소드
			// => 바인딩된 세션에 저장된 객체는 세션 소멸 전까지 유지
			//다른 JSP 문서에 세션에 저장된 에러메세지를 사용할 수 없도록 삭제 처리
			session.removeAttribute("message");
		}
		
		String id=(String)session.getAttribute("id");
		if(id==null) {
			id="";
		} else {
			session.removeAttribute("id");
		}
	%>
	<h1>로그인</h1>
	<hr>
	<form action="login_action.jsp" method="post" name="loginForm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="<%=id%>"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="loginBtn">로그인</button>
		</tr>
	</table>
	</form>
	<p id="message" style="color: red;"><%=message %></p>
	
	<script type="text/javascript">
	loginForm.id.focus();
	
	document.getElementById("loginBtn").onclick=function() {
		if(loginForm.id.value=="") {
			document.getElementById("message").innerHTML="아이디를 입력해 주세요.";
			loginForm.id.focus();
			return;
		}
		
		if(loginForm.passwd.value=="") {
			document.getElementById("message").innerHTML="비밀번호를 입력해 주세요.";
			loginForm.passwd.focus();
			return;
		}
		
		loginForm.submit();
	}
	</script>
	<% } else {//로그인 상태의 사용자인 경우 %>
	<h1>메인페이지</h1>
	<hr>	
	<p>
		<%=loginId %>님, 환영합니다.&nbsp;&nbsp;
		<a href="logout_action.jsp">[로그아웃]</a>&nbsp;&nbsp;
		<a href="login_user.jsp">[내정보]</a>
	</p>
	<% } %>
</body>
</html>
