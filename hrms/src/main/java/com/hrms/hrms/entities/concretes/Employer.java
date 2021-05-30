package com.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entities.dtos.EmployerRegisterDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
public class Employer extends User {
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="is_mail_active")
	private boolean isMailActive;
	
	@Column(name="web_site")
	private String webSite;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	public Employer(EmployerRegisterDto employerRegisterDto) {
		setCompanyName(employerRegisterDto.getCompanyName());
		setWebSite(employerRegisterDto.getWebSite());
		setMail(employerRegisterDto.getMail());
		setPassword(employerRegisterDto.getPassword());
		setPhone(employerRegisterDto.getPhone());
		setIsActive(false);
		setMailActive(false);
	}
	
}
