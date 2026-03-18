package com.park.espacio;

import com.park.espacio.entity.Parking;
import com.park.espacio.entity.Spot;
import com.park.espacio.entity.SpotLocation;
import com.park.espacio.entity.SpotType;
import com.park.espacio.repository.ParkingRepository;
import com.park.espacio.repository.SpotRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class EspacioApplication {

	private final ParkingRepository parkingRepository;
	private final SpotRepository spotRepository;

    public EspacioApplication(ParkingRepository parkingRepository, SpotRepository spotRepository) {
        this.parkingRepository = parkingRepository;
        this.spotRepository = spotRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(EspacioApplication.class, args);
	}

	@PostConstruct
	public void addParkings(){
		Parking parking = new Parking();
		Parking parking2 = new Parking();
		Parking parking3 = new Parking();

		parking.setName("Barcelona parking");
		parking.setCarsCapacity(250);
		parking.setMotosCapacity(85);
		parking.setEstablishedDate(Date.from(new java.util.Date().toInstant()));

		parkingRepository.save(parking);

		Spot spot1 = Spot.builder()
				.code("s1")
				.pricePerHour(1.55)
				.location(SpotLocation.NORTH_EAST)
				.type(SpotType.CAR)
				.build();

		Spot spot2 = Spot.builder()
				.code("s2")
				.pricePerHour(2.15)
				.location(SpotLocation.SOUTH)
				.type(SpotType.CAR)
				.build();
		Spot spot3 = Spot.builder()
				.code("s3")
				.pricePerHour(3.6)
				.location(SpotLocation.EAST)
				.type(SpotType.MOTO)
				.build();

		spotRepository.save(spot1);
		spotRepository.save(spot2);
		spotRepository.save(spot3);

		parking.addSpot(spot1);
		parking.addSpot(spot2);
		parkingRepository.save(parking);

		parking2.setName("Madrid parking");
		parking2.setCarsCapacity(150);
		parking2.setMotosCapacity(65);
		parking2.setEstablishedDate(Date.from(new java.util.Date().toInstant()));
		parkingRepository.save(parking2);

		parking2.addSpot(spot3);
		parkingRepository.save(parking2);

		parking3.setName("Alicante parking");
		parking3.setCarsCapacity(505);
		parking3.setMotosCapacity(310);
		parking3.setEstablishedDate(Date.from(new java.util.Date().toInstant()));

		parkingRepository.save(parking3);
	}

}
