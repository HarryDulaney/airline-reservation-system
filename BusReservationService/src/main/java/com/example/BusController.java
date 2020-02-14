package com.example;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.auth.BusUserDetailsService;
import com.example.auth.User;
import com.example.auth.UserRepository;

@Controller
public class BusController {

    private BusRepository busRepository;
    
    @Autowired
    public BusController(BusRepository busRepository) {
		super();
		this.busRepository=busRepository;
	}
    
    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

	@GetMapping(path = "/busschedule/add")
    public String createBus(Model model) {
        model.addAttribute("bus", new BusSchedule());
        return "edit"; 
    } 

    @PostMapping(path = "/busschedule/save")
    public String saveBus(BusSchedule busschedule) {
    	busRepository.save(busschedule); 
        return "redirect:/busschedule";
    }

    @GetMapping(path = "/busschedule")
    public String getAllBusSchedule(Model model) {
        model.addAttribute("busschedule", busRepository.findAll());
        return "busschedule";
    }
    
    @GetMapping(path = "/busreservation")
    public String getAllBusSchedule1(Model model) {
        model.addAttribute("busschedule", busRepository.findByAccountUserID(BusUserDetailsService.userID1));
        return "busreservation";
    }
    
    @GetMapping(path = "/availablebusschedule")
    public String getAllBusSchedule3(Model model) {
        model.addAttribute("busschedule", busRepository.findAllNotInAccount(BusUserDetailsService.userID1));
        return "availablebusschedule";
    }

    @GetMapping(path = "/busschedule/edit/{busID}")
    public String editBusSchedule(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", busRepository.findById(busID));
        return "edit";
    }
    

    @GetMapping(path = "/busschedule/delete/{busID}")
    public String deleteBus(@PathVariable(name = "busID") long busID) {
        busRepository.deleteById(busID);
        return "redirect:/busschedule";
    }
    
    @GetMapping(path = "/availablebusschedule/addto/{busID}")
    public String addbusSchedule(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", busRepository.findById(busID));
        busRepository.addBusToAccount(BusUserDetailsService.userID1,busID);
        return "redirect:/availablebusschedule";
    }
    
    
    @GetMapping(path = "/busreservation/delete/{busID}")
    public String deleteBusinAccount(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", busRepository.findById(busID));
        busRepository.deleteBusInAccount(BusUserDetailsService.userID1,busID);
        return "redirect:/busreservation";
    }
    
    
    @GetMapping()
    public BigDecimal totalPrice(Model model) {
        model.addAttribute("totalprice", busRepository.findTotalinAccount(BusUserDetailsService.userID1));
        return busRepository.findTotalinAccount(BusUserDetailsService.userID1);
    }
    
    
    
    
    
    
    
    
    
    
    

    
   
    

	 
    
    

}