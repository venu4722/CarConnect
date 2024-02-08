package com.hexaware.exception;

/**
 * Exception thrown when authentication fails.
 */
@SuppressWarnings("serial")
public class AuthenticationException extends Exception {

	/**
	 * Constructs a new AuthenticationException with the specified detail message.
	 * 
	 * @param msg the detail message.
	 */
	public AuthenticationException(String msg) {
		super(msg);
	}
}
