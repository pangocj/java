<%@page import="org.apache.commons.httpclient.methods.GetMethod"%>
<%@page import="org.apache.commons.httpclient.HttpClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 가상의 클라이언트(브라우저)를 이용하여 다른 서버의 웹프로그램을 요청하고 실행결과를
제공받아 클라이언트에게 그대로 전달하여 응답하는 JSP 문서 --%>
<%-- => HttpClient 객체를 사용하여 프록시(Proxy) 기능을 제공하는 웹프로그램 작성 --%>
<%-- => https://apache.org 사이트에서 필요한 라이브러리 파일을 다운로드 받아 프로젝트 빌드 처리 --%>
<%-- => commons-httpclient-3.1.jar, commons-codec-1.16.jar, commons-logging-1.2.jar --%>
<%
	//요청 웹프로그램의 URL 주소 저장
	String url="https://www.khan.co.kr/rss/rssdata/kh_sports.xml";

	//HttpClient 객체 생성 - 가상의 브라우저 기능을 제공하기 위한 객체
	HttpClient client=new HttpClient();
	
	//GetMethod 객체 생성 - 가상의 브라우저를 사용하여 GET 방식으로 웹프로그램을 요청하기 위한 객체
	// => PostMethod 객체 : 가상의 브라우저를 사용하여 POST 방식으로 웹프로그램을 요청하기 위한 객체
	GetMethod method=new GetMethod(url);
	
	try {
		//HttpClient.executeMethod(Method method) : 가상의 브라우저를 사용하여 웹프로그램을 요청하는 메소드
		// => 가상의 브라우저로 요청한 웹프로그램 실행에 대한 상태코드(StatusCode - int) 반환 
		int statusCode=client.executeMethod(method);
		
		//클라이언트에게 응답하기 위한 프록시 프로그램의 response 객체 초기화
		response.reset();
		
		//프록시 프로그램의 출력스트림(out 객체) 초기화
		out.clearBuffer();
		
		//프록시 프로그램을 요청한 클라이언트에게 상태코드 전달
		response.setStatus(statusCode);
		
		if(statusCode==HttpServletResponse.SC_OK) {//정상적인 실행결과를 응답받은 경우 - 상태코드 : 200
			//Method.getResponseBodyAsString() : 요청에 대한 실행결과가 저장된 리스폰즈 메세지
			//몸체부의 결과값을 문자열로 반환하는 메소드
			// => 결과값을 반환받아 원하는 문자형태(캐릭터셋)으로 변경하여 저장
			String result=new String(method.getResponseBodyAsString().getBytes("8859_1"),"utf-8");
			
			//프록시 프로그램을 요청한 클라이언트에게 실행결과에 대한 문서형태(MimeType)를 전달
			response.setContentType("text/xml; charset=utf-8");
			
			//프록시 프로그램을 요청한 클라이언트에게 실행결과를 전달
			out.println(result);
		}
	} finally {
		//가상의 브라우저를 사용하여 접속된 웹서버의 연결 해제
		//Method.releaseConnection() : 웹서버 접속을 해제하는 메소드
		if(method!=null) method.releaseConnection();
	}
%>
