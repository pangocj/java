<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- USERINFO 테이블에 저장된 모든 회원정보를 검색하여 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%-- => 회원정보에서 [회원이름] 태그를 클릭한 경우 [user_view.jsp] 문서 요청 - 아이디 전달 --%>
<%-- => [회원등록] 태그를 클릭한 경우 [user_write.jsp] 문서 요청 - 관리자에게만 링크 제공 --%>
<%-- => [로그아웃] 태그를 클릭한 경우 [user_logout_action.jsp] 문서 요청 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	//비로그인 상태의 사용자인 경우 - 비정상적인 요청
	if(loginUserinfo==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	List<UserinfoDTO> userinfoList=UserinfoModelOneDAO.getDAO().selectUserinfoList();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/user.css" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
<tr>
	<td width="20"></td>
	<td>
	  	<table width=590 border=0 cellpadding=0 cellspacing=0>
		  	<tr>
				<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 회원목록</b></td>
		  	</tr>
	  	</table>  
	  	<br>
	  
	  	<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  	<tr>
				<td width=190 align=center bgcolor="E6ECDE" height="22">아이디</td>
				<td width=200 align=center bgcolor="E6ECDE">이름</td>
				<td width=200 align=center bgcolor="E6ECDE">이메일</td>
		  	</tr>

			<% for(UserinfoDTO userinfo : userinfoList) { %>		  	
		  	<tr>
				<td width=190 align=center bgcolor="ffffff" height="20">
					<%=userinfo.getUserid() %>
				</td>
				<td width=200 align=center bgcolor="ffffff">
					<a href="user_view.jsp?userid=<%=userinfo.getUserid() %>" class="user">
						<%=userinfo.getName() %>
					</a>
				</td>
				<td width=200 align=center bgcolor="ffffff">
					<!-- JSP 표현식(Expression)은 NULL을 [null] 문자열로 변환하여 출력 처리 -->
					<%-- => JSP 표현식(Expression)의 값이 NULL인 경우 출력되지 않도록 if 구문 사용 --%>
					<% if(userinfo.getEmail()!=null) { %>
						<%=userinfo.getEmail() %>
					<% } %>
				</td>
		  	</tr>
		  	<% } %>
	  	</table>

		<br>
	  	<table border="0" cellpadding="0" cellspacing="1" width="590">
			<tr>
				<td align="right">
					<% if(loginUserinfo.getStatus()==9) { %>
					<input type="button" value="회원등록" onclick="location.href='user_write.jsp';"/>
					<% } %>
					<input type="button" value="로그아웃" onclick="location.href='user_logout_action.jsp';"/>
				</td>
			</tr>
		</table>		
	</td>
</tr>
</table>  
</body>
</html>