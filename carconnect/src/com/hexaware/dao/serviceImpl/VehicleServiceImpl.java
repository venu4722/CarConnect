package com.hexaware.dao.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.dao.service.IVehicleService;
import com.hexaware.model.Vehicle;
import com.hexaware.util.DBConnection;

/**
 * Implementation of the IVehicleService interface for managing vehicle
 * operations in the database.
 */
public class VehicleServiceImpl implements IVehicleService {

	/**
	 * Retrieves vehicle information by vehicle ID from the database.
	 * 
	 * @param vehicleID The unique identifier of the vehicle.
	 * @return The Vehicle object containing the details of the vehicle with the
	 *         specified ID.
	 */
	@Override
	public Vehicle getVehicleByID(int vehicleID) {
		Vehicle vehicle = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM vehicle WHERE vehicleid=?");
			ps.setInt(1, vehicleID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Create a new Vehicle object with retrieved data
				vehicle = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7), rs.getDouble(8));
				// Display vehicle details
//				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4)
//						+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getBoolean(7) + "\t"
//						+ rs.getDouble(8));
				System.out.println("Vehicle Id: "+ rs.getInt(1));
				System.out.println("Vehicle Model: "+ rs.getString(2));
				System.out.println("Vehicle Make: "+ rs.getString(3));
				System.out.println("Vehicle year: "+ rs.getInt(4));
				System.out.println("Vehicle Color:" + rs.getString(5));
				System.out.println("Vehcile RegistrationNumber:" + rs.getString(6));
				System.out.println("Is Vehicle Available: "+ rs.getBoolean(7));
				System.out.println("Vehicle DailyRate:"+ rs.getDouble(8));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}

	/**
	 * Retrieves all available vehicles from the database.
	 */
	@Override
	public void getAvailableVehicles() {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM vehicle");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// Display vehicle details
//				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4)
//						+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getBoolean(7) + "\t"
//						+ rs.getDouble(8));
				System.out.println("Vehicle Id: "+ rs.getInt(1));
				System.out.println("Vehicle Model: "+ rs.getString(2));
				System.out.println("Vehicle Make: "+ rs.getString(3));
				System.out.println("Vehicle year: "+ rs.getInt(4));
				System.out.println("Vehicle Color:" + rs.getString(5));
				System.out.println("Vehcile RegistrationNumber:" + rs.getString(6));
				System.out.println("Is Vehicle Available: "+ rs.getBoolean(7));
				System.out.println("Vehicle DailyRate:"+ rs.getDouble(8));
				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new vehicle to the database.
	 * 
	 * @param vehicle The Vehicle object containing the details of the new vehicle.
	 */
	@Override
	public void addVehicle(Vehicle vehicle) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO vehicle VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1, vehicle.getVehicleID());
			ps.setString(2, vehicle.getModel());
			ps.setString(3, vehicle.getMake());
			ps.setInt(4, vehicle.getYear());
			ps.setString(5, vehicle.getColor());
			ps.setString(6, vehicle.getRegistrationNumber());
			ps.setBoolean(7, vehicle.isAvailable());
			ps.setDouble(8, vehicle.getDailyRate());
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Vehicle Registered Successfully...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates an existing vehicle in the database.
	 * 
	 * @param vehicle The Vehicle object containing the updated details of the
	 *                vehicle.
	 */
	@Override
	public void updateVehicle(Vehicle vehicle) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE vehicle SET color=?, dailyrate=? WHERE vehicleid=?");
			ps.setString(1, vehicle.getColor());
			ps.setDouble(2, vehicle.getDailyRate());
			ps.setInt(3, vehicle.getVehicleID());
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Vehicle Updated Successfully...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a vehicle from the database based on the vehicle ID.
	 * 
	 * @param vehicleID The unique identifier of the vehicle to be deleted.
	 */
	@Override
	public void deleteVehicle(int vehicleID) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM vehicle WHERE vehicleid=?");
			ps.setInt(1, vehicleID);
			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Vehicle Deleted Successfully...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retrieves the make of the vehicle with ID 1.
	 * 
	 * @return The make of the vehicle with ID 1, or null if not found.
	 */
	public String getVehicleMake() {
	    String make = null;
	    try {
	        Connection connection = DBConnection.getCon();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT make FROM vehicle WHERE vehicleid = 1");
	        if (resultSet.next()) {
	            make = resultSet.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return make;
	}

}
