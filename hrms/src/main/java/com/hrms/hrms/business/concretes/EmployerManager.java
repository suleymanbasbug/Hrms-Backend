package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.userValidation.MailValidationService;
import com.hrms.hrms.core.userValidation.abstracts.RegisterValidationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;
import com.hrms.hrms.entities.dtos.EmployerRegisterDto;

@Service
public class EmployerManager implements EmployerService{

	private RegisterValidationService registerValidationService;
	private EmployerDao employerDao;
	private MailValidationService mailValidationService;
	
	public EmployerManager(RegisterValidationService registerValidationService, EmployerDao employerDao, MailValidationService mailValidationService) {
		super();
		this.registerValidationService = registerValidationService;
		this.employerDao = employerDao;
		this.mailValidationService = mailValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>( employerDao.findAll(),"Başarıyla listelendi");
		
	}

	@Override
	public Result add(EmployerRegisterDto employerRegisterDto) {
		
		if(!registerValidationService.passwordMatch(employerRegisterDto.getPassword(), employerRegisterDto.getPasswordConfirm())) {
			return new ErrorResult("Girdiğiniz şifreler aynı olmalıdır.");
		}
		
		if(!registerValidationService.checkIfEqualEmailAndDomain(employerRegisterDto.getMail(), employerRegisterDto.getWebSite())) {
			
			return new ErrorResult("Girdiğiniz mail web site domaininizden alınmış olmalıdır.");
		}
		
		if(registerValidationService.checkIfExistsMail(employerRegisterDto.getMail())) {
			return new ErrorResult("Bu mail adresiyle kayıtlı kullanıcı var");
		}
		
		Employer employer = new Employer(employerRegisterDto);
		employerDao.save(employer);
		mailValidationService.sendMail();
		
		return new SuccessResult("Şirket Sisteme Başarıyla Eklendi. Sistemimiz tarafından onay sürecinde.");
	}
	
}
