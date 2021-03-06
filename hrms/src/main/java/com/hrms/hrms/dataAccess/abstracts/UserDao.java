package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.User;
import java.lang.String;


public interface UserDao extends JpaRepository<User, Integer> {

	User findByMail(String mail);
}
