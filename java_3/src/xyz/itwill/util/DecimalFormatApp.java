package xyz.itwill.util;

import java.text.DecimalFormat;

//DecimalFormat 클래스 : Number 객체(숫자값)와 String 객체를 서로 반대로 변환하기 위한 기능을  
//메소드로 제공하기 위한 클래스
public class DecimalFormatApp {
	public static void main(String[] args) {
		int money=100_000_000;
		System.out.println("금액 = "+money+"원");

		//DecimalFormat 클래스로 객체를 생성하기 위한 매개변수에 숫자값에 대한 패턴정보를 
		//문자열로 전달받아 객체로 생성하는 생성자를 사용
		// => 패턴문자 : #(숫자 - 공백), 0(숫자 - 0), 콤마(,), 소숫점(.), 달러($)
		DecimalFormat decimalFormat=new DecimalFormat("###,###,##0");
		
		//DecimalFormat.format(long number) : 숫자값을 전달받아 DecimalFormat 객체에 저장된
		//패턴정보를 사용하여 문자열로 변환하여 반환하는 메소드
		System.out.println("금액 = "+decimalFormat.format(money)+"원"); 
		
		//DecimalFormat.getInstance() : 패턴정보가 저장된 DecimalFormat 객체를 반환하는 메소드
		// => 3자리마다 ,를 사용하여 숫자값을 표현하는 패턴정보
		System.out.println("금액 = "+DecimalFormat.getInstance().format(money)+"원");
		
		//DecimalFormat.getCurrencyInstance() : 패턴정보가 저장된 DecimalFormat 객체를 반환하는 메소드
		// => 맨앞에 시스템이 사용하는 화폐단위를 붙이고 3자리마다 ,를 사용하여 숫자값을 표현하는 패턴정보
		System.out.println("금액 = "+DecimalFormat.getCurrencyInstance().format(money));
	}
}
