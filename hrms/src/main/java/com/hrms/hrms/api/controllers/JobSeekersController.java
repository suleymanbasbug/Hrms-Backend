package com.hrms.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobSeekerService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeeker;
import com.hrms.hrms.entities.dtos.JobSeekerRegisterDto;

@RestController
@RequestMapping("/api/jobseeker")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){			 
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(JobSeekerRegisterDto jobSeekerRegisterDto) {
		return this.jobSeekerService.add(jobSeekerRegisterDto);
	}
	
	
}
