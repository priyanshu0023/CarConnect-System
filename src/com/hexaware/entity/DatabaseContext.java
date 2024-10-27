package com.hexaware.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseContext {
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                // Replace with actual database connection details
                String url = "jdbc:mysql://localhost:3306/car_rental";
                String username = "root";
                String password = "password";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
