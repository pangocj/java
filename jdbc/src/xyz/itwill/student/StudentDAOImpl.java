package xyz.itwill.student;

import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 행정보를 삽입,삭제,변경,검색하는 기능을 제공하는 클래스
// => 저장매체 : 정보를 행단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 - DBMS
// => 인터페이스를 상속받아 작성하는 것을 권장 - 메소드 작성 규칙 제공 : 유지보수의 효율성 증가

//STUDENT 테이블에 행을 삽입,삭제,변경,검색하는 기능의 메소드를 제공하는 클래스
// => DAO 클래스의 메소드는 SQL 명령에 필요한 값을 매개변수로 전달받아 하나의 SQL 명령을  
//DBMS 서버에 전달하여 실행하고 실행결과를 Java 객체(값)로 매핑하여 반환
public class StudentDAOImpl implements StudentDAO {
	
	@Override
	public int insertStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StudentDTO selectStudent(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> selectNameStudentList(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> selectAllStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

}
