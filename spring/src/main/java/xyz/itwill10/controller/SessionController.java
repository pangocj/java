package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import xyz.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : Model 객체를 사용하여 저장되는 속성값을 현재 요청 처리 클래스(Controller 클래스)의
//모든 요청 처리 메소드와 뷰에게 제공하기 위한 어노테이션
// => Model 객체를 사용하여 저장되는 속성값을 Request Scope 속성값이 아닌 제한적인 Session Scope 속성값을
//변환하여 사용되도록 제공하는 어노테이션
// => 변경 처리시 호출되는 요청 처리 메소드에서 변경할 객체를 검색하지 않고 뷰에서는 값을
//전달하지 않도록 제한적인 Session Scope 속성값을 제공하기 위해 사용
//value 속성 : 제한적인 Session Scope 속성값으로 변환하기 위한 속성명을 속성값으로 설정
// => 다른 속성이 없는 경우 속성값만 설정 가능
@SessionAttributes("hewon")
public class SessionController {
	//아이디를 전달받아 회원정보를 검색하여 반환하는 메소드 - Service 클래스의 메소드
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setName("홍길동");
		hewon.setEmail("abc@itwill.xyz");
		return hewon;
	}
	
	//아이디를 전달받아 아이디의 회원정보를 검색하여 뷰에게 제공하기 위한 요청 처리 메소드
	// => 요청 처리 메소드에서 검색된 회원정보를 속성값으로 저장하여 뷰(JSP)에서 HTML 태그를 사용하여 출력되도록 응답 처리
	@RequestMapping("/hewon_view")
	public String view(@RequestParam(defaultValue = "abc123") String id, Model model) {
		//Service 클래스의 메소드를 호출하여 매개변수에 전달된 아이디의 회원정보를 검색하여 반환받아 저장
		Hewon hewon=getHewon(id);
		
		//Model 객체를 사용하여 검색된 회원정보를 속성값으로 저장하여 뷰에게 제공
		// => 현재 요청 처리 메소드의 뷰에게만 속성값을 제공하여 응답 처리 - Request Scope
		//model.addAttribute("hewon", hewon);
		
		//속성명을 생략하면 속성값으로 저장된 객체의 자료형(클래스)의 이름을 속성명으로 자동 설정
		// => 속성명은 클래스 이름의 첫문자는 소문자로 자동 변환
		//@SessionAttributes 어노테이션에 의해 Model 객체로 저장된 속성값은 제한적인 Session Scope 
		//속성값으로 변환되어 현재 요청 처리 클래스의 모든 요청 처리 메소드와 뷰에게 속성값 제공
		model.addAttribute(hewon);//속성명 생략 가능
		
		return "hewon_view";
	}
	
	/*
	//아이디를 전달받아 아이디의 회원정보를 검색하여 뷰에게 제공하기 위한 요청 처리 메소드
	// => 요청 처리 메소드에서 검색된 회원정보를 속성값으로 저장하여 뷰(JSP)에서 입력 태그의 초기값으로 사용되도록 응답 처리
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update(@RequestParam(defaultValue = "abc123") String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "hewon_update";
	}
	*/

	//@SessionAttributes 어노테이션에 의해 제공된 회원정보를 요청 처리 메소드와 뷰에서 사용 가능
	// => 아이디를 전달받아 회원정보를 검색하는 명령과 뷰에게 속성값을 저장하여 제공하는 명령 불필요
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update() {
		return "hewon_update";
	}
	
	/*
	//회원정보를 전달받아 변경된 회원정보를 뷰에게 제공하는 요청 처리 메소드
 	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String update(@ModelAttribute Hewon hewon) {
 		return "hewon_result";
	}
	*/

	//요청 처리 메소드의 매개변수에는 @SessionAtrributes 어노테이션에 의해 제공된 회원정보를
	//전달받아 저장하고 변경값으로 매개변수의 저장된 객체의 필드값만 변경 처리
	//SessionStatus 인터페이스로 매개변수를 작성하여 SessionStatus 객체를 제공받아 저장
	// => SessionStatus 객체 : @SessionAtrributes 어노테이션에 의해 제공된 제한적인 Session
	//Scope 속성값의 상태정보를 저장하기 위한 객체
 	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String update(@ModelAttribute Hewon hewon, SessionStatus sessionStatus) {
 		//SessionStatus.setComplete() : @SessionAtrributes 어노테이션에 의해 제공된 제한적인 
 		//Session Scope 속성값을 제거하는 메소드
 		// => 다른 요청 처리 메소드와 뷰에서 제한적인 Session Scope 속성값을 사용하지 못하도록 설정
 		sessionStatus.setComplete();
		return "hewon_result";
	}
}







