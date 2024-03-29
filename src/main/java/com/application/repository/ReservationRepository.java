package com.application.repository;

import com.application.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("ReservationRepository")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationsByUserId(String userId);

    Reservation findReservationsByUserIdAndFlightId(String userId, Long flightId);

    List<Reservation> findReservationsByFlightId(Long flightId);

}
