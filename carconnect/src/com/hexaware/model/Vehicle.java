package com.hexaware.model;

/**
 * Represents a vehicle available for rental.
 */
public class Vehicle {
	private int vehicleID;
	private String model;
	private String make;
	private int year;
	private String color;
	private String registrationNumber;
	private boolean isAvailable;
	private double dailyRate;

	/**
	 * Default constructor.
	 */
	public Vehicle() {
	}

	/**
	 * Parameterized constructor to initialize a Vehicle object.
	 * 
	 * @param vehicleID          The ID of the vehicle.
	 * @param model              The model of the vehicle.
	 * @param make               The make of the vehicle.
	 * @param year               The year of the vehicle.
	 * @param color              The color of the vehicle.
	 * @param registrationNumber The registration number of the vehicle.
	 * @param isAvailable        Indicates if the vehicle is available for rental.
	 * @param dailyRate          The daily rental rate of the vehicle.
	 */
	public Vehicle(int vehicleID, String model, String make, int year, String color, String registrationNumber,
			boolean isAvailable, double dailyRate) {
		this.vehicleID = vehicleID;
		this.model = model;
		this.make = make;
		this.year = year;
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.isAvailable = isAvailable;
		this.dailyRate = dailyRate;
	}

	// Getters and setters for Vehicle attributes

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", model=" + model + ", make=" + make + ", year=" + year + ", color="
				+ color + ", registrationNumber=" + registrationNumber + ", isAvailable=" + isAvailable + ", dailyRate="
				+ dailyRate + "]";
	}
	
	
}
