package inheritance;

//상속(Inheritance) : 클래스를 선언할 때 기존 클래스를 물려받아 사용하는 기능
// => 기존 클래스를 재활용하여 새로운 클래스를 쉽고 빠르게 작성 
// => 공통적인 속성과 행위를 포함한 다수의 클래스를 선언할 때 공통적인 속성과 행위의 클래스를
//선언하고 작성된 클래스를 상속받아 사용 
// => 코드의 중복성을 최소화하여 프로그램 생산성 및 유지보수의 효율성 증가

//물려주는 클래스 - 부모클래스, 선조클래스, 기본클래스, 슈퍼클래스(SuperClass)
//물려받는 클래스 - 자식클래스, 후손클래스, 파생클래스, 서브클래스(SubClass)

//형식) public class 자식클래스 extends 부모클래스 {
//      	//자식클래스에서는 부모클래스의 필드 또는 메소드 사용 가능 
//          ...
//      }
// => 부모클래스의 생성자는 자식클래스에게 상속되지 않으며 부모클래스의 은닉화 선언된
//필드와 메소드는 자식클래스에서 접근 불가능
// => Java에서는 하나의 부모클래스만 상속 가능 - 단일상속

//이벤트 관련 회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
// => 회원정보를 저장하기 위한 Member 클래스를 상속받아 작성하는 것을 권장 - 재사용성 증가
public class MemberEvent extends Member {
	/*
	//부모클래스(Member)에서 상속받은 필드 또는 메소드 미선언 
	private String id;
	private String name;
	*/
	private String email;
	
	public MemberEvent() {
		//super();//부모클래스의 매개변수가 없는 기본 생성자 호출 - 생략 가능
	}

	//super 키워드 : 자식클래스의 메소드에서 부모클래스 객체의 메모리 주소를 저장하기 위한 키워드
	// => 자식클래스의 메소드에서 부모클래스 객체의 필드 또는 메소드를 참조하기 위해 사용
	// => 자식클래스의 메소드에서 super 키워드를 사용하지 않아도 자식클래스의 메소드에서는 this
	//키워드로 참조되는 필드와 메소드가 없으면 자동으로 부모클래스 객체의 필드 또는 메소드 참조
	
	//super 키워드를 사용하는 경우
	//1.자식클래스의 생성자에서 부모클래스의 매개변수가 있는 생성자를 호출하여 초기화 처리하기 
	//위해 super 키워드 사용 - 부모클래스 객체가 생성될 때 필드에 원하는 초기값 저장 가능
	//형식) super(값, 값, ...);
	// => 생략된 경우 부모클래스의 매개변수가 없는 기본 생성자를 호출하여 객체 생성
	// => 생성자에서 다른 생성자를 호출하는 명령은 반드시 첫번째 명령으로 작성
	//2.자식클래스의 메소드에서 오버라이드 선언되어 숨겨진 부모클래스의 메소드를 호출할
	//경우 super 키워드 사용
	
	/*
	public MemberEvent(String id, String name, String email) {
		//super();
		//자식클래스의 메소드에서는 this 키워드로 자식클래스 객체의 필드 또는 메소드를 
		//참조하고 자식클래스 객체의 필드 또는 메소드가 없는 경우 super 키워드를 이용하여 
		//부모클래스 객체의 필드 또는 메소드 참조
		// => 부모클래스의 필드 또는 메소드가 은닉화 선언된 경우 자식클래스에서 접근 불가능
		//this.id = id;
		setId(id);
		//this.name = name;
		setName(name);
		this.email = email;
	}
	*/
	
	//[Alt]+[Shift]+[S] >> 팝업메뉴 - [O] >> 부모클래스의 생성자 선택 >> 필드 선택 >> Generate
	public MemberEvent(String id, String name, String email) {
		super(id, name);//부모클래스의 매개변수가 있는 생성자 호출
		this.email = email;
	}

	/*
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
	*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//메소드 오버라이딩(Method Overriding) : 상속 관계에서 부모클래스의 메소드를 자식
	//클래스에서 재선언하는 기능
	// => 부모클래스의 메소드를 자식클래스의 객체가 사용하기 부적절한 경우 부모클래스의
	//메소드를 자식클래스에서 재선언하여 사용하는 방법
	// => 부모클래스의 메소드(Hide Method)는 숨겨지고 자식클래스의 메소드만 접근 가능
	//메소드 오버라이드의 작성 규칙 - 부모클래스의 메소드와 같은 접근제한자, 반환형
	//, 메소드명, 매개변수, 예외 전달을 사용하여 자식클래스의 메소드 작성
	/*
	public void display() {
		//System.out.println("아이디 = "+id);
		System.out.println("아이디 = "+getId());
		//System.out.println("이름 = "+name);
		System.out.println("이름 = "+getName());
		System.out.println("이메일 = "+email);
	}
	*/
	
	//이클립스에서는 부모클래스의 메소드를 자식클래스에서 오버라이드 선언되도록 자동 완성
	//하는 기능 제공
	// => 오버라이드 선언하고 싶은 부모클래스의 메소드명 입력 >> [Ctrl]+[Space]
	//    >> Override Method 선택
	//@Override : 오버라이드 선언된 메소드를 표현하기 위한 어노테이션
	//어노테이션(Annotation) : API 문서에서 특별한 설명을 제공하기 위한 기능의 자료형(인터페이스)
	// => Java Source 작성에 필요한 특별한 기능을 제공하기 위한 사용되는 어노테이션
    // => @Override, @Deprecated, @SuppressWarings
	@Override
	public void display() {
		super.display();//super 키워드로 부모클래스의 숨겨진 메소드 호출
		System.out.println("이메일 = "+email);
	}
}
