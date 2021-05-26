package com.hrms.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hrms.hrms.business.abstracts.JobSeekerService;
import com.hrms.hrms.core.userValidation.MailValidationService;
import com.hrms.hrms.core.userValidation.UserValidationService;
import com.hrms.hrms.core.userValidation.abstracts.RegisterValidationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.hrms.entities.concretes.JobSeeker;
import com.hrms.hrms.entities.dtos.JobSeekerRegisterDto;


@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private UserValidationService userValidationService;
	private MailValidationService mailValidationService;
	private RegisterValidationService registerValidationService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserValidationService userValidationService, MailValidationService mailValidationService, RegisterValidationService registerValidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userValidationService = userValidationService;
		this.mailValidationService = mailValidationService;
		this.registerValidationService = registerValidationService;
	}



	@Override
	public Result add(@RequestBody JobSeekerRegisterDto jobSeekerRegisterDto ) {
		JobSeeker jobSeeker = new JobSeeker(jobSeekerRegisterDto);
		if(!registerValidationService.passwordMatch(jobSeekerRegisterDto.getPassword(), jobSeekerRegisterDto.getPasswordConfirm())) {
			return new ErrorResult("Girdiğiniz şifreler aynı olmalıdır.");
		}
		
		if(!userValidationService.isValidated(jobSeeker)) {
			return new ErrorResult("Mernis üzerinden kişi doğrulanamadı.");
		}
		if(registerValidationService.checkIfExistsIdentityNumber(jobSeeker.getIdentityNumber())) {
			return new ErrorResult("Bu kimlik numarasıyla kayıtlı kullanıcı var.");
		}
		
		if(registerValidationService.checkIfExistsMail(jobSeeker.getMail())) {
			return new ErrorResult("Bu mail adresiyle kayıtlı kullanıcı var");
		}
		jobSeekerDao.save(jobSeeker);
		mailValidationService.sendMail();
		return new SuccessResult("Kullanıcı başarıyla eklendi.");
	}



	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

}
