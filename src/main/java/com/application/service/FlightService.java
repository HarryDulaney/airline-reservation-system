package com.application.service;

import com.application.entity.FlightEntity;
import com.application.entity.User;
import com.application.repository.FlightRepository;
import com.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("FlightService")
public class FlightService {

    private FlightRepository flightRepository;
    private UserRepository userRepository;

    public FlightService(FlightRepository flightRepository, UserRepository userRepository) {
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
    }

    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }


    public List<FlightEntity> getUsersFlights(String userName) {
        User user = userRepository.findUserByUsername(userName);
        return flightRepository.getAllBookedFlights(user.getUserID());
    }

    public FlightEntity deleteUserFromFlight(String userName, Long flightId) {
        User user = userRepository.findUserByUsername(userName);
        Optional<FlightEntity> flightEntity = flightRepository.findById(flightId);
        if (flightEntity.isPresent()) {
            flightRepository.deleteUserFromFlight(user.getUserID(), flightId);
            return flightEntity.get();
        }
        throw new RuntimeException("Could not find a reservation for this user and flight id");
    }
}
