package com.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.JobSeekerPhoto;

public interface JobSeekerPhotoDao extends JpaRepository<JobSeekerPhoto, Integer>{
	
	List<JobSeekerPhoto> findByJobSeekerId(int jobSeekerId);
}
