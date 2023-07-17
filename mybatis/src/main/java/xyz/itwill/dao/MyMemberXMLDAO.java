package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.MyMember;

public class MyMemberXMLDAO {
	private static MyMemberXMLDAO _dao;
	
	private MyMemberXMLDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberXMLDAO();
	}
	
	public static MyMemberXMLDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 객체를 생성하여 반환하는 메소드
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블의 회원정보로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertMember(MyMember member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.insert(String elementId[, Object parameterValue]) : 매퍼에 등록된 
			//insert 엘리먼트의 SQL 명령(INSERT)을 제공받아 DBMS 서버에 전달하여 실행하고 
			//삽입행의 갯수를 제공받아 반환하는 메소드
			// => elementId : SQL 명령이 등록된 매퍼와 엘리먼트의 식별자를 문자열로 표현하여 전달
			// => parameterValue : SQL 명령 작성에 필요한 값(객체)를 전달 - parameterType 속성값으로 사용
			// => SQL 명령 작성에 필요한 값(객체)이 없는 경우 parameterValue 매개변수에 값 미전달
			int rows=sqlSession.insert("MyMemberXMLMapper.insertMember", member);
			
			//mybatis 프레임워크는 기본적으로 AutoCommit 기능을 비활성화 처리하고 SQL 명령을
			//DBMS 서버에 전달하여 실행
			// => DML 명령을 DBMS 서버에 전달하여 실행한 경우 반드시 커밋 또는 롤백 처리
			if(rows > 0) {
				//SqlSession.commit() : 트렌젝션 적용 명령(COMMIT)을 DBMS 서버에 전달하여 실행 - 커밋 처리
				sqlSession.commit();
			} else {
				//SqlSession.rollback() : 트렌젝션 취소 명령(ROLLBACK)을 DBMS 서버에 전달하여 실행 - 롤백 처리
				sqlSession.rollback();	
			}
			
			return rows;
		} finally {
			sqlSession.close();
		}
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateMember(MyMember member) {
		//SqlSessionFactory.openSession(boolean autoCommit) : SqlSession 객체를 생성하여 반환하는 메소드
		// => false : AutoCommit 기능 비활성화(기본), true : AutoCommit 기능 활성화
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.update(String elementId[, Object parameterValue]) : 매퍼에 등록된 
			//update 엘리먼트의 SQL 명령(UPDATE)을 제공받아 DBMS 서버에 전달하여 실행하고 
			//변경행의 갯수를 제공받아 반환하는 메소드
			return sqlSession.update("MyMemberXMLMapper.updateMember", member);
		} finally {
			sqlSession.close();
		}
	}
	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.delete(String elementId[, Object parameterValue]) : 매퍼에 등록된 
			//delete 엘리먼트의 SQL 명령(DELETE)을 제공받아 DBMS 서버에 전달하여 실행하고 
			//삭제행의 갯수를 제공받아 반환하는 메소드
			return sqlSession.delete("MyMemberXMLMapper.deleteMember", id);
		} finally {
			sqlSession.close();
		}
	}

	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 메소드
	public MyMember selectMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectOne(String elementId[, Object parameterValue]) : 매퍼에 등록된 
			//select 엘리먼트의 SQL 명령(SELECT)을 제공받아 DBMS 서버에 전달하여 실행하고 
			//검색결과가 저장된 객체(값)를 제공받아 반환하는 메소드
			// => 하나의 행만 검색하는 SELECT 명령을 DBMS 서버에 전달하여 실행할 경우 호출하는 메소드 
			return sqlSession.selectOne("MyMemberXMLMapper.selectMember", id);
		} finally {
			sqlSession.close();
		}
	}

	//MYMEMBER 테이블에 저장된 모든 회원정보를 검색하여 List 객체로 반환하는 메소드
	public List<MyMember> selectMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectOne(String elementId[, Object parameterValue]) : 매퍼에 등록된 
			//select 엘리먼트의 SQL 명령(SELECT)을 제공받아 DBMS 서버에 전달하여 실행하고 
			//검색결과가 저장된 List 객체를 제공받아 반환하는 메소드
			// => 여러개의 행을 검색하는 SELECT 명령을 DBMS 서버에 전달하여 실행할 경우 호출하는 메소드 
			return sqlSession.selectList("MyMemberXMLMapper.selectMemberList");
		} finally {
			sqlSession.close();
		}
	}
}
