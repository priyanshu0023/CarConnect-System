package com.hexaware.entity;

public class AuthenticationException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationException() {
        super("Authentication error occurred.");
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }
}
