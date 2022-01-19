package com.application.controller;


import com.application.entity.Reservation;
import com.application.service.ReservationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PreAuthorize("hasAuthority('users')")
    @GetMapping(path = "/reservation/delete/{id}")
    public String deleteUserReservation(@AuthenticationPrincipal OidcUser oidcUser, Model model,
                                        @PathVariable(value = "id") Long reservationId) {
        reservationService.cancel(reservationId);
        return "redirect:/reservations";
    }

    @PreAuthorize("hasAuthority('users')")
    @GetMapping(path = "/reservation/book/{id}")
    public String createReservation(@AuthenticationPrincipal OidcUser oidcUser, Model model,
                                    @PathVariable(value = "id") Long flightId) {
        Reservation reservation = reservationService.bookReservation(oidcUser.getEmail(), flightId);
        model.addAttribute("reservation", reservation);
        return "redirect:/reservations";
    }

    @PreAuthorize("hasAuthority('users')")
    @GetMapping(path = "/reservations")
    public String getUsersReservations(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        model.addAttribute("allReservations", reservationService.getAll(oidcUser.getEmail()));
        return "reservations";
    }

}
