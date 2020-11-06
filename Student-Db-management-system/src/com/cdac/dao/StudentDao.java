package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Faculty;
import com.cdac.dto.Student;

public interface StudentDao {
	
	boolean insertStudent(Student student);
	
	void updateStudent(Student student);
	
	void removeStudent(int studentId);
	
	Student findStudent(int studentId);
	
	Student selectStudentByRollNo(int studentRollNo);
	
	Student selectStudentByName(String studentName);
	
	List<Student> selectAllStudent(int facultyId);
	
	boolean checkStudent (Student student);
	
	
	String forgotPassword(String studentEmail);
	
}
