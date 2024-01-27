package com.terzo.CabBooking.repository;

import com.terzo.CabBooking.model.BookingInfo;
import com.terzo.CabBooking.model.TripInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripInfo, Long> {
    TripInfo findByBookingInfo(BookingInfo bookingInfo);

}
