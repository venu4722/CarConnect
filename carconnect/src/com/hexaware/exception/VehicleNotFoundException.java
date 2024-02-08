package com.hexaware.exception;

/**
 * Exception thrown when a vehicle is not found.
 */
@SuppressWarnings("serial")
public class VehicleNotFoundException extends Exception {

	/**
	 * Constructs a new VehicleNotFoundException with the specified detail message.
	 * 
	 * @param msg the detail message.
	 */
	public VehicleNotFoundException(String msg) {
		super(msg);
	}
}
