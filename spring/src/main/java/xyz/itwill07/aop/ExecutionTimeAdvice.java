package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	//타겟메소드의 명령이 실행되는 처리시간을 계산하여 기록하기 위한 메소드 - Around Advice Method
	/*
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟메소드의 명령 실행전에 동작될 명령 작성
		long startTime=System.currentTimeMillis();
		
		//타겟메소드의 명령 실행 - 타겟메소드 호출
		Object returnValue=joinPoint.proceed();
		
		//타겟메소드의 명령 실행후에 동작될 명령 작성
		long endTime=System.currentTimeMillis();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		System.out.println(className+" 클래스의 "+methodName+"() 메소드 실행 시간 = "
				+(endTime-startTime)+"ms");
		
		return returnValue;
	}
	*/
	
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟메소드의 명령 실행전에 동작될 명령 작성
		//StopWatch 객체 : 시간을 측정하기 위한 기능을 제공하기 위한 객체
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : 시간 측정을 시작하는 메소드
		stopWatch.start();
		
		//타겟메소드의 명령 실행 - 타겟메소드 호출
		Object returnValue=joinPoint.proceed();
		
		//타겟메소드의 명령 실행후에 동작될 명령 작성
		//StopWatch.stop() : 시간 측정을 종료하는 메소드
		stopWatch.stop();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		//StopWatch.getTotalTimeMillis() : 시간 측정 결과를 ms 단위로 반환하는 메소드
		System.out.println(className+" 클래스의 "+methodName+"() 메소드 실행 시간 = "
				+stopWatch.getTotalTimeMillis()+"ms");
		
		return returnValue;
	}
}
