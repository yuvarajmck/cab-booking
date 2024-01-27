package com.terzo.CabBooking.controller;

import com.terzo.CabBooking.Dto.TripInfoDto;
import com.terzo.CabBooking.model.TripInfo;
import com.terzo.CabBooking.service.BookingService;
import com.terzo.CabBooking.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class TripController {

 private final TripService tripService;
 private final BookingService bookingService;

 public TripController(TripService tripService, BookingService bookingService) {
  this.tripService = tripService;
  this.bookingService = bookingService;
 }

 @PostMapping("/start-trip")
 public String getTripDetails(@RequestBody TripInfoDto tripInfoDto){
  TripInfo tripInfo = mapToTrip(tripInfoDto);
  tripService.save(tripInfo);
  return "Trip started";
 }

 @PutMapping("/{id}/end-trip")
 public String updateTrip(@PathVariable long id){

  TripInfo tripInfo =new TripInfo();
  tripInfo.setId(id);
  tripService.update(tripInfo);
  return "Trip ended";
 }
 private TripInfo mapToTrip(TripInfoDto tripInfoDto) {
  return TripInfo.builder()
          .status("Trip Started")
          .pickUpTime(LocalDateTime.now())
          .bookingInfo(bookingService.findById(tripInfoDto.getBookingId()))
          .build();
 }

}
