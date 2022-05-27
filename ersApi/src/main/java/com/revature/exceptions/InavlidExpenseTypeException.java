package com.revature.exceptions;

public class InavlidExpenseTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6974691277345811184L;

	public InavlidExpenseTypeException() {
	}

	public InavlidExpenseTypeException(String message) {
		super(message);
	}

	public InavlidExpenseTypeException(Throwable cause) {
		super(cause);
	}

	public InavlidExpenseTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InavlidExpenseTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
