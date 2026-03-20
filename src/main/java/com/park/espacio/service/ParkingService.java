package com.park.espacio.service;

import com.park.espacio.entity.Parking;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ParkingService {
    List<Parking> getParkings();

    @Nullable Parking getById(long id);

    void update(Parking parking);

    void delete(Parking parking);

    Parking save(Parking parking);
}
