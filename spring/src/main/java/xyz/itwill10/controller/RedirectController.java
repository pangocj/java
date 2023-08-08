package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/*
	@RequestMapping("/redirect_move")
	public String redirect(Model model) {
		model.addAttribute("name", "임꺽정");
		return "display_redirect";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//요청 처리 메소드의 반환값(뷰이름)에 redirect 접두사를 사용하여 URL 주소를 반환하면 Front
		//Controller(DispatchServlet 클래스)는 반환받은 뷰이름의 URL 주소를 클라이언트에게 전달
		// => URL 주소를 전달받은 클라이언트는 브라우저의 요청 URL 주소를 변경하고 URL 주소의
		//웹프로그램을 요청하여 실행결과를 응답받아 출력 처리 - 리다이렉트 이동
		//리다이렉트 이동 : 클라이언트의 URL 주소를 전달하여 페이지를 재요청해 웹프로그램의 
		//실행결과를 제공받아 응답 처리
		// => 클라이언트의 요청 URL 주소는 변경되지만 Request Scope 속성값 사용 불가능
		return "redirect:/redirect_move"; 
	}
	*/
	
	/*
	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}
	
	
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		//Model 객체로 저장된 속성값은 리다이렉트 이동된 페이지의 요청 처리 메소드와 뷰에서 사용 불가능
		// => Model 객체로 저장된 속성값(객체)을 질의문자열(QueryString)로 요청 페이지에 전달 
		model.addAttribute("name", "임꺽정");
		return "redirect:/redirect_move"; 
	}
	*/
	
	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}
	
	//요청 처리 메소드에 RedirectAttributes 인터페이스의 매개변수에 작성하여 RedirectAttributes
	//객체를 Front Controller에게 제공받아 사용 가능
	//RedirectAttributes 객체 : 리다이렉트 이동되는 페이지의 요청 처리 메소드와 뷰에서 사용
	//가능한 Request Scope 속성값을 제공하기 위한 객체
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => Request Scope 속성값을 저장하여 리다렉이트 이동되는 페이지의 요청 처리 메소드와
		//뷰에게 속성값을 제공하기 위한 메소드
		attributes.addFlashAttribute("name", "임꺽정");
		return "redirect:/redirect_move"; 
	}
}
