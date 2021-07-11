package com.spring.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MyValidator implements Validator {

	// which kind of classes you can validate here
	public boolean supports(Class<?> clazz) {
		return Authentication.class.equals(clazz);
	}

	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "user", "Username is empty");
		Authentication authObj = (Authentication) target;
		if(authObj.getPassword().length() < 8)
			e.rejectValue("password", "Password length is less than 8 characters");
		
	}
}
