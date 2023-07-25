package xyz.itwill03.spring;

public class MessagePrint {
	//MessageObject 인터페이스를 상속받은 자식클래스의 객체를 저장하기 위한 필드
	// => 필드에 객체를 저장하기 위한 생성자 또는 Setter 메소드를 반드시 작성 - 포함관계
	// => 필드에 저장된 객체를 사용하여 메소드 호출 가능
	private MessageObject object;

	public MessageObject getObject() {
		return object;
	}

	public void setObject(MessageObject object) {
		this.object = object;
	}
	
	public void messagePrint() {
		//필드에 객체가 저장되지 않은 경우 메소드 호출시 NullPointerException 발생
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}
