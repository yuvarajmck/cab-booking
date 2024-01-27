package com.terzo.CabBooking.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TripInfoDto {
    private long id;
    private long bookingId;
    private double fare;
}