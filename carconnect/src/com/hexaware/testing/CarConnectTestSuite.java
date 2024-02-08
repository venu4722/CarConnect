package com.hexaware.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The CarConnectTestSuite class represents a test suite that includes multiple
 * test classes.
 */
@RunWith(Suite.class)
@SuiteClasses({ AdminTest.class, // Include AdminTest class in the test suite
		CustomerTest.class, // Include CustomerTest class in the test suite
		ReservationTest.class, // Include ReservationTest class in the test suite
		VehicleTest.class // Include VehicleTest class in the test suite
})
public class CarConnectTestSuite {

}
