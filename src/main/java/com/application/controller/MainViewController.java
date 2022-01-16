package com.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainViewController {

    @Value(value = "${register.okta.oauth2.redirect-uri}")
    private String registerUrl;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        model.addAttribute("user", oidcUser);
        return "index";
    }

    @GetMapping("/register")
    public String register(@AuthenticationPrincipal OidcUser oidcUser) {
        return "redirect:" + registerUrl;
    }
}
