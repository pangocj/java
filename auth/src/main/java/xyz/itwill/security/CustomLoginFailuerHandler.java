package xyz.itwill.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

//로그인 실패 후에 실행될 기능을 제공하기 위한 클래스
// => 로그인 실패 횟수 누적, 계정 비활성화 처리 등의 기능 구현
// => AuthenticationFailureHandler 인터페이스를 상속받아 작성하거나 AuthenticationFailureHandler 
//인터페이스를 상속받은 클래스를 상속받아 작성
public class CustomLoginFailuerHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		request.getSession().setAttribute("userid", request.getParameter("userid"));
		setDefaultFailureUrl("/loginPage");
		super.onAuthenticationFailure(request, response, exception);
	}
}











