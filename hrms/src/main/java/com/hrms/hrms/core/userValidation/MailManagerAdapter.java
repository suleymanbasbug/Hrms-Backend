package com.hrms.hrms.core.userValidation;

import org.springframework.stereotype.Service;

@Service
public class MailManagerAdapter implements MailValidationService{

	@Override
	public void sendMail() {
		System.out.println("E-posta adresine mail başarıyla gönderildi");
		
	}

}
