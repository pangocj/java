package basic;

//제어문(Control Statement) : 프로그램의 흐름(스레드 - Thread)을 바꾸어 주는 명령
// => 선택문(if, switch), 반복문(for, while), 기타(break, continue, return)

//if : 조건식에 의해 명령을 선택 실행

//형식-1) if(조건식) { 명령; 명령; ... }
// => 조건식의 결과가 참(true)인 경우 블럭({}) 내부에 작성된 명령들을 실행
// => 블럭 내부에 명령이 하나만 작성된 경우 블럭({}) 기호 생략 가능

//형식-2) if(조건식) { 명령; 명령; ... } else { 명령; 명령; ... }
// => 조건식의 결과가 참(true)인 경우와 거짓(false)인 경우를 구분하여 블럭 내부에 작성된 명령들을 실행

//형식-3) if(조건식) { 명령; 명령; ... } else if(조건식) { 명령; 명령; ... }
//			else if(조건식) { 명령; 명령; ... } else { 명령; 명령; ... }
// => 조건식이 여러 개인 경우 명령을 구문하여 블럭 내부에 작성된 명령 실행
// => 마지막 else에 작성된 명령은 모든 조건식이 거짓인 경우 실행 - else 생략 가능 

//프로그램의 흐름을 파악하기 위한 이클립스 기능 - Debug Perspective 사용
// => 중지점(BreakPoint) 설정 - [F11] : Debug 기능 실행 단축키 - Debug Perspective 변환
//    - [F6] : 현재 스레드 위치의 명령을 하나씩 실행 >> 반복 - Debug 처리 완료 
//    - 프로그램 강제 종료(Terminate : Ctrl + F2) - Java Perspective 변환 - 중지점 제거

public class IfApp {
	public static void main(String[] args) {
		//int su=90;
		int su=40;
		
		//변수값이 50 이상인 경우에만 화면에 출력되도록 프로그램 작성
		/*
		if(su >= 50) {
			System.out.println("su = "+su);
		}
		*/
		
		//if 구문에 명령이 하나만 존재할 경우 {} 기호 생략 가능
		if(su >= 50) System.out.println("su = "+su);
		System.out.println("==============================================================");
		//int score=80;
		int score=50;
		
		//변수값이 60 이상인 경우 합격 메세지를 출력하고 60 미만인 경우 불합격 메세지가
		//출력되도록 프로그램 작성
		/*
		if(score >= 60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		}
		
		if(score < 60) {
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
		}
		*/
		
		if(score >= 60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		} else {
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
		}
		System.out.println("==============================================================");
		//int num=9;
		int num=10;
		
		//변수값을 홀수 또는 짝수로 구분하여 출력하는 프로그램 작성
		// => X % Y == 0 >> X는 Y의 배수 - 배수 표현 조건식
		/*
		if(num % 2 != 0) {
			System.out.println(num+" = 홀수");
		}
		
		if(num % 2 == 0) {
			System.out.println(num+" = 짝수");
		}
		*/
		
		if(num % 2 != 0) {
			System.out.println(num+" = 홀수");
		} else {
			System.out.println(num+" = 짝수");
		}
		System.out.println("==============================================================");
		//char mun='O';
		char mun='0';
		
		//문자변수에 저장된 문자값을 영문자와 비영문자로 구분하여 출력하는 프로그램 작성
		// => X >= 작은값 && X <= 큰값 : X는 작은값부터 큰값 사이의 범위안에 표현되는 값
		if(mun >= 'A' && mun <= 'Z' || mun >= 'a' && mun <= 'z') {
			System.out.println("[결과]"+mun+" = 영문자");
		} else {
			System.out.println("[결과]"+mun+" = 비영문자");
		}
		System.out.println("==============================================================");
		//boolean sw=true;
		boolean sw=false;
		
		//조건식 대신 boolean 변수값을 사용하여 명령을 선택하여 실행 가능
		/*
		if(sw) {
			System.out.println("현재 변수값은 [참]입니다.");
		} else {
			System.out.println("현재 변수값은 [거짓]입니다.");
		}
		*/
		
		if(!sw) {
			System.out.println("현재 변수값은 [거짓]입니다.");
		} else {
			System.out.println("현재 변수값은 [참]입니다.");
		}
		System.out.println("==============================================================");
		int jumsu=85;
		//int jumsu=185;
		
		//변수값이 0~100 범위의 유효값인지 아닌지를 구분하여 출력하는 프로그램 작성
		// => 입력값에 대한 유효성 검증
		if(jumsu >= 0 && jumsu <= 100) {
			//System.out.println("[결과]0~100 범위의 정상적인 점수가 입력 되었습니다.");
			
			//변수값으로 등급을 구분하여 출력하는 프로그램 작성
			//100 ~ 90 : A, 89 ~ 80 : B, 79 ~ 70 : C, 69 ~ 60 : D, 59 ~ 0 : F
			/*
			String grade="";//학점을 저장하기 위한 변수
			if(jumsu <=100 && jumsu >= 90) {
				grade = "A";
			} else if(jumsu <=89 && jumsu >= 80) {
				grade = "B";
			} else if(jumsu <=79 && jumsu >= 70) {
				grade = "C";
			} else if(jumsu <=69 && jumsu >= 60) {
				grade = "D";
			} else if(jumsu <=59 && jumsu >= 0) {
				grade = "F";
			}
			*/
			
			String grade;//학점을 저장하기 위한 변수
			if(jumsu >= 90) {
				grade = "A";
			} else if(jumsu >= 80) {
				grade = "B";
			} else if(jumsu >= 70) {
				grade = "C";
			} else if(jumsu >= 60) {
				grade = "D";
			} else {
				grade = "F";//모든 조건이 거짓인 경우 무조건 실행되는 명령
			}
			
			System.out.println("[결과]"+jumsu+"점 = "+grade+"학점");
		} else {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 점수가 입력 되었습니다.");
		}
		System.out.println("==============================================================");
	}
}
