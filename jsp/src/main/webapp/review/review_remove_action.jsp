<%@page import="java.io.File"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 글번호를 전달받아 REVIEW 테이블에 저장된 게시글의 상태를 [0]으로 변경하여 삭제 처리하고
[review/review_list.jsp] 문서로 이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => 로그인 상태의 사용자 중 게시글 작성자이거나 관리자인 경우에만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf"%>
<%
	if(request.getParameter("num")==null) {//전달값이 없는 경우 - 비정상적인 요청
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;		
	}
	
	//전달값을 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));
	
	//글번호를 전달받아 REVIEW 테이블에 저장된 게시글을 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
	ReviewDTO review=ReviewDAO.getDAO().selectReview(num);
	
	if(review==null) {//검색된 게시글이 없는 경우 - 비정상적인 요청
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;	
	}
	
	//로그인 상태의 사용자가 게시글 작성자 및 관리자가 아닌 경우 - 비정상적인 요청
	if(!loginMember.getId().equals(review.getReviewid()) && loginMember.getMemberStatus()!=9) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}
	
	//검색된 게시글(ReviewDTO 객체)의 상태(Status 필드값)를 [0]으로 변경 처리
	review.setStatus(0);
	
	//게시글을 전달받아 REVIEW 테이블에 저장된 해당 게시글을 변경하는 DAO 클래스의 메소드 호출
	ReviewDAO.getDAO().updateReview(review);
	/*
	if(review.getReviewimg()!=null) {
		//리뷰 이미지 파일을 업로드 디렉토리에서 삭제 처리
		new File(request.getServletContext().getRealPath("/review_images"), review.getReviewimg()).delete();
	}
	*/
	
	//페이지 이동
	response.sendRedirect(request.getContextPath()+"/index.jsp?group=review&worker=review_list");
%>	





















