package com.hrdatabank.otome.services;

import java.util.Optional;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.model.JobDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Interface JobReactiveService.
 */
public interface JobReactiveService {

	/**
	 * Find by id.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: JobReactiveService.java
	 * 
	 *         Find by id.
	 * @param id
	 *            the id
	 * @return the mono
	 */
	Mono<Optional<JobOtome>> findById(long id);

	/**
	 * Find all.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: JobReactiveService.java
	 * 
	 *         Find all.
	 * @return the flux
	 */
	Flux<JobOtome> findAll();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: JobReactiveService.java
	 * 
	 *         Find all job DTO.
	 * @return the flux
	 */
	Flux<JobDto> findAllJobDTO();

	/**
	 * Save.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: JobReactiveService.java
	 * 
	 *         Save.
	 * @param job
	 *            the job
	 * @return the mono
	 */
	Mono<JobOtome> save(JobOtome job);

	/**
	 * Delete by id.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: JobReactiveService.java
	 * 
	 *         Delete by id.
	 * @param id
	 *            the id
	 * @return the mono
	 */
	Mono<Void> deleteById(Long id);
}
