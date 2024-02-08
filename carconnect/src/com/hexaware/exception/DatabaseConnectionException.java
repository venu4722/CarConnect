package com.hexaware.exception;

/**
 * Exception thrown when a database connection cannot be established.
 */
@SuppressWarnings("serial")
public class DatabaseConnectionException extends Exception {

	/**
	 * Constructs a new DatabaseConnectionException with the specified detail
	 * message.
	 * 
	 * @param msg the detail message.
	 */
	public DatabaseConnectionException(String msg) {
		super(msg);
	}
}
