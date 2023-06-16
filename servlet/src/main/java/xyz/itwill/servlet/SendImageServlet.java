package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트 요청에 의해 이미지 파일로 응답하기 위한 서블릿
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에게 이미지 파일이 응답되도록 응답파일의 타입 변경
		// => 응답파일이 문서파일이 아니므로 캐릭터셋 미설정 
		response.setContentType("image/jpeg");
		
		//응답파일을 생성하기 위한 출력스트림을 반환받아 저장
		// => 이미지 파일(이진 파일 : Binary File)를 생성하기 위해 원시데이타(1Byte)를 전달
		//하는 ServletOutputStream 객체 반환
		ServletOutputStream out=response.getOutputStream();
		
		//서버에 저장된 이미지 파일의 시스템 경로를 반환받아 저장	
		//HttpServletRequest.getServletContext() : ServletContext 객체를 반환하는 메소드
		// => ServletContext 객체 : 웹자원(WebContext)을 관리하기 위한 객체 - WAS
		//ServletContext.getRealPath(String contextParh) : 매개변수로 전달받은 웹자원의
		//파일 시스템 경로를 반환하는 메소드
		String imageFilePath=request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		//System.out.println("imageFilePath = "+imageFilePath);
		
		//매개변수에 이미지 파일의 파일 시스템 경로를 제공하여 파일 입력스트림(FileInputStream 객체) 생성
		FileInputStream in=new FileInputStream(imageFilePath);
		
		//입력스트림으로 원시데이타를 읽어와 출력스트림으로 전달 - 반복 처리
		// => 서버에 저장된 이미지 파일을 클라이언트에게 전달하기 위한 응답파일로 생성
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		in.close();//파일 입력스트림 제거
	}
}
