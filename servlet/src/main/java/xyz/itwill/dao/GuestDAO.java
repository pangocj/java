package xyz.itwill.dao;

//GUEST 테이블에 행을 삽입,변경,삭제,검색하기 위한 기능을 제공하는 클래스
public class GuestDAO extends JdbcDAO {
	private static GuestDAO _dao;
	
	private GuestDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new GuestDAO();
	}
	
	public static GuestDAO getDAO() {
		return _dao;
	}
	
	//방명록 게시글정보를 전달받아 GUEST 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	
	
	//방명록 게시글정보를 전달받아 GUEST 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드

	
	//방명록 게시글번호를 전달받아 GUEST 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 메소드
	
	
	//방명록 게시글번호를 전달받아 GUEST 테이블에 저장된 행을 검색하여 반환하는 메소드

	
	//GUEST 테이블에 저장된 모든 행을 검색하여 반환하는 메소드
	
	
}












