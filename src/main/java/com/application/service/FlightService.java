package com.application.service;

import com.application.entity.Flight;
import com.application.entity.Reservation;
import com.application.repository.FlightRepository;
import com.application.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("FlightService")
public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository, ReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getAvailableFlights(String userId) {
        return flightRepository.findAll();
    }


    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }

    public Flight getFlightById(Long flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        return flight.orElseGet(Flight::new);
    }

    public Flight addFlight(Flight flight) {
        flightRepository.saveAndFlush(flight);
        return flight;
    }

    public void saveFlight(Flight flight) {
        flightRepository.saveAndFlush(flight);
    }
}
