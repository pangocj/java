package xyz.itwill10.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import xyz.itwill10.dto.Product;

//스프링 메세지(Spring Message) : 메세지 관리하기 위한 기능
//1.Spring Bean Configuration File(servlet-context.xml)에 메세지 관리 기능을 제공하는 클래스를 Spring Bean으로 등록
//2.메세지가 저장된 Properties 파일 생성

@Controller
@RequestMapping("/msg")
public class MessageController {
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String msg(@ModelAttribute Product product) {
		return "message/register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String msg(@ModelAttribute @Valid Product product, Errors errors) {
		if(errors.hasErrors()) {
			return "message/register";
		}
		return "message/success";
	}
}





