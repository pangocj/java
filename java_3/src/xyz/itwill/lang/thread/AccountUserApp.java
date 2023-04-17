package xyz.itwill.lang.thread;

public class AccountUserApp {
	public static void main(String[] args) {
		//Account 클래스로 객체를 생성하여 저장 - 은행계좌 생성
		Account account=new Account(10000);//잔액 : 10000원
		
		/*
		//단일 스레드(main)를 이용하여 AccountUser 클래스로 객체로 생성하여 저장
		// => 은행계좌를 사용하는 사용자를 여러개 생성하여 같은 은행계좌를 사용하도록 설정
		AccountUser one=new AccountUser(account, "홍길동");
		AccountUser two=new AccountUser(account, "임꺽정");
		AccountUser three=new AccountUser(account, "전우치");
		
		//단일 스레드(main)를 이용하여 모든 은행계좌 사용자를 이용한 은행계좌의 입금 처리
		one.getAccount().deposit(one.getUserName(), 5000);//잔액 : 15000원
		two.getAccount().deposit(two.getUserName(), 5000);//잔액 : 20000원
		three.getAccount().deposit(three.getUserName(), 5000);//잔액 : 25000원
		*/
	}
}
