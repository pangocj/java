package xyz.itwill.exception;

//인증 처리시 인증 실패된 경우 발생되는 예외를 표현하기 위한 클래스
public class AuthFailException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthFailException(String message) {
		super(message);
	}
}