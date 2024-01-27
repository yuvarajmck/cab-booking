package com.terzo.CabBooking.repository;

import com.terzo.CabBooking.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByVehicleNo(String name);
}
