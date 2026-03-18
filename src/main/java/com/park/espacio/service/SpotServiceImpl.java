package com.park.espacio.service;

import com.park.espacio.entity.Spot;
import com.park.espacio.repository.SpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    private final SpotRepository spotRepository;

    public SpotServiceImpl(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public List<Spot> getSpots() {
        return spotRepository.findAll();
    }
}
