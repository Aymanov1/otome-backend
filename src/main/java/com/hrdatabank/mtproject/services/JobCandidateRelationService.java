package com.hrdatabank.mtproject.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.JobCandidateRelation;
import com.hrdatabank.mtproject.entities.JobCandidateRelationPK;
import com.hrdatabank.mtproject.model.Application;
import com.hrdatabank.mtproject.model.ApplicationDto;
import com.hrdatabank.mtproject.model.JobCandidateRelationDto;
import com.hrdatabank.mtproject.model.PaymentCycleAdminDto;
import com.hrdatabank.mtproject.model.PaymentCycleDto;
import com.hrdatabank.mtproject.model.ReportDto;
import com.hrdatabank.mtproject.repositories.JobCandidateRelationRepository;

/**
 * The Class JobCandidateRelationService.
 */
@Service
public class JobCandidateRelationService {

	/** The job candidate relation repository. */
	@Autowired
	private JobCandidateRelationRepository jobCandidateRelationRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Sets the job candidate relation repository.
	 * @param jobCandidateRelationRepository
	 *            the new job candidate relation repository
	 */
	public void setJobCandidateRelationRepository(JobCandidateRelationRepository jobCandidateRelationRepository) {
		this.jobCandidateRelationRepository = jobCandidateRelationRepository;
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         List all job candidate relations.
	 * @return the iterable
	 */
	public Iterable<JobCandidateRelation> listAllJobCandidateRelations() {
		return jobCandidateRelationRepository.findAll();
	}

	public List<JobCandidateRelation> getJobCandidaterelationByIdCandidate(int idCandidate) {
		return jobCandidateRelationRepository.getJobCandidaterelationByIdCandidate(idCandidate);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the job candidate relation by id.
	 * @param jobCandidateRelationPK
	 *            the job candidate relation PK
	 * @return the job candidate relation by id
	 */
	public Optional<JobCandidateRelation> getJobCandidateRelationById(JobCandidateRelationPK jobCandidateRelationPK) {
		return jobCandidateRelationRepository.findById(jobCandidateRelationPK);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Exist job candidate relation.
	 * @param jobCandidateRelationPK
	 *            the job candidate relation PK
	 * @return true, if successful
	 */
	public boolean ExistJobCandidateRelation(JobCandidateRelationPK jobCandidateRelationPK) {
		return jobCandidateRelationRepository.ExistJobCandidateRelation(jobCandidateRelationPK);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Save job candidate relation.
	 * @param jobCandidateRelation
	 *            the job candidate relation
	 * @return the job candidate relation
	 */
	public JobCandidateRelation saveJobCandidateRelation(JobCandidateRelation jobCandidateRelation) {
		return jobCandidateRelationRepository.saveAndFlush(jobCandidateRelation);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         this method Delete job candidate relation.
	 * @param jobCandidateRelation
	 *            the job candidate relation
	 */
	public void deleteJobCandidateRelation(JobCandidateRelation jobCandidateRelation) {
		jobCandidateRelationRepository.delete(jobCandidateRelation);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the applied jobs by shop and by candidate.
	 * @param idShop
	 *            the id shop
	 * @param idCandidate
	 *            the id candidate
	 * @return the applied jobs by shop and by candidate
	 */
	public List<JobCandidateRelation> getAppliedJobsByShopAndByCandidate(int idShop, int idCandidate) {
		return jobCandidateRelationRepository.getAppliedJobsByShopAndByCandidate(idShop, idCandidate);
	}

	public List<JobCandidateRelation> getAppliedJobsByIdCandidateForAts(int idCandidate) {
		return jobCandidateRelationRepository.getAppliedJobsByIdCandidateForAts(idCandidate);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the applied jobs by company and candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param idCompany
	 *            the id company
	 * @return the applied jobs by company and candidate
	 */
	public JobCandidateRelation getAppliedJobsByCompanyAndCandidate(int idCandidate, int idCompany) {
		return jobCandidateRelationRepository.getAppliedJobsByCompanyAndCandidate(idCandidate, idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the applied jobs not hired or failed by company and candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param idCompany
	 *            the id company
	 * @return the applied jobs not hired or failed by company and candidate
	 */
	public List<JobCandidateRelation> getAppliedJobsNotHiredOrFailedByCompanyAndCandidate(int idCandidate,
			int idCompany) {
		return jobCandidateRelationRepository.getAppliedJobsNotHiredOrFailedByCompanyAndCandidate(idCandidate,
				idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the applied jobs by candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the applied jobs by candidate
	 */
	public List<JobCandidateRelation> getAppliedJobsByCandidate(int idCandidate) {
		return jobCandidateRelationRepository.getAppliedJobsByCandidate(idCandidate);
	}

	public List<JobCandidateRelation> getAppliedJobsByCandidateOrderByApplyDate(int idCandidate) {
		return jobCandidateRelationRepository.getAppliedJobsByCandidateOrderByApplyDate(idCandidate);
	}

	public List<JobCandidateRelationDto> getAppliedJobsByCandidateDtoOrderByApplyDate(int idCandidate) {
		return jobCandidateRelationRepository.getAppliedJobsByCandidateDtoOrderByApplyDate(idCandidate);
	}

	public long countAppliedJobsByCandidateDtoOrderByApplyDate(int idCandidate) {
		return jobCandidateRelationRepository.countAppliedJobsByCandidateDtoOrderByApplyDate(idCandidate);
	}

	public List<JobCandidateRelationDto> getLastApplicationByCandidateDtoOrderByApplyDate(int idCandidate) {
		return jobCandidateRelationRepository.getLastApplicationByCandidateDtoOrderByApplyDate(idCandidate);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all job candidate relations by progress and candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param progress
	 *            the progress
	 * @return the all job candidate relations by progress and candidate
	 */
	public List<JobCandidateRelation> getAllJobCandidateRelationsByProgressAndCandidate(int idCandidate,
			String progress) {
		return jobCandidateRelationRepository.getAllJobCandidateRelationsByProgressAndCandidate(idCandidate, progress);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the applied candidate for company last week.
	 * @param idCompany
	 *            the id company
	 * @param date
	 *            the date
	 * @return the applied candidate for company last week
	 */
	public List<JobCandidateRelation> getAppliedCandidateForCompanyLastWeek(int idCompany, Date date) {
		return jobCandidateRelationRepository.getAppliedCandidateForCompanyLastWeek(idCompany, date);
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
	 *         Class Name: JobCandidateRelationService.java
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
	public long countAppliedJobsByCandidate(int idCandidate, String progressFailed, String progressHired) {
		return jobCandidateRelationRepository.countAppliedJobsByCandidate(idCandidate, progressFailed, progressHired);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the only applied jobs by candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param progressFailed
	 *            the progress failed
	 * @param progressHired
	 *            the progress hired
	 * @return the only applied jobs by candidate
	 */
	public List<JobCandidateRelation> getOnlyAppliedJobsByCandidate(int idCandidate, String progressFailed,
			String progressHired) {
		return jobCandidateRelationRepository.getAppliedJobsByCandidate(idCandidate, progressFailed, progressHired);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the job candidate relation by id job id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @param idJob
	 *            the id job
	 * @return the job candidate relation by id job id candidate
	 */
	public JobCandidateRelation getJobCandidateRelationByIdJobIdCandidate(int idCandidate, int idJob) {
		return jobCandidateRelationRepository.getJobCandidateRelationByIdJobIdCandidate(idCandidate, idJob);
	}

	public List<JobCandidateRelation> getJobCandidateRelationByIdJob(int idJob) {
		return jobCandidateRelationRepository.getJobCandidateRelationByIdJob(idJob);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all applications by id company.
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	public long countAllApplicationsByIdCompany(int idCompany) {
		return jobCandidateRelationRepository.countAllApplicationsByIdCompany(idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all interviews by id company.
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	public long countAllInterviewsByIdCompany(int idCompany) {
		return jobCandidateRelationRepository.countAllInterviewsByIdCompany(idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all hired by id company.
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	public long countAllHiredByIdCompany(int idCompany) {
		return jobCandidateRelationRepository.countAllHiredByIdCompany(idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all applications by id job.
	 * @param idJob
	 *            the id job
	 * @return the long
	 */
	public long countAllApplicationsByIdJob(int idJob) {
		return jobCandidateRelationRepository.countAllApplicationsByIdJob(idJob);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all applications by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the long
	 */
	public long countAllApplicationsByIdShop(int idShop) {
		return jobCandidateRelationRepository.countAllApplicationsByIdShop(idShop);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all interviews by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the long
	 */
	public long countAllInterviewsByIdShop(int idShop) {
		return jobCandidateRelationRepository.countAllInterviewsByIdShop(idShop);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all hired by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the long
	 */
	public long countAllHiredByIdShop(int idShop) {
		return jobCandidateRelationRepository.countAllHiredByIdShop(idShop);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all job candidate relations paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the all job candidate relations paginated
	 */
	public Page<JobCandidateRelation> getAllJobCandidateRelationsPaginated(int page, int size) {
		return jobCandidateRelationRepository.getAllJobCandidateRelations(PageRequest.of(page, size));
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all applications by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the all applications by id shop
	 */
	public List<JobCandidateRelation> getAllApplicationsByIdShop(int idShop) {
		return jobCandidateRelationRepository.getAllApplicationsByIdShop(idShop);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all interviews by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the all interviews by id shop
	 */
	public List<JobCandidateRelation> getAllInterviewsByIdShop(int idShop) {
		return jobCandidateRelationRepository.getAllInterviewsByIdShop(idShop);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all hired by id shop.
	 * @param idShop
	 *            the id shop
	 * @return the all hired by id shop
	 */
	public List<JobCandidateRelation> getAllHiredByIdShop(int idShop) {
		return jobCandidateRelationRepository.getAllHiredByIdShop(idShop);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all applications by id company.
	 * @param idComp
	 *            the id comp
	 * @return the all applications by id company
	 */
	public List<JobCandidateRelation> getAllApplicationsByIdCompany(int idComp) {
		return jobCandidateRelationRepository.getAllApplicationsByIdCompany(idComp);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all interviewed list by id company.
	 * @param idComp
	 *            the id comp
	 * @return the all interviewed list by id company
	 */
	public List<JobCandidateRelation> getAllInterviewedListByIdCompany(int idComp) {
		return jobCandidateRelationRepository.getAllInterviewedListByIdCompany(idComp);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all hired list by id company.
	 * @param idComp
	 *            the id comp
	 * @return the all hired list by id company
	 */
	public List<JobCandidateRelation> getAllHiredListByIdCompany(int idComp) {
		return jobCandidateRelationRepository.getAllHiredListByIdCompany(idComp);
	}

	/**
	 * ************** COMPANY SIDE *******************
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all applications by id shop and by id company.
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */

	public long countAllApplicationsByIdShopAndByIdCompany(int idShop, int idCompany) {
		return jobCandidateRelationRepository.countAllApplicationsByIdShopAndByIdCompany(idShop, idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all interviews by id shop and by id company.
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	public long countAllInterviewsByIdShopAndByIdCompany(int idShop, int idCompany) {
		return jobCandidateRelationRepository.countAllInterviewsByIdShopAndByIdCompany(idShop, idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Count all hired by id shop and by id company.
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @return the long
	 */
	public long countAllHiredByIdShopAndByIdCompany(int idShop, int idCompany) {
		return jobCandidateRelationRepository.countAllHiredByIdShopAndByIdCompany(idShop, idCompany);
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
	 *         Class Name: JobCandidateRelationService.java
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
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the page
	 */
	public Page<ApplicationDto> searchApplicationByCriteria(int idCompany, int idJob, List<Integer> shopIds,
			Date startDate, Date endDate, String progressShop, String progress, String jlpt, String durationJp,
			String durationEn, String freeText, int page, int size) {

		return jobCandidateRelationRepository.searchApplicationByCriteria(idCompany, idJob, shopIds, startDate, endDate,
				progressShop, progress, jlpt, durationJp, durationEn, freeText,
				PageRequest.of(page, size, Sort.Direction.DESC, "appliedDate"));
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
	 *         Class Name: JobCandidateRelationService.java
	 * 
	 *         Gets the all application by company.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param idCompany
	 *            the id company
	 * @return the all application by company
	 */
	public Page<JobCandidateRelation> getAllApplicationByCompany(int page, int size, int idCompany) {
		return jobCandidateRelationRepository.getAllApplicationByCompany(idCompany, PageRequest.of(page, size));
	}

	public List<JobCandidateRelationDto> getAllJobCandidateRelationsForRecommendation() {
		return jobCandidateRelationRepository.getAllJobCandidateRelationsForRecommendation();
	}

	public Page<JobCandidateRelationDto> getAllJobCandidateRelationsForRecommendationPagineted(Pageable pageable) {
		return jobCandidateRelationRepository.getAllJobCandidateRelationsForRecommendationPaginated(pageable);
	}

	public Page<ApplicationDto> displayApplicationsByCriteria(List<Integer> companyIds, List<Integer> shopIds,
			int idJob, Date startDate, Date endDate, Date lastActionStartDate, Date lastActionEndDate,
			String progressShop, String progress, String jlpt, String durationJp, String durationEn, String freeText,
			int page, int size) {
		return jobCandidateRelationRepository.displayApplicationsByCriteria(companyIds, shopIds, idJob, startDate,
				endDate, lastActionStartDate, lastActionEndDate, progressShop, progress, jlpt, durationJp, durationEn,
				freeText, PageRequest.of(page, size, Sort.Direction.DESC, "appliedDate"));
	}

	public List<Application> getApplicationsByCriteriaForExport(List<Integer> companyIds, List<Integer> shopIds,
			int idJob, Date startDate, Date endDate, Date lastActionStartDate, Date lastActionEndDate,
			String progressShop, String progress, String jlpt, String durationJp, String durationEn, String freeText) {
		return jobCandidateRelationRepository.getApplicationsByCriteriaForExport(companyIds, shopIds, idJob, startDate,
				endDate, lastActionStartDate, lastActionEndDate, progressShop, progress, jlpt, durationJp, durationEn,
				freeText);
	}

	public long getAppliedAndCheckedPolicyJobsByPK(JobCandidateRelationPK jobCandidateRelationPK) {
		return jobCandidateRelationRepository.getAppliedAndCheckedPolicyJobsByPK(jobCandidateRelationPK);
	}

	/******** scheduler did you talk to the shop for Line ******/

	public List<Integer> getCandidatesForDidYouTalkToShop() {
		return jobCandidateRelationRepository.getCandidatesForDidYouTalkToShop();
	}

	public List<Integer> getJobsForDidYouTalkToShop(int idCandidate) {
		return jobCandidateRelationRepository.getJobsForDidYouTalkToShop(idCandidate);
	}

	/************ method for scheduler remind interview for Line **********/

	public List<JobCandidateRelation> getJobCandidateRelationsForRemindBeforeOneDay() {
		return jobCandidateRelationRepository.getJobCandidateRelationsForRemindBeforeOneDay();
	}

	public List<JobCandidateRelation> getJobCandidateRelationsForRemindTheDay() {
		return jobCandidateRelationRepository.getJobCandidateRelationsForRemindTheDay();
	}

	/********** method for scheduler how was the interview for Line *************/

	public List<Integer> getJobCandidateRelationsForHowWasItAfterInterview() {
		return jobCandidateRelationRepository.getJobCandidateRelationsForHowWasItAfterInterview();
	}

	public List<Integer> getJobCandidateRelationsForHowWasItAfterResult() {
		return jobCandidateRelationRepository.getJobCandidateRelationsForHowWasItAfterResult();
	}

	/********* method for scheduler working reminder for Line ***********/

	public List<JobCandidateRelation> getJobCandidateRelationsForWorkReminder() {
		return jobCandidateRelationRepository.getJobCandidateRelationsForWorkReminder();
	}

	/********* method for scheduler how was the work for Line ***********/

	public List<Integer> getJobCandidateRelationsForHowWasWork() {
		return jobCandidateRelationRepository.getJobCandidateRelationsForHowWasWork();
	}

	/******** scheduler did you talk to the shop for Messenger ******/

	public List<Integer> getMessengerCandidatesForDidYouTalkToShop() {
		return jobCandidateRelationRepository.getMessengerCandidatesForDidYouTalkToShop();
	}

	public List<Integer> getMessengerJobsForDidYouTalkToShop(int idCandidate) {
		return jobCandidateRelationRepository.getMessengerJobsForDidYouTalkToShop(idCandidate);
	}

	/************ method for scheduler remind interview for messenger **********/

	public List<JobCandidateRelation> getMessengerJobCandidateRelationsForRemindBeforeOneDay() {
		return jobCandidateRelationRepository.getMessengerJobCandidateRelationsForRemindBeforeOneDay();
	}

	public List<JobCandidateRelation> getMessengerJobCandidateRelationsForRemindTheDay() {
		return jobCandidateRelationRepository.getMessengerJobCandidateRelationsForRemindTheDay();
	}

	/***** method for scheduler how was the interview for messenger *******/

	public List<Integer> getMessengerJobCandidateRelationsForHowWasItAfterInterview() {
		return jobCandidateRelationRepository.getMessengerJobCandidateRelationsForHowWasItAfterInterview();
	}

	public List<Integer> getMessengerJobCandidateRelationsForHowWasItAfterResult() {
		return jobCandidateRelationRepository.getMessengerJobCandidateRelationsForHowWasItAfterResult();
	}

	/********* method for scheduler working reminder for messenger ***********/

	public List<JobCandidateRelation> getMessengerJobCandidateRelationsForWorkReminder() {
		return jobCandidateRelationRepository.getMessengerJobCandidateRelationsForWorkReminder();
	}

	/********* method for scheduler how was the work for messenger ***********/

	public List<Integer> getMessengerJobCandidateRelationsForHowWasWork() {
		return jobCandidateRelationRepository.getMessengerJobCandidateRelationsForHowWasWork();
	}

	public Page<JobCandidateRelation> getAllApplicationsByIdJob(int page, int size, int idJob) {
		return jobCandidateRelationRepository.getAllApplicationsByIdJob(idJob, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllInterviewsByIdJob(int page, int size, int idJob) {
		return jobCandidateRelationRepository.getAllInterviewsByIdJob(idJob, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllHiredByIdJob(int page, int size, int idJob) {
		return jobCandidateRelationRepository.getAllHiredByIdJob(idJob, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllApplicationsByIdShop(int page, int size, int idShop) {
		return jobCandidateRelationRepository.getAllApplicationsByIdShop(idShop, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllInterviewsByIdShop(int page, int size, int idShop) {
		return jobCandidateRelationRepository.getAllInterviewsByIdShop(idShop, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllHiredByIdShop(int page, int size, int idShop) {
		return jobCandidateRelationRepository.getAllHiredByIdShop(idShop, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllApplicationsByIdCompany(int page, int size, int idCompany) {
		return jobCandidateRelationRepository.getAllApplicationsByIdCompany(idCompany, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllInterviewsByIdCompany(int page, int size, int idCompany) {
		return jobCandidateRelationRepository.getAllInterviewsByIdCompany(idCompany, PageRequest.of(page, size));
	}

	public Page<JobCandidateRelation> getAllHiredByIdCompany(int page, int size, int idCompany) {
		return jobCandidateRelationRepository.getAllHiredByIdCompany(idCompany, PageRequest.of(page, size));
	}

	/********* Method for hired candidates for payment cycle ***********/

	/**
	 * 
	 * @author Awatef Houaoui
	 * 
	 */
	public Page<PaymentCycleDto> getPaymentRequestList(int page, int size, int idCompany) {
		return jobCandidateRelationRepository.getPaymentRequestList(idCompany, PageRequest.of(page, size));
	}

	/**
	 * 
	 * @author Awatef Houaoui
	 * 
	 */
	public List<JobCandidateRelation> getAllUnconfirmedHiredApplications(int idCompany) {
		return jobCandidateRelationRepository.getAllUnconfirmedHiredApplications(idCompany);
	}

	/**
	 * 
	 * @author Awatef Houaoui
	 * 
	 */
	public Page<PaymentCycleAdminDto> getPaymentRequestForAdmin(int page, int size, String nameCompany,
			String requestMonth) {
		return jobCandidateRelationRepository.getPaymentRequestForAdmin(nameCompany, requestMonth,
				PageRequest.of(page, size));
	}

	/**
	 * 
	 * @author Awatef Houaoui
	 * 
	 */
	public Page<PaymentCycleAdminDto> getShopDetailFromPaymentCycle(int page, int size, String nameCompany,
			String requestMonth) {
		return jobCandidateRelationRepository.getShopDetailFromPaymentCycle(nameCompany, requestMonth,
				PageRequest.of(page, size));
	}

	/**
	 * 
	 * @author djo
	 * 
	 */
	public List<JobCandidateRelation> getJobCanidateRelationByPhone(String phone, Date startDate, Date endDate) {
		return jobCandidateRelationRepository.getJobCanidateRelationByPhone(phone, startDate, endDate);
	}

	/**
	 * 
	 * @author djo
	 * 
	 */
	public List<JobCandidateRelation> getJobCanidateRelationByIdCandidateLimit(int idCandidateStart, int idCandidateEnd,
			Date startDate, Date endDate) {
		return jobCandidateRelationRepository.getJobCanidateRelationByIdCandidateLimit(idCandidateStart, idCandidateEnd,
				startDate, endDate);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author wmhamdi
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AdminService.javaPageable pageable, @Param("month")
	 *         String month, @Param("year") String year, @Param("company") String
	 *         company
	 * 
	 *         Find all hired candidates paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	public Page<ReportDto> findAllHiredCandidates(int page, int size, String month, String year, int company) {
		if (month == null) {
			month = "";
		}
		if (year == null) {
			year = "";
		}
		return jobCandidateRelationRepository.findAllHiredCandidates(PageRequest.of(page, size), month, year, company);
	}

	public List<ReportDto> getAllHiredCandidates(String month, String year, int company) {
		return jobCandidateRelationRepository.getAllHiredCandidates(month, year, company);
	}

	public void editHiredCandidate(int idCandidate, int idJob, String staffName, String candidateAddress,
			String candidateName) {
		jobCandidateRelationRepository.editHiredCandidate(idCandidate, idJob, staffName, candidateAddress,
				candidateName);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author wmhamdi
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AdminService.javaPageable pageable, @Param("month")
	 *         String month, @Param("year") String year, @Param("company") String
	 *         company
	 * 
	 *         Find all hired candidates paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword
	 * @return the updating page
	 */
	public JobCandidateRelation editHiredCandidate(int idCandidate, int idJob) {
		return jobCandidateRelationRepository.editHiredCandidate(idCandidate, idJob);
	}

	public Page<JobCandidateRelation> upadetHiredCandidatePage(int page, int size, String month, String year,
			int company) {
		return jobCandidateRelationRepository.upadetHiredCandidatePage(PageRequest.of(page, size), month, year,
				company);
	}

	public JobCandidateRelation getHiredCandidateById(int idCandidate, int idJob) {
		return jobCandidateRelationRepository.getHiredCandidateById(idCandidate, idJob);
	}

	public ReportDto getReportDtoByIdJobAndIdCandidate(int idJob, int idCandidate) {
		return jobCandidateRelationRepository.getReportDtoByIdJobAndIdCandidate(idJob, idCandidate);
	}

	public Double getTotalApprovedAmount(int idCompany) {
		return jobCandidateRelationRepository.getTotalApprovedAmount(idCompany);
	}

}
