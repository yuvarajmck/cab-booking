package com.terzo.CabBooking.service.Impl;

import com.terzo.CabBooking.model.Driver;
import com.terzo.CabBooking.model.Vehicle;
import com.terzo.CabBooking.repository.DriverRepository;
import com.terzo.CabBooking.repository.VehicleRepository;
import com.terzo.CabBooking.service.DriverService;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public DriverServiceImpl(VehicleRepository vehicleRepository, DriverRepository driverRepository) {
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void save(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public Driver findDriverByEmail(String email) {
        return driverRepository.findDriverByEmail(email);
    }

    @Override
    public void update(Driver driver, long id) {

        System.out.println(driver);

        driverRepository.save(driver);
    }

    @Override
    public void delete(long id) {
        Driver driver =driverRepository.findById(id).get();
        Vehicle vehicle = driver.getVehicle();
        driver.setVehicle(null);
        vehicleRepository.delete(vehicle);
        driverRepository.delete(driver);
    }

    @Override
    public Driver findById(long id) {
        return driverRepository.findById(id).get();
    }

//    private Driver mapTodriver(Driver driver) {
//        return Driver.builder()
//                .name(driver.getName())
//                .email(driver.getEmail())
//                .mobile(driver.getMobile())
//                .password(driver.getPassword())
//                .build();
//    }
}



//driver1.setId(driver.getId());
//        driver1.setVehicle(driver.getVehicle());
//        driver1.setName(driver.getName());
//        driver1.setEmail(driver.getEmail());
//        driver1.setMobile(driver1.getMobile());
//        driver1.setPassword(driver.getPassword());
//        driver1.setRides(driver.getRides());
//        driver1.setActive(driver.isActive());
//Driver driver1 = driverRepository.findById(id).get();