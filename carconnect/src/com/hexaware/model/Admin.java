package com.hexaware.model;

import java.util.Date;

import com.hexaware.hashing.MD5Hashing;

/**
 * Represents an Admin entity with attributes such as AdminID, firstName,
 * lastName, email, phoneNumber, userName, password, role, and joinDate.
 */
public class Admin {
	private int adminID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	private String role;
	private Date joinDate;

	/**
	 * Default constructor.
	 */
	public Admin() {
	}

	/**
	 * Parameterized constructor to initialize an Admin object.
	 * 
	 * @param adminID     The ID of the admin.
	 * @param firstName   The first name of the admin.
	 * @param lastName    The last name of the admin.
	 * @param email       The email of the admin.
	 * @param phoneNumber The phone number of the admin.
	 * @param userName    The userName of the admin.
	 * @param password    The password of the admin.
	 * @param role        The role of the admin.
	 * @param joinDate    The join date of the admin.
	 */
	public Admin(int adminID, String firstName, String lastName, String email, String phoneNumber, String userName,
			String password, String role, Date joinDate) {
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		// Hash the password before setting it
		this.password = password;
		this.role = role;
		this.joinDate = joinDate;
	}

	// Getters and setters for Admin attributes
	// get the adminId
	public int getAdminID() {
		return adminID;
	}
	
	//set the adminId
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	// get the firstname
	public String getFirstName() {
		return firstName;
	}
	// set the firstname
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	// get the lastname
	public String getLastName() {
		return lastName;
	}
	// set the lastname
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// get the email
	public String getEmail() {
		return email;
	}
	// set the email
	public void setEmail(String email) {
		this.email = email;
	}
	// get the phonenumber
	public String getPhoneNumber() {
		return phoneNumber;
	}
	// set the phonenumber
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	// get the username
	public String getUserName() {
		return userName;
	}
	// set the username
	public void setUserName(String userName) {
		this.userName = userName;
	}
	// get the password
	public String getPassword() {
		return this.password;
	}
	// set the password
	public void setPassword(String password) {
		// Hash the password before setting it
		this.password = MD5Hashing.doHashing(password);
	}
	// get the role
	public String getRole() {
		return role;
	}
	//set the role
	public void setRole(String role) {
		this.role = role;
	}
	// get the joindate
	public Date getJoinDate() {
		return joinDate;
	}
	// set the join date
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password + ", role="
				+ role + ", joinDate=" + joinDate + "]";
	}
	
	
}
