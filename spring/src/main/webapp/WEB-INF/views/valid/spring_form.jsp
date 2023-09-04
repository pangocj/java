<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Spring 프레임워크에서 제공하는 폼태그 라이브러리 포함 --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>사원등록</h1>
	<hr>
	<c:url value="/valid/spring" var="url"/>
	<%-- Spring Form 태그 : 페이지를 요청하여 입력값을 전달하는 태그 --%>
	<%-- modelAttribute 속성(필수) : 요청 처리 메소드 매개변수에 저장된 Command 객체의 속성명을 속성값으로 설정 --%>
	<%-- => 유효성 검증 실패시 사용자 입력값이 저장된 Command 객체를 제공받아 사용 --%>
	<form:form action="${url }" method="post" modelAttribute="employee">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<%-- Spring input 태그 : 문자열을 입력받기 위한 태그 --%>
				<%-- => input 태그의 type 속성값을 [text]로 설정하는 것과 동일 --%>
				<%-- path 속성 : 값을 전달하기 위한 이름을 속성값으로 설정 --%>
				<%-- => input 태그의 name 속성값과 id 속성값을 동시에 설정하는 것과 동일 --%>
				<%-- => 유효성 검증이 실패하는 경우 value 속성값을 설정하는 것과 동일 --%>
				<form:input path="id"/>
				<%-- Spring errors 태그 : 에러메세지를 제공받아 출력하는 태그 --%>
				<%-- path 속성 : 에러메세지를 제공받아 출력하기 위한 식별자(전달값의 이름)를 속성값으로 설정 --%>
				<%-- cssClass 속성 : 에러메세지를 출력하기 위한 CSS 스타일의 클래스 선택자를 속성값으로 설정 --%>
				<%-- element 속성 : 에러메세지를 출력하기 위한 태그를 속성값으로 설정  --%>
				<%-- delimiter 속성 : 에러메세지가 여러개인 경우 구분하기 위한 구분자를 속성값으로 설정 - 기본 구분자 : <br> --%>
				<form:errors path="id" cssClass="error" element="span" delimiter=" "/>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<%-- Spring password 태그 : 문자열을 입력받기 위한 태그 --%>
				<%-- => input 태그의 type 속성값을 [password]로 설정하는 것과 동일 --%>
				<form:password path="passwd"/>
				<form:errors path="passwd" cssClass="error" element="span" delimiter=" "/>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<form:input path="name"/>
				<form:errors path="name" cssClass="error" element="span" delimiter=" "/>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<form:input path="email"/>
				<form:errors path="email" cssClass="error" element="span" delimiter=" "/>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<%-- Spring radiobutton 태그 : 목록 중 하나를 선택하여 전달하기 위한 태그 --%>
				<%-- => input 태그의 type 속성값을 [radio]로 설정하는 것과 동일 --%>
				<%-- 
				남자<form:radiobutton path="gender" class="gender" value="남자"/>&nbsp;&nbsp;
				여자<form:radiobutton path="gender" class="gender" value="여자"/>
				--%>
				<%-- Spring radiobuttons 태그 : 목록 중 하나를 선택하여 전달하기 위한 태그 --%>
				<%-- => List 객체의 요소값을 제공받아 선택 가능 목록 제공 --%>
				<%-- items 속성 : List 객체(EL)를 속성값으로 설정 --%>
				<%-- <form:radiobuttons path="gender" items="${genderList }"/> --%>
				
				<%-- Spring select 태그 : 목록 중 하나를 선택하여 전달하기 위한 태그 --%>
				<%-- => select 태그와 option 태그를 설정하는 것과 동일 --%>
				<form:select path="gender" items="${genderList }"/>
				<form:errors path="gender" cssClass="error" element="span" delimiter=" "/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<%-- Spring button 태그 : 제출 이벤트를 발생하기 위한 태그 --%>
				<%-- => button 태그의 type 속성값을 [submit]로 설정하는 것과 동일 --%>
				<form:button>등록</form:button>
			</td>
		</tr>
	</table>
	</form:form>
	<%-- 
	<script type="text/javascript">
	$("#joinForm").submit(function() {
		var submitResult=true;
		
		$(".error").hide();

		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if($("#id").val()=="") {
			$("#idMsg").html("아이디를 입력해 주세요.");
			
			submitResult=false;
		} else if(!idReg.test($("#id").val())) {
			$("#idMsg").html("아이디를 형식에 맞게 입력해 주세요.").show();
			submitResult=false;
		}
		
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if($("#passwd").val()=="") {
			$("#passwdMsg").html("비밀번호를 입력해 주세요.");
			submitResult=false;
		} else if(!passwdReg.test($("#passwd").val())) {
			$("#passwdMsg").html("비밀번호를 형식에 맞게 입력해 주세요.");
			submitResult=false;
		} 
		
		if($("#name").val()=="") {
			$("#nameMsg").html("이름을 입력해 주세요.");
			submitResult=false;
		}
		
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if($("#email").val()=="") {
			$("#emailMsg").html("이메일을 입력해 주세요.");
			submitResult=false;
		} else if(!emailReg.test($("#email").val())) {
			$("#emailMsg").html("이메일을 형식에 맞게 입력해 주세요.");
			submitResult=false;
		}
		
		if($(".gender").filter(":checked").length == 0) {
			$("#genderMsg").html("성별을 선택해 주세요.");
			submitResult=false;
		}
		
		$(".error").show();
		
		return submitResult;
	});	
	--%>
</body>
</html>
