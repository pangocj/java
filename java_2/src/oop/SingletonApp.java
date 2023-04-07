package oop;

public class SingletonApp {
	public static void main(String[] args) {
		/*
		//new 연산자로 생성자를 호출하여 객체 생성하여 참조변수에 저장
		// => 참조변수에 저장된 객체를 참조하여 메소드 호출
		Singleton singleton1=new Singleton();
		Singleton singleton2=new Singleton();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);
		
		singleton1.display();
		singleton2.display();
		*/
		
		//싱글톤 클래스는 생성자가 은닉화 선언되어 있어 new 연산자로 생성자를 호출하여 객체 생성 불가능
		// => 객체를 반환하는 정적 메소드를 호출하여 참조변수에 반환받은 객체를 저장하여 사용
		Singleton singleton1=Singleton.getInstance();
		Singleton singleton2=Singleton.getInstance();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);
		
		singleton1.display();
		singleton2.display();
		System.out.println("=============================================================");
		//싱글톤 클래스는 참조변수에 반환받은 객체를 저장하여 메소드를 호출하지 않고 
		//반환받은 객체로 직접 메소드를 호출하여 사용하는 것을 권장 
		Singleton.getInstance().display();
		Singleton.getInstance().display();
		System.out.println("=============================================================");
	}
}
