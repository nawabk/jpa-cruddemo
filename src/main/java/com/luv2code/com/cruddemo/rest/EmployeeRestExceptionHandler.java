package com.luv2code.com.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	//add an exceptional handler for employee not found exception
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
		EmployeeErrorResponse error=new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
				                              exc.getMessage(),System.currentTimeMillis() );
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//add another exceptional handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
		EmployeeErrorResponse error=new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(),
				                              exc.getMessage(),System.currentTimeMillis() );
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
