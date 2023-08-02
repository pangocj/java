package xyz.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		StudentService service=context.getBean("studentService", StudentService.class);
		System.out.println("==========================================================");
		/*
		Student newStudent=new Student();
		newStudent.setNo(6000);
		newStudent.setName("홍경래");
		newStudent.setPhone("010-3189-9622");
		newStudent.setAddress("서울시 도봉구");
		newStudent.setBirthday("1999-05-05");
		service.addStudent(newStudent);
		*/
		
		/*
		Student searchStudent=service.getStudent(6000);
		System.out.println(searchStudent);//toString() 메소드를 호출하여 필드값을 반환받아 출력 
		searchStudent.setName("로빈훗");
		searchStudent.setBirthday("1999-02-05");
		service.modifyStudent(searchStudent);
		*/
		
		service.removeStudent(6000);
		
		List<Student> studentList=service.getStudentList();
		for(Student student : studentList) {
			System.out.println("학번 = "+student.getNo()+", 이름 = "+student.getName()
					+", 전화번호 = "+student.getPhone()+", 주소 = "+student.getAddress()
					+", 생년월일 = "+student.getBirthday().substring(0, 10));
		}
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
