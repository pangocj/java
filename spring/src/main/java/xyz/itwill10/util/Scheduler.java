package xyz.itwill10.util;

//스프링 스케줄링(Spring Scheduling) : 특정 날짜 및 시간마다 원하는 명령이 자동으로 실행되도록 제공하는 기능
// => 휴면 계정 처리, 메일 전송 등의 기능이 자동 실행되도록 설정
//1.Spring Bean Configuration File(servlet-context.xml)에서 스케줄링 관련 클래스를 Spring Bean으로
//등록하여 원하는 날짜 또는 시간 마다 메소드를 자동 호출하여 실행되도록 설정
//2.메소드에 스케줄링 관련 어노테이션을 사용하여 원하는 날짜 또는 시간 마다 메소드를 자동 호출하여 실행되도록 설정

public class Scheduler {
	//@Scheduled : 메소드에 스케줄링 관련 기능을 제공하기 위한 어노테이션
	//cron 속성 : 메소드를 호출하기 위한 날짜 및 시간을 속성값으로 설정
	// => 속성값 : 초 분 시 일 월 요일 - 패턴문자 사용 가능
	//@Scheduled(cron = "1 * * * * *")//매월 매일 매시 매분 1초
	//@Scheduled(cron = "0 1 * * * *")//매월 매일 매시 1분 0초
	//@Scheduled(cron = "0 0 5 * * *")//매월 매일 5시 0분 0초
	//@Scheduled(cron = "0 0 5 1 * *")//매월 1일 5시 0분 0초
	//@Scheduled(cron = "0 0 5 1 1 *")//1월 1일 5시 0분 0초
	//@Scheduled(cron = "0 0 5 * * 1-5")//요일 : 0(일)~6(토) - 0 대신 7 사용 가능
	//@Scheduled(cron = "0 0 1-23/3 * * 1-5")
	public void autoUpdate() {
		System.out.println("Scheduler 클래스의 autoUpdate() 메소드 호출");
	}
}
