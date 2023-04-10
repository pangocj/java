package oop;

//this 키워드 : 메소드 내부에 숨겨져 있는 키워드로 메소드를 호출한 객체의 메모리 주소
//(HashCode)를 자동으로 전달받아 저장하는 키워드
// => 메소드 내부의 명령에서 객체의 필드 또는 메소드를 사용하기 위한 this 키워드 사용
// => 메소드 내부에서 객체를 대신 표현하기 위한 사용하는 키워드 
// => this 키워드를 사용하지 않아도 자동으로 객체의 필드 또는 메소드에 접근하여 사용

//메소드에 this 키워드가 존재해야되는 이유
// => 필드는 객체마다 메모리(HeapArea)에 독립적으로 생성되지만 메소드는 객체와 상관없이
//메모리(MethodArea)에 하나만 생성 - 프로토타입 클래스(Prototype Class)
// => 메소드에서 필드를 사용할 때 this 키워드로 객체를 명확히 구분하여 필드 접근하도록 사용

//this 키워드를 사용하는 경우
//1.메소드에서 매개변수의 이름을 필드의 이름과 동일하게 작성한 경우 필드를 표현하기 위해
//this 키워드 사용 - 생성자 및 Setter 메소드
//2.생성자에서 다른 생성자를 호출하여 초기화 작업을 하기 위해 this 키워드 사용
//3.이벤트 처리 프로그램 또는 다중 스레드 프로그램의 메소드에서 객체 자체를 표현하기 위해
//this 키워드 사용

//회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
// => VO(Value Object) 클래스 : 특정 대상의 값을 저장할 목적의 객체를 생성하기 위한 클래스
public class Member {
	//필드 선언 : 객체를 생성하면 객체의 필드에는 기본값(숫자형 : 0, 논리형 : false, 
	//참조형 : null)이 초기값으로 자동 저장
	// => 객체 생성시 객체 필드에 초기값으로 자동 저장될 기본값 변경 가능 
	private String id="NoId";
	private String name="NoName";
	private String email="NoEmail";
	
	//생성자 선언 : 객체를 생성하기 위한 특별한 형태의 메소드
	// => 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자 제공
	// => 생성자를 선언하면 매개변수가 없는 기본 생성자 미제공
	// => 객체 필드에 원하는 초기값이 저장된 객체를 생성하기 위해 생성자를 선언 
	//형식) 접근제한자 클래스명(자료형 변수명, 자료형 변수명, ... ) { 명령; 명령; ... }
	// => 반환형을 작성하지 않고 생성자의 이름은 반드시 클래스 이름과 동일하게 작성
	// => 메소드 오버로드를 사용하여 생성자를 여러개 선언 가능
	// => 일반적으로 생성자에서는 필드에 필요한 초기값을 저장하기 위한 명령 작성 - 초기화 작업
	
	//매개변수가 없는 생성자 선언 - 기본 생성자(Default Constructor)
	// => 초기화 작업 미구현 - 객체 필드에 기본값이 초기값으로 저장
	// => 기본 생성자를 선언하지 않으면 상속시 문제가 발생할 수 있으므로 기본 생성자를 선언하는 것을 권장
	//이클립스를 사용하여 기본 생성자 선언 가능
	// => [Ctrl]+[Space] >> 나열된 목록 중 Constructor 선택
	public Member() {
		//this(값, 값, ...) : 생성자에서 this 키워드로 다른 생성자를 호출하는 명령
		// => this 키워드로 생성자를 호출하는 명령은 첫번째 명령으로 작성 
		// => 생성자를 호출하는 명령 전에 다른 명령이 먼저 실행될 경우 에러 발생
		//this("NoId", "NoName", "NoEmail");
	}
	
	//매개변수가 있는 생성자
	// => 매개변수에 전달되어 저장된 값을 필드의 초기값으로 저장
	//이클립스를 사용하여 매개변수가 있는 생성자 선언 가능
	// => [Alt]+[Shift]+[S] >> 팝업메뉴 - [O] >> 필드 선택 >> Generate
	public Member(String id) {
		this.id = id;
	}
		
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Member(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	//메소드 선언
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//필드값을 확인하기 위해 필드값을 출력하는 메소드
	public void display() {
		//System.out.println("아이디 = "+this.id);
		System.out.println("아이디 = "+id);
		System.out.println("이름 = "+name);
		System.out.println("이메일 = "+email);
	}
}
