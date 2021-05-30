package com.hrms.hrms.entities.dtos;

import java.time.LocalDate;

import com.hrms.hrms.entities.concretes.JobAdvertisement;
import com.hrms.hrms.entities.concretes.JobTitle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	
	private int totalOpenPosition;
	private LocalDate applicationDeadline;
	private JobTitle jobTitle;
	private LocalDate releaseDate;
	
	public JobAdvertisementDto(JobAdvertisement jobAdvertisement) {
		setTotalOpenPosition(jobAdvertisement.getTotalOpenPosition());
		setApplicationDeadline(jobAdvertisement.getApplicationDeadline());
		setReleaseDate(jobAdvertisement.getReleaseDate());
		setJobTitle(jobAdvertisement.getJobTitle());
	}
	
}
