package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

//횡단관심모듈 - Advice 클래스
@Slf4j
public class EmailSendAdvice {
	//메일 전송 전에 삽입되어 실행될 명령이 작성된 메소드 - Before Advice Method
	// => 받는 사람의 이메일 주소와 제목을 타겟메소드의 매개변수로 제공받아 기록하는 명령 작성
	public void accessLog(JoinPoint joinPoint) {
		//타겟메소드의 매개변수에서 받는 사람의 이메일 주소를 제공받아 저장 
		String email=(String)joinPoint.getArgs()[0];
		//타겟메소드의 매개변수에서 메일 제목을 제공받아 저장 
		String subject=(String)joinPoint.getArgs()[1];
		log.info(email+"님에게 <"+subject+"> 제목의 이메일을 전송합니다.");		
	}

	//메일 전송 성공 후에 삽입되어 실행될 명령이 작성된 메소드 - After Returning Advice Method
	// => 받는 사람의 이메일 주소를 타겟메소드의 반환값으로 제공받아 기록하는 명령 작성
	public void successLog(String email) {
		log.info(email+"님에게 이메일을 성공적으로 전송 하였습니다.");		
	}

	//메일 전송 실패 후에 삽입되어 실행될 명령이 작성된 메소드 - After Throwing Advice Method
	// => 메일 전송 실패에 대한 메세지를 타겟메소드의 예외로부터 제공받아 기록하는 명령 작성
	public void errorLog(Exception exception) {
		log.info("이메일 전송 실패 = "+exception.getMessage());
	}
}










