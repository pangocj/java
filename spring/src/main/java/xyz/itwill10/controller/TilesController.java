package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TilesView 클래스 : 요청 처리 메소드의 반환값(ViewName)을 제공받아 다수의 JSP 문서가 결합된
//JSP 문서(템플릿 페이지)로 응답하기 위한 기능을 제공하는 클래스 - ViewResolver
//1.TilesView 관련 라이브러리(tiles-extras 라이브러리)를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.요청 처리 메소드의 반환값(ViewName)을 제공받아 응답할 템플릿 페이지 설정
// => TilesView 프로그램의 환경설정파일을 설정 - /WEB-INF/spring/appServlet/tiles.xml
//3.Front Controller(DispatcherServlet 클래스)가 요청 처리 메소드의 반환값(ViewName)을 제공받아
//TilesView 클래스를 이용하여 응답 처리되도록 Spring Bean Configuration File(servlet-context.xml) 설정
// => InternalResourceViewResolver 클래스보다 TilesView 클래스가 먼저 실행되도록 우선 순위 설정

@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
}













