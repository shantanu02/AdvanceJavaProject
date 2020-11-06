package com.cdac.service;

import com.cdac.dto.Faculty;

public interface FacultyService {
	 void addFaculty(Faculty faculty);
	 
	 boolean validateFaculty(Faculty faculty);
	 
	 Faculty selectFaculty(int facultyId);
	 
	 String forgotPassword(String facultyEmail);
	 
	 
	 void uploadImage(String profilePic,int facultyId);
	 
}
