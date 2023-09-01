package xyz.itwill10.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Employee;

//입력값 검증(InputDate Validation) : 사용자 입력값에 대한 유효성 검사를 구현하기 위한 기능

@Controller
@RequestMapping("/valid")
public class ValidController {
	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public String html() {
		return "valid/html_form";
	}
	
	@RequestMapping(value = "/html", method = RequestMethod.POST)
	public String html(@ModelAttribute Employee employee) {
		employee.setPasswd(BCrypt.hashpw(employee.getPasswd(), BCrypt.gensalt()));
		return "valid/html_result";
	}
}












