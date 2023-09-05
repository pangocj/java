package xyz.itwill.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Spring Security : SpringMVC 프로그램의 인증과 인가 기능을 지원하는 보안 프레임워크

//인증(Authentication) : 로그인 사용자가 맞는지를 확인하는 절차
// => 인증을 정상적으로 수행하기 위해 사용자를 식별할 수 있는 정보 필요 - Credential  

//인가(Authorization - 권한) : 인증된 사용자가 요청된 자원에 접근 가능한가를 결정하는 절차
// => 인증 처리 후 실행 - 권한은 일반적으로 역활(Role) 형태로 부여

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/user/page", method = RequestMethod.GET)
	public String userPage() {
		return "user_page";
	}
	
	@RequestMapping(value = "/manager/page", method = RequestMethod.GET)
	public String managerPage() {
		return "manager_page";
	}
	
	@RequestMapping(value = "/admin/page", method = RequestMethod.GET)
	public String adminPage() {
		return "admin_page";
	}
}
