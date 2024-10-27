package com.hexaware.entity;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestVehicleAvailability {

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
    public void testGettingAvailableVehicles() throws SQLException {
        String selectSQL = "SELECT * FROM vehicle WHERE availability = true";
        PreparedStatement stmt = connection.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();

        assertTrue(rs.next(), "At least one vehicle should be available");
        while (rs.next()) {
            assertTrue(rs.getBoolean("availability"), "Vehicle should be available");
        }
    }
}
