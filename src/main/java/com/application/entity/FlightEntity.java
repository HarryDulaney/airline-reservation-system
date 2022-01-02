package com.application.entity;

import com.application.model.FlightReservationLookup;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
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
                        "INNER JOIN reservations r ON r.flight_id = f.flight_id " +
                        "WHERE r.user_id = ?1 " +
                        "ORDER BY f.flight_date ",

                resultClass = FlightReservationLookup.class,
                resultSetMapping = "FlightReservationLookupMap"
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
                        resultSetMapping = "FlightReservationLookupMap"
                )

        }
)

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "FlightReservationLookupMap",
                classes = {
                        @ConstructorResult(targetClass = FlightReservationLookup.class, columns = {
                                @ColumnResult(name = "flightId", type = Long.class),
                                @ColumnResult(name = "flightNumber", type = Long.class),
                                @ColumnResult(name = "departureDate", type = Date.class),
                                @ColumnResult(name = "originCity", type = String.class),
                                @ColumnResult(name = "destinationCity", type = String.class),
                                @ColumnResult(name = "priceUs", type = Float.class),
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
    private String flightNumber;

    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm:ss a")
    @Column(name = "flight_date")
    private Date departureDate;

    @Column(name = "origin")
    private String originCity;

    @Column(name = "destination")
    private String destinationCity;

    @Column(name = "price_us")
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

    public BigDecimal getPriceUs() {
        return priceUs;
    }

    public void setPriceUs(BigDecimal priceUs) {
        this.priceUs = priceUs;
    }
}
