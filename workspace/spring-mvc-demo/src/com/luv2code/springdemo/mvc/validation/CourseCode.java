package com.luv2code.springdemo.mvc.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
public @interface CourseCode {
   
	//define the attributes
	public String[] value() default {"LUV"};
	
	public String message() default "must start with LUV";
	//define default groups
	
	public Class<?>[] groups() default {};
	
	//define default payloads
	
	public Class<? extends Payload>[] payload() default {};
	
}
