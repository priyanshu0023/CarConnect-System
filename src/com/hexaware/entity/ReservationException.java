package com.hexaware.entity;

public class ReservationException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservationException() {
        super("Reservation error occurred.");
    }

    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationException(Throwable cause) {
        super(cause);
    }
}
