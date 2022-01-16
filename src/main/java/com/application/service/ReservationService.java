package com.application.service;

import com.application.entity.Reservation;
import com.application.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("ReservationService")
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAll(String userId) {
        return reservationRepository.findReservationsByUserId(userId);
    }

    public void cancel(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        reservation.ifPresent(value -> reservationRepository.delete(value));
    }

    @Transactional
    public Reservation bookReservation(String email, Long flightId) {
        Reservation reservation = new Reservation();
        reservation.setFlightId(flightId);
        reservation.setUserId(email);
        return reservationRepository.saveAndFlush(reservation);
    }
}
