package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Role;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleRepository.
 */
@Repository
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: RoleRepository.java
	 * 
	 *         Find role by name.
	 * @param name
	 *            the name
	 * @return the role
	 */
	@Query("SELECT r FROM Role r where LOWER(r.name) = LOWER(:name)")
	public Role findRoleByName(@Param("name") String name);

}
