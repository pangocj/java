package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-3_email.xml");
		
		System.out.println("==========================================================");
	
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();			
	}
}
