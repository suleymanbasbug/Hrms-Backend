package com.hrms.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeekerCv;
import com.hrms.hrms.entities.concretes.JobSeekerEducation;
import com.hrms.hrms.entities.concretes.JobSeekerExperience;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/api/jobseekercv")
public class JobSeekerCvsController {

	private JobSeekerCvService jobSeekerCvService;
	
	public JobSeekerCvsController(JobSeekerCvService jobSeekerCvService) {
		super();
		this.jobSeekerCvService = jobSeekerCvService;
	}

	@GetMapping("/findbyjobseekerid")
	public DataResult<JobSeekerCv> findByJobSeekerId(int jobSeekerId){
		return jobSeekerCvService.findByJobSeekerId(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobSeekerCv jobSeekerCv ){
		return jobSeekerCvService.add(jobSeekerCv);
	}
	
	@PostMapping("/addEducation")
	public ResponseEntity<?> addEducation(@Valid @RequestBody JobSeekerEducation jobSeekerEducation) {
		return ResponseEntity.ok(jobSeekerCvService.addEducation(jobSeekerEducation));
	}
	
	@PostMapping("/addExperience")
	public ResponseEntity<?> addExperience(@Valid @RequestBody JobSeekerExperience jobSeekerExperience) {
		return ResponseEntity.ok(jobSeekerCvService.addExperience(jobSeekerExperience));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları.");
		return errors;
	}
}
