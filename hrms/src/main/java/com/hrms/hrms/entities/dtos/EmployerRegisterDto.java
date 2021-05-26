package com.hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRegisterDto {
	
	private String companyName;
	private String webSite;
	private String mail;
	private String phone;
	private String password;
	private String passwordConfirm;
}
