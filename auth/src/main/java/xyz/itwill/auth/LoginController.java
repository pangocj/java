package xyz.itwill.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login() {
		return "login_page";
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "access_denied";
	}
}
