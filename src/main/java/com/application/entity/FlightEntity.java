package com.application.entity;

import com.application.model.FlightReservationLookup;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

import javax.persistence.*;

@NamedNativeQueries(value =
        {@NamedNativeQuery(
                name = "getUsersFlightReservations",
                query = "SELECT f.flight_id AS \"flightId\", " +
                        "f.flight_num AS \"flightNumber\", " +
                        "f.flight_date AS \"departureDate\", " +
                        "f.origin AS \"originCity\", " +
                        "f.destination AS \"destinationCity\", " +
                        "f.price_us AS \"priceUs\", " +
                        "r.reservation_id AS \"reservationId\", " +
                        "r.user_id AS \"userId\" " +
                        "FROM flight_tbl f " +
                        "LEFT JOIN reservations r ON r.flight_id = f.flight_id " +
                        "WHERE r.user_id = ?1 ",

                resultClass = FlightReservationLookup.class,
                resultSetMapping = "FlightReservationLookupMap1"
        ),
                @NamedNativeQuery(
                        name = "getAvailableFlightForUser",
                        query = "SELECT f.flight_id AS \"flightId\", " +
                                "f.flight_num AS \"flightNumber\", " +
                                "f.flight_date AS \"departureDate\", " +
                                "f.origin AS \"originCity\", " +
                                "f.destination AS \"destinationCity\", " +
                                "f.price_us AS \"priceUs\", " +
                                "r.reservation_id AS \"reservationId\", " +
                                "r.user_id AS \"userId\" " +
                                "FROM flight_tbl f " +
                                "INNER JOIN reservations r ON r.flight_id != f.flight_id " +
                                "WHERE r.user_id = ?1 " +
                                "ORDER BY f.flight_date ",

                        resultClass = FlightReservationLookup.class,
                        resultSetMapping = "FlightReservationLookupMap2"
                )

        }
)

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "FlightReservationLookupMap1",
                classes = {
                        @ConstructorResult(targetClass = FlightReservationLookup.class, columns = {
                                @ColumnResult(name = "flightId", type = Long.class),
                                @ColumnResult(name = "flightNumber", type = Long.class),
                                @ColumnResult(name = "departureDate", type = Date.class),
                                @ColumnResult(name = "originCity", type = String.class),
                                @ColumnResult(name = "destinationCity", type = String.class),
                                @ColumnResult(name = "priceUs", type = Double.class),
                                @ColumnResult(name = "reservationId", type = Long.class),
                                @ColumnResult(name = "userId", type = String.class),

                        })
                }
        ),
        @SqlResultSetMapping(
                name = "FlightReservationLookupMap2",
                classes = {
                        @ConstructorResult(targetClass = FlightReservationLookup.class, columns = {
                                @ColumnResult(name = "flightId", type = Long.class),
                                @ColumnResult(name = "flightNumber", type = Long.class),
                                @ColumnResult(name = "departureDate", type = Date.class),
                                @ColumnResult(name = "originCity", type = String.class),
                                @ColumnResult(name = "destinationCity", type = String.class),
                                @ColumnResult(name = "priceUs", type = Double.class),
                                @ColumnResult(name = "reservationId", type = Long.class),
                                @ColumnResult(name = "userId", type = String.class),

                        })
                }
        )
})


@Entity
@Table(name = "flight_tbl")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "flight_num")
    private Long flightNumber;

    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm:ss a")
    @Column(name = "flight_date")
    private Date departureDate;

    @Column(name = "origin")
    private String originCity;

    @Column(name = "destination")
    private String destinationCity;

    @Column(name = "price_us")
    private Double priceUs;


    public FlightEntity() {
    }

    public FlightEntity(Long flightId,
                        Long flightNumber,
                        Date departureDate,
                        String originCity,
                        String destinationCity,
                        Double priceUs) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.priceUs = priceUs;
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

    public Double getPriceUs() {
        return priceUs;
    }

    public void setPriceUs(Double priceUs) {
        this.priceUs = priceUs;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date date) {
        this.departureDate = date;
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

}
