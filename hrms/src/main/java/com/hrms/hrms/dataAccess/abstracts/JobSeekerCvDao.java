package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.JobSeekerCv;

public interface JobSeekerCvDao extends JpaRepository<JobSeekerCv, Integer>{

	JobSeekerCv findByJobSeekerId(int id);
	
}
