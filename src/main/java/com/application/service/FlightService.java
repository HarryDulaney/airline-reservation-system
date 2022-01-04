package com.application.service;

import com.application.entity.FlightEntity;
import com.application.entity.Reservation;
import com.application.model.FlightReservationLookup;
import com.application.repository.FlightRepository;
import com.application.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("FlightService")
public class FlightService {

    private FlightRepository flightRepository;
    private ReservationRepository reservationRepository;

    public FlightService(FlightRepository flightRepository, ReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
        this.reservationRepository = reservationRepository;
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

    public void deleteFlight(Long flightId) {
        Optional<FlightEntity> flight = flightRepository.findById(flightId);

        flight.ifPresent(flightEntity -> {
            List<Reservation> associatedReservations = reservationRepository.findReservationsByFlightId(flightId);
            for (Reservation reservation : associatedReservations) {
                reservation.setFlightId(0L);// 0 means the flight was cancelled
            }
            reservationRepository.saveAll(associatedReservations);
            reservationRepository.flush();

            flightRepository.delete(flightEntity);
        });
    }

    public FlightEntity getFlightById(Long flightId) {
        Optional<FlightEntity> flight = flightRepository.findById(flightId);
        return flight.orElseGet(FlightEntity::new);
    }
}
