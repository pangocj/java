package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 [/login.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 로그인정보를 전달받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증 처리한 후 인증 
//성공시 세션에 권한 관련 객체를 속성값으로 저장하고 [/loginform.do] 페이지로 리다이렉트 이동
//하기 위한 정보가 저장된 ActionForward 객체 반환
// => 인증 실패시 [user_login.jsp] 문서로 포워드 이동하기 위한 정보가 저장된  ActionForward 
//객체 반환 - 에러메세지와 아이디를 request 객체의 속성값으로 저장하여 JSP 문서에 제공
public class LoginModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		//클라이언트 요청에 대한 명령을 실행하면서 발생되는 모든 예외를 처리하기 위한 기능 구현
		try {
			//[/login.do] 페이지를 GET 방식으로 요청한 경우 - 비정상적인 요청
			if(request.getMethod().equals("GET")) {
				throw new Exception();//인위적인 예외 발생
			}
			
			//서블릿(컨트롤러) 요청시 전달된 값을 반환받아 저장
			// => 서블릿(컨트롤러)의 request 객체를 요청 처리 메소드의 매개변수로 전달받아 사용
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//모델 클래스의 요청 처리 매소드에서는 Service 클래스의 객체로 메소드를 호출하여
			//데이타 처리 관련 기능이 실행되도록 작성
			
		} catch (Exception e) {//모든 예외를 전달받아 예외 처리하기 위한 명령 작성
			e.printStackTrace();//서버 콘솔에 예외가 발생한 예외정보 출력
			//[error.do] 페이지로 리다이렉트 이동하기 위한 정보를 ActionForward 객체에 저장
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		
		return actionForward;
	}

}
