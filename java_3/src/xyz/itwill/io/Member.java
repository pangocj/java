package xyz.itwill.io;

import java.io.Serializable;

//객체 직렬화(Object Serialization) : 객체를 byte(원시데이타) 배열로 변환하여 입력 또는 출력
//처리되기 위한 기능을 제공

//클래스를 객체 직렬화 처리하는 방법 - 객체 직렬화 클래스
//1.Serializable 인터페이스를 상속받아 클래스 작성
// => Serializable 인터페이스에 추상메소드가 없으므로 오버라이드 선언 불필요
// => 객체의 모든 필드값을 byte 배열로 변환하여 입력 또는 출력 처리
//2.Externalizable 인터페이스를 상속받아 클래스 작성
// => Externalizable 인터페이스의 readExternal(ObjectInput in)와 writeExternal(ObjectOutput out)
//추상메소드를 반드시 오버라이드 선언
// => 오버라이드 선언된 메소드에서 원하는 필드값만을 byte 배열로 변환하여 입력 또는 출력 처리

//회원정보(아이디, 이름, 전화번호)를 저장하기 위한 클래스 - VO 클래스
// => 객체 단위로 입력 또는 출력 처리하기 위한 클래스는 반드시 객체 직렬화 클래스로 선언
public class Member implements Serializable {
	//객체 직렬화 클래스는 클래스를 구분하기 위한 고유값이 저장된 serialVersionUID 필드를 
	//선언하는 것을 권장 - 필드의 자료형은 long으로 설정하고 static과 final 제한자 사용
	// => 이클립스에서는 고유값이 저장된 serialVersionUID 필드를 자동 생성하는 기능 제공
	private static final long serialVersionUID = -3306639107947980039L;
	
	private String id;
	private String name;
	private String phone;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "아이디 = "+id+", 이름 = "+name+", 전화번호 = "+phone;
	}
}
