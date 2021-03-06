package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="system_users")
public class SystemUser {

	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
}
