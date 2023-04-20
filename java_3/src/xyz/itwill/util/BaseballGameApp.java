package xyz.itwill.util;

import java.util.Random;
import java.util.Scanner;

//숫자야구게임 : 0~9 범위의 정수 난수값을 3개 제공받아 키보드로 입력하여 맞추는 게임
// => 난수값과 키보드 입력값은 0~9 범위의 3개에 정수값으로 서로 다르며 0으로 시작 불가능
// => 키보드 입력값이 형식에 맞지 않은 경우 재입력되도록 작성
// => 난수값과 입력값을 비교하여 동일한 정수값이 존재하는 경우 위치가 같으며 스트라이크
//처리하고 위치가 다르면 볼로 처리하여 계산
// => 스트라이크가 3대면 성공 메세지 출력후 프로그램 종료하고 아니면 스트라이크와 볼의 갯수 출력
// => 키보드로 정수값을 입력할 수 있는 기회는 15번을 제공하며 기회를 모두 소진한 경우 난수값 출력
public class BaseballGameApp {
	public static void main(String[] args) {
		Random random=new Random();
		
		//0~9 범위의 정수값 3개를 저장하기 위한 배열 선언 - 난수값을 저장하기 위한 배열
		int[] dap=new int[3];
		
		//규칙에 맞는 난수값을 배열 요소에 저장되도록 처리하기 위한 반복문
		while(true) {
			for(int i=0;i<dap.length;i++) {
				dap[i]=random.nextInt(10);//0~9 범위의 난수값을 배열 요소에 저장
			}
			
			if(dap[0]!=0 && dap[0]!=dap[1] && dap[1]!=dap[2] && dap[2]!=dap[0]) break;
		}
		
		Scanner scanner=new Scanner(System.in);

		// 0~9 범위의 정수값 3개를 저장하기 위한 배열 선언 - 입력값을 저장하기 위한 배열
		int[] num=new int[3];
		
		//정답 관련 상태정보를 저장하기 위한 변수 선언
		// => false : 정답을 못맞춘 상태, true : 정답을 맞춘 상태
		boolean result=false;
		
		//키보드로 정수값을 입력받아 비교 처리하는 기회를 제공하기 위한 반복문
		for(int cnt=1;cnt<=15;cnt++) {
			//스트라이크와 볼의 갯수를 저장하기 위한 변수 선언
			int strike=0, ball=0;
			
			//규칙에 맞는 키보드 입력값을 배열 요소에 저장되도록 처리하기 위한 반복문
			loop:
			while(true) {
				System.out.print(cnt+"번째 입력 >> ");
				String input=scanner.nextLine();
				
				if(input.length()!=3) {//비정상적인 값이 입력된 경우
					System.out.println("[에러]3자리의 숫자만 입력 가능합니다.");
					continue;
				}
				
				//입력받은 문자열의 문자를 차례대로 추출하여 배열 요소에 저장
				for(int i=0;i<num.length;i++) {
					//문자코드(CharacterCode) - '0' : 48 ~ '9' : 57
					//ex) '4' - '0' = 52 - 48 = 4
					num[i]=input.charAt(i)-'0';//문자값 >> 정수값
					
					if(num[i] < 0 || num[i] > 9) {//비정상적인 값이 입력된 경우
						System.out.println("[에러]3자리의 숫자만 입력 가능합니다.");
						continue loop;
					}
				}
				
				if(num[0]!=0 && num[0]!=num[1] && num[1]!=num[2] && num[2]!=num[0]) break;
				System.out.println("[에러]0으로 시작되거나 중복된 숫자가 존재합니다.");
			}
			
			//난수값과 입력값을 비교하여 스트라이크와 볼을 구분하여 계산
			// => 난수값이 저장된 배열의 요소값과 입력값이 저장된 배열의 요소값을 교차 비교
			for(int i=0;i<dap.length;i++) {//난수값이 저장된 배열 요소를 처리하기 위한 반복문
				for(int j=0;j<num.length;j++) {//입력값이 저장된 배열 요소를 처리하기 위한 반복문
					if(dap[i] == num[j]) {//요소값이 같은 경우
						if(i == j) {//요소값이 저장된 위치(Index)가 같은 경우
							strike++;//스트라이크 증가
						} else {
							ball++;//볼 증가
						}
					}
				}
			}
			
			//처리 결과 출력
			if(strike == 3) {
				System.out.println("[메세지]축하합니다. "+cnt+"번만에 맞췄습니다.");
				result=true;
				break;
			}
			
			System.out.println("[결과]"+strike+"스트라이크 "+ball+"볼");
		}
		
		if(!result) {//정답을 맞추지 못한 경우
			System.out.print("[메세지]정답을 못맞췄군요. 정답은 [");
			for(int su : dap) {
				System.out.print(su);
			}
			System.out.println("]입니다.");
		}
		
		scanner.close();
	}
}
