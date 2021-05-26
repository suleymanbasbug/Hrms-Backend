package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
