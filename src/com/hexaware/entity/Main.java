package com.hexaware.entity;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static DatabaseConnection dbConnection = new DatabaseConnection();
    private static Connection connection = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // 1. Establish database connection
            connection = dbConnection.getConnection();
            
            boolean exit = false;

            // Menu Loop
            while (!exit) {
                System.out.println("\n--- Car Connect System ---");
                System.out.println("1. Add Customer");
                System.out.println("2. Add Vehicle");
                System.out.println("3. Create Reservation");
                System.out.println("4. Update Vehicle Availability");
                System.out.println("5. Delete Customer");
                System.out.println("6. Delete Reservation");
                System.out.println("7. View All Vehicles");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        addVehicle();
                        break;
                    case 3:
                        createReservation();
                        break;
                    case 4:
                        updateVehicleAvailability();
                        break;
                    case 5:
                        deleteCustomer();
                        break;
                    case 6:
                        deleteReservation();
                        break;
                    case 7:
                        viewAllVehicles();
                        break;
                    case 8:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            }
        } catch (DatabaseConnectionException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    dbConnection.closeConnection();
                }
            } catch (SQLException e) {
                System.out.println("Error closing the connection: " + e.getMessage());
            }
        }
    }

    // Add a new customer
    private static void addCustomer() throws SQLException {
        System.out.println("\n--- Add Customer ---");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        String insertCustomerSQL = "INSERT INTO customer (firstname, lastname, email, phonenumber, address, username, password, registrationdate) "
                                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertCustomerStmt = connection.prepareStatement(insertCustomerSQL);
        insertCustomerStmt.setString(1, firstName);
        insertCustomerStmt.setString(2, lastName);
        insertCustomerStmt.setString(3, email);
        insertCustomerStmt.setString(4, phoneNumber);
        insertCustomerStmt.setString(5, address);
        insertCustomerStmt.setString(6, username);
        insertCustomerStmt.setString(7, password);
        insertCustomerStmt.setTimestamp(8, new Timestamp(System.currentTimeMillis())); // Registration date as current timestamp

        int rowsInserted = insertCustomerStmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new customer was added successfully!");
        }
    }

    // Add a new vehicle
    private static void addVehicle() throws SQLException {
        System.out.println("\n--- Add Vehicle ---");
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Registration Number: ");
        String registrationNumber = scanner.nextLine();
        System.out.print("Daily Rate: ");
        double dailyRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        String insertVehicleSQL = "INSERT INTO vehicle (model, make, year, color, registrationnumber, availability, dailyrate) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertVehicleStmt = connection.prepareStatement(insertVehicleSQL);
        insertVehicleStmt.setString(1, model);
        insertVehicleStmt.setString(2, make);
        insertVehicleStmt.setInt(3, year);
        insertVehicleStmt.setString(4, color);
        insertVehicleStmt.setString(5, registrationNumber);
        insertVehicleStmt.setBoolean(6, true); // Default availability true
        insertVehicleStmt.setDouble(7, dailyRate);

        int rowsInserted = insertVehicleStmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new vehicle was added successfully!");
        }
    }

    // Create a new reservation
    private static void createReservation() throws SQLException {
        System.out.println("\n--- Create Reservation ---");
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Vehicle ID: ");
        int vehicleId = scanner.nextInt();
        System.out.print("Start Date (yyyy-mm-dd hh:mm:ss): ");
        scanner.nextLine(); // Consume newline
        String startDate = scanner.nextLine();
        System.out.print("End Date (yyyy-mm-dd hh:mm:ss): ");
        String endDate = scanner.nextLine();
        System.out.print("Total Cost: ");
        double totalCost = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        String insertReservationSQL = "INSERT INTO reservation (customerid, vehicleid, startdate, enddate, totalcost, status) "
                                    + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertReservationStmt = connection.prepareStatement(insertReservationSQL);
        insertReservationStmt.setInt(1, customerId);
        insertReservationStmt.setInt(2, vehicleId);
        insertReservationStmt.setString(3, startDate);
        insertReservationStmt.setString(4, endDate);
        insertReservationStmt.setDouble(5, totalCost);
        insertReservationStmt.setString(6, "confirmed"); // Default status confirmed

        int rowsInserted = insertReservationStmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new reservation was created successfully!");
        }
    }

    // Update vehicle availability
    private static void updateVehicleAvailability() throws SQLException {
        System.out.println("\n--- Update Vehicle Availability ---");
        System.out.print("Vehicle ID: ");
        int vehicleId = scanner.nextInt();
        System.out.print("Availability (true/false): ");
        boolean availability = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        String updateVehicleSQL = "UPDATE vehicle SET availability = ? WHERE vehicleid = ?";
        PreparedStatement updateVehicleStmt = connection.prepareStatement(updateVehicleSQL);
        updateVehicleStmt.setBoolean(1, availability);
        updateVehicleStmt.setInt(2, vehicleId);

        int rowsUpdated = updateVehicleStmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Vehicle availability updated successfully!");
        }
    }

    // Delete a customer by customer ID
    private static void deleteCustomer() throws SQLException {
        System.out.println("\n--- Delete Customer ---");
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String deleteCustomerSQL = "DELETE FROM customer WHERE customerid = ?";
        PreparedStatement deleteCustomerStmt = connection.prepareStatement(deleteCustomerSQL);
        deleteCustomerStmt.setInt(1, customerId);

        int rowsDeleted = deleteCustomerStmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Customer deleted successfully!");
        }
    }

    // Delete a reservation by reservation ID
    private static void deleteReservation() throws SQLException {
        System.out.println("\n--- Delete Reservation ---");
        System.out.print("Reservation ID: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String deleteReservationSQL = "DELETE FROM reservation WHERE reservationid = ?";
        PreparedStatement deleteReservationStmt = connection.prepareStatement(deleteReservationSQL);
        deleteReservationStmt.setInt(1, reservationId);

        int rowsDeleted = deleteReservationStmt.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Reservation deleted successfully!");
        }
    }

    // View all vehicles
    private static void viewAllVehicles() throws SQLException {
        System.out.println("\n--- All Vehicles ---");

        String selectVehicleSQL = "SELECT * FROM vehicle";
        PreparedStatement selectVehicleStmt = connection.prepareStatement(selectVehicleSQL);
        ResultSet vehicles = selectVehicleStmt.executeQuery();

        while (vehicles.next()) {
            int vehicleId = vehicles.getInt("vehicleid");
            String model = vehicles.getString("model");
            String make = vehicles.getString("make");
            int year = vehicles.getInt("year");
            String color = vehicles.getString("color");
            String registrationNumber = vehicles.getString("registrationnumber");
            boolean availability = vehicles.getBoolean("availability");
            double dailyRate = vehicles.getDouble("dailyrate");

            System.out.println("Vehicle ID: " + vehicleId + ", Model: " + model + ", Make: " + make + ", Year: " + year +
                               ", Color: " + color + ", Registration Number: " + registrationNumber + ", Availability: " + availability +
                               ", Daily Rate: $" + dailyRate);
        }
    }
}