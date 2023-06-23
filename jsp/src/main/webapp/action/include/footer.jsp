<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 요청 JSP 문서에서 스레드가 이동되어 실행되는 JSP 문서는 요청 JSP 문서의 request 객체와
response 객체를 전달받아 사용 --%>
<%-- => request 객체와 response 객체로 메소드 사용 제한 발생  --%>  
<%
	//스레드가 이동되어 실행되는 JSP 문서에서는 request 객체의 정보를 반환받아 사용할 수 
	//있지만 request 객체의 정보 변경 불가능
	// => request 객체의 정보를 변경해야될 경우 요청 JSP 문서에서 처리
	//request.setCharacterEncoding("utf-8");
	
	String master=request.getParameter("master");
	
	//스레드가 이동되어 실행되는 JSP 문서에서는 response 객체에 실행 결과를 포함하여 요청 JSP 
	//문서에 전달할 수 있지만 클라이언트에게 에러코드나 URL 주소를 직접 전달하여 응답 불가능
	// => 클라이언트에게 에러코드나 URL 주소를 전달할 경우 JavaScript 이용
	if(master==null) {
		//response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		response.sendRedirect("../standard_action.jsp");
		return;
	}
%>    
<hr>    
<p>Copyright © Itwill Corp. All rights reserved.</p>
<%-- <p>관리자 : 홍길동(hong@itwill.xyz)</p> --%>
<p>관리자 : <%=master %></p>