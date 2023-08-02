package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@Aspect : 핵심관심코드에 횡단관심코드를 삽입하여 실행하기 위한 기능을 제공하는 어노테이션
// => Spring Bean Configuration File의 aspect 엘리먼트와 유사한 기능 제공
@Aspect
public class AopAnnotationAdvice {
	//@Pointcut : 타겟메소드를 지정하기 위한 어노테이션
	// => 메소드를 호출하여 Pointcut 표현식으로 설정된 타겟메소드를 제공받아 받아 사용
	// => Spring Bean Configuration File의 pointcut 엘리먼트와 유사한 기능 제공
	//value 속성 : 타겟메소드를 지정하기 위한 Pointcut 표현식을 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	@Pointcut("within(xyz.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
	//@Before : 타겟메소드의 핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드를 제공하기 위한 어노테이션 
	// => Spring Bean Configuration File의 before 엘리먼트와 유사한 기능 제공
	//value 속성 : 타겟메소드를 지정하기 위한 Pointcut 표현식을 속성값으로 설정
	// => @Pointcut 어노테이션을 사용한 메소드 호출하여 Pointcut 표현식을 제공 받아 사용 가능
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	//@Before("within(xyz.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		log.info("[before]핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드");
	}

	//@After : 타겟메소드의 핵심관심코드 실행 후 반드시 삽입되어 실행될 횡단관심코드를 제공하기 위한 어노테이션 
	// => Spring Bean Configuration File의 after 엘리먼트와 유사한 기능 제공
	@After("aopPointCut()")
	public void afterLog() {
		log.info("[after]핵심관심코드 실행 후에 반드시 삽입되어 실행될 횡단관심코드");
	}

	//@AfterReturning : 타겟메소드의 핵심관심코드가 정상적으로 실행된 후 삽입되어 실행될 횡단관심코드를 제공하기 위한 어노테이션 
	// => Spring Bean Configuration File의 after-returning 엘리먼트와 유사한 기능 제공
	//returning 속성 : 타겟메소드의 반환값을 전달받아 저장하기 위한 매개변수의 이름을 속성값으로 설정 
	@AfterReturning(value="aopPointCut()", returning = "object")
	public void afterReturningLog(Object object) {
		log.info("[after-returning]핵심관심코드가 정상적으로 실행 후에 삽입되어 실행될 횡단관심코드");
	}

	//@AfterThrowing : 타겟메소드의 핵심관심코드 실행시 예외가 발생된 후 삽입되어 실행될 횡단관심코드를 제공하기 위한 어노테이션 
	// => Spring Bean Configuration File의 after-throwing 엘리먼트와 유사한 기능 제공
	//throwing 속성 : 타겟메소드에서 발생된 예외를 전달받아 저장하기 위한 매개변수의 이름을 속성값으로 설정 
	@AfterThrowing(value="aopPointCut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		log.info("[after-throwing]핵심관심코드 실행시 예외가 발생된 후에 삽입되어 실행될 횡단관심코드");
	}

	//@Around : 타겟메소드의 핵심관심코드 실행 전과 후에 삽입되어 실행될 횡단관심코드를 제공하기 위한 어노테이션 
	// => Spring Bean Configuration File의 after-throwing 엘리먼트와 유사한 기능 제공
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[around]핵심관심코드 실행 전에 삽입되어 실행될 횡단관심코드");
		Object result=joinPoint.proceed();
		log.info("[around]핵심관심코드 실행 후에 삽입되어 실행될 횡단관심코드");
		return result;
	}
}














