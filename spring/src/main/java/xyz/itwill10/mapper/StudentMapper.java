package xyz.itwill10.mapper;

import java.util.List;

import xyz.itwill10.dto.Student;

public interface StudentMapper {
	int insertStudent(Student student);
	List<Student> selectStudentList();
}
