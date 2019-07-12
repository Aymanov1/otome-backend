package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.LineStation;

// TODO: Auto-generated Javadoc
/**
 * The Interface LineStationRepository.
 */
@Repository
@RepositoryRestResource
public interface LineStationRepository extends JpaRepository<LineStation, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: LineStationRepository.java
	 * 
	 *         Gets the line station by id line CD.
	 * @param idLineCD
	 *            the id line CD
	 * @return the line station by id line CD
	 */
	@Query(value = "select l from LineStation l where l.lineCD=:idLineCD")
	public LineStation getLineStationByIdLineCD(@Param("idLineCD") int idLineCD);

}
