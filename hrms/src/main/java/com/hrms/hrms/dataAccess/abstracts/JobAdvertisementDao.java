package com.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	@Query("From JobAdvertisement where isActive=true and employerIsActive=true")
	List<JobAdvertisement> getByIsActive();
	
	List<JobAdvertisement> getByEmployer_IdAndIsActiveTrue(int employerId);
}
