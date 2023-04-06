package oop;

//실행이 목적인 클래스 - main 메소드를 반드시 작성
public class MethodApp {
	//프로그램 실행시 JVM(Java Virtual Machine)에 의해 자동 호출하는 특별한 메소드
	public static void main(String[] args) {
		//클래스로 객체를 생성하여 객체의 메모리 주소를 참조변수에 저장
		// => 같은 패키지에 작성된 클래스는 패키지 표현없이 클래스 사용 가능
		// => 참조변수를 사용하여 객체의 필드 또는 메소드 접근 가능
		Method method=new Method();
		
		//참조변수를 출력할 경우 "자료형@메모리주소" 형식의 문자열을 제공받아 출력
		System.out.println("method = "+method);
		System.out.println("==============================================================");
		//객체를 이용하여 메소드를 호출하면 프로그램의 흐름(스레드)이 객체의 메소드로 이동하여
		//메소드의 명령을 실행하고 메소드가 종료되면 메소드를 호출한 다음 차례의 명령 실행
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		System.out.println("==============================================================");
		method.printOne();
		method.printOne();
		System.out.println("==============================================================");
		method.printTwo(50);
		method.printTwo(80);
		method.printTwo(-30);
		System.out.println("==============================================================");
		method.printThree(35, 79);
		method.printThree(19, 88);
		method.printThree(67, 12);
		System.out.println("==============================================================");
		//반환값이 존재하는 메소드 호출  
		// => 메소드의 반환값을 지속적으로 사용하고자 할 경우 반환값을 변수에 저장
		int total=method.returnTot(30, 70);
		System.out.println("합계(메소드 호출의 반환값) = "+total);
		//메소드의 반환값을 일시적으로 사용할 경우 반환값을 변수에 미저장
		System.out.println("합계(메소드 호출의 반환값) = "+method.returnTot(20, 80));
		System.out.println("==============================================================");
		boolean result=method.isOddEven(10);
		if(result) {
			System.out.println("매개변수로 전달된 값은 [짝수]입니다.");
		} else {
			System.out.println("매개변수로 전달된 값은 [홀수]입니다.");
		}
		
		//조건식 대신 메소드의 반환값이 이용하여 명령을 선택 실행
		if(method.isOddEven(9)) {
			System.out.println("매개변수로 전달된 값은 [짝수]입니다.");
		} else {
			System.out.println("매개변수로 전달된 값은 [홀수]입니다.");
		}
		System.out.println("==============================================================");
		//배열의 메모리 주소를 반환하는 메소드를 호출하면 반환된 메모리 주소를 참조변수에 저장
		// => 참조변수에 저장된 메모리 주소를 사용하여 배열 참조 가능
		int[] array=method.returnArray();
		for(int num : array) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("==============================================================");
		System.out.println("합계 = "+method.sumOne(10, 20, 30));
		//매개변수에 값이 정상적으로 전달되지 않을 경우 메소드 호출에 대한 에러 발생
		//System.out.println("합계 = "+method.sumOne());
		//System.out.println("합계 = "+method.sumOne(10,20));
		//System.out.println("합계 = "+method.sumOne(10,20,30,40));
		System.out.println("==============================================================");
		//System.out.println("합계 = "+method.sumTwo(10, 20, 30));//에러 발생
		//매개변수의 배열의 메모리 주소를 전달하여 메소드 호출
		System.out.println("합계 = "+method.sumTwo(new int[]{10, 20, 30}));
		System.out.println("합계 = "+method.sumTwo(new int[]{}));
		System.out.println("합계 = "+method.sumTwo(new int[]{10, 20}));
		System.out.println("합계 = "+method.sumTwo(new int[]{10, 20, 30, 40}));
		System.out.println("==============================================================");
		System.out.println("합계 = "+method.sumThree(10, 20, 30));
		System.out.println("합계 = "+method.sumThree());
		System.out.println("합계 = "+method.sumThree(10, 20));
		System.out.println("합계 = "+method.sumThree(10, 20, 30, 40));
		System.out.println("==============================================================");
	}
}
