package xyz.itwill10.dao;

import java.util.List;

import xyz.itwill10.dto.Student;

public interface StudentDAO {
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int no);
	Student selectStudent(int no);
	List<Student> selectStudentList();
}
