package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.DashboardInformation;

// TODO: Auto-generated Javadoc
/**
 * The Interface DashboardInformationRepository.
 */
@Repository
@RepositoryRestResource
public interface DashboardInformationRepository extends JpaRepository<DashboardInformation, Serializable> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationRepository.java
	 * 
	 * Find searching job.
	 * @param date the date
	 * @return the int
	 */
	@Query(value = "select count(di) from DashboardInformation di where di.status ='Search' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findSearchingJob(@Param("date") String date);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationRepository.java
	 * 
	 * Find suggested searchs.
	 * @param date the date
	 * @return the int
	 */
	@Query(value = "select count(di) from DashboardInformation di where di.status ='Suggested' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findSuggestedSearchs(@Param("date") String date);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationRepository.java
	 * 
	 * Find failed searchs.
	 * @param date the date
	 * @return the int
	 */
	@Query(value = "select count(di) from DashboardInformation di where di.status ='Failed' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findFailedSearchs(@Param("date") String date);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationRepository.java
	 * 
	 * Find open applypage.
	 * @param date the date
	 * @return the int
	 */
	@Query(value = "select count(di) from DashboardInformation di where di.status ='OpenApply' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findOpenApplypage(@Param("date") String date);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationRepository.java
	 * 
	 * Find ignored dashboard information by id candidate and date.
	 * @param date the date
	 * @param id the id
	 * @return the dashboard information
	 */
	@Query(value = "select di from DashboardInformation di where di.status='Ignored' and di.dateOfSet=:date and di.idCandidate =:id")
	public DashboardInformation findIgnoredDashboardInformationByIdCandidateAndDate(@Param("date") Date date,
			@Param("id") int id);

}