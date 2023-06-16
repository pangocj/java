package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//[multipart/form-data]로 전달된 경우 request 객체로부터 입력스트림(ServletInputStream 객체)을
//제공받아 임시파일에 저장한 후 전달값과 전달파일을 구분하여 처리
// => [multipart/form-data]를 처리하는 클래스를 이용하여 처리하는 것을 권장

//[multipart/form-data]를 처리하는 클래스가 포함된 라이브러리를 다운로드 받아 프로젝트에 빌드 처리
//1.Apache 그룹에서 배포한 commons-fileupload 라이브러리의 클래스 사용 - 선택적 파일 업로드 
//2.Oreilly 그룹에서 배포한 cos 라이브러리의 클래스 사용 - 무조건 파일 업로드

//Oreilly 그룹에서 배포한 cos 라이브러리를 다운로드 프로젝트 빌드 처리
//1.http://www.servlets.com 사이트 접속 >> COS File Upload Library 메뉴 클릭 >> cos-22.05.zip 다운로드
//2.cos-22.05.zip 파일 압축 풀기 >> cos-22.05 폴더 이동 >> lib 폴더 이동 >> cos.jar 복사
//3.프로젝트 >> src/main/webapp >> WEB-INF >> lib >> cos.jar 붙여넣기
// => /WEB-INF/lib 폴더에 라이브러리 파일(jar 파일)을 붙여넣기 하면 자동으로 라이브러리 빌드 처리

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
		
		/*
		request.setCharacterEncoding("utf-8");
		
		//form 태그의 [multipart/form-data]로 전달된 입력값은 HttpServletRequest 객체의
		//getParameter() 메소드를 호출하여 반환 불가능
		String uploader=request.getParameter("uploader");
		*/

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파일업로드</h1>");
		out.println("<hr>");
		//out.println("<p>올린이 = "+uploader+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}












