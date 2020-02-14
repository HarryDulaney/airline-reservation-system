package com.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.BusUserDetailsService;
import com.example.auth.User;
import com.example.auth.UserRepository;

@RestController
public class RestBusController {

    private BusRepository busRepository;
    
    @Autowired
    public RestBusController(BusRepository busRepository) {
		super();
		this.busRepository=busRepository;
	}
    
    //working
	@PostMapping(path = "/busscheduleJ/add")
    public BusSchedule createBus(BusSchedule busschedule) {
		busRepository.save(busschedule);
    	return busschedule; 
    }

    //working
    @GetMapping(path = "/busscheduleJ")
    public List<BusSchedule> getAllBusScheduleJSON() {
        return busRepository.findAll();
    }
    
    //working
    @GetMapping(path = "/busreservationJ")
    public List<BusSchedule> getAllBusSchedule1() {
        return busRepository.findByAccountUserID(BusUserDetailsService.userID1);
    }
    //working
    @GetMapping(path = "/availablebusscheduleJ")
    public List<BusSchedule> getAllBusSchedule3() {
        return busRepository.findAllNotInAccount(BusUserDetailsService.userID1);
    }
    
    
    //working
    @PutMapping(path = "/busscheduleJ/edit/{busID}")
    public String editBus(@PathVariable(value = "busID") long busID,@RequestBody BusSchedule busschedule) {
         busRepository.save(busschedule);
         return "Bus Saved";

    }
   
    
    //working
    @DeleteMapping(path = "/busscheduleJ/delete/{busID}")
    public void deleteBus(@PathVariable(name = "busID") long busID) {
        busRepository.deleteById(busID);
    }
    
    
    //working
    @PostMapping(path = "/availablebusscheduleJ/addto/{busID}")
    public void addbusSchedule(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", busRepository.findById(busID));
        busRepository.addBusToAccount(BusUserDetailsService.userID1,busID);
    }
    
    //working
    @DeleteMapping(path = "/busreservationJ/delete/{busID}")
    public void deleteBusinAccount(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", busRepository.findById(busID));
        busRepository.deleteBusInAccount(BusUserDetailsService.userID1,busID);
    }


    @GetMapping(path = "/busscheduleJ/total")
    public BigDecimal totalPrice(Model model) {
        //model.addAttribute("totalprice", busRepository.findTotalinAccount(MenuUserDetailsService.userID1));
        return busRepository.findTotalinAccount(BusUserDetailsService.userID1);
    }

	 
    
    
}