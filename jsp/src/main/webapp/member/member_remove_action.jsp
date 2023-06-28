<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비밀번호를 전달받아 MEMBER 테이블에 저장된 회원정보의 비밀번호와 비교하여 같은 경우
MEMBER 테이블에 저장된 회원정보의 회원상태를 [0]으로 변경하여 탈퇴 처리하고 [main/main_page.jsp] 문서를
요청하기 위한 URL 주소를 전달하여 응답하는 JSP 문서 --%>   
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf" %>
<%
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}
	
	//전달값을 반환받아 저장 - 암호화 처리
	String passwd=Utility.encrypt(request.getParameter("passwd"));
	
	//로그인 상태의 사용자 비밀번호와 전달받은 비밀번호를 비교하여 같지 않은 경우
	if(!loginMember.getPasswd().equals(passwd)) {
		session.setAttribute("message", "입력하신 비밀번호가 맞지 않습니다.");
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=member&worker=password_confirm&action=remove'");
		out.println("</script>");
		return;
	}
	
	//아이디와 회원상태를 전달받아 MEMBER 테이블에 저장된 회원정보의 회원상태를 변경하는 DAO 클래스의 메소드 호출
	MemberDAO.getDAO().updateMemberStatus(loginMember.getId(), 0);

	//세션 무효화 처리
	session.invalidate();
	
	//페이지 이동	
	response.sendRedirect(request.getContextPath()+"/index.jsp?group=member&worker=member_remove");
%>
