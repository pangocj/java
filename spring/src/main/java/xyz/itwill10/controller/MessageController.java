package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.itwill10.dto.Product;

//스프링 메세지(Spring Message) : 메세지 관리하기 위한 기능

@Controller
@RequestMapping("/msg")
public class MessageController {
	@RequestMapping("/register")
	public String msg(@ModelAttribute Product product) {
		return "message/register";
	}
	
	
}
