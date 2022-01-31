package com.application.repository;

import com.application.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FlightRepository")
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
