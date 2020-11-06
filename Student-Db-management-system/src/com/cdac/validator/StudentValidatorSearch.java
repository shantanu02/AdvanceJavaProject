package com.cdac.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Faculty;
import com.cdac.dto.Student;

@Service
public class StudentValidatorSearch implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Student.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "studentName","unKey","Name is Required");
		//ValidationUtils.rejectIfEmpty(errors, "studentPassword","upKey","Password is Required");
		//ValidationUtils.rejectIfEmpty(errors, "studentRollNo","unKey" ,"Roll no is required");
		//ValidationUtils.rejectIfEmpty(errors, "studentName","unKey" ,"Name no is required");
	
		Student user = (Student) target;

		if (user.getStudentPassword() != null) {
			if (user.getStudentPassword().length() < 6) {
				errors.rejectValue("studentPassword", "passKey", "** password should contain more 6 chars");
			}

		}
	
	}

}
