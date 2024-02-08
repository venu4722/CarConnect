package com.hexaware.exception;

/**
 * Exception thrown when an error occurs related to reservation operations.
 */
@SuppressWarnings("serial")
public class ReservationException extends Exception {

	/**
	 * Constructs a new ReservationException with the specified detail message.
	 * 
	 * @param msg the detail message.
	 */
	public ReservationException(String msg) {
		super(msg);
	}
}
