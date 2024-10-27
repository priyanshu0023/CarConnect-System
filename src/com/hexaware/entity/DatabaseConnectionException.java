package com.hexaware.entity;

public class DatabaseConnectionException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseConnectionException() {
        super("Database connection error occurred.");
    }

    public DatabaseConnectionException(String message) {
        super(message);
    }

    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseConnectionException(Throwable cause) {
        super(cause);
    }
}
