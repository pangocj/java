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

//클래스를 작성할 때 필드와 메소드에 접근 제한자를 사용하여 접근 허용 설정
//접근 제한자(Access Modifier) : private, package(default), protected, public
// => 클래스, 필드, 생성자, 메소드를 선언할 때 접근 허용을 설정하기 위한 키워드
//private : 클래스 내부에서만 접근 가능하도록 허용하는 접근 제한자
// => 필드, 생성자, 메소드를 은닉화 처리하기 위해 사용 - 클래스 외부에서 접근할 경우 에러 발생
// => 일반적으로 필드에 사용하는 접근 제한자 - 객체로 필드에 직접적인 접근을 제한하기 위한 사용
// => 데이타 은닉화(Data Hiding) : 값을 숨겨 보호하기 위한 기능
//public : 모든 패키지의 클래스에서 접근 가능하도록 허용하는 접근 제한자
// => 일반적으로 메소드에 사용하는 접근 제한자 - 프로그램 작성에 필요한 모든 클래스에서 접근
//할 수 있도록 허용
 
//자동차를 객체 모델링하여 클래스로 작성
// => 속성 : 모델명, 엔진상태, 현재속도 - 필드
// => 행위 : 시동 온(On), 시동 오프(Off), 속도 증가, 속도 감소, 이동 중지 - 메소드
public class Car {
	//필드(Field) : 클래스 내부에 선언된 모든 메소드는 필드 접근 가능
	private String modelName;//모델명
	private boolean engineStatus;//엔진상태 - false : EngineOff, true : EngineOn
	private int currentSpeed;//현재속도
	
	//생성자(Constructor) : 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자(Default 
	//Constructor)가 자동으로 생성되어 제공
	
	//메소드(Method) : 필드를 사용하여 메소드의 명령으로 필요한 기능을 제공되도록 작성
	public void startEngine() {//시동 온(On)
		engineStatus=true;
		System.out.println(modelName+"의 자동차 시동을 켰습니다.");
	}

	public void stopEngine() {//시동 오프(Off)
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
	
	public void speedUp(int speed) {//속도 증가
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
	
	public void speedDown(int speed) {//속도 감소
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
	
	public void speedZero() {//이동 중지
		currentSpeed=0;
		System.out.println(modelName+"의 자동차가 멈췄습니다.");
	}
	
	//은닉화 처리된 필드를 위해 필드값을 반환하는 Getter 메소드와 필드값 변경하는 
	//Setter 메소드 선언 - 캡슐화
	//캡슐화(Encapsulation) : 표현대상의 속성(필드)과 행위(메소드)를 하나의 자료형(클래스)로 작성
	// => 필드를 은닉화 처리하여 보호하고 메소드를 이용하여 처리되도록 설정
	
	//Getter 메소드 : 클래스에 외부에서 필드값을 사용할 수 있도록 필드값을 반환하는 메소드
	// => 필드의 자료형이 [boolean]인 경우에는 메소드의 이름을 [is필드명]으로 작성 
	//형식) public 반환형 get필드명() { return 필드명; }
	public String getModelName() {
		return modelName;
	}
	
	//Setter 메소드 : 매개변수로 값을 전달받아 매개변수에 저장된 값으로 필드값을 변경하는 메소드
	//형식) public void set필드명(자료형 변수명) { 필드명=변수명; }
	// => 매개변수에 전달되어 저장된 값에 대한 검증 가능
	public void setModelName(String modelName) {
		//this : 메소드 내부에서 클래스의 객체를 표현하는 키워드
		// => this 키워드를 사용하여 필드 표현
		this.modelName=modelName;
	}
	
	//이클립스에서는 은닉화 처리된 필드에 대한 Getter 메소드와 Setter 메소드를 생성하는 기능 제공
	//단축키 : [Alt]+[Shift]+[S] >> 팝업메뉴 - [R] >> 필드 선택 >> Generate 
	public boolean isEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		if(currentSpeed > 150) return;
		this.currentSpeed = currentSpeed;
	}	
}
