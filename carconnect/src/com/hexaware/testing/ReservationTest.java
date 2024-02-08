package com.hexaware.testing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.ReservationController;

/**
 * The ReservationTest class contains unit tests for the ReservationController
 * class.
 */
public class ReservationTest {
	ReservationController reservationController;

	/**
	 * Sets up the test environment before each test case.
	 */
	@Before
	public void setUp() {
		reservationController = new ReservationController();
	}

	/**
	 * Tests the getRegistrationNumberFromReservation method of
	 * ReservationController class.
	 */
	@Test
	public void testVehicleMake() {
		assertEquals("MBZ123", reservationController.getRegistrationNumberFromReservation());
	}

	/**
	 * Tests the getCustomerNameFromReservation method of ReservationController
	 * class.
	 */
	@Test
	public void getCustomerFromReservation() {
		assertEquals("Suresh Kumar", reservationController.getCustomerNameFromReservation());
	}

	/**
	 * Tears down the test environment after each test case.
	 */
	@After
	public void tearDown() {
		reservationController = null;
	}
}
