package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.Student;
 
public interface StudentService {
	void addStudent(Student student);
	List<Student> getStudentList();
}
