package com.hexaware.entity;

public class VehicleNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleNotFoundException() {
        super("Requested vehicle not found.");
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }

    public VehicleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleNotFoundException(Throwable cause) {
        super(cause);
    }
}
