package com.park.espacio.service;

import com.park.espacio.entity.Parking;
import com.park.espacio.repository.ParkingRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<Parking> getParkings() {
        return StreamSupport.stream(parkingRepository.findAll().spliterator(), false).collect(toList());
    }
    @Override
    public @Nullable Parking getById(long id) {
        return parkingRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Parking parking) {
        parking.spots.forEach(spot -> spot.setParking(parking));
        parkingRepository.save(parking);
    }

    @Override
    public void delete(Parking parking) {
        parkingRepository.delete(parking);
    }
}
