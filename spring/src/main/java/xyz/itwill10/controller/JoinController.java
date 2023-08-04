package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
}
