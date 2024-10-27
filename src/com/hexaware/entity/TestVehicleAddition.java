package com.hexaware.entity;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestVehicleAddition {

    private static DatabaseConnection dbConnection = new DatabaseConnection();
    private static Connection connection = null;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        connection = dbConnection.getConnection();
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        if (connection != null) {
            dbConnection.closeConnection();
        }
    }

    @Test
    public void testAddingNewVehicle() throws SQLException {
        String insertSQL = "INSERT INTO vehicle (model, make, year, color, registrationnumber, availability, dailyrate) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(insertSQL);
        stmt.setString(1, "ModelTest");
        stmt.setString(2, "MakeTest");
        stmt.setInt(3, 2024);
        stmt.setString(4, "Red");
        stmt.setString(5, "REG123TEST");
        stmt.setBoolean(6, true); // Available
        stmt.setDouble(7, 100.0);

        int rowsInserted = stmt.executeUpdate();
        assertEquals(1, rowsInserted, "A new vehicle should be added successfully");
    }
}
