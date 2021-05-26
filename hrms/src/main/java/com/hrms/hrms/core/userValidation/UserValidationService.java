package com.hrms.hrms.core.userValidation;

import com.hrms.hrms.entities.concretes.JobSeeker;

public interface UserValidationService {
	
	boolean isValidated(JobSeeker jobSeeker);
}
