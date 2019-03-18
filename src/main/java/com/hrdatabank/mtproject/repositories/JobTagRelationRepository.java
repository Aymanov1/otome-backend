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

@Repository
@RepositoryRestResource
public interface JobTagRelationRepository extends JpaRepository<JobTagRelation, Serializable> {

	@Query("Select count(jt) from JobTagRelation jt where jt.jobTagRelationPK.idTag=:idTag")
	public long countTagJobRelationsByIdTag(@Param("idTag") int idTag);

	@Query("Select jt from JobTagRelation jt where jt.jobTagRelationPK.idTag=:idTag")
	public List<JobTagRelation> getJobTagRelationsByIdTag(@Param("idTag") int idTag);

	@Query("Select jt from JobTagRelation jt where jt.jobTagRelationPK.idTag=:idTag")
	public Page<JobTagRelation> getJobTagRelationsByIdTagPaginated(@Param("idTag") int idTag, Pageable pageable);

	@Modifying
	@Transactional
	@Query("DELETE from JobTagRelation jt where jt.jobTagRelationPK.idJob=:idJob")
	public void deleteJobTagRelationsByIdJob(@Param("idJob") int idJob);

	@Query(value = "SELECT  jt.id_job FROM job_tag_relation jt   INNER JOIN job j ON (j.id_job = jt.id_job)  INNER JOIN tag t ON (jt.id_tag = t.id_tag)  WHERE jt.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate)  and j.status = TRUE  and lower(t.tag_text) like lower(CONCAT('%',:tag,'%'))   GROUP BY   jt.id_job , ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT count(jt.id_job) FROM job_tag_relation jt   INNER JOIN job j ON (j.id_job = jt.id_job)  INNER JOIN tag t ON (jt.id_tag = t.id_tag)  WHERE jt.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate)  and j.status = TRUE  and lower(t.tag_text) like lower(CONCAT('%',:tag,'%'))")
	public Page<Integer> findAllOpenedJobsByTag(@Param("tag") String tag, Pageable pageable,
			@Param("idCandidate") int idCandidate);

	@Query("Select jt from JobTagRelation jt where lower(jt.tag.tagText)  like  lower(CONCAT('%',:tagText,'%'))")
	public List<JobTagRelation> getJobTagRelationsByTagText(@Param("tagText") String tagText);

}
