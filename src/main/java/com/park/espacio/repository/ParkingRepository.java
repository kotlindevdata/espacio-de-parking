package com.park.espacio.repository;

import com.park.espacio.entity.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Long> {
}
