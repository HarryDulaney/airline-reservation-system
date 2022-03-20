package com.application.service;

import com.application.common.Const;
import com.application.entity.Flight;
import com.application.entity.Reservation;
import com.application.repository.FlightRepository;
import com.application.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("FlightService")
public class FlightService {

    @PersistenceContext
    private EntityManager entityManager;

    private FlightRepository flightRepository;
    private ReservationRepository reservationRepository;

    public FlightService(FlightRepository flightRepository,
                         ReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getAvailableFlights(String userId) {
        return flightRepository.findAll();
    }


    public Flight delete(Flight flight) {
        flightRepository.delete(flight);
        return flight;
    }

    public Flight getFlightById(Long flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        return flight.orElseGet(Flight::new);
    }

    public Flight addFlight(Flight flight) {
        flightRepository.saveAndFlush(flight);
        return flight;
    }

    public Flight saveFlight(Flight flight) {
        List<Reservation> reservations = flight.getReservations();
        return flightRepository.saveAndFlush(flight);
    }

    @Transactional
    public void delete(Long flightId) {
        List<Reservation> linkedReservations = reservationRepository.findReservationsByFlightId(flightId);
        for (Reservation reservation : linkedReservations) {
            reservation.setFlightId(null); // Flight Id -1 reference to 'Cancelled Flight' record
            reservation.setStatus(Const.STATUS_CANCELLED);
            entityManager.merge(reservation);
        }

        entityManager.flush();

        flightRepository.deleteById(flightId);
        flightRepository.flush();

    }
}
