package oop;

//클래스(Class) : 객체(Object)를 생성하기 위한 자료형 - 참조형
// => Java에서는 객체(Object) 대신 인스턴스(Instance)라는 용어 사용
// => 현실에 존재하는 사물 또는 관념을 클래스라는 자료형으로 표현하여 프로그램에 동작될 수 
//있도록 객체로 생성하여 사용

//클래스 선언 형식
//형식) [public] class 클래스명 {
//			필드(Field) : 표현 대상의 속성(값)을 저장하기 위한 변수 - 멤버변수
//			...
//			생성자(Constructor) : 클래스로 객체를 생성하기 위한 특별한 형태의 메소드
//          ...
//          메소드(Method) : 표현 대상의 행위를 명령으로 제공하기 위한 함수 - 멤버함수
//          ...
//      }

//자동차를 객체 모델하여 클래스로 작성
// => 속성 : 모델명, 엔진상태, 현재속도 - 필드
// => 행위 : 시동 온(On), 시동 오프(Off), 속도 증가, 속도 감소, 이동 중지 - 메소드
public class Car {
	//필드(Field) : 클래스 내부에 선언된 모든 메소드는 필드 접근 가능
	String modelName;//모델명
	boolean engineStatus;//엔진상태 - false : EngineOff, true : EngineOn
	int currentSpeed;//현재속도
	
	//생성자(Constructor) : 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자(Default 
	//Constructor)가 자동으로 생성되어 제공
	
	//메소드(Method) : 필드를 사용하여 메소드의 명령으로 필요한 기능을 제공되도록 작성
	void startEngine() {//시동 온(On)
		engineStatus=true;
		System.out.println(modelName+"의 자동차 시동을 켰습니다.");
	}

	void stopEngine() {//시동 오프(Off)
		if(currentSpeed != 0) {//자동차가 멈췄있지 않은 상태인 경우 
			/*
			currentSpeed=0;
			System.out.println(modelName+"의 자동차가 멈췄습니다.");
			*/
			
			//클래스 내부에 선언된 메소드는 서로 호출 가능
			// => 코드의 중복성을 최소화 하여 프로그램의 생산성 및 유지보수의 효율성 증가
			speedZero();
		}
		
		engineStatus=false;
		System.out.println(modelName+"의 자동차 시동을 껐습니다.");
	}
	
	void speedUp(int speed) {//속도 증가
		if(!engineStatus) {//엔진이 꺼져 있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져 있습니다.");
			return;//메소드 종료
		}
		
		if(currentSpeed+speed > 150) {
			speed = 150 - currentSpeed;
		}
		
		currentSpeed+=speed;
		System.out.println(modelName+"의 자동차 속도가 "+speed
				+"Km/h 증가 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
	}
	
	void speedDown(int speed) {//속도 감소
		if(!engineStatus) {//엔진이 꺼져 있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져 있습니다.");
			return;//메소드 종료
		}
		
		if(currentSpeed < speed) {
			speed = currentSpeed;
		}
		
		currentSpeed-=speed;
		System.out.println(modelName+"의 자동차 속도가 "+speed
				+"Km/h 감소 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
	}
	
	void speedZero() {//이동 중지
		currentSpeed=0;
		System.out.println(modelName+"의 자동차가 멈췄습니다.");
	}
}
