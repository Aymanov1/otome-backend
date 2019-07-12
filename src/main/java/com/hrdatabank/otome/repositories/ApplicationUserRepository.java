package com.hrdatabank.otome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.ApplicationUser;

/**
 * The Interface ApplicationUserRepository.
 */
@Repository
@RepositoryRestResource
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: ApplicationUserRepository.java
	 * 
	 *         Find by username.
	 * @param username
	 *            the username
	 * @return the application user
	 */
	ApplicationUser findByUsername(String username);
}