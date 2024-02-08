package com.hexaware.reportgenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.util.DBConnection;

public class ReportGenerator {
    // Method to generate and print a report
    public void generateReport() throws SQLException {
        try {
            // Retrieve reservation data from the database
             ResultSet reservationResultSet = getReservationData();
           
            // Retrieve vehicle data from the database
             ResultSet vehicleResultSet= getVehicleData();

            // Process and format the data into a report
            System.out.println("Reservation Details...");
            System.out.println("-------------------------");
            while (reservationResultSet.next()) {
                int reservationID = reservationResultSet.getInt("ReservationID");
                int customerID = reservationResultSet.getInt("CustomerID");
                int vehicleID = reservationResultSet.getInt("VehicleID");
                String startDate = reservationResultSet.getString("StartDate");
                String endDate = reservationResultSet.getString("EndDate");
                double totalCost = reservationResultSet.getDouble("TotalCost");
                String status = reservationResultSet.getString("Status");

                System.out.println("Reservation ID: " + reservationID);
                System.out.println("Customer ID: " + customerID);
                System.out.println("Vehicle ID: " + vehicleID);
                System.out.println("Start Date: " + startDate);
                System.out.println("End Date: " + endDate);
                System.out.println("Total Cost: " + totalCost);
                System.out.println("Status: " + status);
                System.out.println("-------------------------");
            }
            System.out.println("Vehicle Details...");
            System.out.println("-------------------------");
            while(vehicleResultSet.next()) {
            	System.out.println("VehicleID:" + vehicleResultSet.getInt(1));
            	System.out.println("VehicleModel: "+ vehicleResultSet.getString(2));
            	System.out.println("VehicleMake:" + vehicleResultSet.getString(3));
            	System.out.println("VehicleYear:"+ vehicleResultSet.getInt(4));
            	System.out.println("VehicleColor:"+ vehicleResultSet.getString(5));
            	System.out.println("VehicleRegistrationNumber:"+ vehicleResultSet.getString(6));
            	System.out.println("isVehicleAvailable:"+ vehicleResultSet.getBoolean(7));
            	System.out.println("VehicleDailyRate:" + vehicleResultSet.getDouble(8));
            	 System.out.println("-------------------------");
            }

            // Close result sets and statements
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve reservation data from the database
    private ResultSet getReservationData() throws SQLException {
    	Connection con=DBConnection.getCon();
        String query = "SELECT * FROM Reservation";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    // Method to retrieve vehicle data from the database
    private ResultSet getVehicleData() throws SQLException {
    	Connection con=DBConnection.getCon();
        String query = "SELECT * FROM Vehicle";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

}
