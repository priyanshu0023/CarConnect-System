package com.hexaware.entity;

import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCustomerAuthentication {

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
    public void testCustomerAuthenticationWithInvalidCredentials() throws SQLException {
        String username = "invalidUser";
        String password = "invalidPass";
        String query = "SELECT * FROM customer WHERE username = ? AND password = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        assertFalse(rs.next(), "Authentication should fail for invalid credentials");
    }
}
