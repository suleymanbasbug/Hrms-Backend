package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_advertisements")
public class JobAdvertisement {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="total_open_position")
	private int totalOpenPosition;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@JsonIgnore
	@Column(name="release_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate releaseDate=LocalDate.now();
	
	@Column(name="is_active", columnDefinition = "boolean default true")
	private boolean isActive=true;
	
	@Column(name="employer_is_active", columnDefinition = "boolean default true")
	private boolean employerIsActive=true;

	@ManyToOne()
	@JoinColumn(name = "jobTitle_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
}
