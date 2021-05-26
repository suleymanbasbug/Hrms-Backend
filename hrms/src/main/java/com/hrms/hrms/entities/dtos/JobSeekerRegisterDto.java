package com.hrms.hrms.entities.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerRegisterDto {
	
	private String firstName;
	private String lastName;
	private String identityNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String mail;
	private String password;
	private String passwordConfirm;
}
