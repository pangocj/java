package xyz.itwill10.exception;

//비정상적으로 페이지를 요청한 경우의 문제를 처리하기 위한 예외 클래스
public class BadRequestException extends Exception {
	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		// TODO Auto-generated constructor stub
	}
	
	public BadRequestException(String message) {
		super(message);
	}
}
