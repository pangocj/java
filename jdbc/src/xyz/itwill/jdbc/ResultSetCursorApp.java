package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetCursorApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			//ResultSet.getRow() : ResultSet 커서가 위치한 처리행의 행번호(RowIndex)를 반환하는 메소드 
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
	}
}








