package com.application.service;

import com.application.entity.FlightEntity;
import com.application.model.FlightReservationLookup;
import com.application.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FlightService")
public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<FlightReservationLookup> getAvailableFlights(String userId) {
        return flightRepository.getAllAvailableFlights(userId);
    }

    public List<FlightReservationLookup> getUsersReservedFlights(String userId) {
        return flightRepository.getFlightReservations(userId);
    }

}
