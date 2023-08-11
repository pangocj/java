package xyz.itwill10.exception;

//회원정보에 대한 변경, 삭제, 검색할 때 사용자로부터 전달받은 아이디의 회원정보가 없는 경우의 
//문제를 처리하기 위한 예외 클래스 
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}
}
