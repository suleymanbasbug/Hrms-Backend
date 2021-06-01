package com.hrms.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobSeekerEducationService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerEducationDao;
import com.hrms.hrms.entities.concretes.JobSeekerEducation;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {

	private JobSeekerEducationDao jobSeekerEducationDao;
	
	@Autowired
	public JobSeekerEducationManager(JobSeekerEducationDao jobSeekerEducationDao) {
		super();
		this.jobSeekerEducationDao = jobSeekerEducationDao;
	}

	@Override
	public Result add(JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationDao.save(jobSeekerEducation);
		return new SuccessResult("Eğitim Bilgisi Başarıyla Eklendi");
	}

}
