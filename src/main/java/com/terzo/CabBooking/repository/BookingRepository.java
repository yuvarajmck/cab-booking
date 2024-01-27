package com.terzo.CabBooking.repository;

import com.terzo.CabBooking.model.BookingInfo;
import com.terzo.CabBooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingInfo, Long> {
    List<BookingInfo> findBookingInfoByBookingStatus(String status);

    List<BookingInfo> findAllByUser(User user);
//    @Query("s")
//    void update(BookingInfo bookingInfo);
}
