package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.StudentDTO;

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
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 메소드
	public List<StudentDTO> selectStudentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<>();
		try {
			con=getConnection();
			
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				//ResultSet 커서 위치의 행을 DTO 객체로 표현
				// => ResultSet 커서 위치의 행에 대한 컬럼값은 DTO 객체의 필드에 매핑하여 저장
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				
				//List 객체에 DTO 객체를 요소로 추가
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudentList 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
}
