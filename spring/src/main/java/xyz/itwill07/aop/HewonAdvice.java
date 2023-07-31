package xyz.itwill07.aop;

//횡단관심모듈(CrossCutting Concern Module) : 횡단관심코드로 작성된 메소드가 선언된 클래스 - Advice 클래스
// => 횡단관심코드 : 데이타 처리 명령을 제외한 보조적인 기능을 제공하는 명령
// => 로그 처리, 보안(권한) 처리, 트렌젝션 처리, 예외 처리 등의 명령
public class HewonAdvice {
	//타겟메소드의 명령 실행전에 삽입되어 실행될 명령을 작성한 메소드 - Before Advice Method
	// => JoinPoint : 핵심관심코드를 기준으로 횡단관심코드가 삽입되어 동작될 위치를 표현
	//타겟메소드(Target Method) : 핵심관심모듈의 메소드 중 PiuntCut 표현식으로 지정되어 
	//횡단관심코드가 삽입될 메소드
	// => PiuntCut 표현식 : 핵심관심모듈의 메소드 중 특정 메소드만 지정하기 위한 언어
	public void beforeLog() {
		System.out.println("### [before]핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드 ###");
	}
}
