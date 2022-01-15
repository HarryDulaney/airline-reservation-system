package com.application.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "flight_tbl")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id")
    private UUID flightId;

    @Column(name = "flight_num")
    private Long flightNumber;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "origin")
    private String originCity;

    @Column(name = "destination")
    private String destinationCity;

    @Column(name = "price_us")
    private BigDecimal priceUs;

    @Column(name = "carrier", length = 40)
    private String carrier;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "departure_time")
    private LocalTime departureTime;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @OneToMany(mappedBy = "flight")
    private Collection<Reservation> reservations;

    public Flight() {
    }

    public Flight(UUID flightId,
                  Long flightNumber,
                  Date departureDate,
                  String originCity,
                  String destinationCity,
                  BigDecimal priceUs,
                  String carrier,
                  LocalTime departureTime,
                  LocalTime arrivalTime) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.priceUs = priceUs;
        this.carrier = carrier;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }


    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }


    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public BigDecimal getPriceUs() {
        return priceUs;
    }

    public void setPriceUs(BigDecimal priceUs) {
        this.priceUs = priceUs;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "flightId = " + flightId + ", " +
                "flightNumber = " + flightNumber + ", " +
                "departureDate = " + departureDate + ", " +
                "originCity = " + originCity + ", " +
                "destinationCity = " + destinationCity + ", " +
                "priceUs = " + priceUs + ", " +
                "carrier = " + carrier + ", " +
                "departureTime = " + departureTime + ", " +
                "arrivalTime = " + arrivalTime + ")";
    }
}
