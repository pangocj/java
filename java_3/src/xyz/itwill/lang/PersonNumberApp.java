package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 주민번호를 입력받아 주민번호를 이용하여 생년월일과 성별을 제공받아 출력하는 프로그램 작성
// => 주민번호는 14자리로 입력받고 7번째 자리에 반드시 - 문자가 존재
// => 비정상적인 주민번호가 입력된 경우 에러 메세지를 출력 후 재입력되도록 처리
//ex) 주민번호[ex.901225-1234567] >> 000101-4567890
//    [결과]생년월일 = 2000년 01월 01일, 성별 = 여자
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		//주민번호를 저장하기 위한 변수
		String number;
		//정상적인 주민번호를 입력받기 위한 반복문 - 입력값 검증
		while(true) {
			System.out.print("주민번호[ex.901225-1234567] >> ");
			//키보드로 입력받은 문자열에서 앞과 뒤의 공백을 제거하여 반환받아 변수에 저장
			//number=scanner.nextLine().trim();
			//키보드로 입력받은 문자열에서 모든 공백을 제거하여 반환받아 변수에 저장
			number=scanner.nextLine().replace(" ", "");
			
			//정상적인 주민번호가 입력된 경우 반복문 종료
			//if(number.length()==14 && number.charAt(6)=='-') break;
			if(number.length()==14 && number.indexOf("-")==6) break;
			
			System.out.println("[에러]형식에 맞게 주민번호를 입력해 주세요.");
		}
		
		scanner.close();
		
		//입력된 주민번호레서 8번째 위치의 문자 하나를 문자열로 분리하여 저장
		String separation=number.substring(7, 8);
		//System.out.println("separation = "+separation);
		
		//생년월일을 저장하기 위한 변수 - 입력받은 주민번호를 분리하여 변수에 저장
		String birthday="";
		if(separation.equals("1") || separation.equals("2")) {//20세기(19XX)에 태어난 경우
			birthday+="19";//문자열을 추가하여 저장
		} else if(separation.equals("3") || separation.equals("4")) {//21세기(20XX)에 태어난 경우
			birthday+="20";
		} 
		
		birthday+=number.substring(0, 2)+"년 ";
		birthday+=number.substring(2, 4)+"월 ";
		birthday+=number.substring(4, 6)+"일";
		
		//성별을 저장하기 위한 변수
		String gender="";
		if(separation.equals("1") || separation.equals("3")) {
			gender="남자";
		} else if(separation.equals("2") || separation.equals("4")) {
			gender="여자";
		}
		
		System.out.println("생년월일 = "+birthday+", 성별 = "+gender);
	}
}
