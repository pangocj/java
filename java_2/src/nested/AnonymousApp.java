package nested;

public class AnonymousApp {
	public static void main(String[] args) {
		//인터페이스를 사용하여 참조변수는 생성 가능하지만 객체 생성 불가능
		// => 인터페이스는 클래스가 상속받기 위한 자료형
		// => 인터페이스를 상속받은 자식클래스는 인터페이스에 선언된 모든 추상메소드를
		//반드시 오버라이드 선언
		// => 인터페이스를 상속받은 자식클래스로 객체를 생성하여 인터페이스로 생성된
		//참조변수에 저장 가능
		//Anonymous anonymous=new Anonymous();

		//인터페이스를 상속받은 이름이 없는 자식클래스를 선언하고 인터페이스의 메소드를
		//오버라이드 선언하여 객체 생성 가능 - 익명의 내부클래스(지역클래스)
		//익명의 내부클래스(Anonymous InnerClass) : 인터페이스 또는 추상클래스를 상속받은
		//이름이 없는 자식클래스 - 익명의 내부클래스로 하나의 객체를 생성할 목적으로 사용
		// => 익명의 내부클래스는 상속받은 인터페이스 또는 추상클래스의 모든 추상메소드를
		//오버라이드 선언
		Anonymous anonymous=new Anonymous() {
			@Override
			public void display() {
				System.out.println("익명의 내부클래스의 오버라이드 메소드 호출");
			}
		};
		
		anonymous.display();
	}
}
