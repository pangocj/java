package basic;

import java.util.Scanner;

//키보드로 점수를 입력받아 학점을 계산하여 출력하는 프로그램 작성
// => 100 ~ 90 : A, 89 ~ 80 : B, 79 ~ 70 : C, 69 ~ 60 : D, 59 ~ 0 : F
// => 키보드로 입력된 점수가 0~100 범위의 정수값이 아닌 경우 에러 메세지 출력 후 재입력되도록 작성
public class InputCheckApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		/*
		System.out.print("점수 입력[0~100] >> ");
		int score=scanner.nextInt();
		*/
		
		/*
		//반복문의 조건식이 무조건 참이 되도록 비정상적인 값을 초기값으로 저장
		int score=-1;
		//비정상적인 입력값인 경우 반복문 실행하고 정상적인 값이 입력된 경우 반복문 종료
		while(score<0 || score>100) {
			System.out.print("점수 입력[0~100] >> ");
			score=scanner.nextInt();
			if(score<0 || score>100) {
				System.out.println("[에러]점수는 0~100 범위의 정수값만 입력 가능합니다.");
			}
		}
		*/
		
		/*
		int score;
		do {
			System.out.print("점수 입력[0~100] >> ");
			score=scanner.nextInt();
			if(score<0 || score>100) {
				System.out.println("[에러]점수는 0~100 범위의 정수값만 입력 가능합니다.");
			}
		} while(score<0 || score>100);
		*/		
		
		int score;
		while(true) {//조건식 대신 [true]를 사용하면 무조건 참 - 무한루프
			System.out.print("점수 입력[0~100] >> ");
			score=scanner.nextInt();
			//입력값이 정상적인 값인 반복문 종료
			if(score >= 0 && score <= 100) break;
			//비정상적인 값이 입렵된 경우 에러 메세지 출력 후 반복문 재실행
			System.out.println("[에러]점수는 0~100 범위의 정수값만 입력 가능합니다.");
		}
		
		String grade="";
		switch(score/10) {
		case 10:
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F";
		}
		
		System.out.println("[결과]"+score+"점 = "+grade+"학점");
		
		scanner.close();
	}
}
