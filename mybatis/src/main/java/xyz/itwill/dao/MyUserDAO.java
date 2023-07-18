package xyz.itwill.dao;

public class MyUserDAO extends AbstractSession {
	private static MyUserDAO _dao;

	private MyUserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyUserDAO();
	}
	
	public static MyUserDAO getDAO() {
		return _dao;
	}
	
	
}
