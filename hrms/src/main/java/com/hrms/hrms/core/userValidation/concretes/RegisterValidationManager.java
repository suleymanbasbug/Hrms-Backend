package com.hrms.hrms.core.userValidation.concretes;

import org.springframework.stereotype.Service;

import com.hrms.hrms.core.userValidation.abstracts.RegisterValidationService;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.hrms.dataAccess.abstracts.UserDao;

@Service
public class RegisterValidationManager implements RegisterValidationService{

	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;
	
	public RegisterValidationManager(JobSeekerDao jobSeekerDao , UserDao userDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userDao = userDao;
	}

	@Override
	public boolean passwordMatch(String password, String confirmPassword) {
		boolean result = password.equals(confirmPassword);
		return result;
	}

	@Override
	public boolean checkIfExistsIdentityNumber(String identityNumber) {
		if(jobSeekerDao.findByIdentityNumber(identityNumber)==null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIfExistsMail(String mail) {
		if(userDao.findByMail(mail)==null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIfEqualEmailAndDomain(String mail, String website) {
		String[] mailArr = mail.split("@", 2);
		String domain = website.substring(4, website.length());
		System.out.println(mailArr[1]);
		System.out.println(domain);
		if (mailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

}
