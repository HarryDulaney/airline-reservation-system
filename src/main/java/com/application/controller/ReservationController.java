package com.application.controller;


import com.application.service.ReservationService;
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

    @GetMapping(path = "/reservation/delete/{id}")
    public String deleteUserReservation(@AuthenticationPrincipal OidcUser oidcUser, Model model,
                                        @PathVariable(value = "id") Long reservationId) {
        reservationService.cancel(reservationId);
        return "redirect:/reservation";
    }

    @GetMapping(path = "/reservation/book//{id}")
    public String createReservation(@AuthenticationPrincipal OidcUser oidcUser, Model model,
                                    @PathVariable(value = "id") Long reservationId) {
        reservationService.bookReservation(oidcUser.getEmail(), reservationId);
        return "redirect:/reservation";
    }

    @GetMapping(path = "/reservations")
    public String getUsersReservations(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        model.addAttribute("allReservations", reservationService.getAll(oidcUser.getEmail()));
        return "reservations";
    }

}
