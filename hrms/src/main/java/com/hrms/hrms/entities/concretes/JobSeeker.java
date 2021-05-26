package com.hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrms.hrms.entities.dtos.JobSeekerRegisterDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User{

	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	@Column(name="is_mail_active")
	private boolean isMailActive;
	
	public JobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto) {
		setIdentityNumber(jobSeekerRegisterDto.getIdentityNumber());
		setFirstName(jobSeekerRegisterDto.getFirstName());
		setLastName(jobSeekerRegisterDto.getLastName());
		setBirthDate(jobSeekerRegisterDto.getBirthDate());
		setMail(jobSeekerRegisterDto.getMail());
		setPassword(jobSeekerRegisterDto.getPassword());
		setIsActive(true);
		setMailActive(false);
		
	}
}
