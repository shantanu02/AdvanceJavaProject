package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {
	@Id
	@GeneratedValue
	@Column(name="faculty_id")
	private int facultyId;
	@Column(name="faculty_name")
	private String facultyName;
	@Column(name="faculty_email")
	private String facultyEmail;
	@Column(name="faculty_phone")
	private String facultyPhone;
	@Column(name="faculty_password")
	private String facultyPassword;
	@Column(name = "profile_pic")
	private String profilePic;
	

	// 0 parameter constructor
	public Faculty() {
		super();
	}
	
	//all parameter constructor
	public Faculty(int facultyId, String facultyName, String facultyEmail, String facultyPhone,
			String facultyPassword) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyEmail = facultyEmail;
		this.facultyPhone = facultyPhone;
		this.facultyPassword = facultyPassword;
	}
	
	// facultyId constructor
	public Faculty(int facultyId) {
		super();
		this.facultyId = facultyId;
	}
	
	
	//Email And Password Constructor for  Login
	public Faculty(String facultyEmail, String facultyPassword) {
		super();
		this.facultyEmail = facultyEmail;
		this.facultyPassword = facultyPassword;
	}

	//Getters and Setters
	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyEmail() {
		return facultyEmail;
	}

	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}

	public String getFacultyPhone() {
		return facultyPhone;
	}

	public void setFacultyPhone(String facultyPhone) {
		this.facultyPhone = facultyPhone;
	}

	public String getFacultyPassword() {
		return facultyPassword;
	}

	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	
	//toString for debbuging
	@Override
	public String toString() {
		return facultyId + " " + facultyName + " " + facultyEmail
				+ " " + facultyPhone + " " + facultyPassword ;
	}
	
	
	
	
	
	
}
