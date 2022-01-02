package com.application.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "flight_id")
    private Long flightId;

    public Reservation() {

    }

    public Reservation(Long reservationId, String userId, Long flightId) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.flightId = flightId;
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
