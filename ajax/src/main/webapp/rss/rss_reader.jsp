<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- RSS 서비스를 제공하는 웹프로그램을 AJAX 기능으로 요청하여 실행결과를 응답받아 
클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- RSS(Really Simple Syndication 또는 Rich Site Summary) : 블로그, 뉴스, 기업정보 등과 같이
자주 업데이트 되는 사이트의 컨텐츠를 보다 쉽게 사용자에게 제공하기 위한 만들어진 서비스 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<h1>RSS Reader</h1>
	<hr>
	<div id="display"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		//문제점)현재 실행중인 웹프로그램과 동일한 서버의 웹프로그램은 AJAX 기능으로 요청하여
		//실행결과를 응답받아 처리 가능하지만 다른 서버의 웹프로그램을 AJAX 기능으로 요청할
		//경우 에러(에러코드 : 0) 발생
		//url: "https://www.khan.co.kr/rss/rssdata/kh_sports.xml",
		
		//해결법)다른 서버의 웹프로그램을 프록시 기능으로 요청하여 응답하는 프로그램을 작성하여
		//AJAX 기능으로 프록시 프로그램 요청하여 실행결과를 응답받아 처리 가능
		url: "rss_proxy.jsp",
		
		dataType: "xml",
		success: function(xmlDoc) {
			var channelTitle=$(xmlDoc).find("channel").children("title").text();
			
			var html="<h2>"+channelTitle+"</h2>";
			html+="<ul>";
			$(xmlDoc).find("item").each(function() {
				var title=$(this).find("title").text();
				var link=$(this).find("link").text();
				var date;
				if($(this).find("pubDate").length!=0) {
					date=$(this).find("pubDate").text();
				} else {
					date=$(this).find("dc\\:date").text();
				}
				html+="<li><a href='"+link+"' target='_blank'>"+title+"["+date+"]</a></li>";
			});
			html+="</ul>";
			
			$("#display").html(html);
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	</script>
</body>
</html>

