package com.hexaware.exception;

/**
 * Exception thrown when an invalid input is provided.
 */
@SuppressWarnings("serial")
public class InvalidInputException extends Exception {

	/**
	 * Constructs a new InvalidInputException with the specified detail message.
	 * 
	 * @param msg the detail message.
	 */
	public InvalidInputException(String msg) {
		super(msg);
	}
}
