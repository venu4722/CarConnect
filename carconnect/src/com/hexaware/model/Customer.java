package com.hexaware.model;

import java.util.Date;

import com.hexaware.hashing.MD5Hashing;

/**
 * Represents a Customer entity with attributes such as customerID, firstName,
 * lastName, email, phoneNumber, address, userName, password, and
 * registrationDate.
 */
public class Customer {
	private int customerID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private String userName;
	private String password;
	private Date registrationDate;

	/**
	 * Default constructor.
	 */
	public Customer() {
	}

	/**
	 * Parameterized constructor to initialize a Customer object.
	 * 
	 * @param customerID       The ID of the customer.
	 * @param firstName        The first name of the customer.
	 * @param lastName         The last name of the customer.
	 * @param email            The email of the customer.
	 * @param phoneNumber      The phone number of the customer.
	 * @param address          The address of the customer.
	 * @param userName         The username of the customer.
	 * @param password         The password of the customer.
	 * @param registrationDate The registration date of the customer.
	 */
	public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String address,
			String userName, String password, Date registrationDate) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		// Hash the password before setting it
		this.password = password;
		this.registrationDate = registrationDate;
	}

	// Getters and setters for Customer attributes

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		// Hash the password before setting it
		this.password = MD5Hashing.doHashing(password);
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", userName=" + userName
				+ ", password=" + password + ", registrationDate=" + registrationDate + "]";
	}
}
