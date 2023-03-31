package basic;

//switch : 값을 비교하여 명령 선택 실행 - 실수값 제외
//형식) switch(비교대상) {
//			case 값1: 명령; 명령; ... [break;]
//			case 값2: 명령; 명령; ... [break;]
//			case 값3: 명령; 명령; ... [break;]
//          ...
//			[default: 명령; 명령; ...]
//		}
// => 비교대상에는 변수 또는 연산식을 작성하여 비교하고자 하는 값 제공
// => 비교대상의 값을 case 키워드로 제공된 값과 차례대로 비교하여 같은 case 키워드의 값을  
//가지고 있는 위치로부터 작성된 모든 명령 실행
// => case 키워드로 제공되는 값은 리터럴 또는 상수(Constant)만 작성 가능
// => case 키워드로 제공되는 값이 중복되어 작성될 경우 에러 발생
// => break 키워드를 만나면 switch 구문 강제 종료
// => case 키워드로 제공되는 값이 모든 다른 경우 default 키워드의 명령 실행 - 생략 가능

public class SwitchApp {
	public static void main(String[] args) {
		//int choice=1;
		//int choice=2;
		int choice=3;
		
		switch(choice) {
		case 1: 
			System.out.println("수성으로 이동합니다.");
		case 2: 
			System.out.println("금성으로 이동합니다.");
		case 3: 
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("==============================================================");
		choice=4;
		
		//switch의 값과 case 값이 모두 다른 경우 명령 미실행
		switch(choice) {
		case 1: 
			System.out.println("수성으로 이동합니다.");
		case 2: 
			System.out.println("금성으로 이동합니다.");
		case 3: 
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("==============================================================");
		choice=5;
		
		//switch의 값과 case 값이 모두 다른 경우 default에 작성된 명령을 무조건 실행
		switch(choice) {
		case 1: 
			System.out.println("수성으로 이동합니다.");
		case 2: 
			System.out.println("금성으로 이동합니다.");
		case 3: 
			System.out.println("화성으로 이동합니다.");
		default: 	
			System.out.println("지구로 이동합니다.");
		}
		System.out.println("==============================================================");
		choice=1;
		
		switch(choice) {
		case 1: 
			System.out.println("수성으로 이동합니다."); break;
		case 2: 
			System.out.println("금성으로 이동합니다."); break;
		case 3: 
			System.out.println("화성으로 이동합니다."); break;
		}
		System.out.println("==============================================================");
		int jumsu=85;
		
		//변수값이 0~100 범위의 유효값인지 아닌지를 구분하여 출력하는 프로그램 작성
		if(jumsu >= 0 && jumsu <= 100) {
			
		} else {
			
		}
		
		
	}
}


















