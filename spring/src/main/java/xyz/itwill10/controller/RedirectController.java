package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		//Model 객체를 사용하여 뷰(View)에게 제공할 객체를 속성값으로 저장 - Request Scope
		model.addAttribute("name", "홍길동");
		
		//뷰를 생성하기 위한 뷰이름(ViewName) 반환
		// => Front Controller(DispatchServlet 클래스)는 제공받은 뷰이름을 InternalResourceViewResolver 
		//객체를 사용하여 JSP 문서로 변환하고 JSP 문서로 포워드 이동하여 응답 처리
		//포워드 이동 : 서버 내부에서 현재 웹프로그램의 스레드를 다른 웹프로그램으로 이동하여 응답 처리
		// => 클라이언트의 요청 URL 주소는 변경되지 않으며 Request Scope 속성값을 객체로 제공받아 사용 가능
		return "display_forward";
	}
}








