package com.hexaware.dao.service;

import com.hexaware.model.Customer;

/**
 * The ICustomerService interface provides methods for interacting with the
 * Customer entity. This interface defines operations such as retrieving
 * customer information by ID or username, registering a new customer, updating
 * existing customer details, and deleting a customer.
 */
public interface ICustomerService {

	/**
	 * Retrieves customer information by ID.
	 * 
	 * @param customerID The unique identifier of the customer.
	 * @return The Customer object corresponding to the customer ID, or null if not
	 *         found.
	 */
	Customer getCustomerByID(int customerID);

	void getCustomerByIDWithoutReturnType(int customerID);

	/**
	 * Retrieves customer information by username.
	 * 
	 * @param userName The username of the customer.
	 * @return The Customer object corresponding to the username, or null if not
	 *         found.
	 */
	Customer getCustomerByUsername(String userName);

	void getCustomerByUsernameWithoutReturnType(String userName);

	/**
	 * Registers a new customer.
	 * 
	 * @param customer The Customer object containing the details of the new
	 *                 customer to be registered.
	 */
	void registerCustomer(Customer customer);

	/**
	 * Updates existing customer details.
	 * 
	 * @param customer The Customer object containing the updated details of the
	 *                 customer.
	 */
	void updateCustomer(Customer customer);

	/**
	 * Deletes a customer by ID.
	 * 
	 * @param customerID The unique identifier of the customer to be deleted.
	 */
	void deleteCustomer(int customerID);

	/**
	 * Retrieves the details of customers along with their reservation status.
	 * 
	 * This method should be implemented by concrete classes to provide the
	 * functionality of retrieving customer details and their reservation status.
	 */
	public void getCustomerDetailsAndTheirReservationStatus();

}
