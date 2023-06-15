package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(form.html)로부터 전달받은 입력값(회원정보)을 반환받아 클라이언트에게 전달하여 
//응답하는 서블릿
// => 입력페이지의 form 태그를 이용하여 POST 방식으로 요청해야만 실행되는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
	
		//서블릿을 GET 방식으로 요청한 경우 비정상적인 요청으로 클라이언트에게 에러코드를
		//전달하거나 에러페이지로 이동되도록 처리
		//HttpServletRequest.getMethod() : 서블릿을 요청한 요청방식(GET or POST)을 반환하는 메소드
		if(request.getMethod().equals("GET")) {//서블릿을 비정상적으로 요청한 경우
			/*
			//HttpServletResponse.sendError(int sc) : 클라이언트에게 에러코드(4XX or 5XX)를
			//전달하여 응답하는 메소드
			// => 상태코드(StatusCode)는 HttpServletResponse 인터페이스의 정의된 상수 사용 
			//response.sendError(400);
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
			//response.sendError(405);
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405
			return;
			*/
			
			/*
			//HttpServletResponse.sendRedirect(String url) : 클라이언트에게 301 상태코드와
			//URL 주소를 전달하여 응답
			// => 클라이언트는 전달받은 URL 주소로 브라우저의 요청 URL를 변경하여 웹프로그램을
			//요청하여 실행결과를 응답받아 출력 - 페이지 이동(리다이렉트 이동) 
			//response.sendRedirect("error.html");//에러페이지로 이동
			response.sendRedirect("form.html");//입력페이지로 이동
			return;
			*/
			
			//클라이언트에서 자바스트립트 전달하여 응답
			out.println("<script type='text/javascript'>");
			out.println("alert('비정상적으로 페이지를 요청 하였습니다.');");
			out.println("location.href='form.html';");
			out.println("</script>");
			return;
		}
		
		//서블릿을 POST 방식으로 요청한 경우 사용자 입력값을 리퀘스트 메세지 몸체부에 저장하여 전달
		// => 리퀘스트 메세지 몸체부에 저장되어 전달되는 값은 기본적으로 문자형태를 서유럽어
		//(ISO-8859-1)의 반환받아 사용
		// => 리퀘스트 메세지 몸체부에 저장되어 전달되는 값에 대한 캐릭터셋 변경
		//HttpServletRequest.setCharacterEncoding(String encoding) : 리퀘스트 메세지 몸체부에
		//저장되어 전달되는 값에 대한 문자형태를 변경하는 메소드
		// => GET 방식으로 요청한 경우 리퀘스트 메세지 몸체부를 사용하지 않으므로 메소드 사용 불필요
		request.setCharacterEncoding("utf-8");
		
		//서블릿을 요청할 때 전달된 값을 반환받아 저장
		//HttpServletRequest.getParameter(String name) : 매개변수로 전달받은 이름의 전달값을 
		//문자열(String 객체)로 반환하는 메소드
		// => 매개변수의 이름으로 전달된 값이 없는 경우 [null] 반환
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		//동일한 이름으로 전달되는 값이 여러개 있는 경우 getParameterValues() 메소드 호출 
		//String hobby=request.getParameter("hobby");//첫번째 전달값만 반환받아 저장
		//HttpServletRequest.getParameter(String name) : 매개변수로 전달받은 이름의 모든
		//전달값을 문자열 배열(String[])로 반환하는 메소드
		String[] hobby=request.getParameterValues("hobby");
		String job=request.getParameter("job");
		String profile=request.getParameter("profile");
		
		/*
		if(id==null || id.equals("")) {//전달값이 없는 경우 - 비정상적인 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST); 
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) {//전달값이 정규표현식 패턴과 맞지 않은 경우
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		*/
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원가입확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디 = "+id+"</p>");
		out.println("<p>비밀번호 = "+passwd+"</p>");
		out.println("<p>이름 = "+name+"</p>");
		out.println("<p>이메일 = "+email+"</p>");
		out.println("<p>성별 = "+gender+"</p>");
		out.println("<p>취미 = ");
		for(int i=0;i<hobby.length;i++) {
			out.println(hobby[i]);//배열의 요소값을 HTML 문서에 포함하여 응답
			if(i < hobby.length-1) {
				out.println(",");
			}
		}
		out.println("</p>");
		out.println("<p>직업 = "+job+"</p>");
		//전달값의 엔터(Enter)를 <br> 태그로 변환해야만 줄바꿈 처리 가능
		out.println("<p>자기소개 = <br>"+profile.replace("\n", "<br>")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
