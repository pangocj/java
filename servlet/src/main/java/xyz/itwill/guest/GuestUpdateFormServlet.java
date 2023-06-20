package xyz.itwill.guest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//글번호를 전달받아 GUEST 테이블에 저장된 방명록 게시글을 검색하여 입력태그의 초기값으로 설정
//하고 사용자로부터 방명록 게시글(변경값)을 입력받기 위한 서블릿
// => [글변경] 태그를 클릭한 경우 방명록 게시글 변경페이지(/guest/modify.itwill)로 이동 - 입력값 전달
// => [글목록] 태그를 클릭한 경우 방명록 게시글 목록페이지(/guest/list.itwill)로 이동
@WebServlet("/guest/modifyForm.itwill")
public class GuestUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//전달값이 없는 경우 - 비정상적인 요청
		if(request.getParameter("num")==null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		//전달값을 반환받아 정수값으로 변환하여 저장  
		int num=Integer.parseInt(request.getParameter("num"));
		
		//글번호를 전달받아 GUEST 테이블에 저장된 해당 글번호의 방명록 게시글을 검색하여
		//DTO 객체를 반환하는 DAO 클래스의 메소드 호출
		GuestDTO guest=GuestDAO.getDAO().selectGuest(num);
		
		//검색된 방명록 게시글이 없는 경우 - 비정상적인 요청
		if(guest==null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>방명록 글변경</h1>");
		out.println("<hr>");
		out.println("<form action='modify.itwill' method='post' name='modifyForm'>");
		//방명록 게시글을 구분하기 위한 글번호를 반드시 전달
		out.println("<input type='hidden' name='num' value='"+guest.getNum()+"'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>작성자</td>");
		out.println("<td><input type='text' name='writer' value='"+guest.getWriter()+"'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>제목</td>");
		out.println("<td><input type='text' name='subject' value='"+guest.getSubject()+"'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>내용</td>");
		out.println("<td><textarea rows='4' cols='60' name='content'>"+guest.getContent()+"</textarea></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<button type='button' id='modifyBtn'>글변경</button>");
		out.println("<button type='reset'>다시쓰기</button>");
		out.println("<button type='button' onclick='location.href=\"list.itwill\";'>글목록</button>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<script type='text/javascript'>");
		out.println("modifyForm.writer.focus();");
		out.println("document.getElementById('modifyBtn').onclick=function() {");
		out.println("if(modifyForm.writer.value=='') {");
		out.println("alert('작성자를 입력해 주세요.');");
		out.println("modifyForm.writer.focus();");
		out.println("return;");
		out.println("}");
		out.println("if(modifyForm.subject.value=='') {");
		out.println("alert('제목을 입력해 주세요.');");
		out.println("modifyForm.subject.focus();");
		out.println("return;");
		out.println("}");
		out.println("if(modifyForm.content.value=='') {");
		out.println("alert('내용을 입력해 주세요.');");
		out.println("modifyForm.content.focus();");
		out.println("return;");
		out.println("}");
		out.println("modifyForm.submit();");
		out.println("}");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

}
