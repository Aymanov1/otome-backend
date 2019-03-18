package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.JobTagRelation;
import com.hrdatabank.mtproject.repositories.JobTagRelationRepository;

@Service
public class JobTagRelationService {
	/** The jobTagRelation repository. */
	@Autowired
	private JobTagRelationRepository jobTagRelationRepository;

	public void setJobTagRelationRepository(JobTagRelationRepository jobTagRelationRepository) {
		this.jobTagRelationRepository = jobTagRelationRepository;
	}

	public Iterable<JobTagRelation> listAllJobTagRelations() {
		return jobTagRelationRepository.findAll();
	}

	public Optional<JobTagRelation> getJobTagRelationById(long id) {
		return jobTagRelationRepository.findById(id);
	}

	public JobTagRelation saveJobTagRelation(JobTagRelation jobTagRelation) {
		return jobTagRelationRepository.save(jobTagRelation);
	}

	public void deleteJobTagRelationsByIdJob(int idJob) {
		jobTagRelationRepository.deleteJobTagRelationsByIdJob(idJob);

	}

	public Page<Integer> findAllOpenedJobsByTag(String tag, org.springframework.data.domain.Pageable pageable,
			int idCandidate) {
		return jobTagRelationRepository.findAllOpenedJobsByTag(tag, pageable, idCandidate);
	}
}
