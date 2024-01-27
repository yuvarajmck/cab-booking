package com.terzo.CabBooking.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookingInfoDto {
    private long id;
    private String userEmail;
    private String pickUpLocation;
    private String dropLocation;
    private String driverEmail;
    private double distance;
}
