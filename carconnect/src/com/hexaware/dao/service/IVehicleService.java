package com.hexaware.dao.service;

import com.hexaware.model.Vehicle;

/**
 * The IVehicleService interface provides methods for interacting with the
 * Vehicle entity. This interface defines operations such as retrieving vehicle
 * information by ID, retrieving available vehicles, adding a new vehicle,
 * updating an existing vehicle, and deleting a vehicle.
 */
public interface IVehicleService {

	/**
	 * Retrieves vehicle information by ID.
	 * 
	 * @param vehicleID The unique identifier of the vehicle.
	 * @return The Vehicle object containing the details of the vehicle with the
	 *         specified ID.
	 */
	Vehicle getVehicleByID(int vehicleID);

	/**
	 * Retrieves available vehicles.
	 */
	void getAvailableVehicles();

	/**
	 * Adds a new vehicle.
	 * 
	 * @param vehicle The Vehicle object containing the details of the new vehicle
	 *                to be added.
	 */
	void addVehicle(Vehicle vehicle);

	/**
	 * Updates an existing vehicle.
	 * @param vehicle The Vehicle object containing the updated details of the vehicle.
	 */
	void updateVehicle(Vehicle vehicle);

	/**
	 * Deletes a vehicle by ID.
	 * @param vehicleID The unique identifier of the vehicle to be deleted.
	 */
	void deleteVehicle(int vehicleID);
}
