package xyz.itwill09.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//모델 기능을 제공하기 위한 클래스 - 요청 처리 클래스(Controller 클래스)
// => 클라이언트가 [/view.do]의 URL 주소로 요청한 경우 컨트롤러에 의해 실행될 요청 처리 클래스
public class ViewController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product", new Product(4000,"프린터"));
		modelAndView.setViewName("product_view");
		return modelAndView;
	}
}
