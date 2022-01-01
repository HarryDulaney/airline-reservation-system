package com.application.repository;

import java.math.BigDecimal;
import java.util.List;

import com.application.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("FlightRepository")
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    @Query(value = "Select bs.BusID, bs.BusNumber, DATE_FORMAT(bs.BusDate,'%W: %M %D,  %h:%i:%p') As BusDate, bs.BusFrom, bs.BusTo, bs.Price\n" +
            "from BusSchedule bs\n" +
            "where bs.busID not in(select br.BusID from reservations br where br.UserID = ?)", nativeQuery = true)
    List<FlightEntity> findAllNotInAccount(long userID);

    @Query(value = "Select bs.BusID, DATE_FORMAT(bs.BusDate,'%W: %M %D,  %h:%i:%p') As BusDate, bs.BusNumber, bs.BusFrom , bs.BusTo, bs.Price\n" +
            "from BusSchedule bs, reservations br\n" +
            "Where br.BusID = bs.BusID and br.UserID = ?1", nativeQuery = true)
    List<FlightEntity> getAllBookedFlights(long userID);

    @Modifying
    @Query(value = "insert into reservations (user_id,flight_id) VALUES (:userId,:flightId)", nativeQuery = true)
    @Transactional
    void addBusToAccount(Long userId, Long flightId);


    @Modifying
    @Query(value = "DELETE FROM reservations WHERE user_id = :userId and flight_id = :flightId", nativeQuery = true)
    @Transactional
    Void deleteUserFromFlight(Long userId, Long flightId);


    @Query(value = "Select sum(price) from reservations br, BusSchedule bs\n" +
            "where br.BusID = bs.BusID and br.UserID = ?", nativeQuery = true)
    BigDecimal findTotalinAccount(long userID);


}
