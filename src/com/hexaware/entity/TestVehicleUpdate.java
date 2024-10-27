package com.hexaware.entity;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestVehicleUpdate {

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
    public void testUpdatingVehicleDetails() throws SQLException {
        String updateSQL = "UPDATE vehicle SET dailyrate = ? WHERE registrationnumber = ?";
        PreparedStatement stmt = connection.prepareStatement(updateSQL);
        stmt.setDouble(1, 120.0);
        stmt.setString(2, "REG123TEST"); // Assuming this registration number exists

        int rowsUpdated = stmt.executeUpdate();
        assertEquals(1, rowsUpdated, "Vehicle daily rate should be updated");

        // Verify update
        String selectSQL = "SELECT dailyrate FROM vehicle WHERE registrationnumber = ?";
        PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
        selectStmt.setString(1, "REG123TEST");
        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            assertEquals(120.0, rs.getDouble("dailyrate"), "Vehicle daily rate should be updated to 120.0");
        }
    }
}
