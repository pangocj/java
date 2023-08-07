package xyz.itwill10.dto;

import lombok.Data;

//회원정보를 저장하기 위한 클래스 - VO 클래스 : 값을 저장할 목적의 객체를 생성하기 위한 클래스
// => DAO 클래스의 메소드에서 사용될 경우 DTO 클래스의 기능 제공
// => 페이지 요청시 전달된 값을 저장하기 위해 전달값의 이름과 같은 이름으로 필드 작성
@Data
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
}
