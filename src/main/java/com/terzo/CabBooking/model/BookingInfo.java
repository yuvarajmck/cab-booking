package com.terzo.CabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    private LocalDateTime bookingStartTime;
    private LocalDateTime bookingEndTime;
    private String bookingStatus;
    private String pickUp;
    private String dropLocation;
    @ManyToOne
    private Driver driver;
    private double distance;
}
