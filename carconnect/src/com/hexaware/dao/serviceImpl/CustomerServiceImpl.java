package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.hexaware.dao.service.ICustomerService;
import com.hexaware.model.Customer;
import com.hexaware.util.DBConnection;

/**
 * Implementation of the ICustomerService interface for managing customer
 * operations in the database.
 */
public class CustomerServiceImpl implements ICustomerService {

	/**
	 * Retrieves customer information by ID from the database.
	 * 
	 * @param customerID The unique identifier of the customer.
	 * @return A Customer object containing the details of the customer with the
	 *         specified ID.
	 */
	@Override
	public Customer getCustomerByID(int customerID) {
		Customer customer = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE customerid=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Create Customer object with retrieved details
				System.out.println("Customer FirstName: "+ rs.getString(2));
				System.out.println("Customer LastName: "+ rs.getString(3));
				System.out.println("Customer Email: "+ rs.getString(4));
				System.out.println("Customer Phone Number: "+ rs.getString(5));
				System.out.println("Customer Address: "+ rs.getString(6));
				System.out.println("Customer Username: "+ rs.getString(7));
				System.out.println("Customer RegistrationDate:"+ rs.getDate(9));
		
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	/**
	 * Retrieves and prints details of a customer by ID without returning any value.
	 * 
	 * @param customerID The ID of the customer to retrieve details for.
	 */
	@Override
	public void getCustomerByIDWithoutReturnType(int customerID) {
	    try {
	        Connection con = DBConnection.getCon();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE customerid=?");
	        ps.setInt(1, customerID);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            // Print customer details retrieved from the database
	            System.out.println(rs.getString(2)); // Assuming this is first name
	            System.out.println(rs.getString(3)); // Assuming this is last name
	            System.out.println(rs.getString(4)); // Assuming this is email
	            System.out.println(rs.getString(5)); // Assuming this is phone number
	            System.out.println(rs.getString(6)); // Assuming this is username
	            System.out.println(rs.getString(7)); // Assuming this is password
	            System.out.println(rs.getDate(9));   // Assuming this is join date
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	/**
	 * Retrieves customer information by username from the database.
	 * 
	 * @param userName The username of the customer.
	 * @return A Customer object containing the details of the customer with the
	 *         specified username.
	 */
	@Override
	public Customer getCustomerByUsername(String userName) {
		Customer customer = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE username=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Create Customer object with retrieved details
				
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	/**
	 * Retrieves and prints details of a customer by username without returning any value.
	 * 
	 * @param userName The username of the customer to retrieve details for.
	 */
	@Override
	public void getCustomerByUsernameWithoutReturnType(String userName) {
	    try {
	        Connection con = DBConnection.getCon();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE username=?");
	        ps.setString(1, userName);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            // Print customer details retrieved from the database
	            System.out.println("Customer FirstName: " + rs.getString(2));
	            System.out.println("Customer LastName: " + rs.getString(3));
	            System.out.println("Customer Email: " + rs.getString(4));
	            System.out.println("Customer Phone Number: " + rs.getString(5));
	            System.out.println("Customer Address: " + rs.getString(6));
	            System.out.println("Customer Username: " + rs.getString(7));
	            System.out.println("Customer RegistrationDate: " + rs.getDate(9));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	/**
	 * Registers a new customer in the database.
	 * 
	 * @param customer The Customer object containing the details of the customer to
	 *                 be registered.
	 */
	@Override
	public void registerCustomer(Customer customer) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, customer.getCustomerID());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPhoneNumber());
			ps.setString(6, customer.getAddress());
			ps.setString(7, customer.getUserName());
			ps.setString(8, customer.getPassword());
			ps.setDate(9, new java.sql.Date(customer.getRegistrationDate().getTime()));
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Customer Registered Successfully...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates the information of an existing customer in the database.
	 * 
	 * @param customer The Customer object containing the updated details of the
	 *                 customer.
	 */
	@Override
	public void updateCustomer(Customer customer) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con
					.prepareStatement("UPDATE customer SET email=?, phonenumber=? WHERE customerid=?");
			ps.setString(1, customer.getEmail());
			ps.setString(2, customer.getPhoneNumber());
			ps.setInt(3, customer.getCustomerID());
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Customer Updated Successfully...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a customer from the database based on the customer ID.
	 * 
	 * @param customerID The unique identifier of the customer to be deleted.
	 */
	@Override
	public void deleteCustomer(int customerID) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE customerid=?");
			ps.setInt(1, customerID);
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Customer deleted Successfully...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Retrieves and prints details of customers along with their reservation status.
	 * 
	 * This method retrieves details of customers along with their reservation status from the database
	 * and prints them.
	 */
	@Override
	public void getCustomerDetailsAndTheirReservationStatus() {
	    try {
	        Connection con = DBConnection.getCon();
	        Statement s = con.createStatement();
	        ResultSet rs = s.executeQuery("SELECT CONCAT(c.firstname, ' ', c.lastname), r.status "
	                                    + "FROM customer c "
	                                    + "JOIN reservation r "
	                                    + "ON c.customerid = r.customerid");
	        while (rs.next()) {
	            System.out.println("Customer FullName: " + rs.getString(1));
	            System.out.println("Customer Reservation Status: " + rs.getString(2));
	            System.out.println("------------------------------------------------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	/**
	 * Retrieves the ID of a customer with the username 'shiva12'.
	 * 
	 * @return The ID of the customer with the username 'shiva12', or 0 if not found.
	 */
	public int getIdFromCustomer() {
	    int customerId = 0;
	    try {
	        Connection connection = DBConnection.getCon();
	        Statement statement = connection.createStatement();
	        ResultSet rSet = statement.executeQuery("SELECT customerid FROM customer WHERE username='venu12'");
	        if (rSet.next()) {
	            customerId = rSet.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return customerId;
	}

	
	/**
	 * Retrieves the name of the customer with ID 2.
	 * 
	 * @return The name of the customer with ID 2, or null if not found.
	 */
	public String getCustomerNameBYId() {
	    String customerName = null;
	    try {
	        Connection connection = DBConnection.getCon();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT firstname FROM customer WHERE customerid = 2");
	        if (resultSet.next()) {
	            customerName = resultSet.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return customerName;
	}


}
