package xyz.itwill10.controller;

import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Employee;

//스프링 입력값 검증(InputDate Validation) : 사용자 입력값에 대한 유효성 검사를 구현하기 위한 기능

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
				
		return "valid/html_result";
	}
	
	//Spring Form 태그에서 사용하기 위한 Command 객체를 저장할 매개변수 선언
	@RequestMapping(value = "/spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Employee employee) {
		return "valid/spring_form";
	}
}





