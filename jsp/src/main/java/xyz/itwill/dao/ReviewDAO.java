package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.ReviewDTO;

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
				String sql="select count(*) from review join member on review.id=member.id where "
						+search+" like '%'||?||'%' and status <> 0";
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
	
	//페이징 처리 관련 정보와 게시글 검색 기능 관련 정보를 전달하여 REVIEW 테이블에 저장된 
	//게시글 목록을 검색하여 List 객체로 반환하는 메소드
	public List<ReviewDTO> selectReviewList(int startRow, int endRow, String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ReviewDTO> reviewList=new ArrayList<>();
		try {
			con=getConnection();
			
			if(keyword.equals("")) {//게시글 검색 기능을 사용하지 않은 경우
				String sql="select * from (select rownum rn, temp.* from (select num, member.id"
					+ ", name, subject, content, regdate, readcount, ref, restep, relevel"
					+ ", ip, status from review join member on review.id=member.id "
					+ "order by ref desc, restep) temp) where rn between ? and ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			} else {//게시글 검색 기능을 사용한 경우
				String sql="select * from (select rownum rn, temp.* from (select num, member.id"
					+ ", name, subject, content, regdate, readcount, ref, restep, relevel"
					+ ", ip, status from review join member on review.id=member.id"
					+ " where "+search+" like '%'||?||'%' and status <> 0"
					+ " order by ref desc, restep) temp) where rn between ? and ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewDTO review=new ReviewDTO();
				review.setNum(rs.getInt("num"));
				review.setId(rs.getString("id"));
				review.setName(rs.getString("name"));
				review.setSubject(rs.getString("subject"));
				review.setContent(rs.getString("content"));
				review.setRegdate(rs.getString("regdate"));
				review.setReadcount(rs.getInt("readcount"));
				review.setRef(rs.getInt("ref"));
				review.setRestep(rs.getInt("restep"));
				review.setRelevel(rs.getInt("relevel"));
				review.setIp(rs.getString("ip"));
				review.setStatus(rs.getInt("status"));
				reviewList.add(review);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectReviewList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return reviewList;
	}
	
	//REVIEW_SEQ 시퀸스의 다음값을 검색하여 반환하는 메소드
	public int selectNextNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int nextNum=0;
		try {
			con=getConnection();
			
			String sql="select review_seq.nextval from dual";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				nextNum=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNextNum() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return nextNum;
	}
	
	//게시글정보를 전달받아 REVIEW 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertReview(ReviewDTO review) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into review values(?,?,?,?,sysdate,0,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, review.getNum());
			pstmt.setString(2, review.getId());
			pstmt.setString(3, review.getSubject());
			pstmt.setString(4, review.getContent());
			pstmt.setInt(5, review.getRef());
			pstmt.setInt(6, review.getRestep());
			pstmt.setInt(7, review.getRelevel());
			pstmt.setString(8, review.getIp());
			pstmt.setInt(9, review.getStatus());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertReview() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
}
