package xyz.itwill.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

//Spring 프레임워크를 사용하여 모듈(단위 프로그램 - 컴퍼넌트)을 검사하는 테스트 프로그램 작성 방법
// => SpringMVC 프로그램에서 사용하는 모듈 : DAO 클래스, Service 클래스, Controller 클래스 등
//1.junit 라이브러리와 spring-test 라이브러리를 프로젝트 빌드 처리 - 메이븐 : pom.xml
//2.테스트 프로그램에서 사용될 로그 구현체에 대한 환경설정파일 변경
// => [src/test/resources] 폴더의 [log4j.xml] 파일의 내용 변경
//3.[src/test/java] 폴더에 테스트 프로그램 관련 클래스 작성
// => junit 라이브러리와 spring-test 라이브러리의 scope 속성을 주석 처리한 후 테스트 프로그램
//관련 클래스 작성 - 테스트 프로그램 관련 클래스 작성 후 주석 제거
//4.JUint 프로그램으로 테스트 프로그램을 실행하여 모듈 검사

//@RunWith : 테스트 프로그램을 실행하기 위한 실행 클래스를 설정하는 어노테이션
// => 테스트 프로그램 관련 클래스를 객체로 생성하여 메소드를 호출하기 위한 클래스 지정
//value 속성 : 테스트 프로그램을 실행하기 위한 클래스(Class 객체)를 속성값으로 설정
// => 다른 속성이 없는 경우 속성값만 설정 가능
//SpringJUnit4ClassRunner 클래스를 사용하여 테스트 프로그램을 실행할 경우 자동으로 스프링
//컨테이너(ApplicationContext 객체)를 생성하여 제공
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : 테스트 프로그램에서 사용될 Spring Bean를 제공하기 위한 Spring Bean 
//Configuration File을 설정하기 위한 어노테이션
//locations 속성 : Spring Bean Configuration File의 경로를 요소로 저장한 배열을 속성값으로 설정
// => Spring Bean Configuration File의 경로는 file 접두사를 사용하여 파일 시스템 형식으로 표현하여 제공
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class DataSourceTest {
	//테스트 클래스의 메소드에서 사용할 객체를 저장하기 위한 필드 선언
	// => 필드에 @Autowired 어노테이션을 사용하여 의존성 주입 - 생성자를 이용한 의존성 주입 불가능 
	@Autowired
	private DataSource dataSource;
	
	//@Test : 테스트 메소드를 설정하는 어노테이션 - 테스트 명령을 작성하여 실행
	// => SpringJUnit4ClassRunner 클래스에 의해 테스트 프로그램 관련 클래스가 객체로 생성된 후 자동 호출 메소드
	@Test
	public void testDataSource() throws SQLException {
		log.info("DataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		log.info("Connection = "+connection);
		connection.close();
	}
}
