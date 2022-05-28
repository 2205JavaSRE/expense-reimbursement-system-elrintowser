package com.revature.exceptions;

public class InvalidStatusException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4931979645648134439L;

	public InvalidStatusException() {
		super();
	}

	public InvalidStatusException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidStatusException(String message) {
		super(message);
	}

	public InvalidStatusException(Throwable cause) {
		super(cause);
	}

}
