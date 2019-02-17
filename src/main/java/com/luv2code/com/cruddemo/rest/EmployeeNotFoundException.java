package com.luv2code.com.cruddemo.rest;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		
	}

	public EmployeeNotFoundException(String message) {
		super(message);
		
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmployeeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
