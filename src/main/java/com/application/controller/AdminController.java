package com.application.controller;

import java.math.BigDecimal;
import java.util.List;

import com.application.entity.FlightEntity;
import com.application.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAuthority('admin')")
@Controller
public class AdminController {

    private FlightRepository flightRepository;

    @Autowired
    public AdminController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    //working
    @PostMapping(path = "/busscheduleJ/add")
    public FlightEntity createBus(FlightEntity busschedule) {
        flightRepository.save(busschedule);
        return busschedule;
    }

    @GetMapping(path = "/availablebusschedule/addto/{busID}")
    public String addbusSchedule(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", flightService.findById(busID));
        flightService.addBusToAccount(UserDetailsServiceImpl.uid, busID);
        return "redirect:/availablebusschedule";
    }

//
//    @GetMapping(path = "/busschedule/delete/{busID}")
//    public String deleteBus(@PathVariable(name = "busID") long busID) {
//        flightService.deleteById(busID);
//        return "redirect:/flightSchedule";
//    }

    @GetMapping(path = "/busschedule/edit/{busID}")
    public String editBusSchedule(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", flightService.findById(busID));
        return "edit";
    }

    @PostMapping(path = "/admin/flights/save")
    public String saveFlight(FlightEntity flightEntity) {
        flightService.saveFlight;
        return "redirect:/flightSchedule";
    }

    @GetMapping(path = "/busschedule/add")
    public String createBus(Model model) {
        model.addAttribute("bus", new FlightEntity());
        return "edit";
    }

    //working
    @GetMapping(path = "/busscheduleJ")
    public List<FlightEntity> getAllBusScheduleJSON() {
        return flightRepository.findAll();
    }

    //working
    @GetMapping(path = "/busreservationJ")
    public List<FlightEntity> getAllBusSchedule1() {
        return flightRepository.findByAccountUserID();
    }

    //working
    @GetMapping(path = "/availablebusscheduleJ")
    public List<FlightEntity> getAllBusSchedule3() {
        return flightRepository.findAllNotInAccount();
    }


    //working
    @PutMapping(path = "/busscheduleJ/edit/{busID}")
    public String editBus(@PathVariable(value = "busID") long busID, @RequestBody FlightEntity busschedule) {
        flightRepository.save(busschedule);
        return "Bus Saved";

    }


    //working
    @DeleteMapping(path = "/busscheduleJ/delete/{busID}")
    public void deleteBus(@PathVariable(name = "busID") long busID) {
        flightRepository.deleteById(busID);
    }


    //working
    @PostMapping(path = "/availablebusscheduleJ/addto/{busID}")
    public void addbusSchedule(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", flightRepository.findById(busID));
        flightRepository.addBusToAccount(, busID);
    }

    //working
    @DeleteMapping(path = "/busreservationJ/delete/{busID}")
    public void deleteBusinAccount(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", flightRepository.findById(busID));
        flightRepository.deleteBusInAccount(, busID);
    }


    @GetMapping(path = "/busscheduleJ/total")
    public BigDecimal totalPrice(Model model) {
        //model.addAttribute("totalprice", busRepository.findTotalinAccount(MenuUserDetailsService.userID1));
        return flightRepository.findTotalinAccount();
    }


}
