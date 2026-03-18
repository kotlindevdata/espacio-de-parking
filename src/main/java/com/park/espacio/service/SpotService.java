package com.park.espacio.service;

import com.park.espacio.entity.Spot;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SpotService {
    List<Spot> getSpots();
}
