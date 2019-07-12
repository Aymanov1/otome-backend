package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.JobTagRelation;
import com.hrdatabank.mtproject.repositories.JobTagRelationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class JobTagRelationService.
 */
@Service
public class JobTagRelationService {
	/** The jobTagRelation repository. */
	@Autowired
	private JobTagRelationRepository jobTagRelationRepository;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobTagRelationService.java
	 * 
	 * Sets the job tag relation repository.
	 * @param jobTagRelationRepository the new job tag relation repository
	 */
	public void setJobTagRelationRepository(JobTagRelationRepository jobTagRelationRepository) {
		this.jobTagRelationRepository = jobTagRelationRepository;
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
	 * Class Name: JobTagRelationService.java
	 * 
	 * List all job tag relations.
	 * @return the iterable
	 */
	public Iterable<JobTagRelation> listAllJobTagRelations() {
		return jobTagRelationRepository.findAll();
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
	 * Class Name: JobTagRelationService.java
	 * 
	 * Gets the job tag relation by id.
	 * @param id the id
	 * @return the job tag relation by id
	 */
	public Optional<JobTagRelation> getJobTagRelationById(long id) {
		return jobTagRelationRepository.findById(id);
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
	 * Class Name: JobTagRelationService.java
	 * 
	 * Save job tag relation.
	 * @param jobTagRelation the job tag relation
	 * @return the job tag relation
	 */
	public JobTagRelation saveJobTagRelation(JobTagRelation jobTagRelation) {
		return jobTagRelationRepository.save(jobTagRelation);
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
	 * Class Name: JobTagRelationService.java
	 * 
	 * this method Delete job tag relations by id job.
	 * @param idJob the id job
	 */
	public void deleteJobTagRelationsByIdJob(int idJob) {
		jobTagRelationRepository.deleteJobTagRelationsByIdJob(idJob);

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
	 * Class Name: JobTagRelationService.java
	 * 
	 * Find all opened jobs by tag.
	 * @param tag the tag
	 * @param pageable the pageable
	 * @param idCandidate the id candidate
	 * @return the page
	 */
	public Page<Integer> findAllOpenedJobsByTag(String tag, org.springframework.data.domain.Pageable pageable,
			int idCandidate) {
		return jobTagRelationRepository.findAllOpenedJobsByTag(tag, pageable, idCandidate);
	}
}
