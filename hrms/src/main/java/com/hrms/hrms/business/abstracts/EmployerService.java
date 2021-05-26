package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;
import com.hrms.hrms.entities.dtos.EmployerRegisterDto;

public interface EmployerService  {

	DataResult<List<Employer>> getAll();
	Result add(EmployerRegisterDto employerRegisterDto);
}
