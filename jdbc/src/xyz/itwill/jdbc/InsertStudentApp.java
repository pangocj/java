package xyz.itwill.jdbc;

import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

//JDBC(Java DataBase Connectivity) : Java를 사용하여 DBMS 서버에 접속해 SQL 명령을 전달하여
//실행하기 위한 기능을 제공하는 Java API(클래스 또는 인터페이스)

//java.sql : JDBC 기능의 프로그램을 작성하기 위한 클래스 및 인터페이스가 선언된 패키지
// => java.sql 패키지에서는  JDBC 기능 구현을 위해 인터페이스 제공 - DBMS 종류가 다양하므로
//클래스로 제공 불가능
// => DBMS 프로그램을 관리하는 그룹에서 JDBC 기능을 구현하기 위한 클래스(JDBC Driver)를 배포하여 제공
// => JDBC Driver가 포함된 라이브러리 파일(Jar 파일)를 다운로드 받아 프로젝트 빌드 처리해야만
//라이브러리의 클래스를 사용하여 JDBC 프로그램 작성 가능

//Oracle DBMS를 이용한 JDBC 프로그램을 작성하기 위한 환경설정
//1.https://www.oracle.com 사이트에서 Oracle JDBC Driver 관련 라이브러리 파일을 다운로드
// => Oracle JDBC Driver : ojdbc11.jar - JDK 버전 참고
//2.Oracle JDBC Driver 관련 라이브러리 파일(ojdbc11.jar)을 프로젝트 폴더에 붙여넣기
//3.프로젝트 폴더에 저장된 라이브러리 파일을 프로젝트에서 사용할 수 있도록 연결 - 빌드(Build)
// => 라이브러리 파일(Jar)의 클래스 및 인터페이스를 프로젝트에서 사용 가능하도록 설정
// => 프로젝트 >> 마우스 오른쪽 버튼 >> Properties >> Java Build Path >> Libraries >>
//    classpath >> Add Jars >> 프로젝트의 내부의 Jar(ojdbc11.jar) 선택 >> Apply And Close   

//STUDENT 테이블 생성 : 학번(숫자형-PRIMARY KEY),이름(문자형),전화번호(문자형),주소(문자형),생년월일(날짜형)
//CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY,NAME VARCHAR2(50),PHONE VARCHAR2(20)
//	,ADDRESS VARCHAR2(100),BIRTHDAY DATE);

//STUDENT 테이블에 학생정보를 삽입하는 JDBC 프로그램 작성
public class InsertStudentApp {
	public static void main(String[] args) {
		//1.OracleDriver 클래스로 객체를 생성하여 DriverManager 클래스의 JDBC Driver 객체로 등록
		//JDBC Driver 객체 : DriverManager 클래스에 등록되어 관리되는 Driver 객체
		//Driver 객체 : DBMS 서버에 접속하여 SQL 명령을 전달하는 기능을 제공하는 객체
		//DriverManager 클래스 : Driver 객체를 관리하기 위한 기능을 제공하는 클래스
		//DriverManager.registerDriver(Driver driver) : Driver 객체를 매개변수로 전달받아
		//DriverManager 클래스가 관리할 수 있는 JDBC Driver 객체로 등록하는 메소드
		DriverManager.registerDriver(new OracleDriver());
	}
}













