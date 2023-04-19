package xyz.itwill.util;

import java.util.Date;

//Date 클래스 : 날짜와 시간을 저장하고 저장된 날짜와 시간 관련 기능을 메소드로 제공하기 위한 클래스
public class DateApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Date 클래스의 기본 생성자를 사용하여 객체를 생성하면 시스템의 현재 날짜와 시간이
		//저장된 Date 객체 생성
		Date now=new Date();
		
		//Date.toString() : Date 객체에 저장된 날짜와 시간을 문자열로 변환하여 반환하느 메소드
		System.out.println("now.toString() = "+now.toString());
		System.out.println("now = "+now);//참조변수를 출력할 경우 toString() 메소드 자동 호출

		String[] day={"일","월","화","수","목","금","토"};
		
		//Date.getYear() : Date 객체에 저장된 날짜와 시간에서 [년]를 반환하는 메소드
		// => 1900년부터 1씩 증가된 정수값 반환
		//Date.getMonth() : Date 객체에 저장된 날짜와 시간에서 [월]를 반환하는 메소드
		// => 0(1월) ~ 11(12월) 범위의 정수값 반환
		//Date.getDate() : Date 객체에 저장된 날짜와 시간에서 [일]를 반환하는 메소드
		//Date.getDay() : Date 객체에 저장된 날짜와 시간에서 [요일]를 반환하는 메소드
		// => 0(일요일) ~ 6(토요일) 범위의 정수값 반환
		String printDate=(now.getYear()+1900)+"년 "+(now.getMonth()+1)+"월 "
				+now.getDate()+"일 "+day[now.getDay()]+"요일";
		
		System.out.println("현재 날짜 = "+printDate);
		
		//Date.getTime() : Date 객체에 저장된 날짜와 시간에서 대한 타임스템프를 반환하는 메소드
		//타임스템프(TimeStamp) : 1970년 1월 1일을 기준으로 1ms마다 1씩 증가된 정수값
		// => 날짜와 시간을 정수값(long)으로 표현하여 연산 처리하기 위해 사용
		//long currentTime=now.getTime();
		long currentTime=System.currentTimeMillis();
		
		//[2000년 1월 1일 0시 0분 0초]가 저장된 Date 객체 생성
		Date wantDate=new Date(100, 0, 1);
		System.out.println("wantDate = "+wantDate);
		
		long wantTime=wantDate.getTime();
		
		System.out.println("연산결과(일) = "+(currentTime-wantTime)/(1000*86400));
	}
}
