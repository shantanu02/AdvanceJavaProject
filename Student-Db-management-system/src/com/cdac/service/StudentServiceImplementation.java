package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.StudentDao;
import com.cdac.dto.Student;

@Service
public class StudentServiceImplementation implements StudentService {

	
	@Autowired
	private StudentDao studentDao;
	
	
	@Override
	public boolean addStudent(Student student) {
		return studentDao.insertStudent(student);

	}

	@Override
	public void modifyStudent(Student student) {
		studentDao.updateStudent(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentDao.removeStudent(studentId);

	}

	@Override
	public Student getStudentByRollNo(int studentRollNo) {
		
		return studentDao.selectStudentByRollNo(studentRollNo);
	}

	@Override
	public Student getStudentByName(String studentName) {
		
		return studentDao.selectStudentByName(studentName);
	}
	
	@Override
	public List<Student> getAllStudent(int facultyId) {
		
		return studentDao.selectAllStudent(facultyId);
	}

	@Override
	public Student searchStudent(int studentId) {
		
		return studentDao.findStudent(studentId);
	}

	@Override
	public boolean validateStudent(Student student) {
		
		return studentDao.checkStudent(student);
	}

	@Override
	public String forgotPassword(String studentEmail) {
		return studentDao.forgotPassword(studentEmail);
		
	}

}
