package com.terzo.CabBooking.service;

import com.terzo.CabBooking.Dto.BookingInfoDto;
import com.terzo.CabBooking.model.BookingInfo;
import com.terzo.CabBooking.model.User;

import java.util.List;

public interface BookingService {
    void save(BookingInfoDto bookingInfo);

    List<User> findAllByStatus();

    BookingInfo findById(long id);

    void update(BookingInfoDto bookingInfoDto);

    void changeDrop(BookingInfoDto bookingInfoDto);
}
