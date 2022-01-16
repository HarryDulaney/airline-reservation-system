package com.application.entity;

import javax.persistence.*;
import java.util.Objects;
import java.lang.Long;


@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Long reservationId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "flight_id", nullable = false)
    private Long flightId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id", insertable = false, updatable = false)
    Flight flight;

    public Reservation() {

    }

    public Reservation(Long reservationId, String userId) {
        this.reservationId = reservationId;
        this.userId = userId;
    }

    public Reservation(Long reservationId, String userId, Long flightId) {
        this(reservationId, userId);
        this.flightId = flightId;
    }


    public Flight getFlight() {
        return flight;
    }

    public void setFLight(Flight flight) {
        this.flight = flight;
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

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return reservationId.equals(that.reservationId) && userId.equals(that.userId) && flightId.equals(that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, userId, flightId);
    }
}
