package com.terzo.CabBooking.service.Impl;

import com.terzo.CabBooking.Dto.BookingInfoDto;
import com.terzo.CabBooking.model.BookingInfo;
import com.terzo.CabBooking.model.User;
import com.terzo.CabBooking.repository.BookingRepository;
import com.terzo.CabBooking.repository.DriverRepository;
import com.terzo.CabBooking.repository.UserRepository;
import com.terzo.CabBooking.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository, DriverRepository driverRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void save(BookingInfoDto bookingInfoDto) {
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setBookingStatus("Pending");
        bookingInfo.setBookingStartTime(LocalDateTime.now());
        bookingInfo.setUser(userRepository.findUserByEmail(bookingInfoDto.getUserEmail()));
        bookingInfo.setDistance(bookingInfoDto.getDistance());
        bookingInfo.setDropLocation(bookingInfoDto.getDropLocation());
        bookingInfo.setPickUp(bookingInfoDto.getPickUpLocation());
        bookingRepository.save(bookingInfo);
    }

    @Override
    public List<User> findAllByStatus() {
        return mapToUserList(bookingRepository.findBookingInfoByBookingStatus("pending"));
    }

    @Override
    public BookingInfo findById(long id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public void update(BookingInfoDto bookingInfoDto) {
        BookingInfo bookingInfo = bookingRepository.findById(bookingInfoDto.getId()).get();
        bookingInfo.setId(bookingInfoDto.getId());
        bookingInfo.setBookingStatus("Booked");
        bookingInfo.setBookingEndTime(LocalDateTime.now());
        bookingInfo.setDriver(driverRepository.findDriverByEmail(bookingInfoDto.getDriverEmail()));
        bookingRepository.save(bookingInfo);
    }

    @Override
    public void changeDrop(BookingInfoDto bookingInfoDto) {
        BookingInfo bookingInfo = bookingRepository.findById(bookingInfoDto.getId()).get();
        bookingInfo.setId(bookingInfoDto.getId());
        bookingInfo.setDropLocation(bookingInfoDto.getDropLocation());
        bookingInfo.setDistance(bookingInfoDto.getDistance());
        bookingRepository.save(bookingInfo);
    }

    private List<User> mapToUserList(List<BookingInfo> bookingInfos){
        return bookingInfos.stream()
                .map(BookingInfo::getUser)
                .collect(Collectors.toList());
    }
}
