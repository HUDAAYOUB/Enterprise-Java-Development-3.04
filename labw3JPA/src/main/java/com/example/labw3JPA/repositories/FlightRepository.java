package com.example.labw3JPA.repositories;

import com.example.labw3JPA.modal.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    Optional<Flight> findByflightNumber(String flightNumber);
    //    List<Flight> findByaircraft(String str);
    List<Flight> findAllByAircraftContaining(String str);
    List<Flight> findAllByFlightMileageGreaterThan(Integer mile);

}