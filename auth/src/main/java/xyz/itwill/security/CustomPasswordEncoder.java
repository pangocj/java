package xyz.itwill.security;

import org.springframework.security.crypto.password.PasswordEncoder;

//비밀번호를 전달받아 암호화 처리하여 반환하거나 암호화 처리된 비밀번호를 비교한 결과를 반환
//하는 메소드를 제공하는 클래스
// => PasswordEncoder 인터페이스를 상속받아 작성
public class CustomPasswordEncoder implements PasswordEncoder {
	//매개변수로 전달받은 문자열을 암호화 처리하여 반환하는 메소드
	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	//매개변수로 전달받은 암호화된 문자열과 일반 문자열을 비교하여 결과를 논리값으로 반환하는 메소드
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

}
