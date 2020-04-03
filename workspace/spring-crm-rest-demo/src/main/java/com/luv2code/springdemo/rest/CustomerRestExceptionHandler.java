package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add an exception handler for customer not found exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e) {

		CustomerErrorResponse cer = new CustomerErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value(),
				System.currentTimeMillis());

		return new ResponseEntity<>(cer, HttpStatus.NOT_FOUND);
	}

	// Add an exception handler for any other type of exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExceptionAll(Exception e) {

		CustomerErrorResponse cer = new CustomerErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				System.currentTimeMillis());

		return new ResponseEntity<>(cer, HttpStatus.BAD_REQUEST);
	}
}
