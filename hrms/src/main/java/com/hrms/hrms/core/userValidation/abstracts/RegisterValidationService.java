package com.hrms.hrms.core.userValidation.abstracts;

public interface RegisterValidationService {

	boolean passwordMatch(String password, String confirmPassword);
	boolean checkIfExistsIdentityNumber(String identityNumber);
	boolean checkIfExistsMail(String mail);
	boolean checkIfEqualEmailAndDomain(String mail, String website);
}
