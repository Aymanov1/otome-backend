package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.CandidateAdminRelation;
import com.hrdatabank.mtproject.entities.Memo;

// TODO: Auto-generated Javadoc
/**
 * The Interface MemoRepository.
 */
@Repository
@RepositoryRestResource
public interface MemoRepository extends JpaRepository<Memo, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoRepository.java
	 * 
	 *         List memos by candidate admin relation.
	 * @param candidateAdminRelation
	 *            the candidate admin relation
	 * @return the list
	 */
	@Query("Select m from Memo m where m.candidateAdminRelation=:candidateAdminRelation ORDER BY m.memoDate DESC")
	public List<Memo> listMemosByCandidateAdminRelation(
			@Param("candidateAdminRelation") CandidateAdminRelation candidateAdminRelation);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoRepository.java
	 * 
	 *         List memos by id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the list
	 */
	@Query("Select m from Memo m where m.candidateAdminRelation.candidate.idUser=:idCandidate ORDER BY m.memoDate DESC")
	public List<Memo> listMemosByIdCandidate(@Param("idCandidate") int idCandidate);

}
