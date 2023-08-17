<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
#btnDiv {
	margin: 10px;
}

#restBoardTable {
	border: 1px solid black;
	border-collapse: collapse; 
}

#restBoardTable td, #restBoardTable th {
	border: 1px solid black;
	padding: 3px;
}

.inputDiv {
	width: 240px;
	height: 80px;
	border: 2px solid black;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -40px;
	margin-left: -120px;
	padding: 5px;
	z-index: 100;
	display: none;
}
</style>
</head>
<body>
	<h1>RestBoard</h1>
	<hr>
	<div id="btnDiv">
		<button type="button" id="writeBtn">글쓰기</button>
	</div>
	
	<%-- 게시글 목록을 출력하는 태그 --%>
	<div id="restBoardListDiv"></div>

	<%-- 페이지 번호를 출력하는 태그 --%>
	<div id="pageNumDiv"></div>
	
	<%-- 신규 게시글을 입력받기 위한 태그 --%>
	<div id="insertDiv" class="inputDiv">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="insertWriter" class="insert"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="insertContent" class="insert"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="insertBtn">저장</button>
					<button type="button" id="cancelInsertBtn">취소</button>
				</td>
			</tr>
		</table>
	</div>
	
	<%-- 변경 게시글을 입력받기 위한 태그 --%>
	<div id="updateDiv" class="inputDiv">
		<input type="hidden" id="updateNum">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="updateWriter" class="update"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="updateContent" class="update"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="updateBtn">변경</button>
					<button type="button" id="cancelUpdateBtn">취소</button>
				</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
	//현재 요청 페이지 번호를 저장하기 위한 전역변수
	// => 모든 함수에서 사용 가능하며 프로그램 종료 전까지 값 유지
	var page=1;

	//게시글 목록을 제공받아 출력하는 함수 호출
	boardListDisplay(page);
	
	//매개변수로 요청 페이지 번호을 전달받아 페이지 번호에 대한 게시글 목록을 JSON 형식의 
	//문자열로 제공받아 HTML 태그로 변환하여 출력하는 함수
	// => 게시글 목록을 JSON 형식의 문자열로 제공하는 Restful API를 비동기식으로 요청하여 응답받아 처리
	function boardListDisplay(pageNum) {
		page=pageNum;
		$.ajax({
			type: "get",
			url: "<c:url value="/rest/board_list"/>?pageNum="+pageNum,
			dataType: "json",
			success: function(result) {
				//alert(result);//[object Object] >> Map 객체가 변환되어 응답된 결과
				
				//매개변수로 제공받은 자바스크립트의 Object 객체를 HTML 태그로 변환
				if(result.restBoardList.length == 0) {//검색된 게시글이 없는 경우
					var html="<table id='restBoardTable'>";
					html+="<tr>";
					html+="<th width='800'>검색된 게시글이 없습니다.</th>";
					html+="</tr>";
					html+="</table>";
					$("#restBoardListDiv").html(html);
					return;
				}
				
				var html="<table id='restBoardTable'>";
				html+="<tr>";
				html+="<th width='50'>번호</th>";
				html+="<th width='100'>작성자</th>";
				html+="<th width='350'>내용</th>";
				html+="<th width='200'>작성일</th>";
				html+="<th width='50'>변경</th>";
				html+="<th width='50'>삭제</th>";
				html+="</tr>";
				$(result.restBoardList).each(function() {//게시글 목록(Array 객체)에 대한 반복 처리
					html+="<tr>";
					html+="<td align='center'>"+this.idx+"</td>";
					html+="<td align='center'>"+this.writer+"</td>";
					html+="<td>"+this.content+"</td>";
					html+="<td align='center'>"+this.regdate+"</td>";
					html+="<td align='center'><button type='button'>변경</button></td>";
					html+="<td align='center'><button type='button'>삭제</button></td>";
					html+="</tr>";
				});
				html+="</table>";

				$("#restBoardListDiv").html(html);
				
				//페이지 번호를 출력하는 함수 호출
				pageNumDisplay(result.pager);
			},
			error: function(xhr) {
				alert("에러코드(게시글 목록 검색) = "+xhr.stauts);
			}
		});
	}
	
	//매개변수로 페이징 처리 관련 정보(Object 객체)를 전달받아 HTML 태그로 변환하여 출력하는 함수
	function pageNumDisplay(pager) {
		var html="";
		
		if(pager.startPage > pager.blockSize) {
			html+="<a href='javascript:boardListDisplay("+pager.prevPage+");'>[이전]</a>";
		} else {
			html+="[이전]";
		}
		
		for(i = pager.startPage ; i < pager.endPage ; i++) {
			if(pager.pageNum != i) {
				html+="<a href='javascript:boardListDisplay("+i+");'>["+i+"]</a>";
			} else {
				html+="["+i+"]";
			}
		}
		
		if(pager.endPage != pager.totalPage) {
			html+="<a href='javascript:boardListDisplay("+pager.nextPage+");'>[다음]</a>";
		} else {
			html+="[다음]";
		}
		
		$("#pageNumDiv").html(html);
	}
	</script>
</body>
</html>













