package com.terzo.CabBooking.service;

import com.terzo.CabBooking.Dto.UserDto;
import com.terzo.CabBooking.model.TripInfo;
import com.terzo.CabBooking.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> findAll();

    void save(UserDto user);

    List<TripInfo> findAllTripById(long id);

    void delete(long id);

    User findById(long id);
}
