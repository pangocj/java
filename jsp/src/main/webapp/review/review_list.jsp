<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- REVIEW 테이블에 저장된 게시글을 검색하여 게시글 목록을 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => 게시글을 페이지로 구분하여 검색 처리 - 페이징 처리 --%>
<%-- => [페이지번호] 태그를 클릭한 경우 [review/review_list.jsp] 문서 요청 - 페이지번호,검색대상,검색단어 전달 --%>
<%-- => [검색] 태그를 클릭한 경우 [review/review_list.jsp] 문서 요청 - 검색대상,검색단어 전달 --%>
<%-- => [글쓰기] 태그를 클릭한 경우 [review/review_write.jsp] 문서 요청 - 로그인 상태의 사용자에게만 링크 제공 --%>
<%-- => 게시글의 [제목] 태그를 클릭한 경우 [review/review_detail.jsp] 문서 요청 - 글번호, 페이지번호, 검색대상, 검색단어 전달 --%>
<%
	//게시글 검색 기능에 필요한 전달값(검색대상과 검색단어)을 반환받아 저장
	String search=request.getParameter("search");
	if(search==null) {//전달값이 없는 경우
		search="";
	}
	
	String keyword=request.getParameter("keyword");
	if(keyword==null) {
		keyword="";
	}
	
	//페이징 처리에 필요한 전달값(페이지 번호)을 반환받아 저장
	// => 페이징 처리에 필요한 전달값이 없는 경우 1번째 페이지의 게시글 목록을 검색하여 응답
	int pageNum=1;
	if(request.getParameter("pageNum")!=null) {//전달값이 있는 경우
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
	}
	
	//하나의 페이지에 검색되어 출력될 게시글의 갯수 설정 - 전달값으로 반환받아 저장 가능
	int pageSize=10;
	
	//게시글 검색 관련 정보를 전달받아 REVIEW 테이블에 저장된 게시글 중 검색 처리된 전체   
	//게시글의 갯수를 검색하여 반환하는 DAO 클래스의 메소드 호출
	int totalReview=ReviewDAO.getDAO().selectReviewCount(search, keyword);
	
	//전체 페이지의 갯수를 계산하여 저장
	//int totalPage=totalReview/pageSize+totalReview%pageSize==0?0:1;
	int totalPage=(int)Math.ceil((double)totalReview/pageSize);
	
	//전달받은 페이지 번호가 비정상적인 경우
	if(pageNum<=0 || pageNum>totalPage) {
		pageNum=1;//1번째 페이지의 게시글 목록을 검색
	}
	
	//페이지 번호에 대한 게시글의 시작 행번호를 계산하여 저장
	//ex) 1Page : 1, 2Page : 11, 3Page : 21, 4Page : 31, ...
	int startRow=(pageNum-1)*pageSize+1;

	//페이지 번호에 대한 게시글의 종료 행번호를 계산하여 저장
	//ex) 1Page : 10, 2Page : 20, 3Page : 30, 3Page : 40, ...
	int endRow=pageNum*pageSize;
		
	//마지막 페이지의 종료 게시글의 행번호가 검색 게시글의 갯수보다 많은 경우
	if(endRow>totalReview) {
		endRow=totalReview;//종료 게시글의 행번호를 검색 게시글의 갯수로 변경
	}
	
	//페이징 처리 관련 정보와 게시글 검색 기능 관련 정보를 전달하여 REVIEW 테이블에 저장된 
	//게시글 목록을 검색하여 List 객체로 반환하는 DAO 클래스의 메소드 호출
	List<ReviewDTO> reviewList=ReviewDAO.getDAO().selectReviewList(startRow, endRow, search, keyword);
	
	//세션에 저장된 권한 관련 속성값을 객체로 반환받아 저장
	// => 로그인 상태의 사용자에게만 글쓰기 권한 제공
	// => 비밀글인 경우 로그인 상태의 사용자가 게시글 작성자이거나 관리자인 경우에만 사용 권한 제공
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	//서버 시스템의 현재 날짜를 제공받아 저장
	// => 게시글 작성날짜와 현재 날짜를 비교하여 게시글 작성날짜를 다르게 출력되도록 응답 처리
	String currentDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	//페이지에 출력될 게시글 일련번호 시작값을 계산하여 저장
	// => 검색 게시글의 갯수 : 91 >> 1Page : 91~82, 2Page : 81~72, 3Page : 71~62, ...
	int printNum=totalReview-(pageNum-1)*pageSize;
