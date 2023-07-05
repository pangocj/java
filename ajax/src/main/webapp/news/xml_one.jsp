<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [xml_two.jsp] 문서를 AJAX 기능으로 요청하여 XML 형식 데이타로 응답받아 태그를 변경하여
클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => XML 형식 데이타를 제공받아 HTML 태그로 변환하여 페이지 변경 - 파싱(Parsing) 처리 --%>
<%-- XML(eXtensible Markup Language) : 엘리먼트(태그)를 사용하여 값을 구분하여 제공하는 구조적인 데이타 표현 방식 --%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#newsList {
	width: 50%;
	margin: 0 auto;
}

#newsHeader {
	padding: 5px;
	text-align: center;
	font-size: x-large;
	border: 2px solid black;
}

#newsContents {
	padding: 5px;
	font-size: medium;
	border: 2px dashed black;
	display: none;
}
</style>
</head>
<body>
	<h1>헤드라인 뉴스</h1>
	<hr>
	<div id="newsList">
		<div id="newsHeader">오늘의 뉴스</div>
		<div id="newsContents">
			<%-- 
			<ol>
				<li>뉴스제목-1[언론사-1]</li>
				<li>뉴스제목-2[언론사-2]</li>
				<li>뉴스제목-3[언론사-3]</li>
				<li>뉴스제목-4[언론사-4]</li>
				<li>뉴스제목-5[언론사-5]</li>
			</ol>
			--%>	
		</div>
	</div>
	
	<script type="text/javascript">
	document.getElementById("newsList").onmouseover=function() {
		var xhr=new XMLHttpRequest();
		
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					//XMLHttpRequest.responseXML : 웹프로그램 요청에 대한 실행결과를 XML 문서로
					//응답받은 경우 응답결과가 저장된 프로퍼티 - XMLDocument 객체 제공
					//document.getElementById("newsContents").innerHTML=xhr.responseXML;
					
					var xmlDoc=xhr.responseXML;
					//alert(xmlDoc);//[object XMLDocument]
					
					//Document.getElementsByTagName(tagName) : Document 객체(Element 객체)에서
					//태그명으로 태그를 검색하여 검색된 모든 태그(Element 객체)가 요소로 
					//저장된 NodeList 객체(HTMLCollection 객체)를 반환하는 메소드
					var newsList=xmlDoc.getElementsByTagName("news");
					//alert(newsList);//[object HTMLCollection]
					//alert(newsList.length);
					
					var html="<ol>";
					for(i=0;i<newsList.length;i++) {
						//NodeList.item(index) : NodeList 객체에서 index 위치의 요소값(Element 객체)을 반환하는 메소드
						var news=newsList.item(i);
						//alert(news);//[object Element]
						
						var title=news.getElementsByTagName("title").item(0).firstChild.nodeValue;
						var publisher=news.getElementsByTagName("publisher").item(0).firstChild.nodeValue;
						html+="<li>"+title+"["+publisher+"]</li>";
					}
					html+="</ol>";

					document.getElementById("newsContents").innerHTML=html;

					document.getElementById("newsContents").style="display: block;";
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		
		xhr.open("get", "xml_two.jsp");
		xhr.send(null);
	}
	
	document.getElementById("newsList").onmouseout=function() {
		document.getElementById("newsContents").style="display: none;";
	}
	</script>
</body>
</html>
