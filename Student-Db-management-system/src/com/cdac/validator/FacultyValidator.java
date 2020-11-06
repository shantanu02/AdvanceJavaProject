package com.cdac.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Faculty;

@Service
public class FacultyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Faculty.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "facultyEmail","unKey","Email is Required");
		ValidationUtils.rejectIfEmpty(errors, "facultyPassword","upKey","Password is Required");
		//ValidationUtils.rejectIfEmpty(errors, "facultyName","unKey","Name is Required");
		//ValidationUtils.rejectIfEmpty(errors, "facultyPhone","unKey","Phone number is Required");
	
		Faculty user = (Faculty) target;

		if (user.getFacultyPassword() != null) {
			if (user.getFacultyPassword().length() < 6) {
				errors.rejectValue("facultyPassword", "passKey", "password should contain more than 6 characters");
			}
			

		}


	
	}
	
	
	
	
	

}
