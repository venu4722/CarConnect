package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.CustomerController;
import com.hexaware.controller.ReservationController;
import com.hexaware.controller.VehicleController;

/**
 * The CustomerView class provides methods to display the customer page and
 * handle customer operations.
 */
public class CustomerView {
	Scanner scanner = new Scanner(System.in);

	/**
	 * Displays the customer page and allows performing customer operations.
	 */
	public void displayCustomerPage() {
		String string = null;
		VehicleController vc = new VehicleController();
		CustomerController cc = new CustomerController();
		ReservationController rc = new ReservationController();
		do {
			System.out.println("1. Get Customers By CustomerId:");
			System.out.println("2. Get Customers By Customer Username:");
			System.out.println("3. Update Specific Customer:");
			System.out.println("4. Delete Specific Customer:");
			System.out.println("5. Get All The Available Vehicles:");
			System.out.println("6. Get Reservation Details By ReservationId");
			System.out.println("7. Get Reservation Details By Customer Username:");
			System.out.println("8. Update Specific Reservation:");
			System.out.println("Enter your Choice:");
			int ch = scanner.nextInt();
			switch (ch) {
			case 1: {
				cc.getCustomerById();
				break;
			}
			case 2: {
				cc.getCustomerByUsernameWithoutReturnType();
				break;
			}
			case 3: {
				cc.updateCustomer();
				break;
			}
			case 4: {
				cc.deleteCustomer();
				break;
			}
			case 5: {
				vc.getAvailableVehicles();
				break;
			}
			case 6: {
				rc.getReservationByID();
				break;
			}
			case 7: {
				rc.getReservationByCustomerId();
				break;
			}
			case 8: {
				rc.updateReservation();
				break;
			}
			default:
				System.out.println("Invalid choice..");
				break;
			}
			System.out.println("Do you want to see more in customerPage --(Type-y)");
			string = scanner.next();
		} while (string.equalsIgnoreCase("y"));
	}
}
