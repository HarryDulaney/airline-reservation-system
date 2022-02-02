package com.application.controller;

import com.application.entity.Flight;
import com.application.service.FlightService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "searchFlights";
    }

    @PreAuthorize("hasAuthority('users')")
    @ModelAttribute("flights")
    public void flights(Model model) {
        model.addAttribute("flights", flightService.getAllFlights());
    }

    @PreAuthorize("hasAuthority('admins')")
    @GetMapping(path = "/admin/flightSchedule")
    public String getAllFlightsSchedule(@AuthenticationPrincipal OidcUser oidcUser,
                                        Model model) {
        Flight flight = new Flight();
        Flight editFlight = new Flight();
        model.addAttribute("newFlight", flight);
        model.addAttribute("editFlight", editFlight);
        return "admin/flightSchedule";
    }

    @PreAuthorize("hasAuthority('admins')")
    @GetMapping(path = "/admin-api/v1/delete-flight/{id}")
    public String deleteFlight(@AuthenticationPrincipal OidcUser oidcUser,
                               @PathVariable("id") Long flightId,
                               Model model,
                               RedirectAttributes redirAttrs) {
        flightService.delete(flightId);
        redirAttrs.addFlashAttribute("success", "The selected " +
                "flight has been deleted.");

        return "redirect:/admin/flightSchedule";
    }

    @PreAuthorize("hasAuthority('admins')")
    @PostMapping(path = "/admin-api/v1/add-flight")
    public ModelAndView addFlight(@AuthenticationPrincipal OidcUser oidcUser,
                                  @ModelAttribute("newFLight") Flight newFlight,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirAttrs,
                                  ModelAndView mav) {

        if (bindingResult.hasErrors()) {
            redirAttrs.addFlashAttribute("error", "Please clear all errors before adding a new flight..");
            mav.setViewName("/admin/flightSchedule");
            mav.addObject("addFlightResult", bindingResult.getFieldErrors());
            return mav;
        }

        flightService.addFlight(newFlight);
        mav.setViewName("redirect:/admin/flightSchedule");
        redirAttrs.addFlashAttribute("success", "Flight was added successfully.");
        return mav;
    }

    @PreAuthorize("hasAuthority('admins')")
    @PostMapping(path = "/admin-api/v1/save-flight")
    public String editFlight(@ModelAttribute("editFlight") Flight flight, Model model, RedirectAttributes redirAttr) {
        Flight edited = flightService.saveFlight(flight);
        redirAttr.addFlashAttribute("success", "Flight with flight number: " + edited.getFlightNumber() + " " +
                "successfully edited and saved");
        return "redirect:/admin/flightSchedule";
    }
}
