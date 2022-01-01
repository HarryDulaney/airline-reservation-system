package com.application.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "USER_TBL")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, unique = true)
    private long userID;

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String username;


    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<FlightEntity> getFlightSchedules() {
        return flightSchedules;
    }

    public void setFlightSchedules(Set<FlightEntity> flightSchedules) {
        this.flightSchedules = flightSchedules;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", flightSchedules=" + flightSchedules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username);
    }
}
