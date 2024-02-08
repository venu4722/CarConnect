package com.hexaware.dao.service;

import com.hexaware.model.Reservation;

/**
 * The IReservationService interface provides methods for interacting with the
 * Reservation entity. This interface defines operations such as retrieving
 * reservation information by ID or customer ID, creating a new reservation,
 * updating an existing reservation, and canceling a reservation.
 */
public interface IReservationService {

	/**
	 * Retrieves reservation information by ID.
	 * 
	 * @param reservationID The unique identifier of the reservation.
	 */
	void getReservationByID(int reservationID);

	/**
	 * Retrieves reservation information by customer ID.
	 * 
	 * @param customerID The unique identifier of the customer.
	 */
	void getReservationByCustomerID(int customerID);

	/**
	 * Creates a new reservation.
	 * 
	 * @param reservation The Reservation object containing the details of the new
	 *                    reservation to be created.
	 */
	void createReservation(Reservation reservation);

	/**
	 * Updates an existing reservation.
	 * 
	 * @param reservation The Reservation object containing the updated details of
	 *                    the reservation.
	 */
	void updateReservation(Reservation reservation);

	/**
	 * Cancels a reservation by ID.
	 * 
	 * @param reservationID The unique identifier of the reservation to be canceled.
	 */
	void cancelReservation(int reservationID);
	
	/**
	 * Calculates and retrieves the total cost for a customer.
	 * 
	 * This method should be implemented to calculate and retrieve the total cost
	 * associated with a specific customer.
	 */
	public void getTotalCostForCustomer();

}
