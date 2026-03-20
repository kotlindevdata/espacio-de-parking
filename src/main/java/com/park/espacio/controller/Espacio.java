package com.park.espacio.controller;

import com.park.espacio.entity.Parking;
import com.park.espacio.entity.Spot;
import com.park.espacio.service.ParkingService;
import com.park.espacio.service.SpotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Espacio {

    private final ParkingService parkingService;
    private final SpotService spotService;

    public Espacio(ParkingService parkingService, SpotService spotService) {
        this.parkingService = parkingService;
        this.spotService = spotService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/parkings";
    }

    @GetMapping("/parkings")
    public String parkings(Model model) {
        model.addAttribute("parkings", parkingService.getParkings());
        return "parkings.html";
    }

    @GetMapping("/parking/{id}")
    public String parking(@PathVariable String id, Model model) {
        model.addAttribute("parking", parkingService.getById(Long.parseLong(id)));
        return "parking.html";
    }

    @PostMapping("/parking/{id}")
    public String updateParking(@PathVariable String id, @ModelAttribute Parking parking,
                                @RequestParam(value = "deleteSpot", defaultValue = "false") boolean deleteSpot) {
        if(deleteSpot) {
            parking.spots.removeIf(spot -> spot.getId() == 0 && spot.getCode() == null
                                                && spot.getParking() == null && spot.getType() == null
                                                && spot.getPricePerHour() == null && spot.getLocation() == null);
        }
        parkingService.update(parking);
        return "redirect:/parkings";
    }

    @PostMapping("/parking/new")
    public String newParking() {

        Parking parking = new Parking();
        Parking newParking = parkingService.save(parking);

        return "redirect:/parking/" + newParking.getId();
    }

    @PutMapping("/parking/{id}")
    public String addNewSpotToParking(@PathVariable String id) {

        Parking parking = parkingService.getById(Long.parseLong(id));

        parking.spots.add(new Spot());
        parkingService.update(parking);

        return "redirect:/parking/" + id;
    }

    @DeleteMapping("/parking/{id}")
    public String deleteParking(@PathVariable String id) {

        Parking parkingToDelete = parkingService.getById(Long.parseLong(id));

        if(parkingToDelete != null) {
            parkingService.delete(parkingToDelete);
        }

        return "redirect:/parkings";
    }

}
