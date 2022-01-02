package com.application.repository;

import com.application.entity.FlightEntity;
import com.application.model.FlightReservationLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FlightRepository")
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    @Query(nativeQuery = true, name = "getUsersFlightReservations")
    List<FlightReservationLookup> getFlightReservations(String userId);

    @Query(nativeQuery = true, name = "getAvailableFlightForUser")
    List<FlightReservationLookup> getAllAvailableFlights(String userId);
}