%>
<style type="text/css">
#review_list {
	width: 1000px;
	margin: 0 auto;
	text-align: center;
}

#review_title {
	font-size: 1.2em;
	font-weight: bold;
}

table {
	margin: 5px auto;
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	border: 1px solid black;
	background: black;
	color: white;
}

td {
	border: 1px solid black;
	text-align: center;	
}

.subject {
	text-align: left;
	padding: 5px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

#review_list a:hover {
	text-decoration: none; 
	color: blue;
	font-weight: bold;
}

.subject_hidden {
	background: black;
	color: white;
	font-size: 14px;
	border: 1px solid black;
	border-radius: 4px;
}

#page_list {
	font-size: 1.1em;
	margin: 10px;
}

#page_list a:hover {
	font-size: 1.3em;
}
</style>

<h1>제품후기</h1>
<div id="review_list">
	<div id="review_title">제품후기목록(<%=totalReview%>)</div>
	
	<% if(loginMember!=null) {//로그인 상태의 사용자인 경우 %>
	<div style="text-align: right;">
		<button type="button" onclick="location.href='<%=request.getContextPath()%>/index.jsp?group=review&worker=review_write';">글쓰기</button>
	</div>
	<% } %>
	
	<%-- 게시글 목록 출력 --%>
	<table>
		<tr>
			<th width="100">글번호</th>
			<th width="500">제목</th>
			<th width="100">작성자</th>
			<th width="100">조회수</th>
			<th width="200">작성일</th>
		</tr>
		
		<% if(totalReview==0) { %>
			<tr>
				<td colspan="5">검색된 게시글이 없습니다.</td>
			</tr>
		<% } else { %>
			<%-- List 객체의 요소(ReviewDTO 객체)를 하나씩 제공받아 처리하기 위한 반복문 --%>
			<% for(ReviewDTO review : reviewList) {  %>
			<tr>
				<%-- 게시글 일련번호 : REVIEW 테이블의 글번호가 아닌 게시글 일련번호로 응답 처리 --%>
				<td><%=printNum %></td>
				<% printNum--; %><%-- 게시글 일련번호를 1씩 감소하여 저장 --%>
				
				<%-- 제목 --%>
				<td class="subject">
					<%-- 게시글이 답글인 경우에 대한 응답 처리 --%>
					<% if(review.getRestep()!=0) {//검색된 게시글이 답글인 경우 %>
						<%-- 게시글의 깊이를 제공받아 왼쪽 여백 설정 --%>
						<span style="margin-left: <%=review.getRelevel()*20%>px;">└[답글]</span>
					<% } %>
					
					<%-- 게시글의 상태를 비교하여 제목과 링크를 구분하여 응답 처리 --%>
					<% if(review.getStatus()==1) {//일반 게시글인 경우 %>
						<a href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_detail&num=<%=review.getNum()%>&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>"><%=review.getSubject()%></a>					
					<% } else if(review.getStatus()==2) {//비밀 게시글인 경우 %>
						<span class="subject_hidden">비밀글</span>
						<%-- 로그인 상태의 사용자가 게시글 작성자이거나 관리자인 경우 --%>
						<% if(loginMember!=null && (loginMember.getId().equals(review.getReviewid()) || loginMember.getMemberStatus()==9)) { %>
							<a href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_detail&num=<%=review.getNum()%>&pageNum=<%=pageNum%>&search=<%=search%>&keyword=<%=keyword%>"><%=review.getSubject()%></a>					
						<% } else { %>
							게시글 작성자 또는 관리자만 확인 가능합니다.
						<% } %>
					<% } else if(review.getStatus()==0) {//삭제 게시글인 경우 %>
						<span class="subject_hidden">삭제글</span>
						작성자 또는 관리자에 의해 삭제된 게시글입니다.
					<% } %>
				</td>
				
				<% if(review.getStatus()!=0) {//삭제 게시글이 아닌 경우 %>
				<%-- 작성자 --%>
				<td><%=review.getName() %></td>
				
				<%-- 조회수 --%>
				<td><%=review.getReadcount() %></td>
				
				<%-- 작성일 : 오늘 작성된 게시글은 시간만 출력하고 오늘 작성된 게시글이 아닌 경우 날짜와 시간 출력 --%>
				<td>
					<% if(currentDate.equals(review.getRegdate().substring(0, 10))) {//오늘 작성된 게시글인 경우 %>
						<%=review.getRegdate().substring(11) %>
					<% } else {//오늘 작성된 게시글이 아닌 경우 %>
						<%=review.getRegdate() %>
					<% } %>		
				</td>
				<% } else {//삭제 게시글인 경우 %>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<% } %>
			</tr>	
			<% } %>
		<% } %>
	</table>
	
	<%-- 페이지 번호 출력 및 링크 제공 - 블럭화 처리 --%>
	<%
		//하나의 페이지 블록에 출력될 페이지 번호의 갯수 설정
		int blockSize=5;
	
		//페이지 블럭에 출력될 시작 페이지 번호를 계산하여 저장
		//ex)1Block : 1, 2Block : 6, 3Block : 11, 4Block : 16, ...
		int startPage=(pageNum-1)/blockSize*blockSize+1;		

		//페이지 블럭에 출력될 종료 페이지 번호를 계산하여 저장
		//ex)1Block : 5, 2Block : 10, 3Block : 15, 4Block : 20, ...
		int endPage=startPage+blockSize-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
	%>
	<div id="page_list">
	<% if(startPage>blockSize) { %>
		<a href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_list&pageNum=<%=startPage-blockSize%>&search=<%=search%>&keyword=<%=keyword%>">[이전]</a>
	<% } else { %>
		[이전]
	<% } %>
	
	<% for(int i=startPage;i<=endPage;i++) { %>
		<% if(pageNum!=i) { %>
			<%-- 요청 페이지 번호와 이벤트가 발생된 페이지 번호가 다른 경우 링크 제공 --%>
			<a href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_list&pageNum=<%=i%>&search=<%=search%>&keyword=<%=keyword%>">[<%=i %>]</a>
		<% } else { %>
			<%-- 요청 페이지 번호와 이벤트가 발생된 페이지 번호가 같은 경우 링크 미제공 --%>
			[<%=i %>]
		<% } %>
	<% } %>
	
	<% if(endPage!=totalPage) { %>
		<a href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_list&pageNum=<%=startPage+blockSize%>&search=<%=search%>&keyword=<%=keyword%>">[다음]</a>
	<% } else { %>
		[다음]
	<% } %>
	</div>
	
	<%-- 사용자로부터 검색어를 입력받아 게시글 검색 기능 구현 --%>
	<form action="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_list" method="post">
		<%-- select 태그를 사용하여 검색대상을 선택해 컬럼명을 전달 --%>
		<select name="search">
			<option value="name" selected="selected">&nbsp;작성자&nbsp;</option>
			<option value="subject">&nbsp;제목&nbsp;</option>
			<option value="content">&nbsp;내용&nbsp;</option>
		</select>
		<input type="text" name="keyword">
		<button type="submit">검색</button>
	</form>
</div>
