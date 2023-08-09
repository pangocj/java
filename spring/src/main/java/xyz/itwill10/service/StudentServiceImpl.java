package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.StudentDAO;
import xyz.itwill10.dto.Student;

//Service 클래스 : 데이타 처리 관련 기능을 제공하기 위한 클래스
// => Service 클래스의 메소드에서는 데이타 처리에 필요한 기능을 구현하기 위한 DAO 클래스의 메소드를 
//호출하여 작성 - 데이타 처리 기능을 모듈화 처리한 클래스 : 컴퍼넌트(Component)
// => Service 클래스가 변경돼도 의존관계로 설정된 Controller 클래스의 영향을 최소화 하기 위한 인터페이스를 상속받아 작성
 
//Service 클래스는 Controller 클래스에게 객체로 제공되어 사용되도록 반드시 Spring Bean으로 등록
// => Service 클래스는 @Service 어노테이션을 사용하여 Spring Bean으로 등록
// => @Service 어노테이션을 사용하면 TransactionManager에 의해 트렌젝션 관리 가능
// => @Service 어노테이션을 스프링 컨테이너가 처리하기 위해 반드시 클래스가 작성된 패키지를
//Spring Bean Configuration File(servlet-context.xml)의 component-scan 엘리먼트로 검색되도록 설정
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	//Service 클래스의 메소드에서 사용될 DAO 클래스의 객체를 저장하기 위한 필드
	// => 생성자를 이용하여 필드에 DAO 클래스의 객체(Spring Bean)가 저장되도록 의존성 주입
	private final StudentDAO studentDAO;
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
