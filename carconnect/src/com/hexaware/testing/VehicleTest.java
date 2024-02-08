package com.hexaware.testing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.VehicleController;

/**
 * The VehicleTest class contains unit tests for the VehicleController class.
 */
public class VehicleTest {
	VehicleController vehicleController;

	/**
	 * Sets up the test environment before each test case.
	 */
	@Before
	public void setUp() {
		vehicleController = new VehicleController();
	}

	/**
	 * Tests the getVehicleMake method of VehicleController class.
	 */
	@Test
	public void testVehicleMake() {
		assertEquals("Mercedes-Benz", vehicleController.getVehicleMake());
	}

	/**
	 * Tears down the test environment after each test case.
	 */
	@After
	public void tearDown() {
		vehicleController = null;
	}
}
