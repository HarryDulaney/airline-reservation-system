package com.application.controller;

import com.okta.spring.boot.oauth.config.OktaOAuth2Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;


@Controller
public class MainViewController {

    @Value(value = "${register.okta.oauth2.redirect-uri}")
    private String registerUrl;


    @Value(value = "${okta.base.url}")
    private String oktaBaseUrl;

    private static final String STATE = "state";
    private static final String NONCE = "nonce";
    private static final String SCOPES = "scopes";
    private static final String OKTA_BASE_URL = "oktaBaseUrl";
    private static final String OKTA_CLIENT_ID = "oktaClientId";
    private static final String REDIRECT_URI = "redirectUri";
    private static final String ISSUER_URI = "issuerUri";
    private static final String LOGO = "signInLogoPath";


    private final OktaOAuth2Properties oktaOAuth2Properties;

    public MainViewController(OktaOAuth2Properties oktaOAuth2Properties) {
        this.oktaOAuth2Properties = oktaOAuth2Properties;
    }


    @GetMapping("/")
    public String index(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        model.addAttribute("user", oidcUser);
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "redirect:" + registerUrl;
    }

    @GetMapping("/login?logout")
    public String logoutSuccess(Model model) {
        // TODO: Logout successful message here.
        return "index";
    }


    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request) throws MalformedURLException {

        String issuer = oktaOAuth2Properties.getIssuer();
        ModelAndView mav = new ModelAndView("login");
        mav.addObject(SCOPES, oktaOAuth2Properties.getScopes());
        mav.addObject(LOGO, "/img/AirSimLogo.png");
        mav.addObject(OKTA_BASE_URL, oktaBaseUrl);
        mav.addObject(OKTA_CLIENT_ID, oktaOAuth2Properties.getClientId());
        mav.addObject(REDIRECT_URI,
                request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                        request.getContextPath() + "/authorization-code/callback"
        );
        mav.addObject(ISSUER_URI, issuer);

        return mav;
    }

    @GetMapping("/authorization-code/callback")
    public String authCallback(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        model.addAttribute("user", oidcUser);
        return "index";
    }

    @GetMapping("/requestAdmin")
    public ModelAndView adminRequestForm(@AuthenticationPrincipal OidcUser oidcUser, ModelAndView mav) {
        mav.setViewName("adminRequest");
        mav.addObject("userFirstName", oidcUser.getGivenName());
        mav.addObject("userLastName", oidcUser.getFamilyName());
        mav.addObject("userEmail", oidcUser.getEmail());
        mav.addObject("userEmailVerified", oidcUser.getEmailVerified());
        return mav;
    }
}
