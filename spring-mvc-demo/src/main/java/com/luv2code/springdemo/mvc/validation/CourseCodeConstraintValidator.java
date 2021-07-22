package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	@Override
	public void initialize(CourseCode courseCode) {
		this.coursePrefix = courseCode.value();
	}
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		if(code != null) {			
			var result = code.startsWith(coursePrefix);
			return result;
		}
		
		return true;
	}
}