package com.application.model;

import java.sql.Date;

public class FlightReservationLookup {
    private Long flightId;
    private String flightNumber;
    private Date departureDate;
    private String originCity;
    private String destinationCity;
    private Float priceUs;
    private Long reservationId;
    private String userId;

    public FlightReservationLookup() {
    }

    public FlightReservationLookup(Long flightId,
                                   String flightNumber,
                                   Date departureDate,
                                   String originCity,
                                   String destinationCity,
                                   Float priceUs,
                                   Long reservationId,
                                   String userId) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.priceUs = priceUs;
        this.reservationId = reservationId;
        this.userId = userId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
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

    public Float getPriceUs() {
        return priceUs;
    }

    public void setPriceUs(Float priceUs) {
        this.priceUs = priceUs;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
