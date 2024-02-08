package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.dao.service.IAdminService;

import com.hexaware.model.Admin;
import com.hexaware.util.DBConnection;

/**
 * Implementation of the IAdminService interface for managing admin operations
 * in the database.
 */
public class AdminServiceImpl implements IAdminService {

	/**
	 * Retrieves admin information by ID from the database.
	 * 
	 * @param adminID The unique identifier of the admin.
	 */
	@Override
	public Admin getAdminByID(int adminID) {
		Admin admin = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE adminid=?");
			ps.setInt(1, adminID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Output admin details
				System.out.println("Admin ID: " + rs.getInt(1));
				System.out.println("First Name: " + rs.getString(2));
				System.out.println("Last Name: " + rs.getString(3));
				System.out.println("Email: " + rs.getString(4));
				System.out.println("Phone Number: " + rs.getString(5));
				System.out.println("Username: " + rs.getString(6));
				System.out.println("Password: " + rs.getString(7));
				System.out.println("Role: " + rs.getString(8));
				System.out.println("Registration Date: " + rs.getDate(9));
			}
			admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;

	}

	/**
	 * Retrieves admin information by username from the database.
	 * 
	 * @param username The username of the admin.
	 * @return An Admin object containing the details of the admin with the
	 *         specified username.
	 */
	@Override
	public Admin getAdminByUsername(String username) {
		Admin admin = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Create Admin object with retrieved details

				admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	/**
	 * Retrieves and prints details of an admin by username without returning any
	 * value.
	 * 
	 * @param username The username of the admin to retrieve details for.
	 */
	@Override
	public void getAdminByUsernameWithoutReturnType(String username) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Print admin details retrieved from the database
				System.out.println("Admin FirstName: " + rs.getString(2));
				System.out.println("Admin LastName: " + rs.getString(3));
				System.out.println("Admin Email: " + rs.getString(4));
				System.out.println("Admin Phone Number: " + rs.getString(5));
				System.out.println("Admin UserName: " + rs.getString(6));
				System.out.println("Admin Role: " + rs.getString(8));
				System.out.println("Admin JoinDate: " + rs.getDate(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Registers a new admin in the database.
	 * 
	 * @param admin The Admin object containing the details of the admin to be
	 *              registered.
	 */
	@Override
	public void registerAdmin(Admin admin) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO admin VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, admin.getAdminID());
			ps.setString(2, admin.getFirstName());
			ps.setString(3, admin.getLastName());
			ps.setString(4, admin.getEmail());
			ps.setString(5, admin.getPhoneNumber());
			ps.setString(6, admin.getUserName());
			ps.setString(7, admin.getPassword());
			ps.setString(8, admin.getRole());
			ps.setDate(9, new java.sql.Date(admin.getJoinDate().getTime()));
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Admin Registered Successfully...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates the information of an existing admin in the database.
	 * 
	 * @param admin The Admin object containing the updated details of the admin.
	 */
	@Override
	public void updateAdmin(Admin admin) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE admin SET email=?, phonenumber=? WHERE adminid=?");
			ps.setString(1, admin.getEmail());
			ps.setString(2, admin.getPhoneNumber());
			ps.setInt(3, admin.getAdminID());
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Admin Updated Successfully...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an admin from the database based on the admin ID.
	 * 
	 * @param adminID The unique identifier of the admin to be deleted.
	 */
	@Override
	public int deleteAdmin(int adminID) {
		int temp = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM admin WHERE adminid=?");
			ps.setInt(1, adminID);
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Admin deleted Successfully...");
				temp++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 * Retrieves the role of an admin based on the username.
	 * 
	 * @param username The username of the admin.
	 * @return The role of the admin.
	 */
	@Override
	public String getAdminRole(String username) {
		String role = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT role FROM admin WHERE username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				role = rs.getString("role");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

}
