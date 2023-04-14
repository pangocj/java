package xyz.itwill.exception;

//프로그램 개발자가 직접 선언한 예외클래스
// => 예외클래스는 반드시 Exception 클래스를 상속받아 작성
public class PasswordMismatchException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PasswordMismatchException() {
		// TODO Auto-generated constructor stub
	}
	
	public PasswordMismatchException(String message) {
		//Exception 클래스에서 예외 메세지를 저장하기 위한 필드
		// => super 키워드로 Exception 클래스의 매개변수가 있는 생성자를 호출하여 예외
		//메세지를 Exception 클래스의 필드에 저장
		super(message);//부모클래스(Exception)의 생성자 호출
	}
}
