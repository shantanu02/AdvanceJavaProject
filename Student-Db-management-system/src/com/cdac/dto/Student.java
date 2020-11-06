package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue
	@Column(name="student_id")
	private int  studentId;
	@Column(name="student_roll_no")
	private int studentRollNo;
	@Column(name="student_name")
	private String studentName;
	@Column(name="student_email")
	private String studentEmail;
	@Column(name="student_blood_group")
	private String studentBloodGroup;
	@Column(name="student_phone")
	private String studentPhone;
	@Column(name="student_password")
	private String studentPassword;
	@Column(name="student_marks_cpp")
	private double studentMarksCpp;
	@Column(name="student_marks_dbt")
	private double studentMarksDbt;
	@Column(name="student_marks_awp")
	private double studentMarksAwp;
	@Column(name="student_marks_mean")
	private double studentMarksMean;
	@Column(name="student_marks_osc")
	private double studentMarksOsc;
	@Column(name="student_marks_java")
	private double studentMarksJava;
	@Column(name="faculty_id")
	private int facultyId;
	
	//0 parameter Constructor
	public Student() {
		super();
	}
	
	//All parameter Constructor
	public Student(int studentId, int studentRollNo, String studentName, String studentEmail, String studentBloodGroup,
			String studentPhone, String studentPassword, double studentMarksCpp, double studentMarksDbt,
			double studentMarksAwp, double studentMarksMean, double studentMarksOsc, double studentMarksJava,
			int facultyId) {
		super();
		this.studentId = studentId;
		this.studentRollNo = studentRollNo;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentBloodGroup = studentBloodGroup;
		this.studentPhone = studentPhone;
		this.studentPassword = studentPassword;
		this.studentMarksCpp = studentMarksCpp;
		this.studentMarksDbt = studentMarksDbt;
		this.studentMarksAwp = studentMarksAwp;
		this.studentMarksMean = studentMarksMean;
		this.studentMarksOsc = studentMarksOsc;
		this.studentMarksJava = studentMarksJava;
		this.facultyId = facultyId;
	}
	
	
	//Student Id constructor
	public Student(int studentId) {
		super();
		this.studentId = studentId;
	}

	
	//Getters and Setters
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentBloodGroup() {
		return studentBloodGroup;
	}

	public void setStudentBloodGroup(String studentBloodGroup) {
		this.studentBloodGroup = studentBloodGroup;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public double getStudentMarksCpp() {
		return studentMarksCpp;
	}

	public void setStudentMarksCpp(double studentMarksCpp) {
		this.studentMarksCpp = studentMarksCpp;
	}

	public double getStudentMarksDbt() {
		return studentMarksDbt;
	}

	public void setStudentMarksDbt(double studentMarksDbt) {
		this.studentMarksDbt = studentMarksDbt;
	}

	public double getStudentMarksAwp() {
		return studentMarksAwp;
	}

	public void setStudentMarksAwp(double studentMarksAwp) {
		this.studentMarksAwp = studentMarksAwp;
	}

	public double getStudentMarksMean() {
		return studentMarksMean;
	}

	public void setStudentMarksMean(double studentMarksMean) {
		this.studentMarksMean = studentMarksMean;
	}

	public double getStudentMarksOsc() {
		return studentMarksOsc;
	}

	public void setStudentMarksOsc(double studentMarksOsc) {
		this.studentMarksOsc = studentMarksOsc;
	}

	public double getStudentMarksJava() {
		return studentMarksJava;
	}

	public void setStudentMarksJava(double studentMarksJava) {
		this.studentMarksJava = studentMarksJava;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	
	
	//To string for debbuging
	@Override
	public String toString() {
		return  studentId + " " + studentRollNo + " " + studentName
				+ " " + studentEmail + " " + studentBloodGroup + " "
				+ studentPhone + " " + studentPassword + " " + studentMarksCpp
				+ " " + studentMarksDbt + " " + studentMarksAwp
				+ " " + studentMarksMean + " " + studentMarksOsc
				+ " " + studentMarksJava + " " + facultyId ;
	}
	

	
}

