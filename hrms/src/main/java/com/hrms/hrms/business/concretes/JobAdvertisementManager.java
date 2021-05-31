package com.hrms.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	private ModelMapper modelMapper;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"İş İlanları Başarıyla Listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(dtoGenerator(jobAdvertisementDao.findByIsActive()),"Aktif Tüm İş İlanları Listelendi.");
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> findByEmployer_IdAndIsActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(dtoGenerator(jobAdvertisementDao.findByEmployer_IdAndIsActiveTrue(employerId)),"İlgili Id'ye Sahip İş Verenin Tüm Aktif İlanları Listelendi.");
	}
	
	private List<JobAdvertisementDto> dtoGenerator(List<JobAdvertisement> advertisement){
		List<JobAdvertisementDto> jobAdvertisementDtos = new ArrayList<JobAdvertisementDto>(); 
		advertisement.forEach(item -> {
			jobAdvertisementDtos.add(modelMapper.map(item, JobAdvertisementDto.class));
		});
		return jobAdvertisementDtos;
	
	}


}
