package com.hexaware.entity;

public class InvalidInputException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
        super("Invalid input data provided.");
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
