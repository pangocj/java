package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Student;

//SpringMVC 기능을 사용하여 웹프로그램을 작성하는 방법
// => 테이블 >> DTO 클래스 >> DAO 클래스(Mybatis) >> Service 클래스 >> Controller 클래스
// >> 테스트 프로그램(JUnit) - 단위 프로그램(모듈) 테스트 >> HTML 문서를 JSP 문서로 변환
// >> 통합 프로그램 테스트 - 브라우저 이용

//Controller 클래스 : 클라이언트의 요청을 처리하기 위한 기능을 제공하기 위한 클래스

//Controller 클래스는 Front Controller(DispatchServlet 클래스)에게 객체로 제공되어 사용되도록 반드시 Spring Bean으로 등록
// => Controller 클래스는 @Controller 어노테이션을 사용하여 Spring Bean으로 등록
//=> @Controller 어노테이션을 사용하면 클라이언트 요청에 의해 호출되는 요청 처리 메소드 작성
//=> @Controller 어노테이션을 스프링 컨테이너가 처리하기 위해 반드시 클래스가 작성된 패키지를
//Spring Bean Configuration File(servlet-context.xml)의 component-scan 엘리먼트로 검색되도록 설정

@Controller
public class StudentController {
	//학생정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String add() {
		return "student/student_add";
	}
	
	//전달값(학생정보)를 제공받아 STUDENT 테이블에 학생정보를 삽입하고 학생목록을 출력하는 
	//JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		
		return "student/student_add";
	}
}












