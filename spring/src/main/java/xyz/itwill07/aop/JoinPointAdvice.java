package xyz.itwill07.aop;

//횡단관심모듈 - Advice 클래스
public class JoinPointAdvice {
	//Before Advice Method
	public void beforeDisplay() {
		System.out.println("### [before]핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드 ###");
	}

}
