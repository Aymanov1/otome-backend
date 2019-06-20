package com.hrdatabank.otome.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.domain.Job;
import com.hrdatabank.otome.repositories.JobRepository;

/**
 * The Class JobService.
 */
@Service
public class JobService {
	private static Logger logger = LoggerFactory.getLogger(JobService.class);

	/** The job repository. */
	@Autowired
	private JobRepository jobRepository;

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	public Job saveJob(Job job) {
		return jobRepository.save(job);
	}
	
	public List<Job> getCheckedJsenJobsByIdJobDetail(String idJobDetail) {
		return jobRepository.getCheckedJsenJobsByIdJobDetail(idJobDetail);
	}

	public List<Job> getCheckedLacottoJobsByIdJobDetail(String idJobDetail) {
		return jobRepository.getCheckedLacottoJobsByIdJobDetail(idJobDetail);
	}

	public Page<Job> findAllJobsByAffiliateInjectionDate(String affiliateType, Date injectionDate, Pageable pageable) {
		return jobRepository.findAllJobsByAffiliateInjectionDate(affiliateType, injectionDate, pageable);
	}
}
