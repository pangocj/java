package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//요청 처리 메소드의 의해 처리된 결과를 뷰(JSP 문서)에게 제공하는 방법
//1.ModelAndView 객체의 addObject() 메소드를 호출하여 처리결과를 속성값으로 저장하여 제공
//2.HttpServletRequest 객체의 setAttribute() 메소드를 호출하여 처리결과를 속성값으로 저장하여 제공
//3.Model 객체의 addAttribute() 메소드를 호출하여 처리결과를 속성값으로 저장하여 제공

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");

		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView 객체에 처리결과를 속성값으로 저장하는 메소드 - Request Scope
		// => 뷰(JSP 문서)에서는 EL 또는 JSTL를 이용하여 속성명으로 속성값을 제공받아 사용
		modelAndView.addObject("mavName", "홍길동");
		
		return modelAndView;
	}
	*/

	//요청 처리 메소드는 Front Controller에 의해 자동 호출되는 메소드
	// => 요청 처리 메소드에 매개변수를 작성하면 Front Controller는 스프링 컨테이너(WebApplicationContext 객체)
	//에게 매개변수에 저장 가능한 객체(Spring Bean)를 제공받아 저장
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "홍길동");
		return modelAndView;
	}	
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		//HttpServletRequest.setAttribute(String attributeName, Object attributeValue)
		// => HttpServletRequest 객체에 처리결과를 속성값으로 저장하는 메소드 - Request Scope
		request.setAttribute("requestName", "임꺽정");
		return "result_display";		
	}
	
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		//Model 객체 : 처리결과를 속성값으로 저장하여 뷰에게 제공하기 위한 객체
		//model.addAttribute((String attributeName, Object attributeValue)
		// => Model 객체에 처리결과를 속성값으로 저장하는 메소드 - Request Scope
		model.addAttribute("modelName", "전우치");
		return "result_display";
	}
}
