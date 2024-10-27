package com.hexaware.entity;

public class AdminNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException() {
        super("Admin user not found.");
    }

    public AdminNotFoundException(String message) {
        super(message);
    }

    public AdminNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdminNotFoundException(Throwable cause) {
        super(cause);
    }
}
