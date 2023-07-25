package xyz.itwill02.factory;

//Factory 클래스로 제공받은 객체가 변경돼도 메소드는 변경되지 않도록 반드시 인터페이스를 상속받아 작성
public class HelloMessageObject implements MessageObject {
	@Override
	public String getMessage() {
		return "Hello!!!";
	}
}
