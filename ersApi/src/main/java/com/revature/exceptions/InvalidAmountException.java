package com.revature.exceptions;

public class InvalidAmountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1132656662362944309L;

	public InvalidAmountException() {
		super();
	}

	public InvalidAmountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidAmountException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAmountException(String message) {
		super(message);
	}

	public InvalidAmountException(Throwable cause) {
		super(cause);
	}

}
