package com.hrdatabank.otome.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.Job;

// TODO: Auto-generated Javadoc
/**
 * The Interface JobRepository.
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Serializable>, JpaSpecificationExecutor<Job> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobRepository.java
	 * 
	 * Gets the checked jsen jobs by id job detail.
	 * @param idJobDetail the id job detail
	 * @return the checked jsen jobs by id job detail
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.idJobDetail =:idJobDetail and j.jobURL LIKE CONCAT('%','j-sen','%')")
	public List<Job> getCheckedJsenJobsByIdJobDetail(@Param("idJobDetail") String idJobDetail);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobRepository.java
	 * 
	 * Gets the checked lacotto jobs by id job detail.
	 * @param idJobDetail the id job detail
	 * @return the checked lacotto jobs by id job detail
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.idJobDetail =:idJobDetail and j.jobURL LIKE CONCAT('%','lacotto','%')")
	public List<Job> getCheckedLacottoJobsByIdJobDetail(@Param("idJobDetail") String idJobDetail);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobRepository.java
	 * 
	 * Find all jobs by affiliate injection date.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @param pageable the pageable
	 * @return the page
	 */
	@Query(value = "SELECT j FROM Job j where j.affiliateType like %:type% and j.injectionDate = :injectionDate")
	public Page<Job> findAllJobsByAffiliateInjectionDate(@Param("type") String affiliateType,
			@Param("injectionDate") LocalDate injectionDate, Pageable pageable);
	
	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobRepository.java
	 * 
	 * Find all jobs by affiliate injection date.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @return the list
	 */
	@Query(value = "SELECT j FROM Job j where j.affiliateType like %:type% and j.injectionDate = :injectionDate")
	public List<Job> findAllJobsByAffiliateInjectionDate(@Param("type") String affiliateType,
			@Param("injectionDate") LocalDate injectionDate);
	
	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobRepository.java
	 * 
	 * Count all jobs by affiliate injection date.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @return the int
	 */
	@Query(value = "SELECT count(j) FROM Job j where j.affiliateType like %:type% and j.injectionDate = :injectionDate")
	public int countAllJobsByAffiliateInjectionDate(@Param("type") String affiliateType,
			@Param("injectionDate") LocalDate injectionDate);


}
