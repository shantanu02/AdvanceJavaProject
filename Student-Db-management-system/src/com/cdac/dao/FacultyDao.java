package com.cdac.dao;

import com.cdac.dto.Faculty;

public interface FacultyDao {
	
	void insertFaculty(Faculty faculty);
	
	boolean checkFaculty (Faculty faculty);
	
	Faculty getFaculty(int facultyId);
	
	String forgotPassword(String facultyEmail);
	
	void uploadImage(String profilePic,int facultyId);
	
}
