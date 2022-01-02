package com.application.controller;

import com.application.entity.FlightEntity;
import com.application.model.FlightReservationLookup;
import com.application.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//    @PreAuthorize("hasAuthority('user')")
//@PreAuthorize("hasAuthority('Everyone')")
@Controller
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        model.addAttribute("user", oidcUser);
        return "index";
    }


    @GetMapping(path = "/flightSchedule")
    public String getAllFlightsSchedule(Model model) {
        List<FlightEntity> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "flightSchedule";
    }


    @GetMapping(path = "/availableFlightSchedule")
    public String getAllFlightForUser(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        List<FlightReservationLookup> lookups = flightService.getAvailableFlights(oidcUser.getEmail());
        model.addAttribute("lookups", lookups);
        return "availableFlightSchedule";
    }


    @GetMapping(path = "/reservations")
    public String getUsersReservations(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        model.addAttribute("flightReservations", flightService.getUsersReservedFlights(oidcUser.getFullName()));
        return "reservations";
    }

}
