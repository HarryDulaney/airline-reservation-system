package com.application.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT_TBL")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLIGHT_ID")
    private long flightId;
    @Column(name = "FLIGHT_NUM")
    private String flightNumber;
    @Column(name = "FLIGHT_DATE")
    private String date;
    @Column(name = "ORIGIN")
    private String originCity;
    @Column(name = "DESTINATION")
    private String destinationCity;
    @Column(name = "PRICE_US")
    private BigDecimal priceUs;


    public FlightEntity() {
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
