package com.hrms.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobSeekerCvService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerCvDao;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerEducationDao;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import com.hrms.hrms.entities.concretes.JobSeekerCv;
import com.hrms.hrms.entities.concretes.JobSeekerEducation;
import com.hrms.hrms.entities.concretes.JobSeekerExperience;

@Service
public class JobSeekerCvManager implements JobSeekerCvService {

	private JobSeekerCvDao jobSeekerCvDao;
	private JobSeekerEducationDao jobSeekerEducationDao;
	private JobSeekerExperienceDao jobSeekerExperienceDao;
	
	@Autowired
	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao, 
							  JobSeekerEducationDao jobSeekerEducationDao,
							  JobSeekerExperienceDao jobSeekerExperienceDao) {
		super();
		this.jobSeekerCvDao = jobSeekerCvDao;
		this.jobSeekerEducationDao = jobSeekerEducationDao;
		this.jobSeekerExperienceDao = jobSeekerExperienceDao;
	}

	
	@Override
	public Result add(JobSeekerCv jobSeekerCv) {
		jobSeekerCvDao.save(jobSeekerCv);
		return new SuccessResult("Gerekli Bilgiler Eklendi");
	}


	@Override
	public Result addEducation(JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationDao.save(jobSeekerEducation);
		return new SuccessResult("Eğitim Eklendi");
	}


	@Override
	public Result addExperience(JobSeekerExperience jobSeekerExperience) {
		this.jobSeekerExperienceDao.save(jobSeekerExperience);
		return new SuccessResult("İş Tecrübesi Eklendi");
	}


	@Override
	public DataResult<JobSeekerCv> findByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<JobSeekerCv>(jobSeekerCvDao.findByJobSeekerId(jobSeekerId)); 
	}

}
