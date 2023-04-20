package xyz.itwill.util;

//Object 타입의 필드가 선언된 클래스로 객체를 생성하여 사용하는 프로그램
// => Object 타입의 필드에 모든 클래스의 객체를 전달하여 저장 가능
// => Object 타입의 필드에 저장된 객체를 반환받아 사용하기 위해서는 반드시 명시적 객체 형변환 사용
public class NonGenericApp {
	public static void main(String[] args) {
		NonGeneric nonGeneric1=new NonGeneric();
		
		//Integer 객체를 Object 클래스의 매개변수로 전달받아 Object 클래스의 필드값으로 변경
		nonGeneric1.setField(100);//오토박싱 : 정수값 >> Integer 객체
		
		//필드값이 Object 클래스의 객체로 반환되므로 반드시 명시적 형변환을 사용해야
		//자식클래스의 참조변수에 객체 저장 가능 - 자식클래스의 메소드 호출
		Integer returnObject1=(Integer)nonGeneric1.getField();
		
		System.out.println("필드값 = "+returnObject1);//오토언박싱 : Integer 객체 >> 정수값
		System.out.println("==============================================================");
		NonGeneric nonGeneric2=new NonGeneric();
		
		//Double 객체를 Object 클래스의 매개변수로 전달받아 Object 클래스의 필드값으로 변경
		nonGeneric2.setField(12.34);//오토박싱 : 실수값 >> Double 객체
		
		//명시적 객체 형변환을 잘못된 경우 ClassCastException 발생
		// => instanceof 연산자를 사용하여 명시적 객체 형변환 전에 자식클래스에 대한 검증
		if(nonGeneric2.getField() instanceof Double) {
			//Integer returnObject2=(Integer)nonGeneric2.getField();
			Double returnObject2=(Double)nonGeneric2.getField();

			System.out.println("필드값 = "+returnObject2);//오토언박싱 : Double 객체 >> 실수값
		}
		System.out.println("==============================================================");
		NonGeneric nonGeneric3=new NonGeneric();
		
		//String 객체를 Object 클래스의 매개변수로 전달받아 Object 클래스의 필드값으로 변경
		nonGeneric3.setField("홍길동");
		
		String returnObject3=(String)nonGeneric3.getField();
		
		System.out.println("필드값 = "+returnObject3);
		System.out.println("==============================================================");
		
	}
}
