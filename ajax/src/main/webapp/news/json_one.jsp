<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [json_two.jsp] 문서를 AJAX 기능으로 요청하여 JSON 형식 데이타로 응답받아 태그를 변경하여
클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => JSON 형식 데이타를 제공받아 HTML 태그로 변환하여 페이지 변경 - 파싱(Parsing) 처리 --%>
<%-- JSON(JavaScrip Object Notation) : 자바스트립트의 객체 표현 방식을 사용하여 값을 구분하는 구조적인 데이타 표현 방식 --%>     
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
					//document.getElementById("newsContents").innerHTML=xhr.responseText;
					
					//eval(text) : 매개변수로 전달받은 문자값을 자바스트립트 명령을 실행하는 함수
					// => JSON 형식의 데이타를 전달받아 자바스크립트 객체로 변환
					//var result=eval("("+xhr.responseText+")");
					
					//JSON.parse(json) : JSON 형식의 데이타를 전달받아 자바스크립트 객체로 변환하여 반환하는 메소드
					var result=JSON.parse(xhr.responseText);
					
					//alert(result);//[object Object],[object Object],[object Object],[object Object],[object Object] - Array 객체
					
					var html="<ol>";
					for(i=0;i<result.length;i++) {
						var title=result[i].title;
						var publisher=result[i].publisher;
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
		
		xhr.open("get", "json_two.jsp");
		xhr.send(null);
	}
	
	document.getElementById("newsList").onmouseout=function() {
		document.getElementById("newsContents").style="display: none;";
	}
	</script>
</body>
</html>
