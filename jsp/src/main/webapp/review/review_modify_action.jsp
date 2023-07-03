<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@page import="java.io.File"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 변경 게시글을 전달받아 REVIEW 테이블에 저장된 게시글을 변경하고 [review/review_detail.jsp]
문서로 이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => [review/review_detail.jsp] 문서로 글번호, 페이지번호, 검색대상, 검색단어 전달 --%>
<%-- => 로그인 상태의 사용자 중 게시글 작성자이거나 관리자인 경우에만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf"%>
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}

	//전달파일을 저장할 서버 디렉토리(웹자원)의 파일 시스템 경로를 반환받아 저장
	String saveDirectory=request.getServletContext().getRealPath("/review_images");

	//MultipartRequest 객체 생성 - 모든 전달파일을 서버 디렉토리에 업로드 처리하여 저장
	MultipartRequest multipartRequest=new MultipartRequest(request, saveDirectory
			, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	//전달값을 반환받아 저장
	int num=Integer.parseInt(multipartRequest.getParameter("num"));
	String pageNum=multipartRequest.getParameter("pageNum");
	String search=multipartRequest.getParameter("search");
	String keyword=multipartRequest.getParameter("keyword");
	String subject=Utility.escapeTag(multipartRequest.getParameter("subject"));
	int status=1;
	if(multipartRequest.getParameter("secret")!=null) {
		status=Integer.parseInt(multipartRequest.getParameter("secret"));
	}
	String content=Utility.escapeTag(multipartRequest.getParameter("content"));
	String reviewimg=multipartRequest.getFilesystemName("reviewimg");
	if(reviewimg!=null) {//파일이 전달되어 업로드 처리된 경우	
		//REVIEW 테이블에 저장된 게시글의 리뷰이미지 파일명을 반환받아 저장 
		String removeImg=ReviewDAO.getDAO().selectReview(num).getReviewimg();
		if(removeImg!=null) {//리뷰이미지 파일이 존재하는 경우 -  기존 리뷰이미지가 존재할 경우
			//기존 리뷰이미지 파일을 업로드 디렉토리에서 삭제 처리 
			new File(saveDirectory, removeImg).delete();
		}
	}

	//DTO 객체를 생성하고 전달값(변경값)으로 필드값 변경
	ReviewDTO review=new ReviewDTO();
	review.setNum(num);
	review.setSubject(subject);
	review.setContent(content);
	review.setReviewimg(reviewimg);
	review.setStatus(status);
	
	//게시글을 전달받아 REVIEW 테이블에 저장된 게시글을 변경하는 DAO 클래스의 메소드 호출
	ReviewDAO.getDAO().updateReview(review);
	
	//페이지 이동
	response.sendRedirect(request.getContextPath()+"/index.jsp?group=review&worker=review_detail"
		+"&num="+num+"&pageNum="+pageNum+"&search="+search+"&keyword="+keyword);
%>
