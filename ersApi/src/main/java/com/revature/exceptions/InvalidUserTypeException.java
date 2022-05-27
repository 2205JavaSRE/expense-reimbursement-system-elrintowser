package com.revature.exceptions;

public class InvalidUserTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2582925336715147764L;

	public InvalidUserTypeException() {
		super();
	}

	public InvalidUserTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUserTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserTypeException(String message) {
		super(message);
	}

	public InvalidUserTypeException(Throwable cause) {
		super(cause);
	}
	
}
