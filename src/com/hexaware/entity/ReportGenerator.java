package com.hexaware.entity;

import java.util.List;

public class ReportGenerator {
    private VehicleService vehicleService;
    private ReservationService reservationService;

    public ReportGenerator(VehicleService vehicleService, ReservationService reservationService) {
        this.vehicleService = vehicleService;
        this.reservationService = reservationService;
    }

    public void generateVehicleReport() {
        List<Vehicle> vehicles = vehicleService.getAvailableVehicles();
        System.out.println("Vehicle Report:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getModel() + " - " + vehicle.getMake());
        }
    }

    public void generateReservationReport() {
        System.out.println("Reservation Report:");
        for (Reservation reservation : reservationService.getReservationsByCustomerId(0)) { // Example logic
            System.out.println("Reservation ID: " + reservation.getReservationID() + " Status: " + reservation.getStatus());
        }
    }
}
