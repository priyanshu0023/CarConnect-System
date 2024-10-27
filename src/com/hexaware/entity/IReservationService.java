package com.hexaware.entity;

import java.util.List;

public interface IReservationService {
    Reservation getReservationById(int reservationId);
    List<Reservation> getReservationsByCustomerId(int customerId);
    void createReservation(Reservation reservationData);
    void updateReservation(Reservation reservationData);
    void cancelReservation(int reservationId);
}
