package com.hexaware.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.hexaware.exception.*;

import com.hexaware.controller.AdminController;
import com.hexaware.controller.CustomerController;

/**
 * The main class that serves as the entry point for the car rental platform
 * application.
 * 
 * @author venuGopalNakkella
 * @version 1.0
 */
public class MainClass {

	/**
	 * The main method that starts the application.
	 * 
	 * @param args command-line arguments (not used)
	 * @throws AuthenticationException if authentication fails
	 * @throws AdminNotFoundException  if an admin is not found
	 * @throws SQLException            if a SQL exception occurs
	 * @throws ParseException          if a parse exception occurs
	 */
	public static void main(String[] args)
			throws AuthenticationException, AdminNotFoundException, SQLException, ParseException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		AdminView adminView = new AdminView();
		CustomerView customerView = new CustomerView();
		AdminController ac = new AdminController();
		CustomerController cc = new CustomerController();
		int attempts = 3;
		boolean isLoggedIn = false;
		String role = "";
		String roleAssigned[] = new String[2];

		while (attempts > 0 && !isLoggedIn) {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println();
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter username:");
				String username = scanner.next();
				roleAssigned[0] = username;
				System.out.println("Enter password:");
				String password = scanner.next();
				try {
					if (ac.login(username, password)) {
						isLoggedIn = true;
						role = "admin";
					}
					// Check if customer login is successful
					else if (cc.login(username, password)) {
						isLoggedIn = true;
						role = "customer";
					} else {
						attempts--;
						System.out.println("Wrong Credentials..  Attempts left:" + attempts);
					}
				} catch (AuthenticationException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				System.out.println("Enter role (admin/customer):");
				String newRole = scanner.next();

				if (newRole.equalsIgnoreCase("admin")) {
					ac.registerAdmin();
				} else if (newRole.equalsIgnoreCase("customer")) {
					cc.registerCustomer();
				} else {
					System.out.println("Invalid role.");
				}
				break;
			}
			default:
				System.out.println("Invalid Choice..");
				break;
			}// end of switch

		} // end of while
		if (isLoggedIn) {
			System.out.println(
					"***************************************************************************************************************************");
			System.out.println(
					"***************************************************************************************************************************");
			System.out.println(
					"***************************************************************************************************************************");
			System.out.println(
					"************************************  WELCOME TO CAR CONNECT-A CAR RENTAL PLATFORM  ***************************************");
			System.out.println(
					"***************************************************************************************************************************");
			System.out.println(
					"***************************************************************************************************************************");
			System.out.println(
					"***************************************************************************************************************************");
			System.out.println();

			switch (role) {
			case "admin": {
				adminView.DisplayAdminPage(roleAssigned);
				break;
			}
			case "customer": {
				customerView.displayCustomerPage();
				break;
			} // end of customerPage

			default:
				System.out.println("Invalid Choice...");
				break;
			}
		} else {
			throw new AuthenticationException("Login Failed!..(Login after 120 sec).");
		}

		System.out.println("****************** Thank you for visting ***********************");
		System.exit(0);
	}

}
