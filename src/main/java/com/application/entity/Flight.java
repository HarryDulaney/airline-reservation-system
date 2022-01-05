package com.application.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "flight_tbl")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "flight_num")
    private Long flightNumber;

    @Column(name = "flight_date")
    private Date departureDate;

    @Column(name = "origin")
    private String originCity;

    @Column(name = "destination")
    private String destinationCity;

    @Column(name = "price_us")
    private BigDecimal priceUs;

    @OneToMany(mappedBy = "flight")
    private Collection<Reservation> reservations;

    public Flight() {
    }

    public Flight(Long flightId,
                  Long flightNumber,
                  Date departureDate,
                  String originCity,
                  String destinationCity,
                  BigDecimal priceUs) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.priceUs = priceUs;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
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
}
