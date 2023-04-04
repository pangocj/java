package example;

import java.util.Scanner;

//키보드로 정수값을 5번 입력받아 합계를 계산하여 출력하는 프로그램을 작성하세요.
//ex) 1번째 정수값 입력 >> 10
//    2번째 정수값 입력 >> 20
//    3번째 정수값 입력 >> 30
//    4번째 정수값 입력 >> 40
//    5번째 정수값 입력 >> 50
//    [결과]합계 = 150
public class TotalOneExample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		int tot=0;
		for(int i=1;i<=5;i++) {
			System.out.print(i+"번째 정수값 입력 >> ");
			int num=scanner.nextInt();
			tot+=num;//입력값을 tot 변수에 누적하여 저장
		}
		
		System.out.println("[결과]합계 = "+tot);
		
		scanner.close();
	}
}
