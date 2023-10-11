package com.example.labw3JPA;

import com.example.labw3JPA.modal.Flight;
import com.example.labw3JPA.repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    @Transactional
    public void testFlightRepository() {

        Flight flight = new Flight();
        flight.setFlightNumber("ABC123");
        flight.setAircraft("Boeing 737");
        flight.setTotalAircraftSeats(200);
        flight.setFlightMileage(1000);

        flightRepository.save(flight);

        Optional<Flight> savedFlight = flightRepository.findByflightNumber("ABC123");
        assertTrue(savedFlight.isPresent());
        assertEquals("ABC123", savedFlight.get().getFlightNumber());

        List<Flight> flightsByAircraft = flightRepository.findAllByAircraftContaining("Boeing");
        assertTrue(flightsByAircraft.size() > 0);

        List<Flight> flightsByMileage = flightRepository.findAllByFlightMileageGreaterThan(500);
        assertTrue(flightsByMileage.size() > 0);
    }
}
