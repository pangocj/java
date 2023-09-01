package xyz.itwill10.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Employee;

//스프링 입력값 검증(InputDate Validation) : 사용자 입력값에 대한 유효성 검사를 구현하기 위한 기능
//1.validation-api 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.HTML 태그 대신 Spring 태그를 사용하여 페이지 요청시 입력값이 전달되도록 뷰 작성
//3.Controller 클래스의 요청 처리 메소드에서 전달값이 저장된 Command 객체를 저장하는 매개변수에
//@Valid 어노테이션을 사용하여 Command 객체를 생성하는 VO 클래스에서 유효성 검증이 되도록 설정

@Controller
@RequestMapping("/valid")
public class ValidController {
	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public String html() {
		return "valid/html_form";
	}
	
	@RequestMapping(value = "/html", method = RequestMethod.POST)
	public String html(@ModelAttribute Employee employee, Model model) {
		//전달값에 대한 입력값 검증 - 서버
		if(employee.getId() == null || employee.getId().equals("")) {
			model.addAttribute("idMsg", "아이디를 입력해 주세요.");
			return "valid/html_form";
		}
		
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(!Pattern.matches(idReg, employee.getId())) {
			model.addAttribute("idMsg", "아이디를 형식에 맞게 입력해 주세요.");
			return "valid/html_form";
		}
		
		employee.setPasswd(BCrypt.hashpw(employee.getPasswd(), BCrypt.gensalt()));
				
		return "valid/result";
	}
	
	//Spring Form 태그에서 사용하기 위한 Command 객체를 저장할 매개변수 선언
	@RequestMapping(value = "/spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Employee employee) {
		//List 객체를 생성하여 뷰에게 제공
		//model.addAttribute("genderList", Arrays.asList("남자", "여자"));
		return "valid/spring_form";
	}
	
	//@Valid  : Spring 태그에 의해 전달된 값을 Command 객체의 필드에 저장하기 전에 전달값에
	//대한 유효성 검증 기능을 제공하기 위한 어노테이션
	// => VO(DTO) 클래스의 필드에 유효성 검증 관련 어노테이션 사용
	//Errors : 유효성 검증 후 발생되는 모든 에러 관련 정보를 저장하기 위한 객채
	@RequestMapping(value = "/spring", method = RequestMethod.POST)
	public String spring(@ModelAttribute @Valid Employee employee, Errors errors) {
		//Errors.hasErrors() : Errors 객체에 에러 관련 정보가 존재할 경우 [true]를 반환하는 메소드
		if(errors.hasErrors()) {
			//model.addAttribute("genderList", Arrays.asList("남자", "여자"));
			return "valid/spring_form";
		}
		
		employee.setPasswd(BCrypt.hashpw(employee.getPasswd(), BCrypt.gensalt()));

		return "valid/result";
	}
	
	//모든 요청 처리 메소드의 뷰에게 반환값을 제공하는 어노테이션
	@ModelAttribute("genderList")
	public List<String> genderList() {
		return Arrays.asList("남자", "여자");
	}
}





