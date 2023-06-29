<%@page import="java.net.URLEncoder"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	//바인딩된 세션에서 권한 관련 정보의 속성값을 객체(로그인 상태의 사용자정보)로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	//비로그인 상태의 사용자가 JSP 문서를 요청한 경우 [member/member_login.jsp] 문서로 이동하기
	//위한 URL 주소를 클라이언트에게 전달하여 응답
	// => 로그인 후 기존 요청 JSP 문서로 이동되도록 설정
	if(loginMember==null) {
		//request.getRequestURI() : 요청 URL 주소에서 JSP 문서의 경로를 반환하는 메소드 
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);//requestURI = /jsp/index.jsp
				
		//request.getQueryString() : 요청 URL 주소에서 질의문자열(QueryString)을 반환하는 메소드 
		String queryString=request.getQueryString();		
		//System.out.println("queryString = "+queryString);//queryString = group=cart&worker=cart_list
		
		String returnUrl=requestURI;
		if(queryString!=null) {
			returnUrl+="?"+queryString;
		} 
		//System.out.println("returnUrl = "+returnUrl);//returnUrl = /jsp/index.jsp?group=cart&worker=cart_list
		
		//로그인 후 요청할 JSP 문서의 URL 주소를 부호화 처리하여 저장
		returnUrl=URLEncoder.encode(returnUrl, "utf-8");
		
		//로그인 후 요청할 JSP 문서의 URL 주소를 질의문자열로 전달
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()
				+"/index.jsp?group=member&worker=member_login&returnUrl="+returnUrl+"';");
		out.println("</script>");
		return;
	}
--%>
<%@include file="/security/login_returnUrl.jspf" %>
<h1>장바구니 목록</h1>