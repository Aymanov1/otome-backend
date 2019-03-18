package com.hrdatabank.otome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.repositories.JobOtomeRepository;

/**
 * The Class JobOtomeService.
 */
@Service
public class JobOtomeService {

	/** The job otome repository. */
	@Autowired
	private JobOtomeRepository jobOtomeRepository;

	/**
	 * Find job by id.
	 *
	 * @param idJobOtome
	 *            the id job otome
	 * @return the optional
	 */
	public Optional<JobOtome> findJobById(long idJobOtome) {
		return jobOtomeRepository.findById(idJobOtome);
	}

	/**
	 * Find all jobs.
	 *
	 * @return the list
	 */
	public List<JobOtome> findAllJobs() {
		return jobOtomeRepository.findAll();
	}

	/**
	 * Delete job.
	 *
	 * @param jobOtome
	 *            the job otome
	 */
	public void deleteJob(JobOtome jobOtome) {
		jobOtomeRepository.delete(jobOtome);
	}

	/**
	 * Save job.
	 *
	 * @param job
	 *            the job
	 * @return the job otome
	 */
	public JobOtome saveJob(JobOtome job) {
		return jobOtomeRepository.save(job);
	}

	/**
	 * Count baitoru jobs affiliate activated.
	 *
	 * @return the long
	 */
	public long countBaitoruJobsAffiliateActivated() {
		return jobOtomeRepository.countBaitoruJobsAffiliateActivated();
	}

	/**
	 * Gets the baitoru jobs affiliate activated.
	 *
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the baitoru jobs affiliate activated
	 */
	public Page<JobOtome> getBaitoruJobsAffiliateActivated(int page, int size) {
		return jobOtomeRepository.getBaitoruJobsAffiliateActivated(PageRequest.of(page, size));
	}

	public Page<JobOtome> getJobsByStationAndJobCategory(int page, int size, Double latitudeStation,
			Double longitudeStation, int maxKm) {
		return jobOtomeRepository.getJobsByStationAndJobCategory(latitudeStation, longitudeStation, maxKm,
				PageRequest.of(page, size));
	}
}
