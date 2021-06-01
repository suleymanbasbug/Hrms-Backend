package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_seeker_educations")
public class JobSeekerEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank
	@NotNull
	@Column(name = "department_name")
	private String deparmentName;
	
	@Min(1950)
	@Max(2030)
	@NotBlank
	@NotNull
	@Column(name = "start_year")
	private int startYear;
	
	@Min(1950)
	@Max(2030)
	@Column(name = "graduation_year")
	private int graduationYear;
	
	@NotNull
	@Column(name = "is_continued")
	private boolean isContinued;
	
	@ManyToOne()
	@JoinColumn(name = "jobSeeker_id")
	private JobSeeker jobSeeker;
	
}