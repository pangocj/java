package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service : Service 클래스를 스프링 컨테이너가 관리할 수 있는 Spring Bean으로 등록하기 위한 어노테이션
// => 클래스의 이름을 beanName으로 자동 설정하지만 value 속성을 사용하여 beanName 변경 가능
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	//@Autowired : 스프링 컨테이너로부터 Spring Bean를 제공받아 필드에 저장하여 의존관계를 
	//자동으로 구현하기 위한 어노테이션 - DI 구현을 위한 어노테이션
	// => 필드에 @Autowired 어노테이션을 사용하여 의존성 주입 - 필드 레벨의 의존성 주입
	// => 필드가 여러개 선언된 경우 필드마다 @Autowired 어노테이션을 사용하여 의존성 주입
	// => bean 엘리먼트의 autowire 속성값을 [byType]으로 설정한 것과 같은 방법으로 의존성 주입 - Setter Injection
	// => Setter 메소드를 이용하여 의존관계를 구현하지만 Setter 메소드를 선언하지 않하도 의존성 주입 가능
	//문제점)필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상인 경우 의존성 주입 실패 - NoUniqueBeanDefinitionException 발생
	//해결법-1)필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상인 경우 필드에 저장될 Spring
	//Bean의 식별자(beanName)을 필드명과 동일하게 변경
	// => @Autowird 어노테이션은 필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상인 경우
	//autowire 속성값을 [byName]으로 설정한 것과 동일한 방법으로 의존성 주입
	//해결법-2)필드의 자료형과 같은 자료형의 Spring Bean이 2개 이상인 경우 필드에 저장될 Spring
	//Bean의 클래스에 @Primary 어노테이션을 사용하여 의존성 주입
	//해결법-3)@Autowired 어노테이션에 종속된 @Qualifier 어노테이션을 사용하여 의존성 주입
	//@Qualifier : 필드에 저장된 Spring Bean을 직접 지정하여 의존성 주입
	// => value 속성에 의존성 주입을 위한 Spring Bean 식별자(beanName)를 속성값으로 설정
	// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능 
	@Autowired
	//@Qualifier(value = "annotationStudentJdbcDAO")
	@Qualifier("annotationStudentMybatisDAO")
	private StudentDAO studentDAO;
	
	//@Autowired 어노테이션 대신 @Resource 어노테이션 또는 @Inject 어노테이션을 사용하여 의존성 주입 가능
	// => @Autowired 어노테이션은 Spring 프레임워크의 라이브러리에서 제공하는 어노테이션이지만 
	//@Resource 어노테이션 또는 @Inject 어노테이션은 Java 라이브러리에서 제공하는 어노테이션
	// => @Resource 어노테이션 또는 @Inject 어노테이션은 다른 프레임워크에서도 사용 가능
	//@Resource 어노테이션 : bean 엘리먼트의 autowire 속성값을 [byName]으로 설정한 것과 동일한 방법으로 의존성 주입
	//@Inject 어노테이션 : bean 엘리먼트의 autowire 속성값을 [byType]으로 설정한 것과 동일한 방법으로 의존성 주입
	// => 동일한 자료형의 Spring Bean이 여러개 있는 경우 @Named 어노테이션을 사용하여 의존성 주입
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 modifyStudent(Student student) 메소드 호출 ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 removeStudent(int num) 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}
}
