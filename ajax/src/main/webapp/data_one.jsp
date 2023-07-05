<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin: 10px;
	font-size: 30px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>AJAX - 값 전달</h1>
	<hr>
	<div id="display">요청 웹프로그램에 대한 응답 결과 출력</div>
	<div>
		이름 : <input type="text" id="name">
		<button type="button" id="getBtn">GET 방식의 요청</button>
		<button type="button" id="postBtn">POST 방식의 요청</button>
	</div>
	
	<script type="text/javascript">
	//[GET 방식의 요청] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	document.getElementById("getBtn").onclick=function() {
		//입력태그의 입력값을 제공받아 저장
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해 주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("name").value="";
		
		//XMLHttpRequest 객체를 생성하여 저장
		var xhr=new XMLHttpRequest();
		
		//XMLHttpRequest 객체의 준비상태가 변경될 때마다 호출될 이벤트 처리 함수 등록
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {//XMLHttpRequest 객체에 응답결과가 전달된 경우
				if(xhr.status==200) {//XMLHttpRequest 객체의 응답결과에 대한 상태코드가 [200]인 경우
					//XMLHttpRequest 객체의 응답결과(HTML)를 이용하여 페이지의 태그 변경
					document.getElementById("display").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		
		//XMLHttpRequest 객체를 이용하여 웹프로그램을 GET 방식으로 요청
		// => GET 방식으로 웹프로그램을 요청할 경우 질의문자열(QueryString)를 사용하여 값 전달
		//문제점)질의문자열로 전달되는 값에 URL 주소로 표현 불가능한 문자가 존재할 경우 400 에러코드 발생 가능
		//해결법)입력값을 부호화 처리하여 질의문자열로 전달
		name=encodeURIComponent(name);
		xhr.open("get", "data_two.jsp?name="+name, true);
		xhr.send(null);		
	}
	
	//[POST 방식의 요청] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	document.getElementById("postBtn").onclick=function() {
		//입력태그의 입력값을 제공받아 저장
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해 주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("name").value="";
		
		//XMLHttpRequest 객체를 생성하여 저장
		var xhr=new XMLHttpRequest();
		
		//XMLHttpRequest 객체의 준비상태가 변경될 때마다 호출될 이벤트 처리 함수 등록
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {//XMLHttpRequest 객체에 응답결과가 전달된 경우
				if(xhr.status==200) {//XMLHttpRequest 객체의 응답결과에 대한 상태코드가 [200]인 경우
					//XMLHttpRequest 객체의 응답결과(HTML)를 이용하여 페이지의 태그 변경
					document.getElementById("display").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		
		//XMLHttpRequest 객체를 이용하여 웹프로그램을 POST 방식으로 요청
		// => send() 메소드의 매개변수를 이용하여 요청 웹프로그램에 값 전달
		//문제점)send() 메소드를 이용하여 값을 전달할 경우 [multipart/form-data] 형식으로 값 전달
		// => 요청 웹프로그램에서 request.getParameter() 메소드로 전달값 반환 불가능
		//해결법)[application/x-www-form-urlencoded] 형식으로 값이 전달되도록 리퀘스트 메세지의 헤더 정보 변경
		xhr.open("post", "data_two.jsp");//async 매개변수에 전달값이 생략된 경우 자동으로 [true]로 처리
		//XMLHttpRequest.setRequestHeader(header, value) : XMLHttpRequest 객체를 이용하여
		//웹프로그램 요청시 사용되는 리퀘스트 메세지의 헤더 정보를 변경하는 메소드
		// => 리퀘스트 메세지 몸체부에 저장된 값이 문자데이타로 표현되도록 헤더 정보 변경
		// => open() 메소드 호출 후 사용 가능
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("name="+name);//리퀘스트 메세지 몸체부에 값을 저장하여 전달
	}
	</script>
</body>
</html>
