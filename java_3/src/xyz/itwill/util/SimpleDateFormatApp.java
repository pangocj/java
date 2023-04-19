package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.text 패키지 : 객체에 저장된 값을 변환하는 기능의 클래스(인터페이스)가 선언된 패키지

//SimpleDateFormat 클래스 : Date 객체와 String 객체를 서로 반대로 변환하기 위한 기능을  
//메소드로 제공하기 위한 클래스
public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now=new Date();
		
		//SimpleDateFormat 클래스로 객체를 생성하기 위한 매개변수에 날짜와 시간에 대한
		//패턴정보를 문자열로 전달받아 객체로 생성하는 생성자를 사용
		// => 패턴정보 : 패턴문자(날짜와 시간을 임의의 문자로 표현)를 사용하여 표현된 문자열
		// => 패턴문자 : y(년), M(월), d(일), E(요일), AM or PM(오전 또는 오후),
		//h(시:12), H(시:24), m(분), s(초)
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		
		//SimpleDateFormat.format(Date date) : Date 객체에 저장된 날짜와 시간을 SimpleDateFormat
		//객체에 저장된 패턴정보를 사용하여 문자열(String 객체)로 변환하는 반환하는 메소드
		String printDate=dateFormat.format(now);//Date 객체 >> String 객체
		
		System.out.println("현재 날짜 = "+printDate);
		
		//SimpleDateFormat.applyPattern(String pattern) : SimpleDateFormat 객체에 저장된
		//패턴정보를 변경하는 메소드
		dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("현재 = "+dateFormat.format(now));
		
		String want="2000-01-01 00:00:00";
		try {
			//SimpleDateFormat.parse(String str) : SimpleDateFormat 객체에 저장된 패턴정보와
			//동일한 문자열을 전달받아 문자열로 표현된 날짜와 시간이 저장된 Date 객체를 생성
			//하여 반환하는 메소드
			// => SimpleDateFormat 객체에 저장된 패턴정보와 일치하지 않는 문자열이 전달된 
			//경우 ParseException 발생 가능 - 예외 처리
			Date wantDate=dateFormat.parse(want);//String 객체 >> Date 객체
			System.out.println("wantDate = "+wantDate);
		} catch (ParseException e) {
			System.out.println("[에러]형식에 맞게 날짜와 시간을 입력해 주세요.");
		}
	}
}
