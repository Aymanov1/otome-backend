package com.hrdatabank.otome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.model.JobDto;
import com.hrdatabank.otome.repositories.JobOtomeReactiveRepository;
import com.hrdatabank.otome.repositories.JobOtomeRepository;

import reactor.core.publisher.Flux;

/**
 * The Class JobOtomeService.
 */
@Service
public class JobOtomeService {

	/** The job otome repository. */
	@Autowired
	private JobOtomeRepository jobOtomeRepository;

	/** The job otome reactive repository. */
	@Autowired
	JobOtomeReactiveRepository jobOtomeReactiveRepository;

	/**
	 * Find job by id.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * Find job by id.
	 * @param idJobOtome            the id job otome
	 * @return the optional
	 */
	public Optional<JobOtome> findJobById(long idJobOtome) {
		return jobOtomeRepository.findById(idJobOtome);
	}

	/**
	 * Find all jobs.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * Find all jobs.
	 * @return the list
	 */
	public List<JobDto> findAllJobs() {
		return jobOtomeRepository.getAllJobsByDto();
	}

	/**
	 * Find all jobs reactive.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * Find all jobs reactive.
	 * @return the flux
	 */
	@SuppressWarnings("unchecked")
	public Flux<JobOtome> findAllJobsReactive() {
		return (Flux<JobOtome>) jobOtomeReactiveRepository.findAll();
	}

	/**
	 * Delete job.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * this method Delete job.
	 * @param jobOtome            the job otome
	 */
	public void deleteJob(JobOtome jobOtome) {
		jobOtomeRepository.delete(jobOtome);
	}

	/**
	 * Save job.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * Save job.
	 * @param job            the job
	 * @return the job otome
	 */
	public JobOtome saveJob(JobOtome job) {
		return jobOtomeRepository.save(job);
	}

	/**
	 * Count baitoru jobs affiliate activated.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * Count baitoru jobs affiliate activated.
	 * @return the long
	 */
	public long countBaitoruJobsAffiliateActivated() {
		return jobOtomeRepository.countBaitoruJobsAffiliateActivated();
	}

	/**
	 * Gets the baitoru jobs affiliate activated.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * Gets the baitoru jobs affiliate activated.
	 * @param page            the page
	 * @param size            the size
	 * @return the baitoru jobs affiliate activated
	 */
	public Page<JobOtome> getBaitoruJobsAffiliateActivated(int page, int size) {
		return jobOtomeRepository.getBaitoruJobsAffiliateActivated(PageRequest.of(page, size));
	}

	/**
	 * Gets the jobs by station and job category.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeService.java
	 * 
	 * Gets the jobs by station and job category.
	 * @param page the page
	 * @param size the size
	 * @param latitudeStation the latitude station
	 * @param longitudeStation the longitude station
	 * @param maxKm the max km
	 * @return the jobs by station and job category
	 */
	public Page<JobOtome> getJobsByStationAndJobCategory(int page, int size, Double latitudeStation,
			Double longitudeStation, int maxKm) {
		return jobOtomeRepository.getJobsByStationAndJobCategory(latitudeStation, longitudeStation, maxKm,
				PageRequest.of(page, size));
	}
}
