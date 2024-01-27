package com.terzo.CabBooking.service.Impl;

import com.terzo.CabBooking.Dto.UserDto;
import com.terzo.CabBooking.model.BookingInfo;
import com.terzo.CabBooking.model.TripInfo;
import com.terzo.CabBooking.model.User;
import com.terzo.CabBooking.repository.BookingRepository;
import com.terzo.CabBooking.repository.TripRepository;
import com.terzo.CabBooking.repository.UserRepository;
import com.terzo.CabBooking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final TripRepository tripRepository;

    public UserServiceImpl(UserRepository userRepository, BookingRepository bookingRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserDto user) {
        userRepository.save(mapToUser(user));
    }

    @Override
    public List<TripInfo> findAllTripById(long id) {
        List<BookingInfo> bookingInfos = bookingRepository.findAllByUser(userRepository.findById(id).get());

        System.out.println(bookingInfos.get(0).getId());

         return bookingInfos.stream()
                .map(tripRepository::findByBookingInfo)
                 .collect(Collectors.toList());

    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    private User mapToUser(UserDto user) {
        return User.builder()
                .active(true)
                .email(user.getEmail())
                .mobile(user.getMobile())
                .name(user.getName())
                .password(user.getPassword())
                .rides(0)
                .build();
    }
}
