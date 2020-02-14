package com.example.careers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.BusRepository;

@Controller
public class CareersController {

	private CareersRepository careersRepository;

	@Autowired
	public CareersController(CareersRepository careersRepository) {
		super();
		this.careersRepository = careersRepository;
	}

	@GetMapping(path = "/jobs")
	public String getAllJobs(Model model) {
		model.addAttribute("JobPostings", careersRepository.findAll());
		return "jobs";
	}

	@GetMapping(path = "/jobs/apply/")
	public String ApplyforJob(Model model) {
		model.addAttribute("JobPostings", careersRepository.findAll());
		return "upload";
	}
	
	

}
