package com.hrdatabank.otome.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.NearestStationOtome;

/**
 * The Interface NearestStationOtomeRepository.
 */
@Repository
@RepositoryRestResource
public interface NearestStationOtomeRepository extends JpaRepository<NearestStationOtome, Serializable> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: NearestStationOtomeRepository.java
	 * 
	 * Gets the near station by id line CD.
	 * @param idNearestStationCD the id nearest station CD
	 * @return the near station by id line CD
	 */
	@Query(value = "select ns from NearestStationOtome ns where ns.idNearestStationCD=:idNearestStationCD")
	public NearestStationOtome getNearStationByIdLineCD(@Param("idNearestStationCD") int idNearestStationCD);
}
