package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

//DBCP(DataBase Connection Pool) : 다수의 Connection 객체를 미리 생성하여 저장하고
//Connection 객체를 반환하는 기능을 제공하는 클래스
// => Connection 객체를 미리 생성하여 사용하므로 JDBC 프로그램의 실행 속도 증가
// => Connection 객체를 생성하기 위한 정보의 변경 용이 - 유지보수의 효율성 증가
// => Connection 객체의 갯수 제한 가능

public class ConnectionPoolApp {
	public static void main(String[] args) throws SQLException {
		//ConnectionPool 클래스는 싱글톤 클래스이므로 new 연산자를 사용하여 객체를 생성하지 
		//않고 메소드를 호출하여 객체를 반환받아 사용
		// => ConnectionPool 객체에는 Connection 객체가 2개 생성되어 저장
		ConnectionPool cp=ConnectionPool.getInstance();
		
		//ConnectionPool.getConnection() : ConnectionPool 객체에 저장된 Connection 객체 중
		//하나를 반환하는 메소드 - 다른 사용자가 사용 불가능하도록 설정
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		//ConnectionPool.freeConnection(Connection con) : Connection 객체를 ConnectionPool 
		//객체에 반환하는 메소드 - 다른 사용자가 사용 가능하므로 설정
		//cp.freeConnection(con1);
		
		Connection con2=cp.getConnection();
		System.out.println("con2 = "+con2);
		//cp.freeConnection(con2);
		
		Connection con3=cp.getConnection();
		System.out.println("con3 = "+con3);
		//cp.freeConnection(con3);
		
		Connection con4=cp.getConnection();
		System.out.println("con4 = "+con4);
		cp.freeConnection(con4);
	}
}
