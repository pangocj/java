package xyz.itwill.util;

import java.util.List;

public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager=new StudentManager();
		
		//저장매체에 학생정보를 삽입하는 메소드 호출
		manager.insertStudent(new Student(1000, "홍길동"));
		manager.insertStudent(new Student(2000, "임꺽정"));
		manager.insertStudent(new Student(3000, "전우치"));
		manager.insertStudent(new Student(4000, "일지매"));
		
		if(manager.insertStudent(new Student(5000, "장길산"))) {
			System.out.println("[메세지]학생정보를 성공적으로 삽입 하였습니다.");
		} else {
			System.out.println("[메세지]이미 저장된 학번의 학생정보이므로 삽입되지 않았습니다.");
		}
		System.out.println("===============================================================");
		//저장매체에 저장된 학생정보 중 학번이 [2000]인 학생정보를 검색하여 반환하는 메소드 호출
		Student searchStudent=manager.selectStudent(2000);
		if(searchStudent != null) {
			System.out.println(searchStudent);
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("===============================================================");
		//저장매체에 저장된 학생정보 중 학번이 [2000]인 학생의 이름을 [임걱정]으로 변경하는 메소드 호출
		searchStudent.setName("임걱정");
		if(manager.updateStudent(searchStudent)) {
			System.out.println("[메세지]학생정보를 성공적으로 변경 하였습니다.");
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("===============================================================");
		//저장매체에 저장된 학생정보 중 학번이 [4000]인 학생정보를 삭제하는 메소드 호출
		if(manager.deleteStudent(4000)) {
			System.out.println("[메세지]학생정보를 성공적으로 삭제 하였습니다.");
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("===============================================================");
		//저장매체에 저장된 모든 학생정보를 반환하는 메소드 호출
		List<Student> studentList=manager.selectStudentList();
		
		for(Student student : studentList) {
			System.out.println(student);//toString() 메소드 자동 호출
		}
		System.out.println("===============================================================");
	}
}