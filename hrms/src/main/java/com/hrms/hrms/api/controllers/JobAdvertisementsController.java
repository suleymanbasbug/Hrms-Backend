package com.hrms.hrms.api.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvertisement;
import com.hrms.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}


	@GetMapping("/getall")
	DataResult<List<JobAdvertisement>> getAll(){
		
		return jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getbyisactive")
	DataResult<List<JobAdvertisementDto>> getByIsActive(){
		return jobAdvertisementService.getByIsActive();
	}
	
	@GetMapping("/getByEmployer_IdAndIsActiveTrue")
	DataResult<List<JobAdvertisementDto>> getByEmployer_IdAndIsActiveTrue(@RequestParam int employerId){
		return jobAdvertisementService.getByEmployer_IdAndIsActiveTrue(employerId);
	}
}
