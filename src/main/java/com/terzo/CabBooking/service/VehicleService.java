package com.terzo.CabBooking.service;

import com.terzo.CabBooking.model.Vehicle;

public interface VehicleService {
    Vehicle save(Vehicle vehicle);
    Vehicle getVehicle(Vehicle vehicle);
}
