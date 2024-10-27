package com.hexaware.entity;

import java.util.List;
import java.util.ArrayList;

public class VehicleService implements IVehicleService {
    private List<Vehicle> vehicles = new ArrayList<>(); // Simulating a database

    @Override
    public Vehicle getVehicleById(int vehicleID) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleID() == vehicleID) {
                return vehicle;
            }
        }
        return null; // Vehicle not found
    }

    @Override
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailability()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle); // Add vehicle to the list (DB simulation)
    }

    @Override
    public void updateVehicle(Vehicle updatedVehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVehicleID() == updatedVehicle.getVehicleID()) {
                vehicles.set(i, updatedVehicle); // Update vehicle
                return;
            }
        }
    }

    @Override
    public void removeVehicle(int vehicleID) {
        vehicles.removeIf(vehicle -> vehicle.getVehicleID() == vehicleID); // Remove vehicle from the list
    }
}
