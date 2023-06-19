package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//GUEST 테  이블에 저장된 모든 행을 검색하여 클라이언트에게 전달하여 응답하는 서블릿
// => [글쓰기]를 클릭한 경우 입력페이지(/guest/writeForm.itwill)로 이동
@WebServlet("/guest/list.itwill")
public class GuestSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//GUEST 테이블에 저장된 모든 행을 검색하여 List 객체로 반환하는 DAO 클래스의 메소드 호출
		List<GuestDTO> guestList=GuestDAO.getDAO().selectGuestList();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>방명록</h1>");
		out.println("<hr>");
		out.println("<table width='1000'>");
		out.println("<tr>");
		out.println("<td align='right'>");
		out.println("<button type='button' onclick='location.href=\"insertForm.itwill\";'>글쓰기</button>");
		out.println("</td>");
		out.println("</tr>");
		if(guestList.isEmpty()) {
			out.println("<tr>");
			out.println("<td>");
			out.println("<table border='1' cellspacing='0' width='100%'>");
			out.println("<tr>");
			out.println("<td align='center'>검색된 방명록 게시글이 하나도 없습니다.</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</td>");
			out.println("</tr>");
		} else {
			for(GuestDTO guest : guestList) {
				out.println("<tr>");
				out.println("<td align='center'>");
				out.println("<table border='1' cellspacing='0' width='100%'>");
				out.println("<tr>");
				out.println("<th width='150'>작성자</th>");
				out.println("<td width='200' align='center'>"+guest.getWriter()+"</td>");
				out.println("<th width='150'>작성일자</th>");
				out.println("<td width='500' align='center'>"+guest.getRegdate()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='150'>제목</th>");
				out.println("<td width='650' colspan='3'>"+guest.getSubject()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='150'>내용</th>");
				out.println("<td width='650' colspan='3'>"+guest.getContent().replace("\n", "<br>")+"</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
