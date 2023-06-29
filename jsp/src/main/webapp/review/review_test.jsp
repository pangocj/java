<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- REVIEW 테이블에 게시글(새글)을 500개 삽입하는 JSP 문서 - 테스트 프로그램 --%>
<%
	ReviewDTO review=new ReviewDTO();
	for(int i=1;i<=500;i++) {
		int num=ReviewDAO.getDAO().selectNextNum();
		review.setNum(num);
		review.setId("abc123");
		review.setSubject("테스트-"+i);
		review.setContent("게시글 연습-"+i);
		review.setRef(num);
		review.setIp("192.168.13.31");
		review.setStatus(1);
		ReviewDAO.getDAO().insertReview(review);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>500개의 테스트 게시글이 삽입 되었습니다.</h1>
</body>
</html>