package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 행정보를 삽입,삭제,변경,검색하는 기능을 제공하는 클래스
// => 저장매체 : 정보를 행단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 - DBMS
// => 인터페이스를 상속받아 작성하는 것을 권장 - 메소드 작성 규칙 제공 : 유지보수의 효율성 증가
// => 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장 - 프로그램에 하나의 객체만 제공되는 클래스

//STUDENT 테이블에 행을 삽입,삭제,변경,검색하는 기능의 메소드를 제공하는 클래스
// => DAO 클래스의 메소드는 SQL 명령에 필요한 값을 매개변수로 전달받아 하나의 SQL 명령을  
//DBMS 서버에 전달하여 실행하고 실행결과를 Java 객체(값)로 매핑하여 반환
// => JdbcDAO 클래스를 상속받아 DAO 클래스의 메소드에서 JdbcDAO 클래스의 메소드 호출 가능
public class StudentDAOImpl extends JdbcDAO implements StudentDAO {
	private static StudentDAOImpl _dao;
	
	private StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAOImpl();
	}
	
	public static StudentDAOImpl getDAO() {
		return _dao;
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	@Override
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into student values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
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
