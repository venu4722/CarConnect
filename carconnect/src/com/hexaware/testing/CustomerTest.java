package com.hexaware.testing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.CustomerController;

/**
 * The CustomerTest class contains unit tests for the CustomerController class.
 */
public class CustomerTest {
	CustomerController customerController;

	/**
	 * Sets up the test environment before each test case.
	 */
	@Before
	public void setUp() {
		customerController = new CustomerController();
	}

	/**
	 * Tests the getIdFromCustomer method of CustomerController class.
	 */
	@Test
	public void testCustomerById() {
		assertEquals(10, customerController.getIdFromCustomer());
	}

	/**
	 * Tests the getCustomerNameById method of CustomerController class.
	 */
	@Test
	public void testCustomerByName() {
		assertEquals("Priya", customerController.getCustomerNameById());
	}

	/**
	 * Tears down the test environment after each test case.
	 */
	@After
	public void tearDown() {
		customerController = null;
	}
}
