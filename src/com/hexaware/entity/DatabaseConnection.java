package com.hexaware.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    // MySQL Database Connection Parameters
    private static final String URL = "jdbc:mysql://localhost:3306/car_connect";
    private static final String USER = "root";
    private static final String PASSWORD = "2511200100#Mons";

    public Connection getConnection() throws DatabaseConnectionException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database successfully.");

        } catch (ClassNotFoundException e) {
            throw new DatabaseConnectionException("MySQL JDBC Driver not found.", e);
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Unable to connect to the database.", e);
        }

        return connection;
    }

    // Close the database connection
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed.");
        }
    }
}
