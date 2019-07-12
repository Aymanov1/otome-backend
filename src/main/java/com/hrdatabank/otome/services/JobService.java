package com.hrdatabank.otome.services;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.domain.Job;
import com.hrdatabank.otome.repositories.JobRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class JobService.
 */
@Service
public class JobService {

	/** The job repository. */
	@Autowired
	private JobRepository jobRepository;

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobService.java
	 * 
	 * Save job.
	 * @param job the job
	 * @return the job
	 */
	public Job saveJob(Job job) {
		return jobRepository.save(job);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobService.java
	 * 
	 * Gets the checked jsen jobs by id job detail.
	 * @param idJobDetail the id job detail
	 * @return the checked jsen jobs by id job detail
	 */
	public List<Job> getCheckedJsenJobsByIdJobDetail(String idJobDetail) {
		return jobRepository.getCheckedJsenJobsByIdJobDetail(idJobDetail);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobService.java
	 * 
	 * Gets the checked lacotto jobs by id job detail.
	 * @param idJobDetail the id job detail
	 * @return the checked lacotto jobs by id job detail
	 */
	public List<Job> getCheckedLacottoJobsByIdJobDetail(String idJobDetail) {
		return jobRepository.getCheckedLacottoJobsByIdJobDetail(idJobDetail);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobService.java
	 * 
	 * Find all jobs by affiliate injection date.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @param pageable the pageable
	 * @return the page
	 */
	public Page<Job> findAllJobsByAffiliateInjectionDate(String affiliateType, LocalDate injectionDate,
			Pageable pageable) {
		return jobRepository.findAllJobsByAffiliateInjectionDate(affiliateType, injectionDate, pageable);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobService.java
	 * 
	 * Find all jobs by affiliate injection date.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @return the list
	 */
	public List<Job> findAllJobsByAffiliateInjectionDate(String affiliateType, LocalDate injectionDate) {
		return jobRepository.findAllJobsByAffiliateInjectionDate(affiliateType, injectionDate);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobService.java
	 * 
	 * Count all jobs by affiliate injection date.
	 * @param affiliateType the affiliate type
	 * @param injectionDate the injection date
	 * @return the int
	 */
	public int countAllJobsByAffiliateInjectionDate(String affiliateType, LocalDate injectionDate) {
		return jobRepository.countAllJobsByAffiliateInjectionDate(affiliateType, injectionDate);
	}
}
