package com.application.model;


import java.sql.Date;

public class FlightReservationLookup {
    private Long flightId;
    private Long flightNumber;
    private Date departureDate;
    private String originCity;
    private String destinationCity;
    private Double priceUs;
    private Long reservationId;
    private String userId;

    public FlightReservationLookup() {}


    public FlightReservationLookup(Long flightId,
                                   Long flightNumber,
                                   Date departureDate,
                                   String originCity,
                                   String destinationCity,
                                   Double priceUs,
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

    public Double getPriceUs() {
        return priceUs;
    }

    public void setPriceUs(Double priceUs) {
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
