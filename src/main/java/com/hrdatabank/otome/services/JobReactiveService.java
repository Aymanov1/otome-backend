package com.hrdatabank.otome.services;

import java.util.Optional;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.model.JobDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Interface JobReactiveService.
 */
public interface JobReactiveService {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the mono
	 */
	Mono<Optional<JobOtome>> findById(long id);

	/**
	 * Find all.
	 *
	 * @return the flux
	 */
	Flux<JobOtome> findAll();
	
	Flux<JobDto> findAllJobDTO();

	/**
	 * Save.
	 *
	 * @param job the job
	 * @return the mono
	 */
	Mono<JobOtome> save(JobOtome job);

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the mono
	 */
	Mono<Void> deleteById(Long id);
}
