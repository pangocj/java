<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 글번호를 전달받아 REVIEW 테이블에 저장된 게시글을 검색하여 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => 전달된 페이지번호, 검색대상, 검색단어는 반환받아 [review_list.jsp] 문서를 요청할 때 전달 --%>
<%
	if(request.getParameter("num")==null) {//전달값이 없는 경우 - 비정상적인 요청
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;		
	}

	//전달값을 반환받아 저장
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	String search=request.getParameter("search");
	String keyword=request.getParameter("keyword");
	
	//글번호를 전달받아 REVIEW 테이블에 저장된 게시글을 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
	ReviewDTO review=ReviewDAO.getDAO().selectReview(num);
	
	if(review==null) {//검색된 게시글이 없는 경우 - 비정상적인 요청
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;	
	}
	
	//세션에 저장된 권한 관련 속성값을 객체로 반환받아 저장
	// => 검색된 게시글이 비밀글인 경우 권한을 비교하기 위해 필요
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	if(review.getStatus()==2) {//검색된 게시글이 비밀글인 경우
		//게시글을 검색한 사용자가 비로그인 상태의 사용자이거나 로그인 상태의 사용자가 게시글
		//작성자 아니고 관리자도 아닌 경우 - 비정상적인 요청
		if(loginMember==null || !loginMember.getId().equals(review.getReviewid()) 
			&& loginMember.getMemberStatus()!=9) {
			out.println("<script type='text/javascript'>");
			out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
			out.println("</script>");
			return;
		}
	}
	
	
%>












