<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인정보를 전달받아 MEMBER 테이블에 저장된 회원정보와 비교하여 로그인 처리하고 
[main/main_page.jsp] 문서를 요청하기 위한 URL 주소를 전달하여 응답하는 JSP 문서 --%>
<%-- => 전달받은 로그인정보로 인증이 실패한 경우 [member/member_login.jsp] 문서를 요청하기 위한 URL 주소를 전달  --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}

	//전달값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=Utility.encrypt(request.getParameter("passwd"));
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
	MemberDTO member=MemberDAO.getDAO().selectMember(id);
	
	//검색된 회원정보가 없거나 검색된 회원정보의 비밀번호와 입력되어 전달된 비밀번호 비교하여 다른 경우 
	if(member==null || !member.getPasswd().equals(passwd)) {//로그인 실패 
		session.setAttribute("message", "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
		session.setAttribute("id", id);
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=member&worker=member_login");
		return;
	}
	
	//로그인 성공 - 바인딩된 세션에 권한 관련 정보의 객체를 속성값으로 저장
	session.setAttribute("loginMember", member);
	
	//페이지 이동
	response.sendRedirect(request.getContextPath()+"/index.jsp?group=main&worker=main_page");
%>
