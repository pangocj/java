package xyz.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//객체를 직접 생성하여 메소드 호출 - 객체간의 결합도가 높아 유지보수의 효율성 감소
		//MessageObject object=new HelloMessageObject();
		
		//프로그램 실행에 필요한 객체를 Factory 클래스로부터 제공받아 메소드 호출
		// => IoC(Inversion of Control) : 제어의 역행 - 객체간의 결합도를 낮춰 유지보수의 효율성 증가
		//MessageObject object=MessageObjectFactory.getMessageObject(1);
		MessageObject object=MessageObjectFactory.getMessageObject(2);
		
		//인터페이스로 생성된 참조변수로 추상메소드를 호출하면 참조변수에 저장된 자식 객체의
		//오버라이드 메소드 호출 - 묵시적 객체 형변환 : 오버라이드에 의한 다형성
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}
