package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램 작성
public class SelectStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하는 메소드
			// => SELECT 명령의 실행 결과(검색행)를 ResultSet 객체에 저장하여 반환 
			//ResultSet 객체 : 검색결과를 2차원 배열(행과 열 - 테이블)의 형태로 저장하여 제공하는 객체
			rs=stmt.executeQuery(sql);
			
			//ResultSet 객체에 저장된 모든 검색행을 행단위로 처리하기 위해 ResultSet 객체는
			//내부적인 커서(Cursor) 제공
			// => ResultSet 커서는 최초 ResultSet 객체의 BOF(Before Of File) 영역에 위치
			//ResultSet.next() : ResultSet 커서를 다음행으로 이동하는 메소드
			// => false 반환 : ResultSet 커서 위치에 처리행이 없는 경우의 반환값 
			//    - ResultSet 커서가 EOF(End Of File) 영역에 위치
			// => true 반환 : ResultSet 커서 위치에 처리행이 있는 경우의 반환값
			if(rs.next()) {//ResultSet 커서 위치에 처리행이 있는 경우
				//System.out.println("[메세지]검색된 학생정보가 있습니다.");
				
				//검색된 다수의 학생정보가 저장된 ResultSet 객체의 처리하기 위한 반복문
				// => ResultSet 객체에 저장된 검색행의 갯수가 불확실하므로 while 구문 사용
				// => if 구문에서 ResultSet 커서를 다음행으로 이미 이동하여 do~while 구문 사용
				do {
					//ResultSet 커서가 위치한 처리행의 컬럼값을 하나씩 반환받아 저장
					//ResultSet.getXXX(int columnIndex) 또는 ResultSet.getXXX(String columnLabel)
					// => ResultSet 커서가 위치한 처리행의 컬럼값을 반환하는 메소드
					// => XXX는 컬럼값을 반환받기 위한 Java 자료형을 표현
					// => columnIndex : 검색행에서 검색대상을 순서대로 1부터 1씩 증가되는 정수값으로 표현 
					// => columnLabel : 검색행에서 검색대상의 이름을 문자열로 표현
					//int no=rs.getInt(1);
					int no=rs.getInt("no");
					String name=rs.getString("name");					
					String phone=rs.getString("phone");					
					String address=rs.getString("address");		
					//Date birthday=rs.getDate("birthday");
					//처리행의 컬럼값은 오라클 자료형에 상관없이 getString() 메소드를 호출하여
					//문자열(String 객체)로 반환 가능
					String birthday=rs.getString("birthday");
					
					System.out.println("학번 = "+no);
					System.out.println("이름 = "+name);
					System.out.println("전화번호 = "+phone);
					System.out.println("주소 = "+address);
					//오라클의 날짜값을 문자열로 반환받으면 [yyyy-MM-dd HH:mm:ss] 형식으로 반환
					// => 날짜만 출력되도록 문자열을 분리하여 출력
					System.out.println("생년월일 = "+birthday.substring(0, 10));
					System.out.println("==================================================");
				} while(rs.next());//ResultSet 커서를 다음행으로 이동 - 처리행이 있는 경우 반복문 실행, 처리행의 없는 경우 반복문 종료
			} else {//ResultSet 커서 위치에 처리행이 없는 경우
				System.out.println("[메세지]검색된 학생정보가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
	}
}
