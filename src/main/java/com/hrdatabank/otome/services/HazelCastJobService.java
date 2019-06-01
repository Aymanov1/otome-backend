package com.hrdatabank.otome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.model.JobDto;
import com.hrdatabank.otome.repositories.JobOtomeReactiveRepository;
import com.hrdatabank.otome.repositories.JobOtomeRepository;

@Service
public class HazelCastJobService {

	/** The job otome reactive repository. */
	@Autowired
	JobOtomeReactiveRepository jobOtomeReactiveRepository;

	/**
	 * Find job by id.
	 *
	 * @param idJobOtome
	 *            the id job otome
	 * @return the optional
	 */
	@Cacheable(value = "jobCache", key = "#idJobOtome", unless = "#result==null")
	public Optional<JobOtome> findJobById(long idJobOtome) {
		return jobOtomeReactiveRepository.findById(idJobOtome);
	}

	/**
	 * Find all jobs.
	 *
	 * @return the list
	 */
	@Cacheable
	public List<JobDto> findAllJobs() {
		return jobOtomeReactiveRepository.getAllJobsByDto();
	}

	/**
	 * Delete job.
	 *
	 * @param jobOtome
	 *            the job otome
	 */
	@CacheEvict(value = "jobCache", key = "#idJobOtome")
	public void deleteJob(JobOtome jobOtome) {
		jobOtomeReactiveRepository.delete(jobOtome);
	}

	/**
	 * Save job.
	 *
	 * @param job
	 *            the job
	 * @return the job otome
	 */
	@CachePut(value = "jobCache", key = "#idJobOtome")
	public JobOtome saveJob(JobOtome job) {
		return jobOtomeReactiveRepository.save(job);
	}

}
