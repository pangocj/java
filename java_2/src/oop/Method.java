package oop;

//메소드(Method) : 클래스 내부에 선언된 함수 - 멤버함수
// => 필드(멤버변수)를 이용하여 필요한 기능을 제공하기 위한 명령의 모임
// => 명령(Statement)은 메소드 내부에서만 작성 가능

//함수(Function) : 매개변수로 값을 제공받아 계산하여 결과를 반환하는 명령의 모임 - 기능

//메소드 선언하는 방법
//형식) 반환형 메소드명(자료형 변수명, 자료형 변수명, ...) {
//     		명령;//메소드를 호출하면 실행되는 명령
//          ...
//      } 
//반환형(ReturnType) : 메소드를 호출하여 얻을 수 있는 결과값에 대한 자료형
// => void 자료형(무반환형) : 메소드를 호출하여 얻을 수 있는 결과값이 없는 경우 사용하는 자료형 
//메소드의 () 기호에는 변수를 나열하여 선언 - 매개변수(Parameter - Argument)
// => 메소드에 작성된 명령을 실행하기 위해 필요한 값을 메소드 호출시 전달받아 저장하기 위한 변수
// => 메소드에 작성된 명령을 실행하기 위한 값이 필요없는 경우 매개변수 생략 가능

//메소드 호출(Method Invoke) : 메소드에 작성된 명령들을 실행하여 필요한 기능 제공
//형식) 객체.메소드명(값, 값, ...)
// => 객체가 저장된 참조변수를 사용하여 객체의 메소드 호출
// => 메소드 호출시 매개변수에 차례대로 값을 전달하여 메소드 호출
// => 매개변수에 값이 정상적으로 전달되지 않으면 메소드 호출 불가능 - 에러 발생

//return 키워드 : 메소드를 강제로 종료하기 위한 키워드
//형식-1) if(조건식) return;  
// => 메소드의 반환형을 [void]로 작성
//형식-2) return 반환값;
// => 메소드를 종료하면서 반환값(변수 또는 연산식)을 메소드를 호출하는 명령에게 제공
// => 메소드의 반환형을 대상의 자료형과 반드시 같도록 작성

//객체 생성(참조)이 목적인 클래스 - main 메소드 미작성
public class Method {
	void displayOne() {
		System.out.println("Method 클래스의 displayOne() 메소드 호출");
	}
	
	void displayTwo() {
		System.out.println("Method 클래스의 displayTwo() 메소드 호출");
	}
	
	void printOne() {
		int tot=0; 
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 범위의 정수들의 합계  = "+tot);
	}
	
	void printTwo(int num) {
		//매개변수에 저장된 값에 대한 검증
		if(num<=0) {//비정상적인 값이 전달되어 저장된 경우
			System.out.println("[에러]매개변수에는 0보다 큰 값이 저장되어야 됩니다.");
			return;//메소드 종료
		}
				
		int tot=0;
		for(int i=1;i<=num;i++) {
			tot+=i;
		}
		System.out.println("1~"+num+" 범위의 정수들의 합계  = "+tot);
	}
	
	void printThree(int num1, int num2) {
		/*
		if(num1>num2) {//비정상적인 값이 전달되어 저장된 경우
			System.out.println("[에러]첫번째 전달값이 두번째 전달값보다 작아야 됩니다.");
			return;//메소드 종료
		}
		*/
		
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		System.out.println(num1+"~"+num2+" 범위의 정수들의 합계  = "+tot);
	}
	 
	int returnTot(int num1, int num2) {
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		
		//변수에 저장된 값을 메소드를 종료하며 메소드를 호출하는 명령에게 반환
		// => 반환되는 값의 자료형과 메소드의 반환형이 반드시 동일
		return tot;
	}
	
	//매개변수로 정수값을 전달받아 홀수와 짝수를 구분하여 반환하는 메소드
	// => false 반환 : 홀수, true : 짝수
	boolean isOddEven(int num) {
		if(num % 2 != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//배열을 반환하는 메소드
	int[] returnArray() {
		/*
		int[] array={10,20,30,40,50};
		return array;//배열의 메모리 주소 반환 - 배열 반환
		*/
		
		//return {10,20,30,40,50};//에러 발생
		return new int[]{10,20,30,40,50};
	}
	
	//매개변수 3개에 전달된 정수값들의 합계를 계산하여 반환하는 메소드
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//매개변수로 배열을 전달받아 배열의 모든 요소값들의 합계를 계산하여 반환하는 메소드
	int sumTwo(int[] array) {
		int tot=0;
		for(int num : array) {
			tot += num;
		}
		return tot;
	}
	
	//매개변수 생략 기호(...)를 이용하여 매개변수를 작성하면 값을 0개 이상 전달받아 
	//메소드에서 배열처럼 사용 가능
	int sumThree(int... array) {
		int tot=0;
		for(int num : array) {
			tot += num;
		}
		return tot;
	}
}
