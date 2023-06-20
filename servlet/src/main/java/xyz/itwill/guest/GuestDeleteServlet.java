package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//글번호를 전달받아 GUEST 테이블에 저장된 행을 삭제하고 방명록 게시글 목록페이지
//(/guest/list.itwill)로 이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 서블릿
@WebServlet("/guest/remove.itwill")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
