package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer>{

}
