package xyz.itwill.bean;

//JavaBean : 클래스로 생성된 모든 Java 객체
// => 웹프로그램에서는 명령 실행에 필요한 값을 저장하기 위한 클래스로 생성된 객체

//회원정보를 저장하기 위한 클래스 - JavaBean 클래스 >> VO 클래스, DTO 클래스
public class Hewon {	
	private String name;
	private String phone;
	private String address;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	public Hewon(String name, String phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
