package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobSeekerPhotoService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerPhotoDao;
import com.hrms.hrms.entities.concretes.JobSeekerPhoto;

@Service
public class JobSeekerPhotoManager implements JobSeekerPhotoService{

	private JobSeekerPhotoDao jobSeekerPhotoDao; 
	
	@Autowired
	public JobSeekerPhotoManager(JobSeekerPhotoDao jobSeekerPhotoDao) {
		super();
		this.jobSeekerPhotoDao = jobSeekerPhotoDao;
	}

	@Override
	public Result add(JobSeekerPhoto jobSeekerPhoto) {
		jobSeekerPhotoDao.save(jobSeekerPhoto);
		return new SuccessResult("Fotoğraf başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobSeekerPhoto>> findByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerPhoto>>(jobSeekerPhotoDao.findByJobSeekerId(jobSeekerId));
	}

}
