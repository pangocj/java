package xyz.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//필터(Filter) : 클라이언트 요청에 대한 웹프로그램 실행 전 또는 후에 동작될 기능을 제공
// => WAS(웹컨테이너)에 의해 관리되며 XSS 방어, 인코딩 변환 처리, 요청에 대한 인증, 권한 검사 등에 사용 

//필터 클래스 : 클라이언트 요청에 대한 웹프로그램 실행 전 또는 후에 동작될 명령을 작성하기 위한 클래스
// => Filter 인터페이스를 상속받아 작성
// => @WebFilter 어노테이션 또는 [web.xml] 파일의 엘리먼트를 사용하여 필터 클래스를 필터로 
//등록하고 URL 패턴정보를 매핑 처리하여 사용

//클라이언트가 요청하는 모든 웹프로그램 실행 전에 리퀘스트 메세지 몸체부에 저장되어 전달되는
//값에 대한 캐릭터셋를 변경하는 기능을 제공하는 필터 클래스 - 인코딩 필터
public class EncodingFilter implements Filter {
	private String encoding;
	
	//필터를 동작하기 위한 필터 클래스를 객체로 생성한 후 가장 먼저 한번만 호출되는 메소드 
	// => 초기화 작업에 필요한 명령 작성
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//FilterConfig.getInitParameter(String name) : [web.xml] 파일에서 init-param 엘리먼트로
		//제공되는 값을 얻어와 반환하는 메소드
		encoding=filterConfig.getInitParameter("encoding");
	}
	
	//웹프로그램 실행 전 또는 후에 동작될 명령을 작성하는 메소드
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//웹프로그램 실행 전에 동작될 명령 작성
		if(request.getCharacterEncoding() == null || 
				!request.getCharacterEncoding().equalsIgnoreCase(encoding)) {
			request.setCharacterEncoding(encoding);
		}

		//FilterChain.doFilter(ServletRequest request, ServletResponseresponse)
		// => 다른 필터 객체 연결하여 사용하기 위한 메소드
		// => 필터 객체가 없는 경우 서블릿 객체와 연결되어 웹프로그램 실행
		chain.doFilter(request, response);
		
		//웹프로그램 실행 후에 동작될 명령 작성
		
	}

}





