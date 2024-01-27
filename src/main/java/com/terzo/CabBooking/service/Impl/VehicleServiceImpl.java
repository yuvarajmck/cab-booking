package com.terzo.CabBooking.service.Impl;

import com.terzo.CabBooking.model.Vehicle;
import com.terzo.CabBooking.repository.VehicleRepository;
import com.terzo.CabBooking.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicleRepository.findByVehicleNo(vehicle.getVehicleNo());
    }

    @Override
    public Vehicle getVehicle(Vehicle vehicle) {
        return null;
    }
}
