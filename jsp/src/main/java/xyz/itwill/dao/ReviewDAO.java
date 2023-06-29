package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewDAO extends JdbcDAO {
	private static ReviewDAO _dao;
	
	private ReviewDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ReviewDAO();		
	}
	
	public static ReviewDAO getDAO() {
		return _dao;
	}
	
	//게시글 검색 관련 정보를 전달받아 REVIEW 테이블에 저장된 게시글 중 검색 처리된 전체  
	//게시글의 갯수를 검색하여 반환하는 메소드
	public int selectReviewCount(String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			
			//매개변수에 저장된 값을 비교하여 DBMS 서버에 다른 SQL 명령을 전달하여 실행
			// => 동적 SQL(DynamicSQL) 기능 
			if(keyword.equals("")) {//게시글 검색 기능을 사용하지 않은 경우
				//REVIEW 테이블에 저장된 전체 게시글의 갯수 검색
				String sql="select count(*) from review";
				pstmt=con.prepareStatement(sql);
			} else {//게시글 검색 기능을 사용한 경우
				//검색대상(컬럼명)에 검색단어가 포함한 게시글의 갯수 검색 - 삭제글 제외
				String sql="select count(*) from review where "
						+search+" like '%'||?||'%' and status<>0";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectReviewCount() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return count;
	}
}













