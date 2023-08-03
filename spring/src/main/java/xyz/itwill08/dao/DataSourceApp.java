package xyz.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//DataSource 객체 : 다수의 Connection 객체를 미리 생성하여 저장하고 있는 객체 - DBCP(DataBase Connection Pool)
// => Spring Bean Configuration File에서 DataSource 인터페이스를 상속받은 자식클래스를 Spring
//Bean으로 등록하여 스프링 컨테이너에게 제공받아 사용
// => DataSource 인터페이스를 상속받은 자식클래스는 Spring 프레임워크에서 제공하는 spring-jdbc
//라이브러리를 빌드 처리 - 메이븐 사용 : pom.xml
// => DataSource 관련 라이브러리외에 Oracle Driver 관련 라이브러리(ojdbc 라이브러리)도 프로젝트 빌드 처리

//스프링 컨테이너에게 DataSource 객체를 제공받아 Connection 객체를 반환받아 사용
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		DataSource dataSource=context.getBean("dataSource", DataSource.class);
		System.out.println("==========================================================");
		System.out.println("dataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		System.out.println("connection = "+connection);
		connection.close();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	
	}
}





