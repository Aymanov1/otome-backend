package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.AffiliateApplication;

// TODO: Auto-generated Javadoc
/**
 * The Interface AffiliateApplicationRepository.
 */
@Repository
@RepositoryRestResource
public interface AffiliateApplicationRepository extends JpaRepository<AffiliateApplication, Serializable> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: AffiliateApplicationRepository.java
	 * 
	 * Gets the affiliate application.
	 * @param referrer the referrer
	 * @return the affiliate application
	 */
	@Query(value = "select af from AffiliateApplication af where af.referrer like  (:referrer)", countQuery = "select count(*)  from AffiliateApplication af where af.referrer like  (:referrer))")
	public AffiliateApplication getAffiliateApplication(@Param("referrer") String referrer);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: AffiliateApplicationRepository.java
	 * 
	 * Gets the affiliate application by date.
	 * @return the affiliate application by date
	 */
	@Query(value = "select count(*) from AffiliateApplication af where DATE(af.orderDate) = DATE(CURRENT_DATE)")
	public long getAffiliateApplicationByDate();

}
