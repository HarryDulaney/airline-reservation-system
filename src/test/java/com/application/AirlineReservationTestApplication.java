package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan("com.application")
public class AirlineReservationTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineReservationTestApplication.class, args);
    }

}
