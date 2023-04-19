package xyz.itwill.lang.thread;

//은행계좌 사용자정보(은행계좌정보, 사용자명)를 저장하기 위한 클래스
public class AccountUser extends Thread {
	private Account account;//은행계좌정보 - 포함관계
	private String userName;//사용자명
	
	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String userName) {
		super();
		this.account = account;
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public void run() {
		//프로그램 개발자에 의해 생성된 스레드로 run() 메소드를 호출하여 명령 실행
		// => 은행계좌 사용자가 사용하는 은행계좌에 입금 처리하는 메소드 호출
		//account.deposit(userName, 5000);
		
		synchronized (account) {
			account.withDraw(userName, 5000);
		}
	}
}
