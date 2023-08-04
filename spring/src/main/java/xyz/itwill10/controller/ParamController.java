package xyz.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	//요청 처리 메소드의 매개변수에 HttpServletRequest 인터페이스로 매개변수를 선언하면 Front Controller에게
	//클라이언트의 요청정보가 저장된 HttpServletRequest 객체를 제공받아 사용 가능
	// => HttpServletRequest 객체의 메소드를 호출하여 현재 페이지 요청시 전달된 값을 반환받아 사용
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String food=request.getParameter("food");
		request.setAttribute("food", food);
		return "param_display";
	}
}
