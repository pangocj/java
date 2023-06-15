package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(fileupload.html)에서 전달된 값과 파일명을 클라이언트에게 전달하여 응답하는 서블릿
// => 전달파일은 서버 디렉토리에 저장 - 파일 업로드(Upload) 처리
@WebServlet("/upload.itwill")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("fileupload.html");
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		
		//form 태그의 [multipart/form-data]로 전달된 입력값은 HttpServletRequest 객체의
		//getParameter() 메소드를 호출하여 반환 불가능
		String uploader=request.getParameter("uploader");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파일업로드</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+uploader+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}












