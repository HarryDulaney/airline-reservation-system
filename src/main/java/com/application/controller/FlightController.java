package com.application.controller;

import com.application.entity.Flight;
import com.application.service.FlightService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PreAuthorize("hasAuthority('users')")
    @GetMapping(path = "/searchFlights")
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
        Flight flight = new Flight();
        model.addAttribute("newFlight", flight);
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "admin/flightSchedule";
    }

    @PreAuthorize("hasAuthority('admins')")
    @PostMapping(path = "/administrator/flight-schedule-delete")
    public String deleteFlight(@AuthenticationPrincipal OidcUser oidcUser,
                               @ModelAttribute("flight") Flight flight,
                               Model model) {
        flightService.deleteFlight(flight);
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "redirect:/admin/flightSchedule";
    }

    @PreAuthorize("hasAuthority('admins')")
    @PostMapping(path = "/administrator/flight-schedule-add")
    public ModelAndView addFlight(@AuthenticationPrincipal OidcUser oidcUser,
                                  @Valid Flight newFlight,
                                  BindingResult bindingResult,
                                  ModelAndView mav) {

        if (bindingResult.hasErrors()) {
            mav.setViewName("/admin/flightSchedule");
            mav.addObject("addFlightResult", bindingResult.getFieldErrors());
            return mav;
        }

        flightService.addFlight(newFlight);
        List<Flight> flights = flightService.getAllFlights();
        mav.setViewName("redirect:/admin/flightSchedule");
        mav.addObject("flights", flights);
        return mav;
    }

    @PreAuthorize("hasAuthority('admins')")
    @PostMapping(path = "/administrator/flight-schedule-save")
    public String editFlightSchedule(@ModelAttribute("flight") Flight flight, Model model) {
        flightService.saveFlight(flight);
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "redirect:/admin/flightSchedule";
    }

}
