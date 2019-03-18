package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.JobCandidateRelation;
import com.hrdatabank.mtproject.entities.JobCandidateRelationPK;
import com.hrdatabank.mtproject.model.Application;
import com.hrdatabank.mtproject.model.ApplicationDto;
import com.hrdatabank.mtproject.model.JobCandidateRelationDto;
import com.hrdatabank.mtproject.model.PaymentCycleAdminDto;
import com.hrdatabank.mtproject.model.PaymentCycleDto;
import com.hrdatabank.mtproject.model.ReportDto;

/**
 * The Interface JobCandidateRelationRepository.
 */
@Repository
@RepositoryRestResource
public interface JobCandidateRelationRepository extends JpaRepository<JobCandidateRelation, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the applied jobs by shop and by candidate.
	 * @param idShop
	 *            the id shop
	 * @param idCandidate
	 *            the id candidate
	 * @return the applied jobs by shop and by candidate
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and  jc.jobCandidateRelationPK.idCandidate=:idCandidate and  jc.applied = true")
	public List<JobCandidateRelation> getAppliedJobsByShopAndByCandidate(@Param("idShop") int idShop,
			@Param("idCandidate") int idCandidate);

	@Query("Select jc from JobCandidateRelation jc where   jc.jobCandidateRelationPK.idCandidate=:idCandidate ")
	public List<JobCandidateRelation> getJobCandidaterelationByIdCandidate(@Param("idCandidate") int idCandidate);

	@Query("Select jc from JobCandidateRelation jc where jc.candidate.idUser>:idCand and jc.candidate.idUser<39179")
	public List<JobCandidateRelation> getAppliedJobsByIdCandidateForAts(@Param("idCand") int idCand);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all applied candidates.
	 * @return the all applied candidates
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.applied = true and (jc.progress!='failed' or jc.progress!='不合格' ) and (jc.shopProgress!='failed' or jc.shopProgress!='不合格' or jc.shopProgress!='キャンセル')")
	public List<JobCandidateRelation> getAllAppliedCandidates();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the applied jobs by company and candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param idCompany
	 *            the id company
	 * @return the applied jobs by company and candidate
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true")
	JobCandidateRelation getAppliedJobsByCompanyAndCandidate(@Param("idCandidate") int idCandidate,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the applied jobs not hired or failed by company and candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param idCompany
	 *            the id company
	 * @return the applied jobs not hired or failed by company and candidate
	 */

	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true  and (lower(jc.progress) NOT LIKE lower('failed') and lower(jc.progress) NOT LIKE lower('不合格') ) and (lower(jc.progress) NOT LIKE lower('working') and lower(jc.progress) NOT LIKE lower('入社済み'))")
	public List<JobCandidateRelation> getAppliedJobsNotHiredOrFailedByCompanyAndCandidate(
			@Param("idCandidate") int idCandidate, @Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the job candidate relation by id job id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param idJob
	 *            the id job
	 * @return the job candidate relation by id job id candidate
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and jc.jobCandidateRelationPK.idCandidate=:idCandidate")
	public JobCandidateRelation getJobCandidateRelationByIdJobIdCandidate(@Param("idCandidate") int idCandidate,
			@Param("idJob") int idJob);

	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob")
	public List<JobCandidateRelation> getJobCandidateRelationByIdJob(@Param("idJob") int idJob);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the applied jobs by candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the applied jobs by candidate
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true and jc.privacyPolicyChecked = TRUE")
	public List<JobCandidateRelation> getAppliedJobsByCandidate(@Param("idCandidate") int idCandidate);

	@Query("Select jc from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true  ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAppliedJobsByCandidateOrderByApplyDate(@Param("idCandidate") int idCandidate);

	@Query("Select NEW com.hrdatabank.mtproject.model.JobCandidateRelationDto(jc.jobCandidateRelationPK.idJob, jc.jobCandidateRelationPK.idCandidate, jc.job.shop.idShop, jc.job.shop.nameShop, jc.job.positionName,jc.progress, jc.interviewDate) from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true  ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelationDto> getAppliedJobsByCandidateDtoOrderByApplyDate(
			@Param("idCandidate") int idCandidate);

	@Query("Select count(jc) from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true  ORDER BY jc.appliedDate DESC")
	public long countAppliedJobsByCandidateDtoOrderByApplyDate(@Param("idCandidate") int idCandidate);

	@Query("Select NEW com.hrdatabank.mtproject.model.JobCandidateRelationDto(jc.jobCandidateRelationPK.idJob, jc.jobCandidateRelationPK.idCandidate, jc.candidateName, jc.candidateNameKatakana, jc.candidatePhone,jc.candidateJLPT, jc.candidateDurationInJapan, jc.candidateBirthday) from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true  ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelationDto> getLastApplicationByCandidateDtoOrderByApplyDate(
			@Param("idCandidate") int idCandidate);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all job candidate relations by progress and candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param progress
	 *            the progress
	 * @return the all job candidate relations by progress and candidate
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and lower(jc.progress) like lower(CONCAT('%',:progress,'%'))")
	public List<JobCandidateRelation> getAllJobCandidateRelationsByProgressAndCandidate(
			@Param("idCandidate") int idCandidate, @Param("progress") String progress);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the applied candidate for company last week.
	 * @param idCompany
	 *            the id company
	 * @param date
	 *            the date
	 * @return the applied candidate for company last week
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and jc.appliedDate>:date and jc.applied = true and (jc.progress!='failed' or jc.progress!='不合格' )")
	public List<JobCandidateRelation> getAppliedCandidateForCompanyLastWeek(@Param("idCompany") int idCompany,
			@Param("date") Date date);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the applied jobs by candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param progressFailed
	 *            the progress failed
	 * @param progressHired
	 *            the progress hired
	 * @return the applied jobs by candidate
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true and (lower(jc.progress) NOT LIKE lower(:progressFailed)) and (lower(jc.progress) NOT LIKE lower(:progressHired))")
	public List<JobCandidateRelation> getAppliedJobsByCandidate(@Param("idCandidate") int idCandidate,
			@Param("progressFailed") String progressFailed, @Param("progressHired") String progressHired);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count applied jobs by candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param progressFailed
	 *            the progress failed
	 * @param progressHired
	 *            the progress hired
	 * @return the long
	 */

	@Query("Select count(jc) from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true and (lower(jc.progress) NOT LIKE lower(:progressFailed)) and (lower(jc.progress) NOT LIKE lower(:progressHired))")
	public long countAppliedJobsByCandidate(@Param("idCandidate") int idCandidate,
			@Param("progressFailed") String progressFailed, @Param("progressHired") String progressHired);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all applications by id company.
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and jc.applied = true")
	public long countAllApplicationsByIdCompany(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all interviews by id company.
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and lower(jc.progress) like 'waiting for result'")
	public long countAllInterviewsByIdCompany(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all hired by id company.
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and (lower(jc.shopProgress) like 'hired' or  lower(jc.shopProgress) like '入社')")
	public long countAllHiredByIdCompany(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all applications by id job.
	 * @param idJob
	 *            the id job
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and jc.applied = true")
	public long countAllApplicationsByIdJob(@Param("idJob") int idJob);

	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and jc.applied = true  ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllApplicationsByIdJob(@Param("idJob") int idJob);

	/************ candidate list for manage job page *****************/
	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and jc.applied = true  ORDER BY jc.appliedDate DESC", countQuery = "select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and jc.applied = true")
	public Page<JobCandidateRelation> getAllApplicationsByIdJob(@Param("idJob") int idJob, Pageable pageable);

	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob  and lower(jc.progress) like 'waiting for result'  ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob  and lower(jc.progress) like 'waiting for result'")
	public Page<JobCandidateRelation> getAllInterviewsByIdJob(@Param("idJob") int idJob, Pageable pageable);

	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社')")
	public Page<JobCandidateRelation> getAllHiredByIdJob(@Param("idJob") int idJob, Pageable pageable);

	/************ candidate list for manage shop page *****************/
	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.applied = true  ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.applied = true")
	public Page<JobCandidateRelation> getAllApplicationsByIdShop(@Param("idShop") int idShop, Pageable pageable);

	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.interviewDate IS NOT NULL ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.interviewDate IS NOT NULL")
	public Page<JobCandidateRelation> getAllInterviewsByIdShop(@Param("idShop") int idShop, Pageable pageable);

	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社')")
	public Page<JobCandidateRelation> getAllHiredByIdShop(@Param("idShop") int idShop, Pageable pageable);

	/************ candidate list for manage company page *****************/
	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idComp and jc.applied = true ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idComp and jc.applied = true")
	public Page<JobCandidateRelation> getAllApplicationsByIdCompany(@Param("idComp") int idComp, Pageable pageable);

	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and lower(jc.progress) like 'waiting for result'  ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and lower(jc.progress) like 'waiting for result'")
	public Page<JobCandidateRelation> getAllInterviewsByIdCompany(@Param("idCompany") int idCompany, Pageable pageable);

	@Query(value = "Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社')")
	public Page<JobCandidateRelation> getAllHiredByIdCompany(@Param("idCompany") int idCompany, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all applications by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.applied = true")
	public long countAllApplicationsByIdShop(@Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all interviews by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.interviewDate IS NOT NULL")
	public long countAllInterviewsByIdShop(@Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all hired by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社')")
	public long countAllHiredByIdShop(@Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all interviews by id job.
	 * @param idJob
	 *            the id job
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and lower(jc.progress) like 'waiting for result'")
	public long countAllInterviewsByIdJob(@Param("idJob") int idJob);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all hired by id job.
	 * @param idJob
	 *            the id job
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社')")
	public long countAllHiredByIdJob(@Param("idJob") int idJob);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all job candidate relations.
	 * @param pageable
	 *            the pageable
	 * @return the all job candidate relations
	 */
	@Query(value = "Select jc from JobCandidateRelation jc where  jc.applied = true", countQuery = "Select count(jc) from JobCandidateRelation jc where  jc.applied = true")
	public Page<JobCandidateRelation> getAllJobCandidateRelations(Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all interviewed list by id job.
	 * @param idJob
	 *            the id job
	 * @return the all interviewed list by id job
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob  and lower(jc.progress) like 'waiting for result'  ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllInterviewedListByIdJob(@Param("idJob") int idJob);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all hired list by id job.
	 * @param idJob
	 *            the id job
	 * @return the all hired list by id job
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllHiredListByIdJob(@Param("idJob") int idJob);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all applications by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the all applications by id shop
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.applied = true  ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllApplicationsByIdShop(@Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all interviews by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the all interviews by id shop
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.interviewDate IS NOT NULL ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllInterviewsByIdShop(@Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all hired by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the all hired by id shop
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllHiredByIdShop(@Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all applications by id company.
	 * @param idComp
	 *            the id comp
	 * @return the all applications by id company
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idComp and jc.applied = true ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllApplicationsByIdCompany(@Param("idComp") int idComp);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all interviewed list by id company.
	 * @param idCompany
	 *            the id company
	 * @return the all interviewed list by id company
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and lower(jc.progress) like 'waiting for result'  ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllInterviewedListByIdCompany(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all hired list by id company.
	 * @param idCompany
	 *            the id company
	 * @return the all hired list by id company
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') ORDER BY jc.appliedDate DESC")
	public List<JobCandidateRelation> getAllHiredListByIdCompany(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Exist job candidate relation.
	 * @param jobCandidateRelationPK
	 *            the job candidate relation PK
	 * @return true, if successful
	 */
	@Query("Select count(jc)>0 from JobCandidateRelation jc where jc.jobCandidateRelationPK=:jobCandidateRelationPK")
	public boolean ExistJobCandidateRelation(
			@Param("jobCandidateRelationPK") JobCandidateRelationPK jobCandidateRelationPK);

	/**
	 * *************************************** COMPANY SIDE
	 * *************************************************.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all applications by id shop and by id company.
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */

	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.job.shop.company.idCompany=:idCompany and jc.applied = true")
	public long countAllApplicationsByIdShopAndByIdCompany(@Param("idShop") int idShop,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all interviews by id shop and by id company.
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and jc.job.shop.company.idCompany=:idCompany and jc.interviewDate IS NOT NULL")
	public long countAllInterviewsByIdShopAndByIdCompany(@Param("idShop") int idShop,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all hired by id shop and by id company.
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.shop.idShop=:idShop and  jc.job.shop.company.idCompany=:idCompany and (lower(jc.shopProgress) like 'hired'  or  lower(jc.shopProgress) like '入社' or lower(jc.progress) like 'working' or lower(jc.progress) like '入社済み')")
	public long countAllHiredByIdShopAndByIdCompany(@Param("idShop") int idShop, @Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all applications by id job and id company.
	 * @param idJob
	 *            the id job
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob  and  jc.job.shop.company.idCompany=:idCompany and  jc.applied = true")
	public long countAllApplicationsByIdJobAndIdCompany(@Param("idJob") int idJob, @Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all interviews by id job and id company.
	 * @param idJob
	 *            the id job
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and  jc.job.shop.company.idCompany=:idCompany and jc.interviewDate IS NOT NULL")
	public long countAllInterviewsByIdJobAndIdCompany(@Param("idJob") int idJob, @Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all hired by id job and id company.
	 * @param idJob
	 *            the id job
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and  jc.job.shop.company.idCompany=:idCompany and (lower(jc.shopProgress) like 'hired'  or  lower(jc.shopProgress) like '入社' or lower(jc.progress) like 'working' or lower(jc.progress) like '入社済み')")
	public long countAllHiredByIdJobAndIdCompany(@Param("idJob") int idJob, @Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all applications by id job and id company.
	 * @param idJob
	 *            the id job
	 * @param idCompany
	 *            the id company
	 * @return the all applications by id job and id company
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and  jc.job.shop.company.idCompany=:idCompany and jc.applied = true")
	public List<JobCandidateRelation> getAllApplicationsByIdJobAndIdCompany(@Param("idJob") int idJob,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all interviewed list by id job and id company.
	 * @param idJob
	 *            the id job
	 * @param idCompany
	 *            the id company
	 * @return the all interviewed list by id job and id company
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and  jc.job.shop.company.idCompany=:idCompany and jc.interviewDate IS NOT NULL")
	public List<JobCandidateRelation> getAllInterviewedListByIdJobAndIdCompany(@Param("idJob") int idJob,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all hired list by id job and id company.
	 * @param idJob
	 *            the id job
	 * @param idCompany
	 *            the id company
	 * @return the all hired list by id job and id company
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.idJob=:idJob and  jc.job.shop.company.idCompany=:idCompany and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社' or lower(jc.progress) like 'working' or lower(jc.progress) like '入社済み')")
	public List<JobCandidateRelation> getAllHiredListByIdJobAndIdCompany(@Param("idJob") int idJob,
			@Param("idCompany") int idCompany);

	// @Query(value = "Select jc from JobCandidateRelation jc where
	// (jc.job.idJob=:idJob or :idJob =0 ) and jc.appliedDate>:startDate and
	// jc.appliedDate<:endDate and (jc.progress=:progress or :progress='') and
	// (jc.job.requiredJLPT=:jlpt or :jlpt='') and
	// (jc.job.requiredDurationInJapan=:duration or :duration='')", countQuery =
	// "Select count(jc) from JobCandidateRelation jc where jc.job.idJob=:idJob and
	// jc.appliedDate>:startDate and jc.appliedDate<:endDate and
	// (jc.progress=:progress or :progress='') and (jc.job.requiredJLPT=:jlpt or
	// :jlpt ='') and (jc.job.requiredDurationInJapan=:duration or :duration ='')")

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Search application by criteria.
	 * @param idCompany
	 *            the id company
	 * @param idJob
	 *            the id job
	 * @param shopIds
	 *            the shop ids
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @param progressShop
	 *            the progress shop
	 * @param progress
	 *            the progress
	 * @param jlpt
	 *            the jlpt
	 * @param durationJp
	 *            the duration jp
	 * @param durationEn
	 *            the duration en
	 * @param freeText
	 *            the free text
	 * @param pageable
	 *            the pageable
	 * @return the page
	 */
	@Query(value = "Select  NEW com.hrdatabank.mtproject.model.ApplicationDto(jc.appliedDate,jc.startingDate, jc.approved, jc.progress,jc.shopProgress,jc.candidate,jc.job,jc.paymentStatus,jc.candidateName,jc.candidateNameKatakana,jc.candidatePhone,jc.candidateJLPT,jc.candidateDurationInJapan,jc.candidateBirthday) from JobCandidateRelation jc where (jc.job.shop.company.idCompany=:idCompany) and (jc.job.idJob=:idJob or :idJob=0) and (jc.job.shop.idShop IN :shopIds or :shopIds IS NULL) and jc.appliedDate>:startDate and jc.appliedDate<:endDate and (jc.shopProgress=:progressShop or :progressShop='all' or :progressShop='') and  (jc.shopProgress is null  or :progress='') and (jc.candidateJLPT=:jlpt or :jlpt='' ) and (jc.candidateDurationInJapan=:durationJp or jc.candidateDurationInJapan=:durationEn or :durationJp='') and (lower(jc.candidateJLPT) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidatePhone) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.requiredDurationInJapan) like lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateDurationInJapan) like lower(CONCAT('%',:freeText,'%'))  or  lower(jc.job.positionName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.jobType)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.shop.nameShop)  like  lower(CONCAT('%',:freeText,'%'))  or  :freeText='' or lower(jc.shopProgress) like  lower(CONCAT('%',:freeText,'%'))  or lower(jc.job.requiredJLPT)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.email) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateName) like  lower(CONCAT('%',:freeText,'%')))", countQuery = "Select  count (jc) from JobCandidateRelation jc where (jc.job.shop.company.idCompany=:idCompany) and (jc.job.idJob=:idJob or :idJob=0) and (jc.job.shop.idShop IN :shopIds or :shopIds IS NULL) and jc.appliedDate>:startDate and jc.appliedDate<:endDate and (jc.shopProgress=:progressShop or :progressShop='all' or :progressShop='') and  (jc.shopProgress is null  or :progress='') and (jc.candidateJLPT=:jlpt or :jlpt='' ) and (jc.candidateDurationInJapan=:durationJp or jc.candidateDurationInJapan=:durationEn or :durationJp='') and (lower(jc.candidateJLPT) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidatePhone) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.requiredDurationInJapan) like lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateDurationInJapan) like lower(CONCAT('%',:freeText,'%'))  or  lower(jc.job.positionName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.jobType)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.shop.nameShop)  like  lower(CONCAT('%',:freeText,'%'))  or  :freeText='' or lower(jc.shopProgress) like  lower(CONCAT('%',:freeText,'%'))  or lower(jc.job.requiredJLPT)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.email) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateName) like  lower(CONCAT('%',:freeText,'%')))")
	public Page<ApplicationDto> searchApplicationByCriteria(@Param("idCompany") int idCompany,
			@Param("idJob") int idJob, @Param("shopIds") List<Integer> shopIds, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate, @Param("progressShop") String progressShop,
			@Param("progress") String progress, @Param("jlpt") String jlpt, @Param("durationJp") String durationJp,
			@Param("durationEn") String durationEn, @Param("freeText") String freeText, Pageable pageable);

	// public Page<JobCandidateRelation> searchApplicationByCriteria(@Param("idJob")
	// int idJob,
	// @Param("startDate") Date startDate, @Param("endDate") Date endDate,
	// @Param("progress") String progress,
	// @Param("jlpt") String jlpt, @Param("duration") String duration, Pageable
	// pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Gets the all application by company.
	 * @param idComp
	 *            the id comp
	 * @param pageable
	 *            the pageable
	 * @return the all application by company
	 */
	@Query(value = "Select jc from JobCandidateRelation  jc where jc.job.shop.company.idCompany =:idCompany", countQuery = "Select count(jc) from  JobCandidateRelation jc where jc.job.shop.company.idCompany =:idCompany")
	public Page<JobCandidateRelation> getAllApplicationByCompany(@Param("idCompany") int idComp, Pageable pageable);

	@Query("Select NEW com.hrdatabank.mtproject.model.JobCandidateRelationDto(jc.jobCandidateRelationPK.idJob, jc.jobCandidateRelationPK.idCandidate, jc.callShopMessageCounter, jc.noCallOrForgotReason, jc.noTalkWithShop, jc.askTalkWithShop, jc.progress, jc.shopProgress, jc.botChekProgress, jc.offered, jc.applied, jc.matched, jc.offerDate, jc.appliedDate, jc.matchDate, jc.postedDate, jc.noTalkWithShopDate, jc.noCallOrForgotDate, jc.callShopMessageDate, jc.interviewDate, jc.remindInterviewDate, jc.remindInterviewDayDate, jc.askForWhenInterviewDate, jc.askCandidateHowWasInterviewDate, jc.resultInterviewDate, jc.startWorkingDate, jc.youStartWorkingTodayDate, jc.askForResultDateCandidate, jc.askForSetInterview, jc.askShopHowWasInterviewDate) from JobCandidateRelation jc")
	public List<JobCandidateRelationDto> getAllJobCandidateRelationsForRecommendation();

	@Query(value = "Select NEW com.hrdatabank.mtproject.model.JobCandidateRelationDto(jc.jobCandidateRelationPK.idJob, jc.jobCandidateRelationPK.idCandidate, jc.callShopMessageCounter, jc.noCallOrForgotReason, jc.noTalkWithShop, jc.askTalkWithShop, jc.progress, jc.shopProgress, jc.botChekProgress, jc.offered, jc.applied, jc.matched, jc.offerDate, jc.appliedDate, jc.matchDate, jc.postedDate, jc.noTalkWithShopDate, jc.noCallOrForgotDate, jc.callShopMessageDate, jc.interviewDate, jc.remindInterviewDate, jc.remindInterviewDayDate, jc.askForWhenInterviewDate, jc.askCandidateHowWasInterviewDate, jc.resultInterviewDate, jc.startWorkingDate, jc.youStartWorkingTodayDate, jc.askForResultDateCandidate, jc.askForSetInterview, jc.askShopHowWasInterviewDate) from JobCandidateRelation jc", countName = "select  count(*) from JobCandidateRelation jc")
	public Page<JobCandidateRelationDto> getAllJobCandidateRelationsForRecommendationPaginated(Pageable page);

	@Query(value = "Select  NEW com.hrdatabank.mtproject.model.ApplicationDto(jc.appliedDate, jc.startingDate, jc.approved, jc.progress,jc.shopProgress,jc.candidate,jc.job,jc.paymentStatus, jc.candidateName, jc.candidateNameKatakana, jc.candidatePhone,jc.candidateJLPT, jc.candidateDurationInJapan, jc.candidateBirthday) from JobCandidateRelation jc where (jc.job.shop.company.idCompany IN :companyIds or :companyIds IS NULL) and  (jc.job.shop.idShop IN :shopIds or :shopIds IS NULL) and (jc.job.idJob=:idJob or :idJob=0) and  (jc.appliedDate BETWEEN :startDate and :endDate)  and (jc.candidate.botInformation.lastActionDate  BETWEEN :lastActionStartDate and :lastActionEndDate) and (jc.shopProgress=:progressShop or :progressShop='all' or :progressShop='' or (:progressShop='応募済み' and jc.shopProgress IS NULL)) and  (jc.shopProgress is null  or :progress='') and (jc.candidateJLPT=:jlpt or :jlpt='' ) and (jc.candidateDurationInJapan=:durationJp or jc.candidateDurationInJapan=:durationEn or :durationJp='') and (lower(jc.candidateJLPT) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidatePhone) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.requiredDurationInJapan) like lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateDurationInJapan) like lower(CONCAT('%',:freeText,'%'))  or  lower(jc.job.positionName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.jobType)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.shop.nameShop)  like  lower(CONCAT('%',:freeText,'%'))  or  :freeText='' or lower(jc.shopProgress) like  lower(CONCAT('%',:freeText,'%'))  or lower(jc.job.requiredJLPT)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.email) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateName) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.memo) like  lower(CONCAT('%',:freeText,'%'))  or  CONCAT(jc.candidate.idUser, '') like  lower(CONCAT('%',:freeText,'%')))", countQuery = "Select  count (jc) from JobCandidateRelation jc where (jc.job.shop.company.idCompany IN :companyIds or :companyIds IS NULL) and (jc.job.idJob=:idJob or :idJob=0) and (jc.job.shop.idShop IN :shopIds or :shopIds IS NULL) and (jc.appliedDate BETWEEN :startDate and :endDate)  and (jc.candidate.botInformation.lastActionDate BETWEEN :lastActionStartDate and :lastActionEndDate) and (jc.shopProgress=:progressShop or :progressShop='all' or :progressShop='' or (:progressShop='応募済み' and jc.shopProgress IS NULL)) and  (jc.shopProgress is null  or :progress='')  and (jc.candidateJLPT=:jlpt or :jlpt='' ) and (jc.candidateDurationInJapan=:durationJp or jc.candidateDurationInJapan=:durationEn or :durationJp='') and (lower(jc.candidateJLPT) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.requiredDurationInJapan) like lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateDurationInJapan) like lower(CONCAT('%',:freeText,'%'))  or  lower(jc.job.positionName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.jobType)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.shop.nameShop)  like  lower(CONCAT('%',:freeText,'%'))  or  :freeText='' or lower(jc.shopProgress) like  lower(CONCAT('%',:freeText,'%'))  or lower(jc.job.requiredJLPT)  like  lower(CONCAT('%',:freeText,'%')) or  lower(jc.candidatePhone) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.email) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.memo) like  lower(CONCAT('%',:freeText,'%')) or  CONCAT(jc.candidate.idUser, '') like  lower(CONCAT('%',:freeText,'%')))")
	public Page<ApplicationDto> displayApplicationsByCriteria(@Param("companyIds") List<Integer> companyIds,
			@Param("shopIds") List<Integer> shopIds, @Param("idJob") int idJob, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate, @Param("lastActionStartDate") Date lastActionStartDate,
			@Param("lastActionEndDate") Date lastActionEndDate, @Param("progressShop") String progressShop,
			@Param("progress") String progress, @Param("jlpt") String jlpt, @Param("durationJp") String durationJp,
			@Param("durationEn") String durationEn, @Param("freeText") String freeText, Pageable pageable);

	@Query(value = "Select  NEW com.hrdatabank.mtproject.model.Application(jc.appliedDate,jc.startingDate, jc.approved,jc.progress,jc.shopProgress,jc.candidate,jc.job,jc.paymentStatus, jc.candidateName, jc.candidateNameKatakana, jc.candidatePhone,jc.candidateJLPT, jc.candidateDurationInJapan, jc.candidateBirthday) from JobCandidateRelation jc where (jc.job.shop.company.idCompany IN :companyIds or :companyIds IS NULL) and  (jc.job.shop.idShop IN :shopIds or :shopIds IS NULL) and (jc.job.idJob=:idJob or :idJob=0) and  (jc.appliedDate BETWEEN :startDate and :endDate)  and (jc.candidate.botInformation.lastActionDate  BETWEEN :lastActionStartDate and :lastActionEndDate) and (jc.shopProgress=:progressShop or :progressShop='all' or :progressShop='' or (:progressShop='応募済み' and jc.shopProgress IS NULL)) and  (jc.shopProgress is null  or :progress='') and (jc.candidateJLPT=:jlpt or :jlpt='' ) and (jc.candidateDurationInJapan=:durationJp or jc.candidateDurationInJapan=:durationEn or :durationJp='') and (lower(jc.candidateJLPT) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidatePhone) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.requiredDurationInJapan) like lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateDurationInJapan) like lower(CONCAT('%',:freeText,'%'))  or  lower(jc.job.positionName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.jobType)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.shop.nameShop)  like  lower(CONCAT('%',:freeText,'%'))  or  :freeText='' or lower(jc.shopProgress) like  lower(CONCAT('%',:freeText,'%'))  or lower(jc.job.requiredJLPT)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.email) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateName) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.memo) like  lower(CONCAT('%',:freeText,'%'))  or  CONCAT(jc.candidate.idUser, '') like  lower(CONCAT('%',:freeText,'%')))", countQuery = "Select  count (jc) from JobCandidateRelation jc where (jc.job.shop.company.idCompany IN :companyIds or :companyIds IS NULL) and (jc.job.idJob=:idJob or :idJob=0) and (jc.job.shop.idShop IN :shopIds or :shopIds IS NULL) and (jc.appliedDate BETWEEN :startDate and :endDate)  and (jc.candidate.botInformation.lastActionDate BETWEEN :lastActionStartDate and :lastActionEndDate) and (jc.shopProgress=:progressShop or :progressShop='all' or :progressShop='' or (:progressShop='応募済み' and jc.shopProgress IS NULL)) and  (jc.shopProgress is null  or :progress='')  and (jc.candidateJLPT=:jlpt or :jlpt='' ) and (jc.candidateDurationInJapan=:durationJp or jc.candidateDurationInJapan=:durationEn or :durationJp='') and (lower(jc.candidateJLPT) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.requiredDurationInJapan) like lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateDurationInJapan) like lower(CONCAT('%',:freeText,'%'))  or  lower(jc.job.positionName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.jobType)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.job.shop.nameShop)  like  lower(CONCAT('%',:freeText,'%'))  or  :freeText='' or lower(jc.shopProgress) like  lower(CONCAT('%',:freeText,'%'))  or lower(jc.job.requiredJLPT)  like  lower(CONCAT('%',:freeText,'%')) or  lower(jc.candidatePhone) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.email) like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidateName)  like  lower(CONCAT('%',:freeText,'%')) or lower(jc.candidate.memo) like  lower(CONCAT('%',:freeText,'%')) or  CONCAT(jc.candidate.idUser, '') like  lower(CONCAT('%',:freeText,'%')))")
	public List<Application> getApplicationsByCriteriaForExport(@Param("companyIds") List<Integer> companyIds,
			@Param("shopIds") List<Integer> shopIds, @Param("idJob") int idJob, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate, @Param("lastActionStartDate") Date lastActionStartDate,
			@Param("lastActionEndDate") Date lastActionEndDate, @Param("progressShop") String progressShop,
			@Param("progress") String progress, @Param("jlpt") String jlpt, @Param("durationJp") String durationJp,
			@Param("durationEn") String durationEn, @Param("freeText") String freeText);

	@Query("Select count(jc) from JobCandidateRelation jc where jc.jobCandidateRelationPK=:jobCandidateRelationPK and privacyPolicyChecked = TRUE")
	public long getAppliedAndCheckedPolicyJobsByPK(
			@Param("jobCandidateRelationPK") JobCandidateRelationPK jobCandidateRelationPK);

	/************ method for scheduler did you talk to the shop for Line **********/

	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) where c.candidatefb= FALSE and c.guest=FALSE and jc.applied = true and jc.progress = 'applied' "
			+ "and j.interview_type != 'youcome' and jc.ask_talk_with_shop != 5 and jc.interview_date IS NULL and "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '3' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '1' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '3' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '5' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12'))", nativeQuery = true)
	public List<Integer> getCandidatesForDidYouTalkToShop();

	@Query(value = "select jc.id_job from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) where c.candidatefb= FALSE and c.guest=FALSE and jc.id_candidate=:idCandidate and jc.applied = true and jc.progress = 'applied'"
			+ " and j.interview_type != 'youcome' and jc.ask_talk_with_shop != 5 and jc.interview_date IS NULL and "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '3' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '1' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '3' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '5' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12'))", nativeQuery = true)
	public List<Integer> getJobsForDidYouTalkToShop(@Param("idCandidate") int idCandidate);

	/************ method for scheduler remind interview for Line **********/

	@Query(value = "select jc.* from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) "
			+ "where c.candidatefb= FALSE and c.guest=FALSE and jc.applied = true and jc.progress = 'waiting for interview' and "
			+ "(((to_timestamp(to_char(jc.interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') - interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ " and (j.interview_type != 'youcome')) or"
			+ "((to_timestamp(to_char(j.interview_date_job, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') - interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))"
			+ " and (j.interview_type = 'youcome')))", nativeQuery = true)
	public List<JobCandidateRelation> getJobCandidateRelationsForRemindBeforeOneDay();

	@Query(value = "select jc.* from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) "
			+ "where c.candidatefb= FALSE and c.guest=FALSE and jc.applied = true and jc.progress = 'waiting for interview' and "
			+ "(((to_timestamp(to_char(jc.interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ " and (j.interview_type != 'youcome')) or"
			+ "((to_timestamp(to_char(j.interview_date_job, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd HH24') ) "
			+ " and (j.interview_type = 'youcome')))", nativeQuery = true)
	public List<JobCandidateRelation> getJobCandidateRelationsForRemindTheDay();

	/********** method scheduler how was the interview for Line ************/

	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) "
			+ "where c.candidatefb= FALSE and c.guest=FALSE and jc.applied = true and jc.progress != 'failed' and "
			+ "(((to_timestamp(to_char(jc.interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ "and (j.interview_type != 'youcome')) or"
			+ "((to_timestamp(to_char(j.interview_date_job, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ "and (j.interview_type = 'youcome')))", nativeQuery = true)
	public List<Integer> getJobCandidateRelationsForHowWasItAfterInterview();

	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) "
			+ "where c.candidatefb= FALSE and c.guest=FALSE and jc.applied = true and jc.progress != 'failed' and "
			+ "(to_timestamp(to_char(jc.result_interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<Integer> getJobCandidateRelationsForHowWasItAfterResult();

	/********* method for scheduler working reminder for Line ***********/

	@Query(value = "select jc.* from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) "
			+ "where c.candidatefb= FALSE and c.guest=FALSE and jc.applied = true and jc.progress != 'failed' and "
			+ "(to_timestamp(to_char(jc.start_working_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<JobCandidateRelation> getJobCandidateRelationsForWorkReminder();

	/********* method for scheduler how was the work for Line ***********/
	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) "
			+ "where c.candidatefb= FALSE and c.guest=FALSE and jc.applied = true and jc.progress != 'failed' and "
			+ "(to_timestamp(to_char(jc.start_working_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<Integer> getJobCandidateRelationsForHowWasWork();

	/********* method for scheduler did you talk to the shop for Messenger ******/

	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) where c.candidatefb= TRUE and c.guest=FALSE and jc.applied = true and jc.progress = 'applied' "
			+ "and j.interview_type != 'youcome' and jc.ask_talk_with_shop != 5 and jc.interview_date IS NULL and "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '3' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '1' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '3' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '5' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12'))", nativeQuery = true)
	public List<Integer> getMessengerCandidatesForDidYouTalkToShop();

	@Query(value = "select jc.id_job from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) where c.candidatefb= TRUE and c.guest=FALSE and jc.id_candidate=:idCandidate and jc.applied = true and jc.progress = 'applied'"
			+ " and j.interview_type != 'youcome' and jc.ask_talk_with_shop != 5 and jc.interview_date IS NULL and "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '3' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '1' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '3' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12') or "
			+ "(to_timestamp(to_char(jc.applied_date, 'yyyy-MM-dd'),'yyyy-MM-dd') + interval '5' day = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd') and to_char(CURRENT_TIMESTAMP, 'HH24') = '12'))", nativeQuery = true)
	public List<Integer> getMessengerJobsForDidYouTalkToShop(@Param("idCandidate") int idCandidate);

	/************ method for scheduler remind interview for Messenger **********/

	@Query(value = "select jc.* from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) "
			+ "where c.candidatefb= TRUE and c.guest=FALSE and jc.applied = true and jc.progress = 'waiting for interview' and  jc.remind_interview_date IS NULL and "
			+ "(((to_timestamp(to_char(jc.interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') - interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ " and (j.interview_type != 'youcome')) or"
			+ "((to_timestamp(to_char(j.interview_date_job, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') - interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))"
			+ " and (j.interview_type = 'youcome')))", nativeQuery = true)
	public List<JobCandidateRelation> getMessengerJobCandidateRelationsForRemindBeforeOneDay();

	@Query(value = "select jc.* from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) "
			+ "where c.candidatefb= TRUE and c.guest=FALSE and jc.applied = true and jc.progress = 'waiting for interview' and "
			+ "(((to_timestamp(to_char(jc.interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ " and (j.interview_type != 'youcome')) or"
			+ "((to_timestamp(to_char(j.interview_date_job, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd'),'yyyy-MM-dd HH24') ) "
			+ " and (j.interview_type = 'youcome')))", nativeQuery = true)
	public List<JobCandidateRelation> getMessengerJobCandidateRelationsForRemindTheDay();

	/********** method scheduler how was the interview for messenger ************/

	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) INNER JOIN job j ON (j.id_job = jc.id_job) "
			+ "where c.candidatefb= TRUE and c.guest=FALSE and jc.applied = true and jc.progress != 'failed' and "
			+ "(((to_timestamp(to_char(jc.interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ "and (j.interview_type != 'youcome')) or"
			+ "((to_timestamp(to_char(j.interview_date_job, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) "
			+ "and (j.interview_type = 'youcome')))", nativeQuery = true)
	public List<Integer> getMessengerJobCandidateRelationsForHowWasItAfterInterview();

	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) "
			+ "where c.candidatefb= TRUE and c.guest=FALSE and jc.applied = true and jc.progress != 'failed' and "
			+ "(to_timestamp(to_char(jc.result_interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<Integer> getMessengerJobCandidateRelationsForHowWasItAfterResult();

	/********* method for scheduler working reminder for messenger ***********/

	@Query(value = "select jc.* from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) "
			+ "where c.candidatefb= TRUE and c.guest=FALSE and jc.applied = true and jc.progress != 'failed' and "
			+ "(to_timestamp(to_char(jc.start_working_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<JobCandidateRelation> getMessengerJobCandidateRelationsForWorkReminder();

	/********* method for scheduler how was the work for messenger ***********/

	@Query(value = "select DISTINCT(jc.id_candidate) from job_candidate_relation jc INNER JOIN user_information c ON (jc.id_candidate = c.id_user) "
			+ "where c.candidatefb= FALSE and c.guest=TRUE and jc.applied = true and jc.progress != 'failed' and "
			+ "(to_timestamp(to_char(jc.start_working_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24')  + interval '24' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<Integer> getMessengerJobCandidateRelationsForHowWasWork();

	/**
	 * @author Wala ben Amor
	 * 
	 */
	@Query("Select count(jc) from JobCandidateRelation jc where jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.applied = true")
	public long countAppliedJobsByCandidate(@Param("idCandidate") int idCandidate);

	/**
	 * 
	 * @author Wala ben Amor
	 * 
	 */
	@Query(value = "Select jc from JobCandidateRelation jc where jc.applied = true and jc.candidateName IS NULL  and jc.candidatePhone IS NULL and jc.candidateJLPT IS NULL  and jc.candidateDurationInJapan IS NULL ORDER BY jc.appliedDate DESC", countQuery = "Select count(jc) from JobCandidateRelation jc where jc.applied = true and jc.candidateName IS NULL  and jc.candidatePhone IS NULL and jc.candidateJLPT IS NULL  and jc.candidateDurationInJapan IS NULL ")
	public Page<JobCandidateRelation> getAllApplicationsWithoutCandidateDetails(Pageable pageable);

	/**
	 * 
	 * @author Wala ben Amor
	 * 
	 */

	@Query(value = "Select count(jc) from JobCandidateRelation jc where jc.applied = true and jc.candidateName IS NULL  and jc.candidatePhone IS NULL and jc.candidateJLPT IS NULL  and jc.candidateDurationInJapan IS NULL")
	public long countApplicationsWithoutCandidateDetails();

	/********************** Methods for Payment Cycle *****************************/

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Count all hired candidates grouped by request month for payment cycle
	 *         with unconfirmed and confirmed request amounts paginated.
	 * @param idCompany
	 *            the company id
	 * @return the request month, number of hired candidates grouped by request
	 *         month, unconfirmed request amount, confirmed request amount
	 */
	@Query(value = "Select NEW com.hrdatabank.mtproject.model.PaymentCycleDto(jc.requestMonth, count(requestMonth), SUM(case when jc.approved = FALSE then cast(jc.casePrice as float) else 0 end), SUM(case when jc.approved = TRUE then cast(jc.casePrice as float) else 0 end)) from JobCandidateRelation jc where jc.job.shop.company.idCompany =:idCompany and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') GROUP by requestMonth \n"
			+ "ORDER BY SUBSTRING(jc.requestMonth, length(jc.requestMonth)-3, 4) DESC, (CASE SUBSTRING(jc.requestMonth, 1, 4) when 'Janu' then 1 when 'Febr' then 2 when 'Marc' then 3 when 'Apri' then 4 when 'May ' then 5 when 'June' then 6 \n"
			+ "when 'July' then 7 when 'Augu' then 8 when 'Sept' then 9 when 'Octo' then 10 when 'Nove' then 11 else 12 end) DESC")
	public Page<PaymentCycleDto> getPaymentRequestList(@Param("idCompany") int idCompany, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Get all unconfirmed hired applications list for scheduler
	 * @param idCompany
	 *            the company id
	 * @return list of JobCandidateRelation
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.job.shop.company.idCompany =:idCompany and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') and jc.approved = FALSE")
	public List<JobCandidateRelation> getAllUnconfirmedHiredApplications(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 *
	 *         Count all hired candidates grouped by request month and company name
	 *         for Admin side payment cycle with unconfirmed and confirmed request
	 *         amounts paginated.
	 * @param nameCompany
	 *            the company name
	 * @param requestMonth
	 *            the request Month
	 * @return the company name, the request month, number of hired candidates
	 *         grouped by request month, unconfirmed request amount, confirmed
	 *         request amount, the payment cycle
	 */
	@Query(value = "Select NEW com.hrdatabank.mtproject.model.PaymentCycleAdminDto(jc.job.shop.company.nameCompany, jc.requestMonth, count(requestMonth), SUM(case when jc.approved = FALSE then cast(jc.casePrice as float) else 0 end), SUM(case when jc.approved = TRUE then cast(jc.casePrice as float) else 0 end), jc.job.shop.company.paymentCycle) from JobCandidateRelation jc where ((jc.job.shop.company.nameCompany =:nameCompany or :nameCompany = NULL or :nameCompany = '') and (jc.requestMonth like  CONCAT('%',:requestMonth,'%') or :requestMonth = NULL or :requestMonth = '')) and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') GROUP by jc.job.shop.company.nameCompany, requestMonth, jc.job.shop.company.paymentCycle \n"
			+ "ORDER BY SUBSTRING(jc.requestMonth, length(jc.requestMonth)-3, 4) DESC, (CASE SUBSTRING(jc.requestMonth, 1, 4) when 'Janu' then 1 when 'Febr' then 2 when 'Marc' then 3 when 'Apri' then 4 when 'May ' then 5 when 'June' then 6 \n"
			+ "when 'July' then 7 when 'Augu' then 8 when 'Sept' then 9 when 'Octo' then 10 when 'Nove' then 11 else 12 end) DESC")
	public Page<PaymentCycleAdminDto> getPaymentRequestForAdmin(@Param("nameCompany") String nameCompany,
			@Param("requestMonth") String requestMonth, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationRepository.java
	 * 
	 *         Get shops details from payment cycle admin page
	 * @param nameCompany
	 *            the company name
	 * @param requestMonth
	 *            the request Month
	 * @return nameShop, number of hired candidates, unconfirmed request amount,
	 *         confirmed request amount
	 */
	@Query(value = "Select NEW com.hrdatabank.mtproject.model.PaymentCycleAdminDto(jc.job.shop.nameShop, count(requestMonth), SUM(case when jc.approved = FALSE then cast(jc.casePrice as float) else 0 end) as unconfirmed, SUM(case when jc.approved = TRUE then cast(jc.casePrice as float) else 0 end) as confirmed) from JobCandidateRelation jc where (jc.job.shop.company.nameCompany =:nameCompany and jc.requestMonth =:requestMonth) and (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') GROUP by jc.job.shop.nameShop, requestMonth \n"
			+ "ORDER BY confirmed DESC")
	public Page<PaymentCycleAdminDto> getShopDetailFromPaymentCycle(@Param("nameCompany") String nameCompany,
			@Param("requestMonth") String requestMonth, Pageable pageable);

	/**
	 * 
	 * @author Wala ben Amor
	 * 
	 */
	@Query("Select NEW com.hrdatabank.mtproject.model.JobCandidateRelationDto(jc.jobCandidateRelationPK.idJob, jc.jobCandidateRelationPK.idCandidate,jc.job.shop.idShop,jc.candidateName, jc.candidateNameKatakana, jc.candidatePhone,jc.job.shop.nameShop, jc.job.positionName, jc.startingDate,jc.approveDate,jc.job.casePrice, jc.approved, jc.appliedDate) from JobCandidateRelation jc where jc.job.shop.company.idCompany=:idCompany and  lower(jc.requestMonth) LIKE lower(:requestMonth)")
	public Page<JobCandidateRelationDto> getAllJobCandidateRelationsByRequestMonth(@Param("idCompany") int idCompany,
			@Param("requestMonth") String requestMonth, Pageable pageable);

	/**********************************************************************/

	/**
	 * get all application by phone number
	 * 
	 * @author djo
	 * 
	 */
	@Query("Select jc from JobCandidateRelation jc where  jc.candidate.phone=:phone and jc.appliedDate>=:startDate and jc.appliedDate<=:endDate ")
	public List<JobCandidateRelation> getJobCanidateRelationByPhone(@Param("phone") String phone,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	/**
	 * get all application by Id candidate limit
	 * 
	 * @author djo
	 * 
	 */
	@Query("Select jc from JobCandidateRelation jc where jc.candidate.idUser > :idCandidateStart and jc.candidate.idUser <= :idCandidateEnd and jc.appliedDate>:startDate and jc.appliedDate<=:endDate")
	public List<JobCandidateRelation> getJobCanidateRelationByIdCandidateLimit(
			@Param("idCandidateStart") int idCandidateStart, @Param("idCandidateEnd") int idCandidateEnd,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	/************************ Report Module Functions ***************************/

	@Query("Select NEW com.hrdatabank.mtproject.model.ReportDto(jc.candidateName, jc.candidateNameCp, jc.candidateNameKatakana, jc.candidateKatakanaCp, jc.candidateBirthday, jc.birthdateCp, jc.appliedDate, jc.startingDate, jc.casePrice, jc.job.shop.company.nameCompany, jc.job.shop.company.addressCompany, jc.job.shop.company.phoneNumber, jc.job.shop.company.traningPeriod, jc.job.shop.company.educationHistory, jc.job.shop.company.companyContractPeriod, jc.job.shop.company.responsiblePerson, jc.job.shop.company.companyFax, jc.job.shop ,CONCAT(jc.job.shop.nameShop,jc.job.positionName), jc.job.positionName, jc.job.openJobDate, jc.job.requiredJLPT, jc.job.startWorkingTime, jc.job.finishWorkingTime, jc.job.hourlyWage, jc.job.idJob,jc.job.requiredDurationInJapan, jc.validityDateCp, jc.job.shop.nameShop, jc.job.shop.addressShop, jc.shopProgress, jc.job.shop.transportationAllowance, jc.jobCandidateRelationPK.idCandidate, jc.staffNameCp, jc.genderCp, jc.candidateAddressCp, jc.candidateAddressKatakanaCp, jc.candidatePhone, jc.candidatePhoneCp, jc.candidateFaxCp, jc.candidatePreferenceCp, jc.staffCommentCp, jc.candidateDocumentCp, jc.job.shop.company.idCompany,	 jc.jobNameCp, jc.employTypeCp,jc.requiredJlptCp,jc.requiredDurationCp,jc.shopNameCp, jc.shopAddressCp,jc.nearestStationCp, jc.hourlyWageCp,jc.transportationAllowanceCp,jc.startTimeCp,jc.finishTimeCp,jc.companyFaxCp,jc.responsiblePersonCp,jc.companyContractPeriodCp,jc.traningPeriodCp,jc.educationHistoryCp,jc.applyDateCp,jc.companyNameCp,jc.companyAddressCp, jc.companyPhoneNumberCp,jc.positionNameCp) from JobCandidateRelation jc where (lower(jc.shopProgress) like 'hired'  or  lower(jc.shopProgress) like '入社') and ((jc.requestMonth like CONCAT(:month,' ',:year)) or (:year is NULL) or (:month is Null) or (:year is NULL and :month is NULL)  or (:year like '')  or (:month like '') or (:year like '' and :month like '')) and (jc.job.shop.company.idCompany =:company or :company=0) ORDER BY jc.startingDate DESC")
	public Page<ReportDto> findAllHiredCandidates(Pageable pageable, @Param("month") String month,
			@Param("year") String year, @Param("company") int company);

	@Query("Select NEW com.hrdatabank.mtproject.model.ReportDto(jc.candidateName,jc.candidateNameCp,jc.candidateNameKatakana,jc.candidateKatakanaCp,jc.candidateBirthday, jc.birthdateCp, jc.appliedDate ,jc.startingDate, jc.job.casePrice, jc.job.shop.company.nameCompany, jc.job.shop.company.addressCompany ,jc.job.shop.company.phoneNumber,jc.job.shop.company.traningPeriod , jc.job.shop.company.educationHistory, jc.job.shop.company.companyContractPeriod,jc.job.shop.company.responsiblePerson,jc.job.shop.company.companyFax, jc.job.shop ,CONCAT(jc.job.shop.nameShop,jc.job.positionName), jc.job.positionName, jc.job.openJobDate,jc.job.requiredJLPT, jc.job.startWorkingTime,jc.job.finishWorkingTime,jc.job.hourlyWage, jc.job.idJob,jc.job.requiredDurationInJapan, jc.validityDateCp, jc.job.shop.nameShop,jc.job.shop.addressShop,jc.shopProgress,jc.job.shop.transportationAllowance, jc.jobCandidateRelationPK.idCandidate , jc.staffNameCp, jc.genderCp, jc.candidateAddressCp,jc.candidateAddressKatakanaCp ,jc.candidatePhone,jc.candidatePhoneCp, jc.candidateFaxCp , jc.candidatePreferenceCp , jc.staffCommentCp ,jc.candidateDocumentCp, jc.job.shop.company.idCompany,	 jc.jobNameCp, jc.employTypeCp,jc.requiredJlptCp,jc.requiredDurationCp,jc.shopNameCp, jc.shopAddressCp,jc.nearestStationCp, jc.hourlyWageCp,jc.transportationAllowanceCp,jc.startTimeCp,jc.finishTimeCp,jc.companyFaxCp,jc.responsiblePersonCp,jc.companyContractPeriodCp,jc.traningPeriodCp,jc.educationHistoryCp,jc.applyDateCp,jc.companyNameCp,jc.companyAddressCp, jc.companyPhoneNumberCp,jc.positionNameCp) from JobCandidateRelation jc  where (lower(jc.shopProgress) like 'hired'  or  lower(jc.shopProgress) like '入社') and ( (jc.requestMonth like CONCAT(:month,' ',:year)) or (:year is NULL) or (:month is Null) or (:year is NULL and :month is NULL)  or (:year like '')  or (:month like '') or (:year like '' and :month like '')) and (jc.job.shop.company.idCompany =:company or :company=0) ORDER BY jc.startingDate DESC")
	public Page<JobCandidateRelation> upadetHiredCandidatePage(Pageable pageable, @Param("month") String month,
			@Param("year") String year, @Param("company") int company);

	@Query(value = "SELECT jc FROM JobCandidateRelation jc WHERE jc.jobCandidateRelationPK.idCandidate=:idCandidate and jc.jobCandidateRelationPK.idJob=:idJob")
	public JobCandidateRelation editHiredCandidate(@Param("idCandidate") int idCandidate, @Param("idJob") int idJob);

	@Query(value = "UPDATE job_candidate_relation SET  staff_name_cp=:staffName, candidate_address_cp=:candidateAddress, position_name_cp=:positionName,candidate_name_cp=:candidateName WHERE (id_candidate =:idCandidate) and (id_job=:idJob)", nativeQuery = true)
	public void editHiredCandidate(@Param("idCandidate") int idCandidate, @Param("idJob") int idJob,
			@Param("idJob") String staffName, @Param("candidateAddress") String candidateAddress,
			@Param("candidateName") String candidateName);

	/*************************/

	// @Query("Select NEW
	// com.hrdatabank.mtproject.model.ReportDto(jc.candidateName,jc.candidateNameCp,jc.candidateNameKatakana,jc.candidateKatakanaCp,jc.candidateBirthday,
	// jc.birthdateCp, jc.appliedDate ,jc.startingDate, jc.casePrice,
	// jc.job.shop.company.nameCompany, jc.job.shop.company.addressCompany
	// ,jc.job.shop.company.phoneNumber,jc.job.shop.company.traningPeriod ,
	// jc.job.shop.company.educationHistory,
	// jc.job.shop.company.companyContractPeriod,jc.job.shop.company.responsiblePerson,jc.job.shop.company.companyFax,
	// jc.job.shop ,CONCAT(jc.job.shop.nameShop,jc.job.positionName),
	// jc.job.positionName, jc.job.openJobDate,jc.job.requiredJLPT,
	// jc.job.startWorkingTime,jc.job.finishWorkingTime,jc.job.hourlyWage,
	// jc.job.idJob,jc.job.requiredDurationInJapan, jc.validityDateCp,
	// jc.job.shop.nameShop,jc.job.shop.addressShop,jc.shopProgress,jc.job.shop.transportationAllowance,
	// jc.jobCandidateRelationPK.idCandidate , jc.staffNameCp, jc.genderCp,
	// jc.candidateAddressCp,jc.candidateAddressKatakanaCp
	// ,jc.candidatePhone,jc.candidatePhoneCp, jc.candidateFaxCp ,
	// jc.candidatePreferenceCp , jc.staffCommentCp ,jc.candidateDocumentCp,
	// jc.job.shop.company.idCompany) from JobCandidateRelation jc where
	// (jc.jobCandidateRelationPK.idCandidate =:idCandidate) and
	// (jc.jobCandidateRelationPK.idJob =:idJob) ORDER BY jc.startWorkingDate DESC")

	@Query("Select NEW com.hrdatabank.mtproject.model.ReportDto(jc.candidateName,jc.candidateNameCp,jc.candidateNameKatakana,jc.candidateKatakanaCp,jc.candidateBirthday, jc.birthdateCp, jc.appliedDate ,jc.startingDate, jc.casePrice, jc.job.shop.company.nameCompany, jc.job.shop.company.addressCompany ,jc.job.shop.company.phoneNumber,jc.job.shop.company.traningPeriod , jc.job.shop.company.educationHistory, jc.job.shop.company.companyContractPeriod,jc.job.shop.company.responsiblePerson,jc.job.shop.company.companyFax, jc.job.shop ,CONCAT(jc.job.shop.nameShop,jc.job.positionName), jc.job.positionName, jc.job.openJobDate,jc.job.requiredJLPT, jc.job.startWorkingTime,jc.job.finishWorkingTime,jc.job.hourlyWage, jc.job.idJob,jc.job.requiredDurationInJapan, jc.validityDateCp, jc.job.shop.nameShop,jc.job.shop.addressShop,jc.shopProgress,jc.job.shop.transportationAllowance, jc.jobCandidateRelationPK.idCandidate , jc.staffNameCp, jc.genderCp, jc.candidateAddressCp,jc.candidateAddressKatakanaCp ,jc.candidatePhone,jc.candidatePhoneCp, jc.candidateFaxCp , jc.candidatePreferenceCp , jc.staffCommentCp ,jc.candidateDocumentCp, jc.job.shop.company.idCompany,	 jc.jobNameCp, jc.employTypeCp,jc.requiredJlptCp,jc.requiredDurationCp,jc.shopNameCp, jc.shopAddressCp,jc.nearestStationCp, jc.hourlyWageCp,jc.transportationAllowanceCp,jc.startTimeCp,jc.finishTimeCp,jc.companyFaxCp,jc.responsiblePersonCp,jc.companyContractPeriodCp,jc.traningPeriodCp,jc.educationHistoryCp,jc.applyDateCp,jc.companyNameCp,jc.companyAddressCp, jc.companyPhoneNumberCp,jc.positionNameCp) from JobCandidateRelation jc  where (jc.jobCandidateRelationPK.idCandidate =:idCandidate) and (jc.jobCandidateRelationPK.idJob =:idJob) ORDER BY jc.startingDate DESC")
	public ReportDto getReportDtoByIdJobAndIdCandidate(@Param("idJob") int idJob,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT COALESCE(SUM(cast(j.case_price as float) ),0) FROM public.job_candidate_relation jc INNER JOIN public.job j ON jc.id_job = j.id_job INNER JOIN shop  s ON s.id_shop = j.id_shop  INNER JOIN company  c ON c.id_company = s.id_company  where  (lower(jc.shop_progress) = 'hired'  or  lower(jc.shop_progress) like '入社') and jc.approved = TRUE and c.id_company=:idCompany", nativeQuery = true)
	public Double getTotalApprovedAmount(@Param("idCompany") int idCompany);

	@Query(value = "select jc from JobCandidateRelation jc where (jc.jobCandidateRelationPK.idCandidate =:idCandidate) and (jc.jobCandidateRelationPK.idJob =:idJob)")
	public JobCandidateRelation getHiredCandidateById(@Param("idCandidate") int idCandidate, @Param("idJob") int idJob);

	/*************************/

	// @Query("Select NEW com.hrdatabank.mtproject.model.ReportDto(jc.candidateName,
	// jc.candidateNameCp, jc.candidateNameKatakana, jc.candidateKatakanaCp,
	// jc.candidateBirthday, jc.birthdateCp, jc.appliedDate, jc.startWorkingDate,
	// jc.job.casePrice, jc.job.shop.company.nameCompany,
	// jc.job.shop.company.addressCompany, jc.job.shop.company.phoneNumber,
	// jc.job.shop.company.traningPeriod, jc.job.shop.company.educationHistory,
	// jc.job.shop.company.companyContractPeriod,
	// jc.job.shop.company.responsiblePerson, jc.job.shop.company.companyFax,
	// jc.job.shop ,CONCAT(jc.job.shop.nameShop,jc.job.positionName),
	// jc.job.positionName, jc.job.openJobDate, jc.job.requiredJLPT,
	// jc.job.startWorkingTime, jc.job.finishWorkingTime, jc.job.hourlyWage,
	// jc.job.idJob,jc.job.requiredDurationInJapan, jc.validityDateCp,
	// jc.job.shop.nameShop, jc.job.shop.addressShop, jc.shopProgress,
	// jc.job.shop.transportationAllowance, jc.jobCandidateRelationPK.idCandidate,
	// jc.staffNameCp, jc.genderCp, jc.candidateAddressCp,
	// jc.candidateAddressKatakanaCp, jc.candidatePhone, jc.candidatePhoneCp,
	// jc.candidateFaxCp, jc.candidatePreferenceCp, jc.staffCommentCp,
	// jc.candidateDocumentCp, jc.job.shop.company.idCompany) from
	// JobCandidateRelation jc where (lower(jc.shopProgress) like 'hired') and
	// ((jc.requestMonth like CONCAT(:month,' ',:year)) or (:year is NULL) or
	// (:month is Null) or (:year is NULL and :month is NULL) or (:year like '') or
	// (:month like '') or (:year like '' and :month like '')) and
	// (jc.job.shop.company.idCompany =:company or :company=0) ORDER BY
	// jc.startWorkingDate DESC")

	@Query("Select NEW com.hrdatabank.mtproject.model.ReportDto(jc.candidateName, jc.candidateNameCp, jc.candidateNameKatakana, jc.candidateKatakanaCp, jc.candidateBirthday, jc.birthdateCp, jc.appliedDate, jc.startingDate, jc.casePrice, jc.job.shop.company.nameCompany, jc.job.shop.company.addressCompany, jc.job.shop.company.phoneNumber, jc.job.shop.company.traningPeriod, jc.job.shop.company.educationHistory, jc.job.shop.company.companyContractPeriod, jc.job.shop.company.responsiblePerson, jc.job.shop.company.companyFax, jc.job.shop ,CONCAT(jc.job.shop.nameShop,jc.job.positionName), jc.job.positionName, jc.job.openJobDate, jc.job.requiredJLPT, jc.job.startWorkingTime, jc.job.finishWorkingTime, jc.job.hourlyWage, jc.job.idJob,jc.job.requiredDurationInJapan, jc.validityDateCp, jc.job.shop.nameShop, jc.job.shop.addressShop, jc.shopProgress, jc.job.shop.transportationAllowance, jc.jobCandidateRelationPK.idCandidate, jc.staffNameCp, jc.genderCp, jc.candidateAddressCp, jc.candidateAddressKatakanaCp, jc.candidatePhone, jc.candidatePhoneCp, jc.candidateFaxCp, jc.candidatePreferenceCp, jc.staffCommentCp, jc.candidateDocumentCp, jc.job.shop.company.idCompany,	 jc.jobNameCp, jc.employTypeCp,jc.requiredJlptCp,jc.requiredDurationCp,jc.shopNameCp, jc.shopAddressCp,jc.nearestStationCp, jc.hourlyWageCp,jc.transportationAllowanceCp,jc.startTimeCp,jc.finishTimeCp,jc.companyFaxCp,jc.responsiblePersonCp,jc.companyContractPeriodCp,jc.traningPeriodCp,jc.educationHistoryCp,jc.applyDateCp,jc.companyNameCp,jc.companyAddressCp, jc.companyPhoneNumberCp,jc.positionNameCp) from JobCandidateRelation jc where (lower(jc.shopProgress) like 'hired' or lower(jc.shopProgress) like '入社') and ((jc.requestMonth like CONCAT(:month,' ',:year)) or (:year is NULL) or (:month is Null) or (:year is NULL and :month is NULL)  or (:year like '')  or (:month like '') or (:year like '' and :month like '')) and (jc.job.shop.company.idCompany =:company or :company=0) ORDER BY jc.startingDate DESC")
	public List<ReportDto> getAllHiredCandidates(@Param("month") String month, @Param("year") String year,
			@Param("company") int company);

}
