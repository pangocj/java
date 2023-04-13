package xyz.itwill.app;

import java.util.Date;
import java.util.Scanner;

//키보드로 이름과 태어난 년도를 입력받아 나이를 계산하여 이름과 나이를 출력하는 프로그램 작성
//ex) 이름 입력 >> 홍길동
//    태어난 년도 >> 2000
//    [결과]홍길동님의 나이는 24살입니다.
public class CalcAgeApp {
	public static void main(String[] args) {
		//Scanner 클래스로 객체를 생성하여 참조변수에 저장
		Scanner scanner=new Scanner(System.in);
		
		//키보드를 이용하여 사용자로부터 이름과 태어난 년도를 입력받아 변수에 저장
		System.out.print("이름 입력 >> ");
		String name=scanner.nextLine();
		
		System.out.print("태어난 년도 >> ");
		int birthYear=scanner.nextInt();
		
		//java.util.Date 클래스로 객체를 생성하여 참조변수에 저장
		// => Date 클래스 : 날짜와 시간을 저장하기 위한 클래스
		// => Date 클래스의 기본 생성자를 사용하여 객체를 생성하면 시스템(OS)의 현재 날짜와
		//시간이 저장된 Date 객체 생성
		Date now=new Date();
		
		//Date.getYear() : Date 객체에 저장된 날짜와 시간에서 년도를 정수값으로 반환하는 메소드
		// => 1900년을 기준으로 1년에 1씩 증가된 정수값으로 반환
		// => @Deprecated 어노테이션이 적용된 메소드
		//@Deprecated 어노테이션 : 메소드 사용을 권장하지 않도록 설정하는 어노테이션
		// => @Deprecated 어노테이션이 적용된 메소드를 호출할 경우 경고 발생
		//@SuppressWarnings 어노테이션 : 경고 메세지를 제거하는 어노테이션
		// => value 속성을 사용하여 경고 관련 속성값을 설정
		// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
		//@SuppressWarnings(value = "deprecation")
		@SuppressWarnings("deprecation")
		int currentYear=now.getYear()+1900;
		
		//현재 년도와 태어난 년도를 이용하여 나이 계산
		//int age=2023-birthYear+1;
		int age=currentYear-birthYear+1;
		
		//결과 출력
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
		
		scanner.close();
	}
}
