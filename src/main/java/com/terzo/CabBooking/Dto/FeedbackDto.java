package com.terzo.CabBooking.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FeedbackDto {
   private long tripId;
    private double rating;
    private String feedback;
}
