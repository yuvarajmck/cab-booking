package com.terzo.CabBooking.service.Impl;

import com.terzo.CabBooking.model.TripInfo;
import com.terzo.CabBooking.repository.TripRepository;
import com.terzo.CabBooking.service.TripService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void save(TripInfo tripInfo) {
        tripRepository.save(tripInfo);
    }

    @Override
    public void update(TripInfo tripInfo) {
        TripInfo tripInfo1=tripRepository.findById(tripInfo.getId()).get();
        tripInfo1.setDropTime(LocalDateTime.now());
        tripRepository.save(tripInfo1);
    }
}
