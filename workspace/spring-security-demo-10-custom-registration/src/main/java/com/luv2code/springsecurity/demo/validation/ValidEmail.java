package com.luv2code.springsecurity.demo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=EmailValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD, ElementType.ANNOTATION_TYPE})
@Documented
public @interface ValidEmail {

	
	String message() default "Invalid Email";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};
	
}
