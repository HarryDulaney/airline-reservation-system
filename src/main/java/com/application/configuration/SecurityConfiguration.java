package com.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration {

    @Profile("dev")
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
    @EnableWebSecurity
    public static class SecurityDisabledConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // allow all requests
            http.authorizeRequests().anyRequest().permitAll();
        }
    }

    @Profile("default")
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
    @EnableWebSecurity
    public static class SecurityConfigProduction extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    // allow antonymous access to the root page
                    .antMatchers("/").permitAll()
                    // all other requests
                    .anyRequest().authenticated()

                    // set logout URL
                    .and().logout().logoutSuccessUrl("/")

                    // enable OAuth2/OIDC
                    .and().oauth2Client()
                    .and().oauth2Login();
        }
    }

}
