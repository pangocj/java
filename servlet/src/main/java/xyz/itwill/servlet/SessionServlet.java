package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//세션(Session) : 서버(웹프로그램)와 클라이언트(브라우저)의 연결 지속성을 제공하기 위한 정보를
//서버에 저장하는 값(객체) - WAS 프로그램에 의해 관리
// => 보안 관련 정보(권한)를 세션에 저장하여 사용할 목적으로 이용
// => 세션을 구분하기 위한 식별자(SessionId)를 이용하여 클라이언트를 구분해 세션에 값(객체)를
//저장하여 사용
//세션 바인딩(Session Binding) : 연결 지속성을 제공하기 위한 값(객체)이 저장될 세션을 웹프로그램에서
//사용할 수 있도록 결합하는 작업 - WAS

//클라이언트에게 [JSESSIONID] 이름의 쿠키값을 제공받지 못한 경우 서버 메모리에 새로운 세션을 생성하여
//바인딩 처리하고 생성된 세션의 식별자(SessionId)를 클라이언트에게 [JSESSIONID] 이름의 쿠키값로 전달
// => 클라이언트에 저장된 [JSESSIONID] 이름의 쿠키값은 브라우저 종료시 소멸
//클라이언트에게 [JSESSIONID] 이름의 쿠키값을 제공받은 경우 세션 트랙킹하여 바인딩 처리
// => 세션 트랙킹이 실패한 경우 새로운 세션을 생성하고 세션의 식별자(SessionId)를 클라이언트에게 전달
//세션 트랙킹(Session Tracking) : 클라이언트에게 제공받은 [JSESSIONID] 이름의 쿠키값과
//서버 메모리에 저장된 세션의 식별자(SessionId)를 비교하여 검색하는 작업

//세션을 바인딩하여 클라이언트에게 바인딩된 세션정보를 전달하여 응답하는 서블릿
@WebServlet("/session.itwill")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//HttpServletRequest.getSession() : 바인딩 처리된 세션(HttpSession 객체) 반환하는 메소드
		// => 새로운 세션을 생성하여 바인딩하거나 기존 세션을 트렉킹하여 바인딩 처리
		//HttpSession 객체 : 연결 지속성을 제공하는 값(객체)을 저장하기 위한 객체
		HttpSession session=request.getSession();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>세션(Session)</h1>");
		out.println("<hr>");
		//HttpSession.isNew() : 세션을 트렉킹하여 바인딩된 경우 [false]를 반환하거 세션을
		//생성하여 바인딩된 경우 [true]를 반환하는 메소드
		if(session.isNew()) {
			out.println("<p>세션을 생성하여 바인딩 하였습니다.</p>");
		} else {
			out.println("<p>세션을 트렉킹하여 바인딩 하였습니다.</p>");
		}
		//HttpSession.getId() : 세션을 구분하기 위한 식별자(SessionId)를 반환하는 메소드
		out.println("<p>세션 고유값(SessionId) = "+session.getId()+"</p>");
		//HttpSession.getMaxInactiveInterval() : 세션 유지시간(초)를 반환하는 메소드 
		// => 세션 유지시간 : 세션을 사용하지 않을 경우 서버 메모리에서 세션이 자동 소멸되도록 설정하는 시간
		// => 세션의 기본 유지시간은 30분으로 설정
		out.println("<p>세션 유지시간 = "+session.getMaxInactiveInterval()+"</p>");
		
		//HttpSession.setAttribute(String attributeName, Object attributeValue)
		// => HttpSession 객체에 연결 지속성을 제공하기 위한 값(객체)를 저장하는 메소드
		// => 매개변수에 값을 구분하기 위한 속성명과 연결 지속성을 제공하기 위한 속성값을 전달
		// => 매개변수로 전달받은 속성명과 같은 이름의 속성값이 존재할 경우 덮어씌우기 - 속성값 변경
		//동일한 세션을 바인딩한 모든 웹프로그램에게 속성명으로 속성값을 제공하여 사용 가능
		// => 하나의 클라이언트는 세션을 사용하여 모든 웹프로그램에게 객체를 공유하여 제공
		session.setAttribute("now", new Date());

		//HttpSession.getAttribute(String attributeName) : HttpSession 객체에 저장된 속성값을
		//반환하는 메소드 - 매개변수에 속성값을 구분하기 위한 속성명 전달
		// => HttpSession 객체에 저장된 속성값은 Object 객체로 반환되므로 반드시 명시적 객체 형변환 이용
		// => 매개변수로 전달받은 속성명의 속성값이 없는 경우 [null] 반환
		Date now=(Date)session.getAttribute("now");
		out.println("<p>세션에 저장된 속성값(객체) = "+now+"</p>");

		//HttpSession.removeAttribute(String attributeName) : HttpSession 객체에 저장된 
		//속성값을 삭제하는 메소드 - 매개변수에 속성값을 구분하기 위한 속성명 전달
		session.removeAttribute("now");

		//HttpSession.invalidate() : 바인된 세션을 언바인딩하여 무효화 처리하는 메소드
		// => 바인딩된 HttpSession 객체 제거
		session.invalidate();
		
		out.println("</body>");
		out.println("</html>");
	}
}
