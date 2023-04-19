package xyz.itwill.util;

import java.util.Calendar;

//Calendar 클래스 : 날짜와 시간을 저장하고 저장된 날짜와 시간 관련 기능을 메소드로 제공하기 위한 클래스
public class CalendarApp {
	public static void main(String[] args) {
		//Calendar.getInstance() : 시스템의 현재 날짜와 시간이 저장된 Calendar 객체를 
		//생성하여 반환하는 메소드
		Calendar calendar=Calendar.getInstance();
		
		//Calendar.toString() : Calendar 객체에 저장된 날짜와 시간을 문자열로 변환하여 반환하는 메소드
		//System.out.println("calendar.toString() = "+calendar.toString());
		System.out.println("calendar = "+calendar);
		
		String[] day={"일","월","화","수","목","금","토"};

		//Calendar.get(int field) : Calendar 객체에 저장된 날짜와 시간에서 매개변수로
		//전달받은 Calendar 클래스의 상수(Constant)에 대한 값을 반환하는 메소드
		// => [월]은 0(1월)~11(12월) 범위의 정수값으로 표현되며 [요일]은 1(일)~7(토) 범위의 정수값으로 표현
		String printDate=calendar.get(Calendar.YEAR)+"년 "
				+(calendar.get(Calendar.MONTH)+1)+"월 "
				+calendar.get(Calendar.DATE)+"일 "
				+day[calendar.get(Calendar.DAY_OF_WEEK)-1]+"요일";
		
		System.out.println("현재 날짜 = "+printDate);
	}
}
