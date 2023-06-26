package xyz.itwill.dao;

//STUDENT 테이블의 행(학생정보)에 대한 삽입,변경,삭제,검색 기능을 제공하는 클래스
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
	
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드

	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드

	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 DTO 객체로 반환하는 메소드

	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 메소드
	
}












