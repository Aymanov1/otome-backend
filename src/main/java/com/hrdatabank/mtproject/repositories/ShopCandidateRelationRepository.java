package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.ShopCandidateRelation;

/**
 * The Interface ShopCandidateRelationRepository.
 */
@Repository
@RepositoryRestResource
public interface ShopCandidateRelationRepository extends JpaRepository<ShopCandidateRelation, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopCandidateRelationRepository.java
	 * 
	 *         Gets the shop candidate relations by id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the shop candidate relations by id candidate
	 */
	@Query("Select sc from ShopCandidateRelation sc where sc.shopCandidateRelationPK.idCandidate=:idCandidate")
	public List<ShopCandidateRelation> getShopCandidateRelationsByIdCandidate(@Param("idCandidate") int idCandidate);

}
