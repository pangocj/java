<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="profile">
	관리자님, 환영합니다.&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/member/member_logout_action.jsp">로그아웃</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/index.jsp?group=main&worker=main_page">쇼핑몰 이동</a>&nbsp;&nbsp;
</div>
<div id="logo"><a href="<%=request.getContextPath() %>/index.jsp">관리자</a></div>
<div id="menu">
	<a href="#">회원관리</a>
	<a href="#">게시글관리</a>
	<a href="#">제품관리</a>
	<a href="#">구매관리</a>
</div>
</html>