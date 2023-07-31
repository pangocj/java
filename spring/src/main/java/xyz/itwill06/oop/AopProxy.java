package xyz.itwill06.oop;

//핵심관심코드에 횡단관심코드가 삽입된 메소드를 제공하는 클래스 - Proxy 클래스 : Aspect 
public class AopProxy implements Aop {
	//핵심관심코드의 메소드가 선언된 클래스의 객체를 저장하기 위한 필드
	// => 필드의 자료형을 인터페이스를 선언하여 모든 자식클래스의 객체가 저장되도록 설정
	private Aop target;
	
	//횡단관심코드의 메소드가 선언된 클래스의 객체를 저장하기 위한 필드
	private AopLogger logger;
	
	//생성자를 이용하여 필드에 객체를 전달받아 저장하거나 객체를 직접 생성하여 필드에 저장 - 의존성 주입(DI)
	public AopProxy(Aop target) {
		this.target=target;
		logger=new AopLogger();
	}
	
	//인터페이스를 상속받아 오버라이드 선언된 메소드(PointCut)에서 핵심관심코드에 횡단관심코드가
	//삽입(Weaving)되어 명령이 실행되도록 작성
	// => 핵심관심코드가 작성된 메소드 호출 전 또는 후에 횡단관심코드가 작성된 메소드 호출
	// => 횡단관심코드가 삽입될 위치 : JoinPoint
	@Override
	public void display1() {
		logger.beforeLog();//횡단관심코드가 작성된 메소드 호출
		target.display1();//핵심관심코드가 작성된 메소드 호출
	}

	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
	}

	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}

}
