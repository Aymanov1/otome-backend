package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrdatabank.mtproject.entities.JobTagRelation;

// TODO: Auto-generated Javadoc
/**
 * The Interface JobTagRelationRepository.
 */
@Repository
@RepositoryRestResource
public interface JobTagRelationRepository extends JpaRepository<JobTagRelation, Serializable> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobTagRelationRepository.java
	 * 
	 * Count tag job relations by id tag.
	 * @param idTag the id tag
	 * @return the long
	 */
	@Query("Select count(jt) from JobTagRelation jt where jt.jobTagRelationPK.idTag=:idTag")
	public long countTagJobRelationsByIdTag(@Param("idTag") int idTag);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobTagRelationRepository.java
	 * 
	 * Gets the job tag relations by id tag.
	 * @param idTag the id tag
	 * @return the job tag relations by id tag
	 */
	@Query("Select jt from JobTagRelation jt where jt.jobTagRelationPK.idTag=:idTag")
	public List<JobTagRelation> getJobTagRelationsByIdTag(@Param("idTag") int idTag);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobTagRelationRepository.java
	 * 
	 * Gets the job tag relations by id tag paginated.
	 * @param idTag the id tag
	 * @param pageable the pageable
	 * @return the job tag relations by id tag paginated
	 */
	@Query("Select jt from JobTagRelation jt where jt.jobTagRelationPK.idTag=:idTag")
	public Page<JobTagRelation> getJobTagRelationsByIdTagPaginated(@Param("idTag") int idTag, Pageable pageable);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobTagRelationRepository.java
	 * 
	 * this method Delete job tag relations by id job.
	 * @param idJob the id job
	 */
	@Modifying
	@Transactional
	@Query("DELETE from JobTagRelation jt where jt.jobTagRelationPK.idJob=:idJob")
	public void deleteJobTagRelationsByIdJob(@Param("idJob") int idJob);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobTagRelationRepository.java
	 * 
	 * Find all opened jobs by tag.
	 * @param tag the tag
	 * @param pageable the pageable
	 * @param idCandidate the id candidate
	 * @return the page
	 */
	@Query(value = "SELECT  jt.id_job FROM job_tag_relation jt   INNER JOIN job j ON (j.id_job = jt.id_job)  INNER JOIN tag t ON (jt.id_tag = t.id_tag)  WHERE jt.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate)  and j.status = TRUE  and lower(t.tag_text) like lower(CONCAT('%',:tag,'%'))   GROUP BY   jt.id_job , ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT count(jt.id_job) FROM job_tag_relation jt   INNER JOIN job j ON (j.id_job = jt.id_job)  INNER JOIN tag t ON (jt.id_tag = t.id_tag)  WHERE jt.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate)  and j.status = TRUE  and lower(t.tag_text) like lower(CONCAT('%',:tag,'%'))")
	public Page<Integer> findAllOpenedJobsByTag(@Param("tag") String tag, Pageable pageable,
			@Param("idCandidate") int idCandidate);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobTagRelationRepository.java
	 * 
	 * Gets the job tag relations by tag text.
	 * @param tagText the tag text
	 * @return the job tag relations by tag text
	 */
	@Query("Select jt from JobTagRelation jt where lower(jt.tag.tagText)  like  lower(CONCAT('%',:tagText,'%'))")
	public List<JobTagRelation> getJobTagRelationsByTagText(@Param("tagText") String tagText);

}
