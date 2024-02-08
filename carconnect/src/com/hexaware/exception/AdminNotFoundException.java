package com.hexaware.exception;

/**
 * Exception thrown when an admin is not found.
 */
@SuppressWarnings("serial")
public class AdminNotFoundException extends Exception {

	/**
	 * Constructs a new AdminNotFoundException with the specified detail message.
	 * 
	 * @param msg the detail message.
	 */
	public AdminNotFoundException(String msg) {
		super(msg);
	}
}
