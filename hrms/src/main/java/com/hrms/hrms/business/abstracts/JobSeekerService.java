package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeeker;
import com.hrms.hrms.entities.dtos.JobSeekerRegisterDto;

public interface JobSeekerService  {

	Result add(JobSeekerRegisterDto jobSeekerRegisterDto);
	DataResult<List<JobSeeker>> getAll();
}
