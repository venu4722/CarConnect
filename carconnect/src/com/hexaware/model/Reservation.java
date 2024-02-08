package com.hexaware.model;

import java.util.Date;

/**
 * Represents a reservation made by a customer for a vehicle.
 */
public class Reservation {
	private int reservationID;
	private Customer customer;
	private Vehicle vehicle;
	private Date startDate;
	private Date endDate;
	private double totalCost;
	private String status;

	/**
	 * Default constructor.
	 */
	public Reservation() {
	}

	/**
	 * Parameterized constructor to initialize a Reservation object.
	 * 
	 * @param reservationID The ID of the reservation.
	 * @param customer      The customer making the reservation.
	 * @param vehicle       The vehicle reserved.
	 * @param startDate     The start date of the reservation.
	 * @param endDate       The end date of the reservation.
	 * @param totalCost     The total cost of the reservation.
	 * @param status        The status of the reservation.
	 */
	public Reservation(int reservationID, Customer customer, Vehicle vehicle, Date startDate, Date endDate,
			double totalCost, String status) {
		this.reservationID = reservationID;
		this.customer = customer;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalCost = totalCost;
		this.status = status;
	}

	// Getters and setters for Reservation attributes

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", customer=" + customer + ", vehicle=" + vehicle
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalCost=" + totalCost + ", status="
				+ status + "]";
	}
	
	
}
