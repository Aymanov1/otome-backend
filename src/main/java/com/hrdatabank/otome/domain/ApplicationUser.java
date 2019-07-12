package com.hrdatabank.otome.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

/**
 * The Class ApplicationUser.
 */
@Entity

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: ApplicationUser.java
 * 
 * Instantiates a new application user.
 */
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class ApplicationUser {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;
}