package com.cdac.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Faculty;
import com.cdac.dto.Student;

@Service
public class StudentValidatoRegistration implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Student.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "studentEmail","unKey","Email is Required");
		ValidationUtils.rejectIfEmpty(errors, "studentPassword","upKey","Password is Required");
		ValidationUtils.rejectIfEmpty(errors, "studentRollNo","unKey" ,"Roll no is required");
		ValidationUtils.rejectIfEmpty(errors, "studentName","unKey" ,"Name no is required");
		ValidationUtils.rejectIfEmpty(errors, "studentPhone","unKey" ,"Phone no is required");
		
		Student user = (Student) target;

		if (user.getStudentPassword() != null) {
			if (user.getStudentPassword().length() < 6) {
				errors.rejectValue("studentPassword", "passKey", "password should contain more than 6 characters");
			}

		}
		
		if (user.getStudentPhone() != null) {
			if (user.getStudentPhone().length() < 10) {
				errors.rejectValue("studentPhone", "passKey", "phone number should contain 10 digits");
			}

		}
		
		
	}

}
