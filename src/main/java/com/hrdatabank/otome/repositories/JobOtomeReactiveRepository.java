package com.hrdatabank.otome.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.model.JobDto;

/**
 * The Interface JobOtomeReactiveRepository.
 */
@RepositoryRestResource
@Repository
public interface JobOtomeReactiveRepository extends CrudRepository<JobOtome, Long> {

	
	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtomeReactiveRepository.java
	 * 
	 * Gets the all jobs by dto.
	 * @return the all jobs by dto
	 */
	@Query(value = "SELECT NEW com.hrdatabank.otome.model.JobDto(j.idJob,  j.shopName, j.jobURL, j.positionName, j.positionCategoryEnglish, j.shopAddress,  j.hourlyWageMemo, j.affiliateType,  j.transportation, j.status, j.startTime,  j.finishTime) FROM JobOtome j ")
	public List<JobDto> getAllJobsByDto();

	


}
