package xyz.itwill10.exception;

import lombok.Getter;
import xyz.itwill10.dto.Userinfo;

//회원정보를 등록할 때 사용자로부터 입력받은 회원정보의 아이디가 기존 회원정보의 아이디와
//중복될 경우 발생될 예외를 처리하기 위한 예외 클래스
public class ExistsUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//예외처리에 필요한 값을 저장하기 위한 필드
	// => 사용자부터 입력받은 회원정보를 저장하기 위한 필드
	@Getter
	private Userinfo userinfo;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	//매개변수로 예외 메세지와 예외처리에 필요한 값을 전달받아 필드에 저장 
	public ExistsUserinfoException(String message, Userinfo userinfo) {
		super(message);
		this.userinfo=userinfo;
	}
}
