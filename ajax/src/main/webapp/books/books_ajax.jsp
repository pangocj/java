<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [books.jsp] 문서를 AJAX 기능으로 요청하여 XML 데이타를 응답받아 태그로 변경하여 
클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => XSL 문서를 사용하여 XML 데이타를 HTML 태그로 변환하여 응답 처리 --%>
<%-- => [books.xsl] 문서를 AJAX 기능으로 요청하여 XSLT 데이타를 응답받아 사용 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<h1>교재목록</h1>
	<hr>
	<div id="books"></div>
	
	<script type="text/javascript">
	var xmlDoc=null;//XML 데이타를 저장하기 위한 전역변수
	var xslDoc=null;//XSLT 데이타를 저장하기 위한 전역변수
	
	$.ajax({
		type: "get",
		url: "books.jsp",
		dataType: "xml",
		success: function(result) {
			xmlDoc=result;
			doXSLT();
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	
	$.ajax({
		type: "get",
		url: "books.xsl",
		dataType: "xml",
		success: function(result) {
			xslDoc=result;
			doXSLT();
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	
	//XSLT 데이타를 사용하여 XML 데이타를 HTML 태그로 변환하는 함수
	function doXSLT() {
		if(xmlDoc==null || xslDoc==null) return;
		
		//XSLTProcessor 객체 생성 - XSLT 데이타를 사용하여 XML 데이타를 전달받아 변환하기 위한 객체
		var xsltProcessor=new XSLTProcessor();
		
		//XSLTProcessor.importStylesheet(xslt) : XSLTProcessor 객체에 변환 정보가 저장된 XSLT 
		//데이타를 전달받아 저장하기 위한 메소드
		xsltProcessor.importStylesheet(xslDoc);
		
		//XSLTProcessor.transformToFragment(xml, document) : XML 데이타를 전달받아 XSLTProcessor
		//객체를 사용하여 document 객체의 자식 Element 객체로 변환하여 반환하는 메소드 
		var fragment=xsltProcessor.transformToFragment(xmlDoc, document);
		
		$("#books").append(fragment);
	}
	</script>
</body>
</html>
