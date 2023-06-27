<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 MEMBER 테이블의 저장된 회원정보의 아이디와 비교하여 중복 결과값을 전달하여 응답하는 JSP 문서 --%>
<%-- => 아이디 미중복 : 아이디 사용 가능 메세지 출력 - [아이디 사용] 태그를 클릭한 경우 부모창의 입력태그 초기값 변경 --%>
<%-- => 아이디 중복 : 아이디 사용 불가능 메세지 출력 --%>
<%
	//전달값이 없는 경우 - 비정상적인 요청
	if(request.getParameter("id")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//전달값을 반환받아 저장
	String id=request.getParameter("id");
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
	// => null 반환 : 회원정보 미검색 - 아이디 미중복(아이디 사용 가능)
	// => DTO 객체 반환 : 회원정보 검색 - 아이디 중복(아이디 사용 불가능)
	MemberDTO member=MemberDAO.getDAO().selectMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
div {
	text-align: center;
	margin: 10px;
}

.id {
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
	<% if(member==null) {//전달받은 아이디가 중복되지 않는 경우 %>
	<div>입력된 <span class="id">[<%=id %>]</span>는 사용 가능한 아이디입니다.</div>
	<div>
		<button type="button" onclick="selectId();">아이디 사용</button>
	</div>
	<script type="text/javascript">
	function selectId() {
		//opener 객체 : 팝업창을 실행한 부모창을 표현하는 자바스크립트 객체
		opener.join.id.value="<%=id%>";//입력태그(아이디)의 초기값 변경
		opener.join.idCheckResult.value="1";//입력태그(검사결과)의 초기값 변경
		window.close();//창닫기 - 팝업창 종료
	}
	</script>
	<% } else {//전달받은 아이디가 중복된 경우 %>
	<div>입력된 <span class="id">[<%=id %>]</span>는 이미 사용중인 아이디입니다.</div>
	<% } %>
</body>
</html>








