package com.hrms.hrms.core.userValidation;



import org.springframework.stereotype.Service;

import com.hrms.hrms.entities.concretes.JobSeeker;



@Service
public class MernisManagerAdapter implements UserValidationService{

	@Override
	public boolean isValidated(JobSeeker jobSeeker) {
		System.out.println("Doğrulama Yapıldı");
		return true;
	}


}
