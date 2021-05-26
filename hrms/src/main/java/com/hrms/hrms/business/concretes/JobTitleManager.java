package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobTitleService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.hrms.entities.concretes.JobTitle;

 @Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(),"Genel iş pozisyonları başarıyla listelendi.");
	}

}
