package com.terzo.CabBooking.repository;

import com.terzo.CabBooking.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findDriverByEmail(String email);
}
