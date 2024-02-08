package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.serviceImpl.CustomerServiceImpl;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.hashing.MD5Hashing;
import com.hexaware.model.Customer;

/**
 * Controller class to handle customer-related operations and interactions.
 */
public class CustomerController {
	Scanner scanner = new Scanner(System.in);
	CustomerServiceImpl dao = new CustomerServiceImpl();

	/**
	 * Retrieves customer information by customer ID.
	 */
	public void getCustomerById() {
		System.out.println("Enter the customerID:");
		int customerId = scanner.nextInt();
		dao.getCustomerByID(customerId);
	}
	/**
	 * Retrieves customer information by customer ID without return type.
	 */
	public void getCustomerByIDWithoutReturnType() {
		System.out.println("Enter the customerID:");
		int customerId = scanner.nextInt();
		dao.getCustomerByIDWithoutReturnType(customerId);
	}

	/**
	 * Retrieves customer information by customer username.
	 * 
	 * @return The customer object corresponding to the username.
	 */
	public Customer getCustomerByUsername() {
		System.out.println("Enter the customer username:");
		String username = scanner.next();
		dao.getCustomerByUsername(username);
		// Assuming getCustomerByUsername returns Customer object from the database
		Customer customer = new Customer();
		return customer;
	}

	/**
	 * Retrieves customer information by customer username without Return Type
	 * 
	 * @return The customer object corresponding to the username.
	 */
	public Customer getCustomerByUsernameWithoutReturnType() {
		System.out.println("Enter the customer username:");
		String username = scanner.next();
		dao.getCustomerByUsernameWithoutReturnType(username);
		// Assuming getCustomerByUsername returns Customer object from the database
		Customer customer = new Customer();
		return customer;
	}

	/**
	 * Registers a new customer.
	 */
	public void registerCustomer() {
		System.out.println("Enter the customerID:");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the firstName:");
		String firstName = scanner.nextLine();
		System.out.println("Enter the lastName:");
		String lastName = scanner.nextLine();
		System.out.println("Enter the Email:");
		String email = scanner.nextLine();
		boolean validEmailEntered = false;
		while (!validEmailEntered) {
			try {
				if (!(email.contains("@") && email.contains("."))) {
					throw new InvalidInputException("Email should contain @ and .");
				}
				validEmailEntered = true;
			} catch (InvalidInputException ine) {
				System.out.println(ine.getMessage());
				
				System.out.println("Invalid email format. Please enter a valid email:");
				email = scanner.nextLine();
			}
		}
		System.out.println("Enter the PhoneNumber:");
		String phno = scanner.nextLine();
		validEmailEntered=false;
		while (!validEmailEntered) {
			try {
				if (phno.length() > 10 || phno.length()<10) {
					throw new InvalidInputException("Phone Number should be 10 digits.");
				}
				validEmailEntered = true;
			} catch (InvalidInputException ine) {
				System.out.println(ine.getMessage());
				
				System.out.println("Invalid PhoneNumber format. Please enter a valid Phone Number:");
				phno = scanner.nextLine();
			}
		}
		System.out.println("Enter the Address:");
		String address = scanner.nextLine();
		System.out.println("Enter the username: ");
		String username = scanner.nextLine();
		System.out.println("Enter the password:");
		String password = scanner.nextLine();
		java.util.Date reDate = new java.util.Date();
		Customer customer = new Customer();
		customer.setCustomerID(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setPhoneNumber(phno);
		customer.setUserName(username);
		customer.setPassword(password);
		customer.setRegistrationDate(reDate);
		dao.registerCustomer(customer);
	}

	/**
	 * Updates an existing customer's information.
	 */
	public void updateCustomer() {
		System.out.println("Enter the customerId:");
		int customerID = scanner.nextInt();
		System.out.println("Enter the email to update for" + customerID);
		String email = scanner.next();
		try {
			if (!(email.contains("@") && email.contains("."))) {
				throw new InvalidInputException("Email should contain @ and .");
			}
		} catch (InvalidInputException ine) {
			System.out.println(ine.getMessage());
		}
		System.out.println("Enter the phoneNumber to update for" + customerID);
		String phno = scanner.next();
		try {
			if (phno.length() > 10) {
				throw new InvalidInputException("Phone number must be of 10 digits..");
			}
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		Customer customer = new Customer();
		customer.setCustomerID(customerID);
		customer.setEmail(email);
		customer.setPhoneNumber(phno);
		dao.updateCustomer(customer);
	}

	/**
	 * Deletes a customer by customerID.
	 */
	public void deleteCustomer() {
		System.out.println("Enter the customerID:");
		int customerId = scanner.nextInt();
		dao.deleteCustomer(customerId);
	}

	/**
	 * Validates customer login credentials.
	 * 
	 * @param username The username entered by the customer.
	 * @param password The password entered by the customer.
	 * @return True if login is successful, false otherwise.
	 */
	public boolean login(String username, String password) {
		String hashedPassword = MD5Hashing.doHashing(password);
		Customer customer = dao.getCustomerByUsername(username);
		boolean isLoggedIn = false;
		if (customer != null) {
			if (customer.getPassword().equals(hashedPassword) && customer.getUserName().equals(username)) {
				isLoggedIn = true;
				System.out.println(customer.getFirstName() + " Successfully Logged in as User..!");
			}
		}
		return isLoggedIn;
	}

	/**
	 * Retrieves Customer details and their Reservation status
	 */
	public void getCustomerDetailsAndTheirReservationStatus() {
		dao.getCustomerDetailsAndTheirReservationStatus();
	}

	/**
	 * Retrieves CustomerID from Customer
	 * 
	 * @return The CustomerID retrieved from the Customer.
	 */
	public int getIdFromCustomer() {
		return dao.getIdFromCustomer();
	}

	/**
	 * Retrieves the name of the customer by their ID.
	 * 
	 * @return The name of the customer corresponding to the ID.
	 */
	public String getCustomerNameById() {
		return dao.getCustomerNameBYId();
	}
}
