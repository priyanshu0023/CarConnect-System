package com.hexaware.entity;

import java.util.List;
import java.util.ArrayList;

public class ReservationService implements IReservationService {
    private List<Reservation> reservations = new ArrayList<>(); // Simulating a database

    @Override
    public Reservation getReservationById(int reservationID) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationID() == reservationID) {
                return reservation;
            }
        }
        return null; // Reservation not found
    }

    @Override
    public List<Reservation> getReservationsByCustomerId(int customerID) {
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerID() == customerID) {
                customerReservations.add(reservation);
            }
        }
        return customerReservations;
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservations.add(reservation); // Add reservation to the list (DB simulation)
    }

    @Override
    public void updateReservation(Reservation updatedReservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationID() == updatedReservation.getReservationID()) {
                reservations.set(i, updatedReservation); // Update reservation
                return;
            }
        }
    }

    @Override
    public void cancelReservation(int reservationID) {
        reservations.removeIf(reservation -> reservation.getReservationID() == reservationID); // Remove reservation
    }
}

