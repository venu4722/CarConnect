package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Utility class for managing database connections.
 */
public class DBConnection {
	private static Connection con = null;

	// Private constructor to prevent instantiation
	private DBConnection() {
	}

	// Static block to initialize the database connection
	static {
		try {
			// Load the MySQL JDBC driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish a connection to the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carconnect", "root", "admin");
		} catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}


	/**
	 * Retrieves the database connection.
	 * 
	 * @return The database connection.
	 */
	public static Connection getCon() {
		return con;
	}
}
