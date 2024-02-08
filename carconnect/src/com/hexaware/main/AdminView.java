package com.hexaware.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.hexaware.controller.AdminController;
import com.hexaware.controller.CustomerController;
import com.hexaware.controller.ReservationController;
import com.hexaware.controller.VehicleController;
import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.reportgenerator.ReportGenerator;

/**
 * The AdminView class provides methods to display the admin page and handle
 * admin operations.
 */
public class AdminView {
	Scanner scanner = new Scanner(System.in);
	AdminController ac = new AdminController();
	VehicleController vc = new VehicleController();
	CustomerController cc = new CustomerController();
	ReservationController rc = new ReservationController();
	ReportGenerator rGenerator = new ReportGenerator();

	/**
	 * Displays the admin page based on the assigned role and allows performing
	 * admin operations.
	 * 
	 * @param roleAssigned The role assigned to the admin.
	 * @throws ParseException         When parsing fails.
	 * @throws AdminNotFoundException When admin is not found.
	 */
	public void DisplayAdminPage(String[] roleAssigned) throws ParseException, AdminNotFoundException {
		String string = null;
		do {
			String role = ac.getAdminRole(roleAssigned[0]);
			System.out.println("=====> Role Assigned:: " + role);
			System.out.println("--------------------------------");
			switch (role) {
			case "super admin": {
				// Display options for super admin
				System.out.println("1. Update the Admin Details.");
				System.out.println("2. Delete the Admin..");
				System.out.println("3. Add a Vehicle ");
				System.out.println("4. Update a Vehicle ");
				System.out.println("5. Delete a Vehicle ");
				System.out.println("6. Update a Specific Customer ");
				System.out.println("7. Delete a Specific Customer ");
				System.out.println("8. Create a Reservation for specific vehicle for a customer ");
				System.out.println("9. Update a Reservation of particular Vehicle");
				System.out.println("10. Cancel Reservation of specific vehicle for a customer ");
				System.out.println("Enter your choice.");
				int ch = scanner.nextInt();
				switch (ch) {
				case 1: {
					ac.updateAdmin();
					break;
				}
				case 2: {
					ac.deleteAdmin();
					break;
				}
				case 3: {
					vc.addVehicle();
					break;
				}
				case 4: {
					vc.updateVehicle();
					break;
				}
				case 5: {
					vc.removeVehicle();
					break;
				}
				case 6: {
					cc.updateCustomer();
					break;
				}
				case 7: {
					cc.deleteCustomer();
					break;
				}
				case 8: {
					rc.createReservation();
					break;
				}
				case 9: {
					rc.updateReservation();
					break;
				}
				case 10: {
					rc.cancelReservation();
					break;
				}
				default:
					System.out.println("Invalid Choice..");
					break;
				}
				break;
			}
			case "fleet manager": {
				// Display options for fleet manager
				System.out.println("1. Get the Admin by AdminID (Enter AdminId)..");
				System.out.println("2. Get the Admin Details by Admin Username(Enter AdminUsername)");
				System.out.println("3. Get All Customer Details and their Reservation Status");
				System.out.println("4. Retrieve Total Cost of Reservation from Each Customer where totalcost>1000");
				System.out.println("5. Generate a Overall Report for Reservations && Vehicles");
				System.out.println("Enter your choice");
				int ch = scanner.nextInt();
				switch (ch) {
				case 1: {
					ac.getAdminById();
					break;
				}
				case 2: {
					ac.getAdminByUsernameWithoutReturnType();
					break;
				}
				case 3: {
					cc.getCustomerDetailsAndTheirReservationStatus();
					break;
				}
				case 4: {
					rc.getTotalCostForCustomers();
					break;
				}
				case 5: {
					try {
						rGenerator.generateReport();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				default:
					System.out.println("Invalid choice..");
					break;
				}
				break;
			}
			default: {
				System.out.println("Invalid choice.");
				break;
			}
			}
			System.out.println("Do you want to see more in AdminPage--(Type-Y)");
			string = scanner.next();
		} while (string.equalsIgnoreCase("y"));
	}
}
