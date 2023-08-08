package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

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
@RequiredArgsConstructor
public class StudentController {
	//Controller 클래스의 요청 처리 메소드에서 사용될 Service 클래스의 객체를 저장하기 위한 필드
	// => 생성자를 이용하여 필드에 Service 클래스의 객체(Spring Bean)가 저장되도록 의존성 주입
	private final StudentService studentService;
	
	//학생정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String add() {
		return "student/student_add";
	}
	
	//전달값(학생정보)를 제공받아 STUDENT 테이블에 학생정보를 삽입하고 학생목록을 출력하는 
	//JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => Service 클래스의 객체로 메소드를 호출하여 데이타 처리 기능 구현 
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		studentService.addStudent(student);
		return "redirect:/student/display";//라디이렉트 이동
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 속성값으로 저장하고 학생목록을 출력하는
	//JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping("/student/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/student_display";
	}
}












