package oop;

//싱글톤 디자인 패턴을 적용하여 작성된 클래스 - 싱글톤 클래스(Singleton Class)
// => 프로그램에 객체를 하나만 제공하기 위한 목적의 클래스를 작성하기 위해 사용
// => 프로그램에 불필요한 객체가 여러개 생성되는 것을 방지하기 위한 디자인 패턴
public class Singleton {
	//클래스의 객체(메모리 주소)를 저장하기 위한 필드 선언
	// => static 제한자를 사용하여 정적 필드 선언
	//시스템 필드 : 클래스 내부에서만 사용하기 위한 필드
	// => Getter 메소드와 Setter 메소드를 작성하지 않는 필드
	// => 일반적인 필드와 구분하기 위해 필드명을 _로 시작되도록 작성하는 것을 권장
	private static Singleton _instance;
	
	//생성자를 은닉화 선언 - 클래스 외부에서 생성자에 접근하지 못하도록 설정
	// => 객체 생성 불가능
	private Singleton() {
		// TODO Auto-generated constructor stub
	}

	//정적 영역(Static Block) : 클래스를 읽어 메모리(MethodArea)에 저장된 후 자동으로 실행될
	//명령을 작성하기 위한 영역
	// => 프로그램에서 한번만 실행되는 명령
	// => 정적 필드 또는 정적 메소드만 사용 가능
	static {
		//클래스로 객체를 생성하여 시스템 필드에 저장
		// => 프로그램에서 객체를 하나만 생성하여 필드 저장
		_instance=new Singleton();
	}
	
	//시스템 필드에 저장된 객체를 반환하는 메소드 
	public static Singleton getInstance() {
		return _instance;
	}
	
	//인스턴스 메소드
	public void display() {
		System.out.println("Singleton 클래스의 display() 메소드 호출");
	}
}
