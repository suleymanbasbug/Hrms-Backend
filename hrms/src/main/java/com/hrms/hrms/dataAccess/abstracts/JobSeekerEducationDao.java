package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer>{

}
