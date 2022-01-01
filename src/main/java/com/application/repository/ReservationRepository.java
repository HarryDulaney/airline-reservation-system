package com.application.repository;

import com.application.entity.FlightEntity;
import com.application.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ReservationRepository")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
