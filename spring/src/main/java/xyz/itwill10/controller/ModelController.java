package xyz.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("name", "홍길동");
		//model.addAttribute("now", new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display";
	}
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name", "임꺽정");
		//model.addAttribute("now", new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display";
	}
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name", "전우치");
		//model.addAttribute("now", new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display";
	}
	
	//시스템의 현재 날짜와 시간을 문자열로 반환하는 메소드
	//@ModelAttribute : 메소드에 @ModelAttribute 어노테이션을 사용하면 메소드에 의해 반환되는 
	//객체(값)을 현재 Controller 클래스에 작성된 모든 요청 처리 메소드의 뷰에게 제공하는 어노테이션
	// => 요청 처리 메소드에 의해 응답 처리될 뷰에서 공통적으로 사용되는 객체(값)를 제공할 목적으로 사용
	//value 속성 : 메소드에 의해 반환된 객체(값)을 뷰에서 사용하기 위한 이름(속성명)을 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	@ModelAttribute(value = "now")
	public String getNow() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
	}
}
