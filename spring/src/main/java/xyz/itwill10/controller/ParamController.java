package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*
	//요청 처리 메소드의 매개변수에 HttpServletRequest 인터페이스로 매개변수를 선언하면 Front Controller에게
	//클라이언트의 요청정보가 저장된 HttpServletRequest 객체를 제공받아 사용 가능
	// => HttpServletRequest 객체의 메소드를 호출하여 현재 페이지 요청시 전달된 값을 반환받아 사용
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String food=request.getParameter("food");
		request.setAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//요청 처리 메소드에서 현재 페이지를 요청할 때 전달된 값의 이름과 같은 이름으로 원시형 또는 String 
	//클래스의 매개변수를 선언하면 Front Controller는 전달값을 매개변수에 자동으로 저장하여 제공
	// => 전달값의 이름과 매개변수의 이름이 같지 않은 경우 String 자료형의 매개변수에는 [null] 저장 
	// => 원시형의 매개변수는 전달값의 이름과 매개변수의 이름이 같지 않은 경우 또는 원시형에 
	//맞지 않은 값이 전달된 경우 400 에러코드 발생
	//매개변수를 이용하여 전달값을 제공받아 사용하기 전에 리퀘스트 메세지 몸체부에 저장되어
	//전달되는 값에 대한 문자형태(캐릭터셋) 변경 처리 - 인코딩 필드 사용
	//필터(Filter) : 웹프로그램 실행 전과 후에 실행될 명령을 제공하는 기능의 프로그램
	// => Filter 인터페이스를 상속받은 자식클래스(Filter 클래스)를 생성하여 [web.xml] 파일에 필터로 등록하여 사용
	// => 필터는 Front Controller 실행 전에 위치하여 필요한 기능 제공 - WAS 프로그램으로 제어
	//클라이언트의 모든 요청에 대해 리퀘스트 메세지 몸체부에 저장되어 전달되는 값에 대한
	//문자형태(캐릭터셋)을 변경하는 인코딩 필터가 사용되도록 [web.xml] 파일 설정
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//전달값을 제공받아 저장하기 위한 매개변수에 @RequestParam 어노테이션을 사용 - 권장
	//@RequestParam : 전달값을 제공받아 매개변수에 저장하기 위한 어노테이션
	// => 매개변수의 이름과 같은 이름으로 전달된 값이 없는 경우 400 에러코드 발생
	// => 전달값의 이름을 매개변수의 이름과 같도록 하여 매개변수에 반드시 전달값이 저장되도록
	//설정하기 위한 어노테이션
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(@RequestParam String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	//required 속성 : false(선택 전달값) 또는 true(필드 전달값 - 기본값) 중 하나를 속성값으로 설정
	// => @RequestParam 어노테이션으로 전달값이 매개변수에 저장되는 필수 여부를 구분하기 위한 속성
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(@RequestParam(required = true) String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
}











