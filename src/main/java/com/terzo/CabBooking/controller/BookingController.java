package com.terzo.CabBooking.controller;

import com.terzo.CabBooking.Dto.BookingInfoDto;
import com.terzo.CabBooking.model.User;
import com.terzo.CabBooking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public String bookCab(@RequestBody BookingInfoDto bookingInfo){
        bookingService.save(bookingInfo);
        return  "Booking successful";
    }

    @GetMapping("/unbooked")
    public List<User> getUnBookedDetails(){
        return bookingService.findAllByStatus();
    }

    @PutMapping("/booking/{id}/confirm")
    public String confirmBooking(@RequestBody BookingInfoDto bookingInfoDto, @PathVariable("id")long id){
        bookingInfoDto.setId(id);
        bookingService.update(bookingInfoDto);
        return "Booking Confirmed";
    }

    @PutMapping("/booking/{id}/change")
    public String updateBooking(@PathVariable("id") long id, @RequestBody BookingInfoDto bookingInfoDto){
        bookingInfoDto.setId(id);
        bookingService.changeDrop(bookingInfoDto);
        return "Drop Location changed and fare updated successfully";
    }
}
