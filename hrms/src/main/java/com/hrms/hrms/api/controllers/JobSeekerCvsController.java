package com.hrms.hrms.api.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeeker;
import com.hrms.hrms.entities.concretes.JobSeekerCv;
import com.hrms.hrms.entities.concretes.JobSeekerEducation;
import com.hrms.hrms.entities.concretes.JobSeekerExperience;
import com.hrms.hrms.entities.concretes.JobSeekerLanguage;
import com.hrms.hrms.entities.concretes.JobSeekerPhoto;
import com.hrms.hrms.core.services.CloudService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;

@RestController
@RequestMapping("/api/jobseekercv")
public class JobSeekerCvsController {

	private JobSeekerCvService jobSeekerCvService;
	private CloudService cloudService;
	
	
	public JobSeekerCvsController(JobSeekerCvService jobSeekerCvService,CloudService cloudService) {
		super();
		this.jobSeekerCvService = jobSeekerCvService;
		this.cloudService = cloudService;
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
	
	@PostMapping("/addLanguage")
	public ResponseEntity<?> addLanguage(@Valid @RequestBody JobSeekerLanguage jobSeekerLanguage){
		return ResponseEntity.ok(jobSeekerCvService.addLanguage(jobSeekerLanguage));
	}
	
	@PostMapping("/addPhoto")
	public Result addPhoto(@RequestParam MultipartFile multipartFile, int jobSeekerId) throws IOException {
		if(!multipartFile.isEmpty() ) {
			Map uploadResult = cloudService.upload(multipartFile);
			JobSeekerPhoto jobSeekerPhoto = new JobSeekerPhoto(0,uploadResult.get("url").toString(),
					uploadResult.get("public_id").toString(),LocalDate.now(),jobSeekerId);
			return jobSeekerCvService.addPhoto(jobSeekerPhoto);
		}
		
		return new ErrorResult("Resim Seçmediniz");
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
