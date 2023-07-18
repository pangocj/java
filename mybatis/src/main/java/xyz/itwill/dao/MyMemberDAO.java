package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.MyMember;
import xyz.itwill.mapper.MyMemberMapper;

public class MyMemberDAO {
	private static MyMemberDAO _dao;
	
	private MyMemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberDAO();
	}
	
	public static MyMemberDAO getDAO() {
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
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberMapper.class).insertMember(member);
		} finally {
			sqlSession.close();
		}
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateMember(MyMember member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberMapper.class).updateMember(member);
		} finally {
			sqlSession.close();
		}
	}
	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberMapper.class).deleteMember(id);
		} finally {
			sqlSession.close();
		}
	}

	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 메소드
	public MyMember selectMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberMapper.class).selectMember(id);
		} finally {
			sqlSession.close();
		}
	}

	//MYMEMBER 테이블에 저장된 모든 회원정보를 검색하여 List 객체로 반환하는 메소드
	public List<MyMember> selectMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberMapper.class).selectMemberList();
		} finally {
			sqlSession.close();
		}
	}
}
