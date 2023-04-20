package xyz.itwill.util;

//제네릭(Generic) : 필드의 자료형(참조형)이 추상적인 경우 자료형 대신 사용될 식별자 - 미지정 자료형
// => Java 자료형(참조형) 선언시 < > 기호에 제네릭 타입(식별자) 선언
//형식) public class 클래스명<제네릭, 제네릭, ...> { }
// => < > 안에 제네릭 타입은 , 기호를 사용하여 나열 선언 가능
// => 제네릭 타입의 식별자는 대문자로 작성하는 것을 권장

//제네릭으로 전달받을 수 있는 Java 자료형을 상속 기능을 사용하여 제한 가능
//형식) public class 클래스명<제네릭 extends 부모클래스> { }
// => 제네릭은 반드시 부모클래스를 상속받은 Java 자료형만 전달받아 사용 가능
public class Generic<T extends Number> {//제네릭 클래스
	private T field;
	
	public Generic() {
		// TODO Auto-generated constructor stub
	}

	public Generic(T field) {
		super();
		this.field = field;
	}

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
}
