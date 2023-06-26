<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 [displayStudent.jsp] 문서를
요청할 수 있는 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>    
<%
	//전달값이 없는 경우 - 비정상적인 요청
	if(request.getParameter("no")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//전달값을 반환받아 변수에 저장
	int no=Integer.parseInt(request.getParameter("no"));
	
	//학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하는 DAO 클래스의 메소드 호출
	int rows=StudentDAO.getDAO().deleteStudent(no);
	
	if(rows > 0) {//삭제행이 있는 경우 - 정상적인 요청
		response.sendRedirect("displayStudent.jsp");	
	} else {//삭제행이 없는 경우 - 비정상적인 요청
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
%>
