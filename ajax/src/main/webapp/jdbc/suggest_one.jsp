<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자가 검색어를 입력한 경우 검색어가 포함된 제시어를 클라이언트에게 제공하는 JSP 문서 --%>
<%-- => 사용자가 검색어를 입력할 경우 [suggest_two.jsp] 문서를 AJAX 기능으로 요청하여 검색어가
포함된 제시어 관련정보를 XML 데이타로 응답받아 출력 처리  --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style type="text/css">
#keyword {
	position: absolute;
	top: 100px;
	left: 10px;
	width: 300px;
	font-size: 16px;
}

#suggestDiv {
	position: absolute;
	top: 120px;
	left: 10px;
	width: 300px;
	padding: 3px;
	border: 1px solid black;
	cursor: pointer;
	font-size: 16px;
	background: rgba(255, 255, 255, 1);
	z-index: 999;
	display: none;
}

#choice {
	position: absolute;
	top: 150px; 
	left: 10px;
}
</style>
</head>
<body>
	<h1>제시어 기능</h1>
	<hr>
	<div>
		<%-- 검색어를 입력받기 위한 태그 --%>
		<input type="text" id="keyword">
		
		<%-- 제시어를 제공받아 출력하기 위한 태그 --%>
		<div id="suggestDiv">
			<div id="suggestList"></div>
		</div>
	</div>
	
	<script type="text/javascript">
	$("#keyword").focus();
	
	//입력태그에서 키보드를 눌렀다 띈 경우 호출될 이벤트 처리 함수 등록
	$("#keyword").keyup(function() {
		var keyword=$("#keyword").val();
		//alert(keyword);
		
		if(keyword=="") {//입력태그에 입력값이 없는 경우
			$("#suggestDiv").hide();//제시어 관련 정보를 출력하는 태그가 보여지지 않도록 설정
			return;
		}
		
		$.ajax({
			type: "post",
			url: "suggest_two.jsp",
			data: "keyword="+keyword,
			dataType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				//alert(code);
				
				if(code=="success") {//검색된 제시어 관련 정보가 있는 경우
					var data=$(xmlDoc).find("data").text();
					//alert(data);
					
					var suggestList=JSON.parse(data);
					//alert(suggestList);
					
					var html="";
					$(suggestList).each(function() {
						html+="<a href='"+this.url+"' target='_blank'>"+this.word+"</a><br>";
					});
						
					$("#suggestList").html(html);
					
					$("#suggestDiv").show();
				} else {//검색된 제시어 관련 정보가 없는 경우
					$("#suggestDiv").hide();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	</script>
</body>
</html>