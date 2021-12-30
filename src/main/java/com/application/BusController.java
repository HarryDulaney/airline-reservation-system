package com.application;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.security.UserDetailsServiceImpl;

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
        model.addAttribute("busschedule", busRepository.findByAccountUserID(UserDetailsServiceImpl.userID1));
        return "busreservation";
    }
    
    @GetMapping(path = "/availablebusschedule")
    public String getAllBusSchedule3(Model model) {
        model.addAttribute("busschedule", busRepository.findAllNotInAccount(UserDetailsServiceImpl.userID1));
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
        busRepository.addBusToAccount(UserDetailsServiceImpl.userID1,busID);
        return "redirect:/availablebusschedule";
    }
    
    
    @GetMapping(path = "/busreservation/delete/{busID}")
    public String deleteBusinAccount(Model model, @PathVariable(value = "busID") long busID) {
        model.addAttribute("bus", busRepository.findById(busID));
        busRepository.deleteBusInAccount(UserDetailsServiceImpl.userID1,busID);
        return "redirect:/busreservation";
    }
    
    
    @GetMapping()
    public BigDecimal totalPrice(Model model) {
        model.addAttribute("totalprice", busRepository.findTotalinAccount(UserDetailsServiceImpl.userID1));
        return busRepository.findTotalinAccount(UserDetailsServiceImpl.userID1);
    }
    
    
    
    
    
    
    
    
    
    
    

    
   
    

	 
    
    

}
