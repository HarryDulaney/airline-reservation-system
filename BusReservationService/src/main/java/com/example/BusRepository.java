package com.example;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BusRepository extends JpaRepository<BusSchedule, Long> {
	
	
	
	@Query(value = "Select bs.BusID, bs.BusNumber, DATE_FORMAT(bs.BusDate,'%W: %M %D,  %h:%i:%p') As BusDate, bs.BusFrom, bs.BusTo, bs.Price\n" + 
			"from BusSchedule bs\n" + 
			"where bs.busID not in(select br.BusID from BusReservation br where br.UserID = ?)", nativeQuery = true)
	List<BusSchedule> findAllNotInAccount(long userID);
	
	
	
	
	@Query(value = "Select bs.BusID, DATE_FORMAT(bs.BusDate,'%W: %M %D,  %h:%i:%p') As BusDate, bs.BusNumber, bs.BusFrom , bs.BusTo, bs.Price\n" + 
			"from BusSchedule bs, BusReservation br\n" + 
			"Where br.BusID = bs.BusID and br.UserID = ?1", nativeQuery = true)
	List<BusSchedule> findByAccountUserID(long userID);
	
	@Modifying
    @Query(value = "insert into BusReservation (UserID,BusID) VALUES (:UserID,:BusID)", nativeQuery = true)
    @Transactional
    void addBusToAccount(@Param("UserID") long userID, @Param("BusID") long busID) ;
	
	
	@Modifying
    @Query(value = "DELETE FROM BusReservation WHERE UserID = ? and BusID = ?", nativeQuery = true)
    @Transactional
    void deleteBusInAccount(@Param("UserID") long userID, @Param("BusID") long busID);
	
	
	@Query(value = "Select sum(price) from BusReservation br, BusSchedule bs\n" + 
			"where br.BusID = bs.BusID and br.UserID = ?", nativeQuery = true)
	BigDecimal findTotalinAccount(long userID);
	
	
}
