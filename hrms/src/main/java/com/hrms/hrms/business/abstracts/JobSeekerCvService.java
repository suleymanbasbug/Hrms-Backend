package com.hrms.hrms.business.abstracts;


import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeekerCv;
import com.hrms.hrms.entities.concretes.JobSeekerEducation;
import com.hrms.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerCvService {

	Result add(JobSeekerCv jobSeekerCv);
	
	Result addEducation(JobSeekerEducation jobSeekerEducation);
	
	Result addExperience(JobSeekerExperience jobSeekerExperience);
	
	DataResult<JobSeekerCv> findByJobSeekerId(int jobSeekerId);
}
