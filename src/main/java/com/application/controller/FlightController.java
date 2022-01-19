package com.application.controller;

import com.application.entity.Flight;
import com.application.service.FlightService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PreAuthorize("hasAuthority('users')")
    @GetMapping(path = "searchFlights")
    public String searchAvailableFlights(@AuthenticationPrincipal OidcUser oidcUser,
                                         Model model) {
        List<Flight> flights = flightService.getAvailableFlights(oidcUser.getEmail());
        model.addAttribute("resultFlights", flights);
        return "searchFlights";
    }

    @PreAuthorize("hasAuthority('admins')")
    @GetMapping(path = "/admin/flightSchedule")
    public String getAllFlightsSchedule(@AuthenticationPrincipal OidcUser oidcUser,
                                        Model model) {
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "admin/flightSchedule";
    }

    @PreAuthorize("hasAuthority('admins')")
    @GetMapping(path = "/admin/flight-schedule/delete/{id}")
    public String deleteFlight(@AuthenticationPrincipal OidcUser oidcUser,
                               @PathVariable(name = "id") Long flightId,
                               Model model) {
        flightService.deleteFlight(flightId);
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "redirect:/admin/flightSchedule";
    }

    @PreAuthorize("hasAuthority('admins')")
    @GetMapping(path = "/admin/flight-schedule/edit/{id}")
    public String editFlightSchedule(Model model, @PathVariable(value = "id") Long flightId) {
        model.addAttribute("flight", flightService.getFlightById(flightId));
        return "admin/edit";
    }

}
