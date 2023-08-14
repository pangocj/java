package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.BadRequestException;

//Interceptor 클래스 : 요청 처리 메소드가 호출되기 전 또는 후에 삽입되어 실행될 기능을 제공하는 클래스
// => Interceptor 클래스는 반드시 HandlerInterceptor 인터페이스를 상속받아 작성 - 필요한 메소드만 오버라이드 선언하여 사용
// => Interceptor 클래스는 Spring Bean Configuration File(servlet-context.xml)에 Spring Bean으로
//등록하고 요청 처리 메소드 호출 전 또는 후에 실행되도록 설정 - 스프링 컨테이너에 의해 관리
// => Filter 클래스는 Front Controller 앞에 위치하여 실행(WAS에 의해 관리)되며 Interceptor 클래스는 
//Front Controller 뒤에 위치하여 실행(스프링 컨테이너에 의해 관리)

//관리자 관련 권한 처리를 위해 작성된 인터셉터 클래스
// => 요청 처리 메소드가 호출 전에 비로그인 사용자이거나 관리자가 아닌 사용자가 페이지를 요청한
//경우 인위적으로 예외 발생 - 에러 페이지로 응답 처리
public class AdminAuthInterceptor implements HandlerInterceptor {
	//preHandle 메소드 : 요청 처리 메소드가 호출되기 전에 실행될 명령을 작성하기 위한 메소드
	// => false 반환 : 요청 처리 메소드 미호출, true 반환 : 요청 처리 메소드 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		//비로그인 사용자이거나 관리자가 아닌 사용자인 경우
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			//response.sendError(HttpServletResponse.SC_FORBIDDEN);//403 에러코드 전달
			//return false;//요청 처리 메소드 미호출
			
			//request.getRequestDispatcher("userinfo/user_error.jsp").forward(request, response);
			//return false;
			
			throw new BadRequestException("비정상적인 요청입니다.");
		}
		
		return true;//요청 처리 메소드 호출
	}
	
	//postHandle 메소드 : 요청 처리 메소드가 호출되어 반환된 뷰이름으로 ViewResolver가 
	//뷰(View)를 생성되기 전에 실행될 명령을 작성하기 위한 메소드
	// => ModelAndView 객체를 제공받아 ViewName 또는 Model 객체의 속성값을 저장(변경)하기 위해 사용하는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	//afterCompletion 메소드 : 요청 처리 메소드가 호출되어 반환된 뷰이름으로 ViewResolver가 
	//뷰(View)를 생성한 후에 실행될 명령을 작성하기 위한 메소드
	// => 뷰(View)를 변경하기 위해 사용하는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
