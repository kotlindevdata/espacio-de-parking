package com.park.espacio.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Parking implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    public String name;
    public Date establishedDate;
    public int motosCapacity;
    public int carsCapacity;
    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "parking",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    public List<Spot> spots =  new ArrayList<>();

    public void addSpot(Spot spot){
        spots.add(spot);
        spot.setParking(this);
    }

    public void removeSpot(Spot spot){
        spots.remove(spot);
        spot.setParking(null);
    }
}
