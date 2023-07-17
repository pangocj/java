package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.Student;

public class StudentDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 객체를 생성하여 반환하는 메소드
	// => SqlSessionFactory 객체 : SqlSession 객체를 생성하여 제공하기 위한 객체
	// => SqlSessionFactory 객체를 생성하기 위해 mybatis 환경설정파일(mybatis-config.xml) 필요
	private SqlSessionFactory getSqlSessionFactory() {
		//mybatis 환경설정파일을 패키지에 작성한 경우 파일 시스템 경로로 표현
		//String resource="xyz/itwill/config/mybatis-config.xml";
		String resource="mybatis-config.xml";
		
		InputStream inputStream=null;
		try {
			//mybatis 환경설정파일을 읽기 위한 입력스트림을 반환받아 저장
			//Resources.getResourceAsStream(String resource) : 매개변수에 mybatis 환경설정파일
			//경로를 전달받아 파일 입력스트림을 생성하여 반환하는 메소드
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {//mybatis 환경설정파일이 없는 경우 예외 발생
			throw new IllegalArgumentException(e);
		}
		
		//SqlSessionFactoryBuilder.build(InputStream inputStream) : 매개변수로 mybatis 환경
		//설정파일의 입력스트림을 전달받아 SqlSessionFactory 객체를 생성하여 반환하는 메소드
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 메소드
	// => SqlSession 객체의 메소드를 호출하여 매퍼에 등록된 정보를 이용하여 SQL 명령을 전달하여
	//실행하고 결과를 Java 객체로 반환받아 사용
	public List<Student> selectStudentList() {
		
	}
}












