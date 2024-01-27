package com.terzo.CabBooking.service;

import com.terzo.CabBooking.model.TripInfo;

public interface TripService {

    void save(TripInfo tripInfo);

    void update(TripInfo tripInfo);
}
