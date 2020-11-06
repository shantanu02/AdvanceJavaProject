package com.cdac.service;

import java.util.List;

import com.cdac.dto.Student;

public interface StudentService {
	

	boolean addStudent(Student student);
	
	void modifyStudent(Student student);
	
	void deleteStudent(int studentId);

	List<Student> getAllStudent(int facultyId);
	
	Student searchStudent(int studentId);
	
	Student getStudentByRollNo(int studentRollNo);
	
	Student getStudentByName(String studentName);
	
	boolean validateStudent(Student student);
	
	 String forgotPassword(String studentEmail);
	
}
