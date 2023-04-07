package oop;

//클래스로 객체를 생성하는 방법
//형식) 클래스명 참조변수 = new 클래스명();
// => new 연산자로 클래스의 기본 생성자를 호출하여 객체를 생성하고 생성된 객체의 메모리 
//주소를 참조변수에 저장
// => 참조변수에 저장된 객체는 . 연산자를 사용하여 필드 또는 메소드에 이용해 프로그램 작성  

//Car 클래스를 객체로 생성하여 작성된 프로그램
public class CarApp {
	public static void main(String[] args) {
		//Car 클래스를 객체를 생성하여 참조변수에 저장
		// => 하나의 클래스로 서로 다른 객체를 여러개 생성 가능
		// => 클래스는 객체를 생성하기 위한 틀(Template)
		// => 객체를 생성하면 객체의 필드에서는 기본값(숫자형 : 0, 논리형 : false, 
		//참조형 : null)이 초기값으로 자동 저장
		Car carOne=new Car();
		Car carTwo=new Car();
		Car carThree=new Car();
		
		System.out.println("carOne = "+carOne);
		System.out.println("carTwo = "+carTwo);
		System.out.println("carThree = "+carThree);
		System.out.println("==============================================================");
		//참조변수.필드명 : 참조변수에 저장된 객체가 . 연산자를 사용하여 필드에 접근
		// => 객체의 필드에는 기본값이 초기값으로 자동 저장
		//문제점)객체를 사용하여 필드에 직접적인 접근을 허용하면 필드에 비정상적인 값 저장 가능
		//해결법)클래스 작성시 필드를 은닉화 처리하여 선언 - 은닉화 선언된 필드에 접근할 경우 에러 발생
		//carOne.modelName="싼타페";//객체의 필드값 변경 - 필드가 은닉화 처리되어 에러 발생
		carOne.setModelName("싼타페");//필드값을 변경하는 Setter 메소드 호출
		
		//System.out.println("첫번째 자동차 모델명 = "+carOne.modelName);//객체의 필드값 사용
		//System.out.println("첫번째 자동차 엔진상태 = "+carOne.engineStatus);
		//System.out.println("첫번째 자동차 현재속도 = "+carOne.currentSpeed);
		//객체의 필드값을 반환하는 Getter 메소드 호출 - 반환받은 필드값 사용(출력)
		System.out.println("첫번째 자동차 모델명 = "+carOne.getModelName());
		System.out.println("첫번째 자동차 엔진상태 = "+carOne.isEngineStatus());
		System.out.println("첫번째 자동차 현재속도 = "+carOne.getCurrentSpeed());
		System.out.println("==============================================================");
		/*
		carTwo.modelName="쏘나타";
		carTwo.engineStatus=true;
		carTwo.currentSpeed=80;
		
		System.out.println("두번째 자동차 모델명 = "+carTwo.modelName);
		System.out.println("두번째 자동차 엔진상태 = "+carTwo.engineStatus);
		System.out.println("두번째 자동차 현재속도 = "+carTwo.currentSpeed);
		*/
		
		carTwo.setModelName("쏘나타");
		carTwo.setEngineStatus(true);
		carTwo.setCurrentSpeed(80);
		
		System.out.println("두번째 자동차 모델명 = "+carTwo.getModelName());
		System.out.println("두번째 자동차 엔진상태 = "+carTwo.isEngineStatus());
		System.out.println("두번째 자동차 현재속도 = "+carTwo.getCurrentSpeed());
		System.out.println("==============================================================");
		//참조변수.메소드명(값,값...) : 참조변수에 저장된 객체가 . 연산자를 사용하여 메소드 호출
		carOne.startEngine();
		carOne.speedUp(50);
		carOne.speedUp(30);
		carOne.speedDown(40);
		carOne.speedZero();
 		carOne.stopEngine();
		System.out.println("==============================================================");
	}
}
