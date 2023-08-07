package xyz.itwill10.dao;

//SpringMVC 기능으로 웹프로그램 작성시 Mybatis 프레임워크를 이용하여 DAO 클래스를 작성하는 방법
//1.DataSource 관련 라이브러리와 Mybatis 관련 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
// => ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spring
//2.Mybatis 프레임워크의 환경설정파일(mybatis-config.xml - settings 엘리먼트) 작성
// => [src/main/webapp] 폴더에 작성해야만 스프링 컨테이너(WebApplicationContext 객체)가
//Mybatis 프레임워크의 환경설정파일을 읽어서 SqlSessionFactory 클래스를 Spring Bean으로 등록 처리
// => [src/main/java] 또는 [src/main/resources] 폴더에 Mybatis 프레임워크의 환경설정파일 작성 가능
//3.DataSource 관련 클래스, SqlSessionFactory 관련 클래스, SqlSession 관련 클래스를 Spring Bean으로 등록
// => SpringMVC 프로그램에서 스프링 컨테이너를 초기화 처리하기 위한 Spring Bean Configuration
//File에서 bean 엘리먼트로 클래스를 Spring Bean 등록 - root-context.xml 또는 servlet-context.xml

public class StudentDAOImpl {

}
