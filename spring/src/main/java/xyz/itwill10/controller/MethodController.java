package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MethodController {
	//사용자에게 값을 입력받기 위한 JSP 문서에 대한 ViewName를 반환하는 요청 처리 메소드
	// => 클라이언트의 요청방식에 상관없이 무조건 요청 처리 메소드 호출
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
}
