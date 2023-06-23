<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 인증정보(아이디와 비밀번호)를 전달받아 인증 처리하기 위한 JSP 문서 --%>
<%-- => [login_form.jsp] 문서의 form 태그를 이용하여 post 방식으로 요청하는 JSP 문서 --%>
<%-- 인증 실패 : 전달받은 인증정보가 저장매체에 저장된 인증정보와 일치하지 않는 경우 --%>
<%-- => 클라이언트에게 [login_form.jsp] 문서를 요청할 있는 URL 주소를 전달하여 응답 --%>   
<%-- 인증 성공 : 전달받은 인증정보가 저장매체에 저장된 인증정보와 일치하는 경우 --%>
<%-- => 권한 관련 정보가 저장된 객체를 세션에 저장 - 클라이언트에게 권한 제공 : 로그인 --%>
<%-- => 클라이언트에게 [login_user.jsp] 문서를 요청할 있는 URL 주소를 전달하여 응답 --%>    
<%
	//request.getMethod() : JSP 문서를 요청한 요청방식(GET or POST)을 반환하는 메소드
	if(request.getMethod().equals("GET")) {//JSP 문서를 GET 방식으로 요청한 경우 - 비정상적인 요청
		/*
		//response.sendError(int sc) : 클라이언트에게 에러코드(4XX or 5XX)를 전달하여 응답 처리하는 메소드
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405
		return;
		*/
		
		/*
		//response.sendRedirect(String url) : 클라이언트에게 URL 주소를 전달하여 응답 처리하는 메소드
		// => URL 주소를 응답받은 클라이언트는 브라우저의 요청 URL 주소를 변경하여 요청 처리하고
		//실행결과를 응답받아 출력 - 리다이렉트를 이용한 페이지 이동(리다이렉트 이동)
		//[login_form.jsp] 문서로 이동하기 위한 URL 주소를 전달하여 응답
		// => 질의문자열(QueryString)을 사용하여 [login_form.jsp] 문서에 값(에러메세지)을 전달
		// => 질의문자열로 영문자, 숫자, 일부 특수문자를 제외한 문자는 전달 불가능 - 부호화 처리하여 전달 가능
		//URLEncoder.encode(String s, String enc) : 매개변수로 전달받은 문자열을 원하는 문자형태의
		//유니코드로 부호화 처리하여 반환하는 메소드
		// => JavaScript의 encodeURIComponent 함수와 동일한 기능 제공
		String message=URLEncoder.encode("비정상적인 방법으로 페이지를 요청 하였습니다.", "utf-8");		
		response.sendRedirect("login_form.jsp?message="+message);
		return;
		*/
		
		//바인딩된 세션에 에러메세지 저장
		session.setAttribute("message", "비정상적인 방법으로 페이지를 요청 하였습니다.");
		response.sendRedirect("login_form.jsp");
		return;
	}

	//request.setCharacterEncoding(String enc) : POST 방식으로 요청하여 리퀘스트 메세지 몸체부에
	//저장되어 전달되는 값에 대한 문자형태를 변경하는 메소드  
	//request.setCharacterEncoding("utf-8");//한글 전달값이 없는 경우 생략 가능

	//request.getParameter(String name) : 전달값을 문자열(String 객체)로 반환하는 메소드
	// => 매개변수로 전달받은 이름의 전달값이 없는 경우 null 반환
	//request.getParameterValues(String name) : 같은 이름으로 전달된 값이 여러개인 경우
	//모든 전달값을 문자열 배열로 반환하는 메소드
	String id=request.getParameter("id");
	String passwd=request.getParameter("passwd");
	
	//저장매체에 저장된 인증정보와 전달받은 인증정보를 비교 - 인증처리
	if(!id.equals("abc123") || !passwd.equals("123456")) {//인증 실패
		session.setAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
		session.setAttribute("id", id);
		response.sendRedirect("login_form.jsp");
		return;
	}
	
	//인증 성공 
	//session.setAttribute(String attributeName, Object attributeValue) : 클라이언트의 정보
	//(JSESSIONID 쿠키)로 바인딩된 세션(session)에 이름(속성명)과 객체(속성값)를 전달받아 
	//저장(변경)하는 메소드
	session.setAttribute("loginId", id);//권한 관련 정보가 저장된 객체를 세션에 저장
	response.sendRedirect("login_user.jsp");
%>
