package xyz.itwill08.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		StudentService service=context.getBean("studentService", StudentService.class);
		System.out.println("==========================================================");
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
