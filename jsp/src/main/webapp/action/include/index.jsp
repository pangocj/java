<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JSP 문서 요청시 전달된 값을 반환받아 저장
	String category=request.getParameter("category");

	if(category==null) {//전달값이 없는 경우
		category="mail";
	}
	
	String headerPath="";//Header 영역에 포함될 파일의 경로를 저장하기 위한 변수
	//전달값을 구분하여 Header 영역에 포함될 파일의 경로 저장
	if(category.equals("mail")) {
		headerPath="header_mail.jsp";
	} else if(category.equals("blog")) {
		headerPath="header_blog.jsp";
	} else if(category.equals("cafe")) {
		headerPath="header_cafe.jsp";
	} else {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//Content 영역에 포함될 파일의 경로를 저장하기 위한 변수
	// => 전달값으로 Content 영역에 포함될 파일의 경로 저장
	String contentPath=category+".jsp";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- Header 영역 --%>
	<%-- 
	<h1>메일페이지</h1>
	<a href="index.jsp">메일(Mail)</a>&nbsp;&nbsp;
	<a href="index.jsp">블로그(Blog)</a>&nbsp;&nbsp;
	<a href="index.jsp">카페(Cafe)</a>&nbsp;&nbsp;
	<hr>
	--%>
	
	<%-- include Directive : 외부파일(JSPF)의 소스코드를 JSP 문서에 포함 --%>
	<%-- => CSL(HTML, CSS, JavaScript) 및 SSL(Java - Script Element)의 소스코드 포함 --%>
	<%-- => JSP 문서를 요청한 경우 include Directive의 file 속성값으로 설정된 외부파일의 
	소스코드를 JSP 문서에 포함한 후 실행된 결과를 클라이언트에게 전달하여 응답 --%>
	<%-- => include Directive의 file 속성값으로 설정된 외부파일의 내용이 변경될 경우
	JSP 문서를 변경한 것과 동일하므로 JSP 문서를 다시 해석하여 서블릿으로 생성 --%>
	<%-- include Directive의 file 속성값으로 JSP의 표현식(Expression) 사용 불가능 --%>
	<%-- => include Directive의 file 속성값으로 설정된 외부파일의 소스코드만 포함 - 정적포함 --%>
	<%--<%@include file="header.jspf" %>  --%>
	<%-- <%@include file="<%=headerPath %>" %> --%>
	
	<%-- include Tag : 요청 JSP 문서에서 다른 JSP 문서로 스레드를 이동하여 실행하고 실행결과를
	가져와 요청 JSP 문서에 포함하는 태그 --%>
	<%-- => JSP 문서의 실행결과(CSL - HTML, CSS, JavaScript) 포함 --%>
	<%-- 형식) <jsp:include page="JSP 문서의 경로"></jsp:include> --%>
	<%-- => page 속성값으로 설정된 JSP 문서가 없는 경우 에러 발생 --%>
	<%-- => page 속성값으로 설정된 JSP 문서가 변경되고 요청 JSP 문서에 미영향 --%>
	<%-- include Tag의 page 속성값으로 JSP의 표현식(Expression) 사용 가능 --%>
	<%-- => JSP의 표현식(Expression)으로 제공되는 JSP 문서 포함 - 동적포함 --%>
	<%-- <jsp:include page="header.jsp"/> --%>
	<jsp:include page="<%=headerPath %>"/>
	 
	<%-- Content 영역 --%>
	<%-- 
	<p>메일 관련 정보가 출력됩니다.</p>
	<p>메일 관련 정보가 출력됩니다.</p>
	<p>메일 관련 정보가 출력됩니다.</p>
	<p>메일 관련 정보가 출력됩니다.</p>
	<p>메일 관련 정보가 출력됩니다.</p>
	--%>
	<jsp:include page="<%=contentPath %>"/>
	
	<%-- Footer 영역 --%>
	<hr>
	<p>Copyright © Itwill Corp. All rights reserved.</p>
	<p>관리자 : 홍길동(hong@itwill.xyz)</p>
</body>
</html>