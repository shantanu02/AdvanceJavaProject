package com.cdac.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Admin;
import com.cdac.dto.Faculty;

@Service
public class AdminValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Admin.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "adminEmail","unKey","Email is Required");
		ValidationUtils.rejectIfEmpty(errors, "adminPassword","upKey","Password is Required");
	}

}
