package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill10.dto.Member;


@Controller
public class JoinController {
	//회원정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	//전달값(회원정보)을 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력하는 JSP 문서의
	//뷰이름을 반환하는 요청 처리 메소드
	// => 전달값과 같은 이름의 매개변수를 선언하여 전달값을 제공받아 요청 처리 메소드에서 사용
	// => 매개변수에 @RequestParam 어노테이션을 사용하여 전달값의 이름과 매개변수의 이름이 
	//다른 경우 400 에러코드가 발생되도록 작성
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "join_display";
	}
	*/
	
	/*
	//전달값(회원정보)을 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력하는 JSP 문서의
	//뷰이름을 반환하는 요청 처리 메소드
	// => 전달값과 같은 이름의 매개변수를 선언하여 전달값을 제공받아 요청 처리 메소드에서 사용
	// => 매개변수에 @RequestParam 어노테이션 대신 @ModelAttribute 어노테이션 사용 가능
	//@ModelAttribute : 객체(값)을 뷰에게 제공하기 위한 어노테이션
	// => @ModelAttribute 어노테이션을 메소드에 사용하면 메소드의 반환값을 요청 처리 클래스의
	//모든 요청 처리 메소드의 뷰에게 제공
	// => @ModelAttribute 어노테이션을 매개변수에 사용하면 매개변수에 저장된 값을 현재 요청  
	//처리 메소드의 뷰에게 제공 - Model 객체를 사용하지 않고 뷰에게 필요한 객체(값)을 속성값으로 제공 
	//value 속성 : 뷰에서 속성값을 사용하기 위한 속성명을 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute(value="id") String id, @ModelAttribute("passwd") String passwd
			, @ModelAttribute("name") String name, @ModelAttribute("email") String email) {
		return "join_display";
	}
	*/

	//전달값(회원정보)을 제공받아 VO 클래스의 객체 필드값으로 저장하여 Request Scope 속성값으로
	//저장하고 속성값을 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		//VO(DTO) 클래스로 객체 생성하여 매개변수에 저장된 전달값으로 필드값 변경
		Member member=new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);
		
		//model.addAttribute("member", member);
		//Model.addAttribute(Object attributeValue) : 객체를 속성값을 저장하여 뷰에게 제공하는 
		//메소드 - Request Scope
		// => 매개변수에 속성값을 사용할 수 있는 속성명을 전달하지 않으면 속성값으로 저장되는
		//객체의 자료형(클래스)의 이름을 속성명으로 사용 - 첫문자는 소문자로 변환되어 사용
		// => 속성값이 원시값(Wrapper 객체) 또는 문자열(String 객체)는 반드시 속성명을 설정
		model.addAttribute(member);
		
		return "join_display";
	}

}








