package com.application.repository;

import com.application.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ReservationRepository")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationsByUserId(String userId);

    Reservation findReservationsByUserIdAndFlightId(String userId, Long flightId);

    List<Reservation> findReservationsByFlightId(Long flightId);

    @Modifying
    @Query(value = "insert into reservations (user_id,flight_id) VALUES (:userId,:flightId)", nativeQuery = true)
    @Transactional
    Void create(Long userId, Long flightId);
}
