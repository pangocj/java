package xyz.itwill.exception;

//회원정보가 없는 경우 발생되는 예외를 표현하기 위한 클래스
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}
}
