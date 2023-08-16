package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//REST(Representational State Transfer) : 자원(Resource)의 표현(Representational)에 의한
//상태(State)를 전달(Transfer)하는 것을 의미
// => 페이지 요청에 대한 실행결과를 클라이언트에게 XML 이나 JSON 형식의 텍스트 데이타로 응답 처리
//Restful API : REST 기능을 사용하여 두 컴퓨터의 시스템이 안전하게 값을 주고 받기 위한 프로그램
// => 스마트기기의 프로그램(앱) 정보를 전달받아 사용하거나 실행결과를 제공받아 출력하기 위해 사용

@Controller
@RequestMapping("/rest")
public class RestfulController {
	//회원정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "rest/input";
	}
	
	//전달값을 매개변수로 제공받아 뷰에게 속성값으로 저장하여 출력하기 위한 JSP 문서의 뷰이름을
	//반환하는 요청 처리 메소드
	// => 하나의 전달값을 하나의 매개변수로 제공받아 요청 처리 메소드에서 사용 - @RequestParam 어노테이션 사용
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
}







