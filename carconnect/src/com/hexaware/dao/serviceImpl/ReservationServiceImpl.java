package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.dao.service.IReservationService;
import com.hexaware.emailservice.EmailService;
import com.hexaware.model.Reservation;
import com.hexaware.util.DBConnection;

/**
 * Implementation of the IReservationService interface for managing reservation
 * operations in the database.
 */
public class ReservationServiceImpl implements IReservationService {
	CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
	VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();

	/**
	 * Retrieves reservation information by reservation ID from the database.
	 * 
	 * @param reservationID The unique identifier of the reservation.
	 */
	@Override
	public void getReservationByID(int reservationID) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM reservation WHERE reservationid=?");
			ps.setInt(1, reservationID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Display reservation details
//				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getDate(4)
//						+ "\t" + rs.getDate(5) + "\t" + rs.getDouble(6) + "\t" + // TotalCost
//						rs.getString(7)); // Status
				System.out.println("Customer Details: " + rs.getInt(2));
				System.out.println(customerServiceImpl.getCustomerByID(rs.getInt(2)));
				System.out.println("Vehicle Details: " + rs.getInt(3));
				System.out.println(vehicleServiceImpl.getVehicleByID(rs.getInt(3)));
				System.out.println("Reservation Start Date: " + rs.getDate(4));
				System.out.println("Reservation End Date:" + rs.getDate(5));
				System.out.println("Total Cost of Reservation: " + rs.getDouble(6));
				System.out.println("Status of Reservation: " + rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves reservations made by a specific customer from the database.
	 * 
	 * @param customerID The unique identifier of the customer.
	 */
	@Override
	public void getReservationByCustomerID(int customerID) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(
					"SELECT ReservationID, CustomerID, VehicleID, StartDate, EndDate, TotalCost, Status FROM reservation WHERE customerid=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Display reservation details
//				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getDate(4)
//						+ "\t" + rs.getDate(5) + "\t" + rs.getDouble(6) + "\t" + rs.getString(7));
				System.out.println("Customer Details: " + rs.getInt(2));
				System.out.println(customerServiceImpl.getCustomerByID(rs.getInt(2)));
				System.out.println("Vehicle Details: " + rs.getInt(3));
				System.out.println(vehicleServiceImpl.getVehicleByID(rs.getInt(3)));
				System.out.println("Reservation Start Date: " + rs.getDate(4));
				System.out.println("Reservation End Date:" + rs.getDate(5));
				System.out.println("Total Cost of Reservation " + rs.getDouble(6));
				System.out.println("Status of Reservation " + rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a new reservation in the database.
	 * 
	 * @param reservation The Reservation object containing the details of the new
	 *                    reservation.
	 */
	@Override
	public void createReservation(Reservation reservation) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO reservation VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, reservation.getReservationID());
			ps.setObject(2, reservation.getCustomer().getCustomerID());
			ps.setObject(3, reservation.getVehicle().getVehicleID());
			ps.setDate(4, new java.sql.Date(reservation.getStartDate().getTime())); // Assuming startDate is a
																					// java.util.Date
			ps.setDate(5, new java.sql.Date(reservation.getEndDate().getTime())); // Assuming endDate is a
																					// java.util.Date
			ps.setDouble(6, reservation.getTotalCost());
			ps.setString(7, reservation.getStatus());
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Reservation Created Successfully..");
			}
			String subject = "Vehicle Reservation (CarConnect)";
//		        String body ="Your reservation for Vehicle Model: " +  reservation.getVehicle().getModel() + " from " + reservation.getStartDate() + " to " + reservation.getEndDate() + " is Successfully confirmed"
//		        		+ "Hello";
			String body = "Hi " + reservation.getCustomer().getFirstName() + ",\n\n"
					+ "Your reservation for Vehicle Model: " + reservation.getVehicle().getModel() + " from "
					+ reservation.getStartDate() + " to " + reservation.getEndDate() + " is successfully confirmed.\n\n"
					+ "Regards,\nCarConnect.";
			EmailService.sendConfirmationEmail(reservation.getCustomer().getEmail(), subject, body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates an existing reservation in the database.
	 * 
	 * @param reservation The Reservation object containing the updated details of
	 *                    the reservation.
	 */
	@Override
	public void updateReservation(Reservation reservation) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con
					.prepareStatement("UPDATE reservation SET totalcost=?,status=? WHERE reservationid=?");
			ps.setDouble(1, reservation.getTotalCost());
			ps.setString(2, reservation.getStatus());
			ps.setInt(3, reservation.getReservationID());
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Reservation Updated Successfully..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cancels a reservation in the database based on the reservation ID.
	 * 
	 * @param reservationID The unique identifier of the reservation to be canceled.
	 */
	@Override
	public void cancelReservation(int reservationID) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM reservation WHERE reservationid=?");
			ps.setInt(1, reservationID);
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Reservation Canceled Successfully..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves and prints the total cost of reservations for customers whose total
	 * cost exceeds 1000.
	 * 
	 * This method retrieves the total cost of reservations for customers whose
	 * total cost exceeds 1000 and prints the customer ID, name, and total cost of
	 * reservations.
	 */
	public void getTotalCostForCustomer() {
		try {
			Connection con = DBConnection.getCon();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT c.customerid, CONCAT(c.firstname, ' ', c.lastname) AS customerName, "
					+ "SUM(r.totalCost) AS total_cost " + "FROM customer c "
					+ "JOIN reservation r ON c.customerid = r.customerid " + "GROUP BY c.customerid "
					+ "HAVING SUM(r.totalCost) > 1000");
			while (rs.next()) {
				System.out.println("CustomerId: " + rs.getInt(1));
				System.out.println("CustomerName: " + rs.getString(2));
				System.out.println("Reservation Total Cost: " + rs.getDouble(3));
				System.out.println("--------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves a reservation associated with the specified vehicle ID.
	 * 
	 * @param vehicleId The ID of the vehicle.
	 * @return A Reservation object associated with the specified vehicle ID, or
	 *         null if not found.
	 */
	public Reservation getReservationByVehicleId(int vehicleId) {
		Reservation reservation = null;
		try {
			Connection connection = DBConnection.getCon();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM reservation WHERE vehicleid=?");
			ps.setInt(1, vehicleId);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				// Create a Reservation object with retrieved details
				reservation = new Reservation(rSet.getInt(1), customerServiceImpl.getCustomerByID(rSet.getInt(2)),
						vehicleServiceImpl.getVehicleByID(rSet.getInt(3)), rSet.getDate(4), rSet.getDate(5),
						rSet.getDouble(6), rSet.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}

	/**
	 * Retrieves the registration number of the vehicle associated with reservation
	 * ID 1.
	 * 
	 * @return The registration number of the vehicle associated with reservation ID
	 *         1, or null if not found.
	 */
	public String getRegistrationNumberFromReservation() {
		String registrationNumber = null;
		try {
			Connection connection = DBConnection.getCon();
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery("SELECT v.registrationnumber " + "FROM vehicle v "
					+ "JOIN reservation r ON v.vehicleid = r.vehicleid " + "WHERE r.vehicleid = 1");
			if (rSet.next()) {
				registrationNumber = rSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrationNumber;
	}

	/**
	 * Retrieves the full name of the customer associated with reservation ID 1.
	 * 
	 * @return The full name of the customer associated with reservation ID 1, or
	 *         null if not found.
	 */
	public String getCustomerNameFromReservation() {
		String custName = null;
		try {
			Connection connection = DBConnection.getCon();
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery("SELECT CONCAT(c.firstname, ' ', c.lastname) " + "FROM customer c "
					+ "JOIN reservation r ON c.customerid = r.customerid " + "WHERE r.customerid = 1;");
			if (rSet.next()) {
				custName = rSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custName;
	}

}
