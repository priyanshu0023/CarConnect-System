package com.hexaware.entity;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCustomerUpdate {

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
    public void testUpdatingCustomerInformation() throws SQLException {
        String updateSQL = "UPDATE customer SET firstname = ? WHERE customerid = ?";
        PreparedStatement stmt = connection.prepareStatement(updateSQL);
        stmt.setString(1, "UpdatedName");
        stmt.setInt(2, 1); // Assuming customer with ID 1 exists

        int rowsUpdated = stmt.executeUpdate();
        assertEquals(1, rowsUpdated, "Customer information should be updated");

        // Verify update
        String selectSQL = "SELECT firstname FROM customer WHERE customerid = ?";
        PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
        selectStmt.setInt(1, 1);
        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            assertEquals("UpdatedName", rs.getString("firstname"), "Customer name should be updated");
        }
    }
}
