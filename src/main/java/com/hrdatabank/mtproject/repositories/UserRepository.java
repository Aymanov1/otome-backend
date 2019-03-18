package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.UserInformation;

/**
 * The Interface UserRepository.
 */
@Repository
@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserInformation, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: UserRepository.java
	 * 
	 *         Find user information by name.
	 * @param email
	 *            the email
	 * @return the user information
	 */
	@Query("SELECT a FROM UserInformation a where a.email = :email")
	public UserInformation findUserInformationByName(@Param("email") String email);

}