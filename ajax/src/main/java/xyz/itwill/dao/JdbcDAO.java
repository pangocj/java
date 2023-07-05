package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//JDBC 기능을 제공하는 DAO 클래스가 상속받아 사용하기 위해 작성된 부모클래스 - 추상클래스
// => WAS 프로그램에 의해 관리되는 DataSource 객체를 제공받아 필드에 저장 - 정적영역에 작성하여 한번만 실행
// => DataSource 객체로부터 Connection 객체를 제공받아 반환하는 메소드
// => 매개변수로 전달받은 JDBC 관련 객체를 제거하는 메소드
public abstract class JdbcDAO {//상속만을 목적으로 작성된 클래스
	private static DataSource dataSource;
	
	static {
		try {
			dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	}
		
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
