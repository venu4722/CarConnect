package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.serviceImpl.VehicleServiceImpl;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.model.Vehicle;

/**
 * Controller class to handle vehicle-related operations and interactions.
 */
public class VehicleController {
	Scanner scanner = new Scanner(System.in);
	VehicleServiceImpl dao = new VehicleServiceImpl();

	/**
	 * Retrieves vehicle information by vehicle ID.
	 */
	public void getVehicleById() {
		System.out.println("Enter the VehicleID");
		int vehicleID = scanner.nextInt();
		Vehicle vehicle = dao.getVehicleByID(vehicleID);
		try {
			if (vehicle == null)
				throw new VehicleNotFoundException("VehicleId is not present");
		} catch (VehicleNotFoundException vnfe) {
			System.out.println(vnfe.getMessage());
		}

	}

	/**
	 * Retrieves available vehicles.
	 */
	public void getAvailableVehicles() {
		System.out.println("Available vehicles are:");
		dao.getAvailableVehicles();
	}

	/**
	 * Adds a new vehicle.
	 */
	public void addVehicle() {
		System.out.println("Enter the vehicleID:");
		int vehicleID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the model of the vehicle:");
		String model = scanner.nextLine();
		System.out.println("Enter the make of the vehicle:");
		String make = scanner.nextLine();
		System.out.println("Enter the year of the vehicle:");
		int year = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the color of the vehicle:");
		String color = scanner.next();
		System.out.println("Enter the registration number:");
		String regstrnum = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the availability of the vehicle:");
		boolean isAvailable = scanner.nextBoolean();
		System.out.println("Enter the daily rate of the vehicle:");
		double dailyRate = scanner.nextDouble();
		Vehicle vehicle = new Vehicle(vehicleID, model, make, year, color, regstrnum, isAvailable, dailyRate);
		dao.addVehicle(vehicle);
	}

	/**
	 * Updates an existing vehicle.
	 */
	public void updateVehicle() {
		System.out.println("Enter the vehicleID:");
		int vehicleID = scanner.nextInt();
		System.out.println("Enter the color:");
		String color = scanner.next();
		System.out.println("Enter the dailyRate:");
		double dailyRate = scanner.nextDouble();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleID(vehicleID);
		vehicle.setColor(color);
		vehicle.setDailyRate(dailyRate);
		dao.updateVehicle(vehicle);
	}

	/**
	 * Removes a vehicle by vehicle ID.
	 */
	public void removeVehicle() {
		System.out.println("Enter the vehicleID:");
		int vehicleID = scanner.nextInt();
		dao.deleteVehicle(vehicleID);
	}

	/**
	 * Retrieves the make of the vehicle.
	 * 
	 * @return The make of the vehicle.
	 */
	public String getVehicleMake() {
		return dao.getVehicleMake();
	}

}
