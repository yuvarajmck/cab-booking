package com.terzo.CabBooking.controller;

import com.terzo.CabBooking.Dto.DriverDto;
import com.terzo.CabBooking.model.Driver;
import com.terzo.CabBooking.model.Vehicle;
import com.terzo.CabBooking.service.DriverService;
import com.terzo.CabBooking.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;
    private final VehicleService vehicleService;

    public DriverController(DriverService driverService, VehicleService vehicleService) {
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @PostMapping("/register")
    public String registerDriver(@RequestBody Driver driver){
        Vehicle vehicle = vehicleService.save(driver.getVehicle());
        System.out.println(driver.getVehicle());
        driver.setVehicle(vehicle);
        driverService.save(driver);
        return "Driver is registered";
    }

    @PutMapping("/{id}/update")
    public Driver updateDriver(@PathVariable("id") long id, @RequestBody Driver driver){
        driver.setId(driver.getId());
        driverService.update(driver, id);
        return driverService.findDriverByEmail(driver.getEmail());
    }

    @DeleteMapping("/{id}/delete")
    public String deleteDriverById(@PathVariable("id") long id){
        driverService.delete(id);
        return "Deleted successfully";
    }

    @GetMapping("/{id}")
    public DriverDto getDriverById(@PathVariable("id") long id){
        return mapToDto(driverService.findById(id));
    }

    private DriverDto mapToDto(Driver driver) {
        return DriverDto.builder()
                .name(driver.getName())
                .email(driver.getEmail())
                .mobile(driver.getMobile())
                .vehicle(driver.getVehicle())
                .build();
    }
}
