package com.application.controller;

import com.application.entity.FlightEntity;
import com.application.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

//    @PreAuthorize("hasAuthority('user')")
@PreAuthorize("hasAuthority('Everyone')")
@Controller
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }


    @GetMapping(path = "/flightSchedule")
    public String getAllBusSchedule(Model model) {
        List<FlightEntity> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "flightSchedule";
    }

    @GetMapping(path = "/reservations")
    public String getAllUsersFlights(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("flightReservations", flightService.getUsersFlights(principal.getName()));
        return "reservations";
    }


    @GetMapping(path = "/reservation/delete/{id}")
    public String removeUserFromFlight(@AuthenticationPrincipal Principal principal, Model model,
                                       @PathVariable(value = "id") Long flightId) {
        FlightEntity flight = flightService.deleteUserFromFlight(principal.getName(),flightId);
        model.addAttribute("removedFlight", flight);
        return "redirect:/reservation";
    }


}
