package com.hexaware.controller;

import java.util.Scanner;
import com.hexaware.exception.*;

import com.hexaware.dao.serviceImpl.AdminServiceImpl;
import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.hashing.MD5Hashing;
import com.hexaware.model.Admin;

/**
 * Controller class to handle admin-related operations and interactions.
 */
public class AdminController {
	Scanner scanner = new Scanner(System.in);
	AdminServiceImpl dao = new AdminServiceImpl();

	/**
	 * Retrieves admin information by admin ID.
	 */
	public void getAdminById() {
		System.out.println("Enter the adminID:");
		int adminId = scanner.nextInt();
		Admin admin = dao.getAdminByID(adminId);
		try {
			if (admin == null)
				throw new AdminNotFoundException("AdminId is not present in database..");
		} catch (AdminNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	 /**
     * Retrieves admin information by admin username.
     * 
     * @throws AdminNotFoundException if admin is not found
     */
	public void getAdminByUsername() throws AdminNotFoundException {
		System.out.println("Enter the admin username:");
		String username = scanner.next();
		Admin admin = dao.getAdminByUsername(username);
		try {
			if (admin == null)
				throw new AdminNotFoundException("username is not correct..");
		} catch (AdminNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**
	 * Retrieves admin by username without return type
	 */
	public void getAdminByUsernameWithoutReturnType() {
		System.out.println("Enter the admin username:");
		String username = scanner.next();
		dao.getAdminByUsernameWithoutReturnType(username);
	}

	/**
	 * Registers a new admin.
	 */
	public void registerAdmin() {
		System.out.println("Enter the adminID:");
		int adminId = scanner.nextInt();
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
		validEmailEntered = false;
		while (!validEmailEntered) {
			try {
				if (phno.length() > 10 || phno.length()<10) {
					throw new InvalidInputException("Phone Number should be of 10 digits.");
				}
				validEmailEntered = true;
			} catch (InvalidInputException ine) {
				System.out.println(ine.getMessage());
				System.out.println("Invalid PhoneNumber format. Please enter a valid PhoneNumber:");
				phno = scanner.nextLine();
			}
		}

		System.out.println("Enter the username: ");
		String username = scanner.nextLine();
		System.out.println("Enter the password:");
		String password = scanner.nextLine();
		System.out.println("Enter the role:");
		String role = scanner.nextLine();
		java.util.Date joinDate = new java.util.Date();
		Admin admin = new Admin();
		admin.setAdminID(adminId);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setEmail(email);
		admin.setPhoneNumber(phno);
		admin.setUserName(username);
		admin.setPassword(password);
		admin.setJoinDate(joinDate);
		admin.setRole(role);
		dao.registerAdmin(admin);
	}

	/**
	 * Updates an existing admin's information.
	 */
	public void updateAdmin() {
		Admin admin = new Admin();
		System.out.println("Enter the adminId:");
		int adminID = scanner.nextInt();
		System.out.println("Enter the email to update for" + adminID);
		String email = scanner.next();
		System.out.println("Enter the phoneNumber to update for" + adminID);
		String phno = scanner.next();
		admin.setAdminID(adminID);
		admin.setEmail(email);
		admin.setPhoneNumber(phno);
		dao.updateAdmin(admin);
	}

	/**
	 * Deletes an admin by adminID.
	 */
	public void deleteAdmin() {
		System.out.println("Enter the adminID:");
		int adminID = scanner.nextInt();
		try {
			if (dao.deleteAdmin(adminID) > 0) {
				throw new AdminNotFoundException("AdminID is not present in database..");
			}
		} catch (AdminNotFoundException anfe) {
			System.out.println(anfe.getMessage());
			
		}

	}

	/**
     * Validates admin login credentials.
     * 
     * @param username The username entered by the admin.
     * @param password The password entered by the admin.
     * @return True if login is successful, false otherwise.
     * @throws AuthenticationException if authentication fails
     */
	public boolean login(String username, String password) throws AuthenticationException {
		String hashedPassword = MD5Hashing.doHashing(password);
		Admin admin = dao.getAdminByUsername(username);

		boolean isLoggedIn = false;
		if (admin != null) {
			if (admin.getPassword().equals(hashedPassword) && admin.getUserName().equals(username)) {
				isLoggedIn = true;
				System.out.println("--------------------------- " + admin.getFirstName()
						+ " Successfully Logged in as ADMIN! ---------------------------");
			}
		}
		return isLoggedIn;
	}

	 /**
     * Retrieves admin role with username.
     * 
     * @param username The username entered by the admin.
     * @return The Admin Role
     */
	public String getAdminRole(String username) {
		return dao.getAdminRole(username);
	}
}
