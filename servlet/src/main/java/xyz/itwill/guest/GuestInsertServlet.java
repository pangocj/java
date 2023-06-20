package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//방명록 게시글을 전달받아 GUEST 테이블에 행을 삽입하고 방명록 게시글 목록페이지
//(/guest/list.itwill)로 이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 서블릿
// => 방명록 게시글 입력페이지(guest/writeForm.itwill)에서 form 태그를 사용해 post 방식으로 요청하는 서블릿
@WebServlet("/guest/write.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿을 GET 방식으로 요청한 경우 - 비정상적 요청
		if(request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		//리퀘스트 메세지 몸체부에 저장되어 전달되는 값에 대한 캐릭터셋 변경
		request.setCharacterEncoding("utf-8");
		
		//전달값을 반환받아 저장
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		//DTO 객체를 생성하여 전달값으로 필드값 변경
		GuestDTO guest=new GuestDTO();
		guest.setWriter(writer);
		guest.setSubject(subject);
		guest.setContent(content);
		
		//DTO 객체를 전달받아 GUEST 테이블에 행을 삽입하는 DAO 클래스의 메소드 호출
		GuestDAO.getDAO().insertGuest(guest);
		
		//클라이언트에게 URL 주소를 전달하여 응답 처리
		// => 클라이언트는 전달받은 URL 주소의 서블릿을 요청하여 실행결과를 응답받아 출력 - 리다이렉트 이동
		response.sendRedirect("list.itwill");
	}
}
