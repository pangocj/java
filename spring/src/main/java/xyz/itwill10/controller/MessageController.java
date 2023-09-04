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
//1.메세지가 저장된 Properties 파일 생성 - 메세지에 {정수값} 형식의 표현식을 사용하여 작성 가능
//2.Spring Bean Configuration File(servlet-context.xml)에 메세지 관리 기능을 제공하는 클래스를 Spring Bean으로 등록
// => 메세지가 저장된 Properties 파일의 경로를 객체의 필드값으로 저장된도록 인젝션 처리 
//3.뷰페이지(JSP 문서)에서 message 태그(code 속성)를 사용하여 메세지를 제공받아 출력 처리
// => {정수값} 형식의 표현식에는 arguments 속성을 사용하여 표현식 대신 출력될 값을 제공  

@Controller
@RequestMapping("/msg")
public class MessageController {
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String msg(@ModelAttribute Product product) {
		return "message/register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String msg(@ModelAttribute @Valid Product product, Errors errors, HttpSession session) {
		//Locale 객체를 사용하여 사용 언어를 변경
		Locale locale=new Locale("en");
		//Session 객체에 Locale 객체를 속성값으로 저장
		// => 반드시 속성명을 SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME 상수로 설정
		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
		
		if(errors.hasErrors()) {
			return "message/register";
		}
		return "message/success";
	}
}





