<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1 align="center">회원목록</h1>
	<hr>
	<table align="center" border="1" cellspacing="0" width="300">
		<tr>
			<th width="140">아이디</th>
			<th width="160">이름</th>
		</tr>
		<%-- 회원목록 출력 => 반복문 시작 --%>	
		<tr align="center">
			<td width="140">admin</td>
			<td width="160">
				<a href="memberView.jsp?id=admin">관리자</a>				</td>
		</tr>
		<%-- 반복문 종료 --%>

		<tr align="right">
			<td colspan="2">
				<button type="button" 
					onclick="location.href='memberInputForm.jsp';">회원등록</button>
			</td>
		</tr>
	</table>
</body>
</html>