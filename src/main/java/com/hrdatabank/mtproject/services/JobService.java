//package com.hrdatabank.mtproject.services;
//
//import static com.hrdatabank.mtproject.specifications.JobSpecifications.findJobsByCritiriaCompanyIdWithOr;
//import static com.hrdatabank.mtproject.specifications.JobSpecifications.findJobsByCritiriaPositionNameWithOr;
//import static com.hrdatabank.mtproject.specifications.JobSpecifications.findJobsByCritiriaShopIdWithOr;
//import static com.hrdatabank.mtproject.specifications.JobSpecifications.findJobsByCritiriaWithAnd;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.jpa.domain.Specifications;
//import org.springframework.stereotype.Service;
//
//import com.hrdatabank.mtproject.entities.Job;
//import com.hrdatabank.mtproject.model.JobDto;
//import com.hrdatabank.mtproject.repositories.JobRepository;
//import com.hrdatabank.mtproject.repositories.JobTagRelationRepository;
//
///**
// * The Class JobService.
// */
//@Service
//public class JobService {
//	private static Logger log = LoggerFactory.getLogger(JobService.class);
//
//	/** The job repository. */
//	@Autowired
//	private JobRepository jobRepository;
//
//	/** The entity manager. */
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Autowired
//	private JobTagRelationRepository jobTagRelationRepository;
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Sets the job repository.
//	 * @param jobRepository
//	 *            the new job repository
//	 */
//	public void setJobRepository(JobRepository jobRepository) {
//		this.jobRepository = jobRepository;
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         List all jobs.
//	 * @return the list
//	 */
//	public List<Job> listAllJobs() {
//		return jobRepository.findAll();
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the job by id.
//	 * @param id
//	 *            the id
//	 * @return the job by id
//	 */
//	public Optional<Job> getJobById(long id) {
//		return jobRepository.findById(id);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the job dto by id.
//	 * @param id
//	 *            the id
//	 * @return the job dto by id
//	 */
//	public JobDto getJobDtoById(int id) {
//		return jobRepository.getJobDtoById(id);
//	}
//
//	public JobDto getJobDtoByIdForRecommeandation(int id) {
//		return jobRepository.getJobDtoByIdForRecommeandation(id);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the job by id job list.
//	 * @param idJobList
//	 *            the id job list
//	 * @return the job by id job list
//	 */
//	public List<Job> getJobByIdJobList(int idJobList) {
//		return jobRepository.getJobByIdJobList(idJobList);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the jobs affiliate acivated.
//	 * @return the jobs affiliate acivated
//	 */
//	public List<Job> getJobsAffiliateAcivated() {
//		return jobRepository.getJobsAffiliateAcivated();
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the job list by id job list and id detail.
//	 * @param idJobList
//	 *            the id job list
//	 * @param idJobDetail
//	 *            the id job detail
//	 * @return the job list by id job list and id detail
//	 */
//	public List<Job> getJobListByIdJobListAndIdDetail(int idJobList, String idJobDetail) {
//		return jobRepository.getJobListByIdJobListAndIdDetail(idJobList, idJobDetail);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the job by id job list and id detail.
//	 * @param idJobList
//	 *            the id job list
//	 * @param idJobDetail
//	 *            the id job detail
//	 * @return the job by id job list and id detail
//	 */
//	public Job getJobByIdJobListAndIdDetail(int idJobList, String idJobDetail) {
//		return jobRepository.getJobByIdJobListAndIdDetail(idJobList, idJobDetail);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Save job.
//	 * @param job
//	 *            the job
//	 * @return the job
//	 */
//	public Job saveJob(Job job) {
//		return jobRepository.save(job);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Find all jobs by keyword paginated.
//	 * @param page
//	 *            the page
//	 * @param size
//	 *            the size
//	 * @param keyword
//	 *            the keyword
//	 * @return the page
//	 */
//	/****************************************/
//	public Page<Job> findAllJobsByKeywordPaginated(int page, int size, String keyword) {
//		return jobRepository.findAllJobsByKeywordPaginated(PageRequest.of(page, size), keyword);
//	}
//
//	public Page<Job> findAllPublicOrPrivateJobsByKeywordPaginated(int page, int size, String keyword,
//			boolean publicStatus) {
//		return jobRepository.findAllPublicOrPrivateJobsByKeywordPaginated(PageRequest.of(page, size), keyword,
//				publicStatus);
//	}
//
//	public Page<Job> findAllCheckedJobsByKeywordPaginated(int page, int size, String keyword) {
//		return jobRepository.findAllCheckedAlgorithmJobsByKeywordPaginated(PageRequest.of(page, size), keyword);
//	}
//
//	//
//	public Page<Job> findAllPublicPrivateCheckedJobsByKeywordPaginated(int page, int size, String keyword,
//			boolean publicStatus) {
//		return jobRepository.findAllPublicPrivateCheckedJobsByKeywordPaginated(PageRequest.of(page, size), keyword,
//				publicStatus);
//	}
//
//	/***************** FILTERED BY NEARSTATION ***************/
//	public Page<Job> findAllJobsByKeywordPaginatedFiltredNearStation(int page, int size, String keyword,
//			String stationFilter) {
//		return jobRepository.findAllJobsByKeywordPaginatedFiltredNearStation(PageRequest.of(page, size), keyword,
//				stationFilter);
//	}
//
//	public Page<Job> findAllPublicOrPrivateJobsByKeywordPaginatedFiltredNearStation(int page, int size, String keyword,
//			boolean publicStatus, String stationFilter) {
//		return jobRepository.findAllPublicOrPrivateJobsByKeywordPaginatedFiltredNearStation(PageRequest.of(page, size),
//				keyword, publicStatus, stationFilter);
//	}
//
//	public Page<Job> findAllCheckedJobsByKeywordPaginatedFiltredNearStation(int page, int size, String keyword,
//			String stationFilter) {
//		return jobRepository.findAllCheckedAlgorithmJobsByKeywordPaginatedFiltredNearStation(PageRequest.of(page, size),
//				keyword, stationFilter);
//	}
//
//	//
//	public Page<Job> findAllPublicPrivateCheckedJobsByKeywordPaginatedFiltredNearStation(int page, int size,
//			String keyword, boolean publicStatus, String stationFilter) {
//		return jobRepository.findAllPublicPrivateCheckedJobsByKeywordPaginatedFiltredNearStation(
//				PageRequest.of(page, size), keyword, publicStatus, stationFilter);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Find all jobs by keyword and id company.
//	 * @param page
//	 *            the page
//	 * @param size
//	 *            the size
//	 * @param idCompany
//	 *            the id company
//	 * @param keyword
//	 *            the keyword
//	 * @return the page
//	 */
//	public Page<Job> findAllJobsByKeywordAndIdCompany(int page, int size, int idCompany, String keyword) {
//		return jobRepository.findAllJobsByKeywordAndIdCompany(PageRequest.of(page, size), idCompany, keyword);
//	}
//
//	public Page<Job> findAllPublicOrPrivateJobsByKeywordAndIdCompany(int page, int size, int idCompany, String keyword,
//			boolean publicStatus) {
//		return jobRepository.findAllPublicOrPrivateJobsByKeywordAndIdCompany(PageRequest.of(page, size), idCompany,
//				keyword, publicStatus);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Find all jobs by keyword and id shop.
//	 * @param page
//	 *            the page
//	 * @param size
//	 *            the size
//	 * @param idShop
//	 *            the id shop
//	 * @param keyword
//	 *            the keyword
//	 * @return the page
//	 */
//	public Page<Job> findAllJobsByKeywordAndIdShop(int page, int size, int idShop, String keyword) {
//		return jobRepository.findAllJobsByKeywordAndIdShop(PageRequest.of(page, size), idShop, keyword);
//	}
//
//	public Page<Job> findAllPublicOrPrivateJobsByKeywordAndIdShop(int page, int size, int idShop, String keyword,
//			boolean publicStatus) {
//		return jobRepository.findAllPublicOrPrivateJobsByKeywordAndIdShop(PageRequest.of(page, size), idShop, keyword,
//				publicStatus);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         this method Delete job by id.
//	 * @param id
//	 *            the id
//	 */
//	public void deleteJobById(long id) {
//		jobRepository.deleteById(id);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the jobs by shop and company.
//	 * @param idShop
//	 *            the id shop
//	 * @param idCompany
//	 *            the id company
//	 * @return the jobs by shop and company
//	 */
//	public List<Job> getJobsByShopAndCompany(int idShop, int idCompany) {
//		return jobRepository.getJobsByShopAndCompany(idShop, idCompany);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the jobs by shop.
//	 * @param idShop
//	 *            the id shop
//	 * @return the jobs by shop
//	 */
//	public List<Job> getJobsByShop(int idShop) {
//		return jobRepository.getJobsByShop(idShop);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author yassine amira
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: JobService.java
//	 * 
//	 *         Gets the jobs affiliate activated.
//	 * @return the jobs affiliate activated
//	 */
//	public List<Job> getJobsAffiliateActivated() {
//		return jobRepository.getJobsAffiliateActivated();
//	}
//
//	/************ old search jobs query ***********/
//	public List<Integer> findAllOpenedJobsByDistance(double lat, double lng) {
//		return jobRepository.findAllOpenedJobsByDistance(lat, lng);
//	}
//
//	public List<Integer> findByTimeByDistance(String workTime, double lat, double lng) {
//		return jobRepository.findByTimeByDistance(workTime, lat, lng);
//	}
//
//	public List<Integer> findByTypeByDistance(String workType, double lat, double lng) {
//		return jobRepository.findByTypeByDistance(workType, lat, lng);
//	}
//
//	public List<Integer> findByAllFieldsByDistance(String workType, String workTime, double lat, double lng) {
//		return jobRepository.findByAllFieldsByDistance(workType, workTime, lat, lng);
//	}
//
//	public Page<JobDto> getJobDtoForRecommendationPaginated(Pageable pageable, boolean open) {
//		return jobRepository.getJobDtoForRecommendationPaginated(pageable, open);
//	}
//
//	/************ new search jobs query ***********/
//
//	// normal jobs wait call first
//	public Page<Integer> findAllNormalOpenedJobsByDistance(double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findAllNormalOpenedJobsByDistance(lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findNormalJobsByTimeByDistance(String workTime, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findNormalJobsByTimeByDistance(workTime, lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findNormalJobsByTypeByDistance(String workType, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findNormalJobsByTypeByDistance(workType, lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findNormalJobsByAllFieldsByDistance(String workType, String workTime, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findNormalJobsByAllFieldsByDistance(workType, workTime, lat, lng, pageable, maxKm,
//				idCandidate);
//	}
//
//	/*********** normal jobs random *************/
//
//	public Page<Integer> findRandomNormalOpenedJobsByDistance(double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findRandomNormalOpenedJobsByDistance(lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findRandomNormalJobsByTimeByDistance(String workTime, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findRandomNormalJobsByTimeByDistance(workTime, lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findRandomNormalJobsByTypeByDistance(String workType, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findRandomNormalJobsByTypeByDistance(workType, lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findRandomNormalJobsByAllFieldsByDistance(String workType, String workTime, double lat,
//			double lng, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findRandomNormalJobsByAllFieldsByDistance(workType, workTime, lat, lng, pageable, maxKm,
//				idCandidate);
//	}
//
//	/************ normal checked jobs *************/
//
//	public Page<Integer> findAllCheckedJobsByDistance(double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findAllCheckedJobsByDistance(lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findCheckedJobsByTimeByDistance(String workTime, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findCheckedJobsByTimeByDistance(workTime, lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findCheckedJobsByTypeByDistance(String workType, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findCheckedJobsByTypeByDistance(workType, lat, lng, pageable, maxKm, idCandidate);
//	}
//
//	public Page<Integer> findCheckedJobsByAllFieldsByDistance(String workType, String workTime, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate) {
//		return jobRepository.findCheckedJobsByAllFieldsByDistance(workType, workTime, lat, lng, pageable, maxKm,
//				idCandidate);
//	}
//
//	/*********** affiliate jobs random type first *************/
//
//	public Page<Integer> findAllFirstAffiliateOpenedJobsByDistance(double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findAllFirstAffiliateOpenedJobsByDistance(lat, lng, type, pageable, maxKm, idCandidate,
//				hiddenTypes);
//	}
//
//	public Page<Integer> findFirstAffiliateJobsByTimeByDistance(String workTime, double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findFirstAffiliateJobsByTimeByDistance(workTime, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findFirstAffiliateJobsByTypeByDistance(String workType, double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findFirstAffiliateJobsByTypeByDistance(workType, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findFirstAffiliateJobsByAllFieldsByDistance(String workType, String workTime, double lat,
//			double lng, String type, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findFirstAffiliateJobsByAllFieldsByDistance(workType, workTime, lat, lng, type, pageable,
//				maxKm, idCandidate, hiddenTypes);
//	}
//
//	/********** affiliate jobs random type not first ***********/
//
//	public Page<Integer> findAllRestAffiliateOpenedJobsByDistance(double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findAllRestAffiliateOpenedJobsByDistance(lat, lng, type, pageable, maxKm, idCandidate,
//				hiddenTypes);
//	}
//
//	public Page<Integer> findRestAffiliateJobsByTimeByDistance(String workTime, double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findRestAffiliateJobsByTimeByDistance(workTime, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findRestAffiliateJobsByTypeByDistance(String workType, double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findRestAffiliateJobsByTypeByDistance(workType, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findRestAffiliateJobsByAllFieldsByDistance(String workType, String workTime, double lat,
//			double lng, String type, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findRestAffiliateJobsByAllFieldsByDistance(workType, workTime, lat, lng, type, pageable,
//				maxKm, idCandidate, hiddenTypes);
//	}
//
//	/*********** affiliate jobs lowest wage and type first ************/
//
//	public Page<Integer> findLowestWageAffiliateJobsByDistance(double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findLowestWageAffiliateJobsByDistance(lat, lng, type, pageable, maxKm, idCandidate,
//				hiddenTypes);
//	}
//
//	public Page<Integer> findLowestWageAffiliateJobsByTimeByDistance(String workTime, double lat, double lng,
//			String type, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findLowestWageAffiliateJobsByTimeByDistance(workTime, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findLowestWageAffiliateJobsByTypeByDistance(String workType, double lat, double lng,
//			String type, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findLowestWageAffiliateJobsByTypeByDistance(workType, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findLowestWageAffiliateJobsByAllFieldsByDistance(String workType, String workTime, double lat,
//			double lng, String type, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findLowestWageAffiliateJobsByAllFieldsByDistance(workType, workTime, lat, lng, type,
//				pageable, maxKm, idCandidate, hiddenTypes);
//	}
//
//	/********** affiliate jobs lowest wage and without type first *************/
//
//	public Page<Integer> findRestLowestWageAffiliateJobsByDistance(double lat, double lng, String type,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findRestLowestWageAffiliateJobsByDistance(lat, lng, type, pageable, maxKm, idCandidate,
//				hiddenTypes);
//	}
//
//	public Page<Integer> findRestLowestWageAffiliateJobsByTimeByDistance(String workTime, double lat, double lng,
//			String type, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findRestLowestWageAffiliateJobsByTimeByDistance(workTime, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findRestLowestWageAffiliateJobsByTypeByDistance(String workType, double lat, double lng,
//			String type, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findRestLowestWageAffiliateJobsByTypeByDistance(workType, lat, lng, type, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	public Page<Integer> findRestLowestWageAffiliateJobsByAllFieldsByDistance(String workType, String workTime,
//			double lat, double lng, String type, org.springframework.data.domain.Pageable pageable, int maxKm,
//			int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findRestLowestWageAffiliateJobsByAllFieldsByDistance(workType, workTime, lat, lng, type,
//				pageable, maxKm, idCandidate, hiddenTypes);
//	}
//
//	/************ affiliate jobs random ***************/
//
//	public Page<Integer> findRandomAffiliateOpenedJobsByDistance(double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findRandomAffiliateOpenedJobsByDistance(lat, lng, pageable, maxKm, idCandidate,
//				hiddenTypes);
//	}
//
//	public Page<Integer> findRandomAffiliateJobsByTimeByDistance(String workTime, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findRandomAffiliateJobsByTimeByDistance(workTime, lat, lng, pageable, maxKm, idCandidate,
//				hiddenTypes);
//	}
//
//	public Page<Integer> findRandomAffiliateJobsByTypeByDistance(String workType, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate, List<String> hiddenTypes) {
//		return jobRepository.findRandomAffiliateJobsByTypeByDistance(workType, lat, lng, pageable, maxKm, idCandidate,
//				hiddenTypes);
//	}
//
//	public Page<Integer> findRandomAffiliateJobsByAllFieldsByDistance(String workType, String workTime, double lat,
//			double lng, org.springframework.data.domain.Pageable pageable, int maxKm, int idCandidate,
//			List<String> hiddenTypes) {
//		return jobRepository.findRandomAffiliateJobsByAllFieldsByDistance(workType, workTime, lat, lng, pageable, maxKm,
//				idCandidate, hiddenTypes);
//	}
//
//	/**
//	 * @author Wala ben Amor
//	 * 
//	 *         delete DB Cache
//	 * 
//	 */
//	public void deleteDBCache() {
//		log.info("------------deleteDBCache-------------------------------------");
//		jobRepository.setSessionAuthorizationQuery();
//		jobRepository.resetAllQuery();
//		jobRepository.deallocateAllQuery();
//		jobRepository.closeAllQuery();
//		jobRepository.unlistenQuery();
//		jobRepository.selectPGAdvisoryQuery();
//		jobRepository.discardPlansQuery();
//		jobRepository.discardTempQuery();
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to get LineJobsAffiliateActivated
//	 */
//	public List<Job> getLineJobsAffiliateActivated(int page, int size) {
//		return jobRepository.getLineJobsAffiliateActivated(PageRequest.of(page, size));
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to get BaitoruJobsAffiliateActivated
//	 */
//	public List<Job> getBaitoruJobsAffiliateActivated(int page, int size) {
//		return jobRepository.getBaitoruJobsAffiliateActivated(PageRequest.of(page, size));
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to get TownWorkJobsAffiliateActivated
//	 */
//	public List<Job> getTownWorkJobsAffiliateActivated(int page, int size) {
//		return jobRepository.getTownWorkJobsAffiliateActivated(PageRequest.of(page, size));
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to get TownWorkJobsAffiliateActivated
//	 */
//	public List<Job> getJsenJobsAffiliateActivated(int page, int size) {
//		return jobRepository.getJsenJobsAffiliateActivated(PageRequest.of(page, size));
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to count LineJobsAffiliateActivated
//	 */
//	public long countLineJobsAffiliateActivated() {
//		return jobRepository.countLineJobsAffiliateActivated();
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to count BaitoruJobsAffiliateActivated
//	 */
//	public long countBaitoruJobsAffiliateActivated() {
//		return jobRepository.countBaitoruJobsAffiliateActivated();
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to count TownWorkJobsAffiliateActivated
//	 */
//	public long countTownWorkJobsAffiliateActivated() {
//		return jobRepository.countTownWorkJobsAffiliateActivated();
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to count TownWorkJobsAffiliateActivated
//	 */
//	public long countJsenJobsAffiliateActivated() {
//		return jobRepository.countJsenJobsAffiliateActivated();
//	}
//
//	/**************** Sukiya Intent *****************/
//
//	public Page<Integer> findAllSukiyaOpenedJobsByDistance(double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int idCandidate) {
//		return jobRepository.findAllSukiyaOpenedJobsByDistance(lat, lng, pageable, idCandidate);
//	}
//
//	public Page<Integer> findAllSukiyaOpenedJobsByDistanceAndTime(String workTime, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int idCandidate) {
//		return jobRepository.findAllSukiyaOpenedJobsByDistanceAndTime(workTime, lat, lng, pageable, idCandidate);
//	}
//
//	public Page<Integer> findAllSukiyaOpenedJobsByDistanceAndType(String workType, double lat, double lng,
//			org.springframework.data.domain.Pageable pageable, int idCandidate) {
//		return jobRepository.findAllSukiyaOpenedJobsByDistanceAndType(workType, lat, lng, pageable, idCandidate);
//	}
//
//	public Page<Integer> findAllSukiyaOpenedJobsByDistanceAndTypeAndTime(String workType, String workTime, double lat,
//			double lng, org.springframework.data.domain.Pageable pageable, int idCandidate) {
//		return jobRepository.findAllSukiyaOpenedJobsByDistanceAndTypeAndTime(workType, workTime, lat, lng, pageable,
//				idCandidate);
//	}
//
//	public void randomSeed(double seed) {
//		jobRepository.randomSeed(seed);
//	}
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to get jobs by criteria filter
//	 */
//	public Page<Job> getJobsCritiria(List<Integer> companies, List<Integer> shopIds, List<String> jobPositionsList,
//			String nearStation, String wageMin, String wageMax, String category, String interviewType, String jlpt,
//			String duration, String freeText, String checkedJobsStatus, String publicPrivateJobsStatus,
//			Pageable pageable) {
//
//		/******************************************************/
//		log.info("---------------companies----|||||||---------------:{}", companies);
//		log.info("---------------shopIds-------|||||||------------:{}", shopIds);
//		if (companies == null) {
//			companies = new ArrayList<>();
//		}
//		if (shopIds == null) {
//			shopIds = new ArrayList<>();
//		}
//		if (jobPositionsList == null) {
//			jobPositionsList = new ArrayList<>();
//		}
//		log.info("---------------jobPositionsList---|||||||----------------:{}", jobPositionsList);
//		Specification<Job> searchidCompanyOr = findJobsByCritiriaCompanyIdWithOr(companies);
//		Specification<Job> searchidShopOr = findJobsByCritiriaShopIdWithOr(shopIds);
//		Specification<Job> searchPositionNamesOr = findJobsByCritiriaPositionNameWithOr(jobPositionsList);
//
//		Specification<Job> searchSpecStatus;
//
//		searchSpecStatus = findJobsByCritiriaWithAnd(nearStation, wageMin, wageMax, category, interviewType, jlpt,
//				duration, freeText, checkedJobsStatus, publicPrivateJobsStatus);
//
//		/******************************************************/
//		Page<Job> searchResultsJobsList;
//		@SuppressWarnings("deprecation")
//		Specifications<Job> spef = Specifications.where(searchSpecStatus);
//
//		if (!companies.isEmpty()) {
//			spef = spef.and(searchidCompanyOr);
//		}
//
//		if (!shopIds.isEmpty()) {
//			spef = spef.and(searchidShopOr);
//		}
//
//		if (!jobPositionsList.isEmpty()) {
//			spef = spef.and(searchPositionNamesOr);
//		}
//		searchResultsJobsList = jobRepository.findAll(spef, pageable);
//		/****************************************************/
//		return searchResultsJobsList;
//
//	}
//
//	/************************** EXPORT *****************************/
//
//	/**
//	 * @author wala ben Amor
//	 * 
//	 *         Method to export all jobs by criteria filter
//	 */
//	public List<Job> getJobsCritiriaToExport(List<Integer> companies, List<Integer> shopIds,
//
//			List<String> jobPositionsList, String nearStation, String wageMin, String wageMax, String category,
//			String interviewType, String jlpt, String duration, String freeText, String checkedJobsStatus,
//			String publicPrivateJobsStatus) {
//
//		if (companies == null) {
//			companies = new ArrayList<Integer>();
//		}
//		if (shopIds == null) {
//			shopIds = new ArrayList<>();
//		}
//		if (jobPositionsList == null) {
//			jobPositionsList = new ArrayList<>();
//		}
//		log.info("{}", jobPositionsList);
//		Specification<Job> searchidCompanyOr = findJobsByCritiriaCompanyIdWithOr(companies);
//		Specification<Job> searchidShopOr = findJobsByCritiriaShopIdWithOr(shopIds);
//		Specification<Job> searchPositionNamesOr = findJobsByCritiriaPositionNameWithOr(jobPositionsList);
//
//		Specification<Job> searchSpecStatus = findJobsByCritiriaWithAnd(nearStation, wageMin, wageMax, category,
//				interviewType, jlpt, duration, freeText, checkedJobsStatus, publicPrivateJobsStatus);
//
//		String rrrr = "---";
//		List<Job> searchResultsJobsList;
//		Specifications<Job> spef = Specifications.where(searchSpecStatus);
//		rrrr = rrrr + "---spef---1--";
//		if (!companies.isEmpty()) {
//			spef = spef.and(searchidCompanyOr);
//			rrrr = rrrr + "---spef----2--";
//		}
//
//		if (!shopIds.isEmpty()) {
//			spef = spef.and(searchidShopOr);
//
//			rrrr = rrrr + "---spef----3---";
//		}
//
//		if (!jobPositionsList.isEmpty()) {
//			spef = spef.and(searchPositionNamesOr);
//			log.info("------------------spef---4-----------------searchPositionNamesOr-----------------");
//			rrrr = rrrr + "---spef----4----";
//		}
//
//		searchResultsJobsList = jobRepository.findAll(spef);
//		/****************************************************/
//		return searchResultsJobsList;
//
//	}
//
//	/********************** Close/ delete jobs ***********************/
//
//	/**
//	 * 
//	 * @author Awatef Houaoui
//	 * 
//	 */
//	public void deleteAllUnusedJobs() {
//		jobRepository.deleteAllUnusedJobs();
//	}
//
//	/**
//	 * 
//	 * @author Awatef Houaoui
//	 * 
//	 */
//	public void closeJobsByType(String jobType) {
//		jobRepository.closeJobsByType(jobType);
//	}
//
//	/**
//	 * 
//	 * @author Awatef Houaoui
//	 * 
//	 */
//	public List<String> getAllTypesOfAffiliateJobs() {
//		return jobRepository.getAllTypesOfAffiliateJobs();
//	}
//
//	/**
//	 * 
//	 * @author Awatef Houaoui
//	 * 
//	 */
//	public List<Job> getAllAffiliateJobs(String type, String area) {
//		return jobRepository.getAllAffiliateJobs(type, area);
//	}
//
//	/**
//	 * 
//	 * @author Awatef Houaoui
//	 * 
//	 */
//	public List<Job> getAllNormalJobs(String name) {
//		return jobRepository.getAllNormalJobs(name);
//	}
//
//	/**
//	 * 
//	 * @author Awatef Houaoui
//	 * 
//	 */
//	public List<String> getAllAreasOfAffiliateJobs() {
//		return jobRepository.getAllAreasOfAffiliateJobs();
//	}
//
//	/********************** Method for Otome Bot API ***********************/
//
//	/**
//	 * 
//	 * @author Awatef Houaoui
//	 * 
//	 */
//	public Page<Job> getJobsByStationAndJobCategory(int page, int size, String positionCategory, double lat, double lng,
//			int maxKm) {
//		return jobRepository.getJobsByStationAndJobCategory(positionCategory, lat, lng, maxKm,
//				PageRequest.of(page, size));
//	}
//
//	public List<Job> getCheckedJsenJobsByIdJobDetail(String idJobDetail) {
//		return jobRepository.getCheckedJsenJobsByIdJobDetail(idJobDetail);
//	}
//
//	public List<Job> getCheckedLacottoJobsByIdJobDetail(String idJobDetail) {
//		return jobRepository.getCheckedLacottoJobsByIdJobDetail(idJobDetail);
//	}
//	
//	public Page<Job> findAllJobsByAffiliateInjectionDate(String affiliateType , Date injectionDate,Pageable pageable){
//		return jobRepository.findAllJobsByAffiliateInjectionDate(affiliateType, injectionDate, pageable);
//	}
//}
