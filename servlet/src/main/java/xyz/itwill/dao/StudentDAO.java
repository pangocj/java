package xyz.itwill.dao;

//DAO(Data Access Object) 클래스 : 테이블에 행 삽입,삭제,변경,검색하는 SQL 명령을 전달하여
//실행하고 실행결과를 Java 객체(값)로 매핑하여 반환하는 기능을 제공하는 클래스
// => 싱글톤 클래스(프로그램에 객체를 하나만 생성하여 제공하는 클래스)로 작성하는 것을 권장

//STUDENT 테이블에 학생정보를 삽입,삭제,변경,검색하는 기능을 제공하는 클래스
public class StudentDAO extends JdbcDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}

	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	
}












