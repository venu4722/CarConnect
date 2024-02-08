package com.hexaware.testing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.AdminController;

/**
 * The AdminTest class contains unit tests for the AdminController class.
 */
public class AdminTest {
	AdminController adminController;

	/**
	 * Sets up the test environment before each test case.
	 */
	@Before
	public void setUp() {
		adminController = new AdminController();
	}

	/**
	 * Tests the getAdminRole method of AdminController class.
	 */
	@Test
	public void testAdminRole() {
		assertEquals("super admin", adminController.getAdminRole("raju12"));
	}

	/**
	 * Tears down the test environment after each test case.
	 */
	@After
	public void tearDown() {
		adminController = null;
	}
}
