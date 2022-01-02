package com.application.service;

import com.application.entity.Reservation;
import com.application.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("reservationService")
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

}
