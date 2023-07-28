package xyz.itwill05.di;

import java.util.List;

//Service 클래스 : 프로그램 실행에 필요한 데이타 처리 기능을 제공하는 클래스 - 컴퍼넌트
// => Service 클래스의 메소드는 다수의 DAO 객체로 메소드를 호출하여 작성 - DAO 모듈화
// => Service 클래스의 메소드에서 DAO 객체를 사용하기 위해 DAO 클래스와 포함관계(의존관계)로 설정되도록 작성
// => Service 클래스가 변경돼도 Service 클래스를 사용하는 클래스(컨트롤러 - 모델)에 영향을 
//최소화 하기 위한 반드시 인터페이스를 상속받아 작성 - 결합도를 낮춰 유지보수의 효율성 증가
public class StudentServiceImpl implements StudentService {
	//StudentJdbcDAO 클래스로 필드 선언 - StudentJdbcDAO 객체만 저장 가능한 필드
	// => 필드에 StudentJdbcDAO 객체를 저장해야만 포함관계(의존관계)가 완성
	// => StudentServiceImpl 클래스의 메소드에서 필드에 저장된 StudentJdbcDAO 객체로 메소드 호출 가능
	//문제점)DAO 클래스가 변경될 경우 Service 클래스의 필드 및 메소드 변경 가능
	// => 결합도가 높아 유지보수의 효율성 감소
	//private StudentJdbcDAO studentJdbcDAO;

	//StudentDAO 인터페이스로 필드 선언 - StudentDAO 인터페이스를 상속받은 자식클래스로 생성된 모든 객체 저장
	// => 필드에 StudentDAO 인터페이스를 상속받은 DAO 클래스의 객체를 저장해야만 포함관계(의존관계)가 완성
	// => StudentServiceImpl 클래스의 메소드에서 인터페이스로 생성된 필드의 추상메소드를 호출하면
	//필드에 저장된 자식클래스 객체의 메소드 호출 - 오버라이딩에 의한 다형성
	// => DAO 클래스가 변경돼도 Service 클래스의 영향 최소화 - 결합도를 낮춰 유지보수의 효율성 증가
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl 클래스의 setStudentDAO(StudentDAO studentDAO) 메소드 호출 ***");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 modifyStudent(Student student) 메소드 호출 ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 removeStudent(int num) 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}
}
