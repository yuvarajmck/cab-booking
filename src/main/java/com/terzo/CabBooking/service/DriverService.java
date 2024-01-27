package com.terzo.CabBooking.service;

import com.terzo.CabBooking.model.Driver;


public interface DriverService {
    void save(Driver driver);

    Driver findDriverByEmail(String email);

    void update(Driver driver, long id);

    void delete(long id);

    Driver findById(long id);
}
