package com.hexaware.controller;


import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hexaware.dao.serviceImpl.CustomerServiceImpl;
import com.hexaware.dao.serviceImpl.ReservationServiceImpl;
import com.hexaware.dao.serviceImpl.VehicleServiceImpl;
import com.hexaware.exception.ReservationException;
import com.hexaware.model.Customer;
import com.hexaware.model.Reservation;
import com.hexaware.model.Vehicle;

/**
 * Controller class to handle reservation-related operations and interactions.
 */
public class ReservationController {
	Scanner scanner = new Scanner(System.in);
	ReservationServiceImpl dao = new ReservationServiceImpl();

	/**
	 * Retrieves reservation information by reservation ID.
	 */
	public void getReservationByID() {
		System.out.println("Enter the ReservationID:");
		int resvID = scanner.nextInt();
		dao.getReservationByID(resvID);
	}

	/**
	 * Retrieves reservation information by customer ID.
	 */
	public void getReservationByCustomerId() {
		System.out.println("Enter the customerID");
		int custID = scanner.nextInt();
		dao.getReservationByCustomerID(custID);
	}

	CustomerServiceImpl daoCustomerServiceImpl = new CustomerServiceImpl();
	VehicleServiceImpl daovVehicleServiceImpl = new VehicleServiceImpl();

	/**
	 * Creates a new reservation.
	 * @throws ParseException when date format is wrong
	 */
	public void createReservation() throws ParseException {
		System.out.println("Enter the reservationID:");
		int resvID = scanner.nextInt();
		System.out.println("Enter CustomerID:");
		int customerId = scanner.nextInt();
		Customer customer = daoCustomerServiceImpl.getCustomerByID(customerId);
		if (customer == null) {
			System.out.println("Customer with ID " + customerId + " does not exist. Unable to create reservation.");
			return;
		}
		System.out.println("Enter vehicleId:");
		int vehicleId = scanner.nextInt();
		Reservation reservation=dao.getReservationByVehicleId(vehicleId);
		boolean validVehicleId = false;
		while (!validVehicleId) {
		    try {
		        if (reservation != null) {
		            throw new ReservationException("OOPS!!!.. Vehicle already Reserved By Other Customer");
		        }
		        validVehicleId = true; // Set flag to true if the vehicle is available
		    } catch (ReservationException re) {
		        System.out.println(re.getMessage());
		        System.out.println("Enter vehicleId:");
		        vehicleId = scanner.nextInt();
		        reservation = dao.getReservationByVehicleId(vehicleId); // Query reservation for the new vehicleId
		    }
		}
		Vehicle vehicle = daovVehicleServiceImpl.getVehicleByID(vehicleId);
		if (vehicle == null) {
			System.out.println("Vehicle with Id " + vehicleId + "does not exist. Unable to create reservation.");
			return;
		}
		
		Date startDate = new java.util.Date();
		
		System.out.println("Enter end date (yyyy-MM-dd):"); // Prompt user to enter end date
        String endDateStr = scanner.next();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = dateFormat.parse(endDateStr);
		System.out.println("Enter totalCost:");
		Double totalCost = scanner.nextDouble();
		System.out.println("Enter the status");
		String status = scanner.next();
		reservation = new Reservation(resvID, customer, vehicle, startDate, endDate, totalCost, status);
		dao.createReservation(reservation);
	}

	/**
	 * Updates an existing reservation.
	 */
	public void updateReservation() {
		System.out.println("enter reservationID:");
		int resvID = scanner.nextInt();
		System.out.println("enter totalCost:");
		double totalCost = scanner.nextDouble();
		System.out.println("Enter the Status:");
		String status = scanner.next();
		Reservation reservation = new Reservation();
		reservation.setReservationID(resvID);
		reservation.setTotalCost(totalCost);
		reservation.setStatus(status);
		dao.updateReservation(reservation);
	}

	/**
	 * Cancels a reservation by reservation ID.
	 */
	public void cancelReservation() {
		System.out.println("Enter the reservationID:");
		int resvID = scanner.nextInt();
		dao.cancelReservation(resvID);
	}
	
	/**
	 * Calculates the total cost for all customers.
	 */
	public void getTotalCostForCustomers() {
	    dao.getTotalCostForCustomer();
	}

	/**
	 * Retrieves the registration number from the reservation.
	 * 
	 * @return The registration number from the reservation.
	 */
	public String getRegistrationNumberFromReservation() {
	    return dao.getRegistrationNumberFromReservation();
	}

	/**
	 * Retrieves the customer name from the reservation.
	 * 
	 * @return The customer name from the reservation.
	 */
	public String getCustomerNameFromReservation() {
	    return dao.getCustomerNameFromReservation();
	}

}
