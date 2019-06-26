package com.hrdatabank.otome.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.Job;

/**
 * The Interface JobRepository.
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Serializable>, JpaSpecificationExecutor<Job> {

	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.idJobDetail =:idJobDetail and j.jobURL LIKE CONCAT('%','j-sen','%')")
	public List<Job> getCheckedJsenJobsByIdJobDetail(@Param("idJobDetail") String idJobDetail);

	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.idJobDetail =:idJobDetail and j.jobURL LIKE CONCAT('%','lacotto','%')")
	public List<Job> getCheckedLacottoJobsByIdJobDetail(@Param("idJobDetail") String idJobDetail);

	@Query(value = "SELECT j FROM Job j where j.affiliateType like %:type% and j.injectionDate = :injectionDate")
	public Page<Job> findAllJobsByAffiliateInjectionDate(@Param("type") String affiliateType,
			@Param("injectionDate") LocalDate injectionDate, Pageable pageable);

}
