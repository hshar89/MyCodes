package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String>{
    private String[] coursePrefix;
	@Override 
	public void initialize(CourseCode arg) {
		coursePrefix = arg.value();
	}
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result=  false;
		if(theCode!=null) {
			for(String toCheck: coursePrefix) {
		result = theCode.startsWith(toCheck);
		   if(result) {
			   break;
		   }
	    }
		}else {
			return true;
		}
		return result;
	}

}
