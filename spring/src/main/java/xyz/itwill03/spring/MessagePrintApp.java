package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);//객체 필드에 객체를 전달하여 저장 - 포함관계 완성
		print.messagePrint();
		*/
		
		//ApplicationContext 객체 : 스프링 컨테이너(Spring Container) 기능을 제공하기 위한 객체
		// => Spring Bean Configuration File(XML)을 제공받아 객체(Spring Bean)를 생성하여 관리
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring 컨테이너에세 필요한 Spring Bean(객체)를 제공받아 저장
		// => 매개변수에 Spring Bean를 구분하기 위한 식별자(beanName 또는 beanId)를 전달
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		
		print.messagePrint();

		//ApplicationContext 객체 제거 - Spring 컨테이너 소멸 
		// => Spring 컨테이너가 관리하는 모든 Spring Bean(객체) 소멸 
		((ClassPathXmlApplicationContext)context).close();
	}
}









