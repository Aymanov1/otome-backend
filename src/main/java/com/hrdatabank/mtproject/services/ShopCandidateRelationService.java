package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.ShopCandidateRelation;
import com.hrdatabank.mtproject.entities.ShopCandidateRelationPK;
import com.hrdatabank.mtproject.repositories.ShopCandidateRelationRepository;

/**
 * The Class ShopCandidateRelationService.
 */
@Service
public class ShopCandidateRelationService {

	/** The shop candidate relation repository. */
	@Autowired
	private ShopCandidateRelationRepository shopCandidateRelationRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopCandidateRelationService.java
	 * 
	 *         Sets the shop candidate relation repository.
	 * @param shopCandidateRelationRepository
	 *            the new shop candidate relation repository
	 */
	public void setShopCandidateRelationRepository(ShopCandidateRelationRepository shopCandidateRelationRepository) {
		this.shopCandidateRelationRepository = shopCandidateRelationRepository;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopCandidateRelationService.java
	 * 
	 *         List all shop candidate relations.
	 * @return the iterable
	 */
	public Iterable<ShopCandidateRelation> listAllShopCandidateRelations() {
		return shopCandidateRelationRepository.findAll();
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopCandidateRelationService.java
	 * 
	 *         Gets the shop candidate relation by id.
	 * @param shopCandidateRelationPK
	 *            the shop candidate relation PK
	 * @return the shop candidate relation by id
	 */
	public Optional<ShopCandidateRelation> getShopCandidateRelationById(ShopCandidateRelationPK shopCandidateRelationPK) {
		return shopCandidateRelationRepository.findById(shopCandidateRelationPK);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopCandidateRelationService.java
	 * 
	 *         Save shop candidate relation.
	 * @param shopCandidateRelation
	 *            the shop candidate relation
	 * @return the shop candidate relation
	 */
	public ShopCandidateRelation saveShopCandidateRelation(ShopCandidateRelation shopCandidateRelation) {
		return shopCandidateRelationRepository.save(shopCandidateRelation);

	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopCandidateRelationService.java
	 * 
	 *         Gets the shop candidate relations by id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the shop candidate relations by id candidate
	 */
	public List<ShopCandidateRelation> getShopCandidateRelationsByIdCandidate(int idCandidate) {
		return shopCandidateRelationRepository.getShopCandidateRelationsByIdCandidate(idCandidate);
	}

}
