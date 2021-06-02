package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeekerPhoto;

public interface JobSeekerPhotoService {

	Result add(JobSeekerPhoto jobSeekerPhoto);
	DataResult<List<JobSeekerPhoto>> findByJobSeekerId(int jobSeekerId);
}