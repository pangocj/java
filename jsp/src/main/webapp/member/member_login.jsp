<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 로그인정보(아이디와 비밀번호)를 입력받기 위한 JSP 문서 --%>
<%-- => [로그인] 태그를 클릭한 경우 [member/member_login_action.jsp] 문서를 요청하여 이동 - 입력값(로그인정보) 전달 --%>
<%
	//전달값(로그인 후 요청할 JSP 문서의 URL 주소)을 반환받아 저장
	String returnUrl=request.getParameter("returnUrl");
	if(returnUrl==null) {
		returnUrl="";
	}

	//인증 실패시 세션에 저장되어 제공된 속성값을 객체로 반환받아 사용
	// => [member_login.jsp] 문서에서만 사용 가능하도록 속성값을 객체로 반환받은 후 반드시 삭제 
	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		session.removeAttribute("message");
	}
	
	String id=(String)session.getAttribute("id");
	if(id==null) {
		id="";
	} else {
		session.removeAttribute("id");
	}
%>    
<style type="text/css">
#space {
	height: 50px;
}    
.login_tag {
	margin: 5px auto;
	width: 300px;
}    

#loginForm label {
	text-align: right;
	width: 100px;
	float: left;
}

#loginForm ul li {
	list-style-type: none;
	margin-bottom: 10px;
}

#loginForm input:focus {
	border: 2px solid aqua;
}

#login_btn {
	margin: 0 auto;
	padding: 5px;
	width: 300px;
	background-color: black;
	color: white;
	font-size: 1.2em;
	cursor: pointer;
	letter-spacing: 20px;
	font-weight: bold; 	 
}

#search {
	margin-top: 10px;	
	margin-bottom: 20px;	
}

#message {
	color: red;	
	font-weight: bold;
}

a:hover {
	color: blue;
	text-decoration: underline;
}
</style>
<div id="space"></div>
<form id="loginForm" name="loginForm" action="<%=request.getContextPath() %>/member/member_login_action.jsp" method="post">
	<input type="hidden" name="returnUrl" value="<%=returnUrl%>">
	<ul class="login_tag">
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" value="<%=id%>">
		</li>
		<li>
			<label for="id">비밀번호</label>
			<input type="password" name="passwd" id="passwd">
		</li>
	</ul>
	<div id="login_btn">로그인</div>
	<div id="search">
		<a href="<%=request.getContextPath() %>/index.jsp?group=member&worker=search_id">아이디 찾기</a> |
		<a href="#">비밀번호 찾기</a> 
	</div>
	<div id="message"><%=message %></div>
</form>
<script type="text/javascript">
$("#id").focus();

$("#login_btn").click(function() {
	if($("#id").val()=="") {
		$("#message").text("아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}
	
	if($("#passwd").val()=="") {
		$("#message").text("비밀번호를 입력해 주세요.");
		$("#passwd").focus();
		return;
	}
	
	$("#loginForm").submit();
});

</script>
