package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.FacultyDao;
import com.cdac.dto.Faculty;

@Service
public class FacultyServiceImplementation implements FacultyService {

	
	@Autowired
	private FacultyDao facultyDao;
	
	@Override
	public void addFaculty(Faculty faculty) {
		facultyDao.insertFaculty(faculty);

	}

	@Override
	public boolean validateFaculty(Faculty faculty) {
		return facultyDao.checkFaculty(faculty);
	}

	@Override
	public Faculty selectFaculty(int facultyId) {
		
		return facultyDao.getFaculty(facultyId);
	}
	
	
	@Override
	public String forgotPassword(String facultyEmail) {
		return facultyDao.forgotPassword(facultyEmail);
	}
	
	@Override
	public void uploadImage(String profilePic, int facultyId) {
		facultyDao.uploadImage(profilePic, facultyId);
	}
	
	
}
