package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.CandidateAdminRelation;
import com.hrdatabank.mtproject.entities.CandidateAdminRelationPK;
import com.hrdatabank.mtproject.repositories.CandidateAdminRelationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CandidateAdminRelationService.
 */
@Service
public class CandidateAdminRelationService {

	/** The candidate admin relation repository. */
	@Autowired
	private CandidateAdminRelationRepository candidateAdminRelationRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateAdminRelationService.java
	 * 
	 *         Sets the candidate admin relation repository.
	 * @param candidateAdminRelationRepository
	 *            the new candidate admin relation repository
	 */
	public void setCandidateAdminRelationRepository(CandidateAdminRelationRepository candidateAdminRelationRepository) {
		this.candidateAdminRelationRepository = candidateAdminRelationRepository;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateAdminRelationService.java
	 * 
	 *         List all candidate admin relations.
	 * @return the iterable
	 */
	public Iterable<CandidateAdminRelation> listAllCandidateAdminRelations() {
		return candidateAdminRelationRepository.findAll();
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateAdminRelationService.java
	 * 
	 *         Gets the candidate admin relation by id.
	 * @param candidateAdminRelationPK
	 *            the candidate admin relation PK
	 * @return the candidate admin relation by id
	 */
	public Optional<CandidateAdminRelation> getCandidateAdminRelationById(
			CandidateAdminRelationPK candidateAdminRelationPK) {
		return candidateAdminRelationRepository.findById(candidateAdminRelationPK);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateAdminRelationService.java
	 * 
	 *         Save candidate admin relation.
	 * @param candidateAdminRelation
	 *            the candidate admin relation
	 * @return the candidate admin relation
	 */
	public CandidateAdminRelation saveCandidateAdminRelation(CandidateAdminRelation candidateAdminRelation) {
		return candidateAdminRelationRepository.save(candidateAdminRelation);
	}

}
