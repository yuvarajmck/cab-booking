package com.terzo.CabBooking.Dto;

import com.terzo.CabBooking.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverDto {
    private String name;
    private String email;
    private String mobile;
    private String password;
    private Vehicle vehicle;
}
