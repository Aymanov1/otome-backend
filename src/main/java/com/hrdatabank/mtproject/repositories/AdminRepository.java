package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Admin;

/**
 * The Interface AdminRepository.
 */
@Repository
@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin, Serializable> {
	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AdminRepository.java
	 * 
	 *         Find admin by email.
	 * @param email
	 *            the email
	 * @return the admin
	 */
	@Query("SELECT a FROM Admin a where a.email = :email")
	public Admin findAdminByEmail(@Param("email") String email);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AdminRepository.java
	 * 
	 *         Find admin by name.
	 * @param email
	 *            the email
	 * @return the admin
	 */
	@Query("SELECT a FROM Admin a where a.userName = :name")
	public Admin findAdminByName(@Param("name") String email);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AdminRepository.java
	 * 
	 *         Find all admins by keyword paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	@Query(value = "SELECT a from Admin a where lower(a.userName) like lower(CONCAT('%',:keyword,'%')) or lower(a.email) like lower(CONCAT('%',:keyword,'%'))", countQuery = "SELECT COUNT(*) from Admin a where lower(a.userName) like lower(CONCAT('%',:keyword,'%')) or lower(a.email) like lower(CONCAT('%',:keyword,'%'))")
	public Page<Admin> findAllAdminsByKeywordPaginated(Pageable pageable, @Param("keyword") String keyword);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AdminRepository.java
	 * 
	 *         Find by username.
	 * @param username
	 *            the username
	 * @return the optional
	 */
	@Query("select u from Admin u  where u.email=:email")
	public Optional<Admin> findByUsername(@Param("email") String username);

}
