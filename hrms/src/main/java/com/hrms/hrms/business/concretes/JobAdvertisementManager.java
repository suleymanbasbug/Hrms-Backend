package com.hrms.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.hrms.entities.concretes.JobAdvertisement;
import com.hrms.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"İş İlanları Başarıyla Listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(dtoGenerator(jobAdvertisementDao.getByIsActive()));
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getByEmployer_IdAndIsActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(dtoGenerator(jobAdvertisementDao.getByEmployer_IdAndIsActiveTrue(employerId)));
	}
	
	private List<JobAdvertisementDto> dtoGenerator(List<JobAdvertisement> advertisement){
		List<JobAdvertisementDto> jobAdvertisementDtos = new ArrayList<JobAdvertisementDto>(); 
		advertisement.forEach(item -> {
			jobAdvertisementDtos.add(new JobAdvertisementDto(item));
		});
		return jobAdvertisementDtos;
	
	}


}
