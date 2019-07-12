package com.hrdatabank.mtproject.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.DashboardInformation;
import com.hrdatabank.mtproject.repositories.DashboardInformationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardInformationService.
 */
@Service
public class DashboardInformationService {

	/** The dashboard information repository. */
	@Autowired
	DashboardInformationRepository dashboardInformationRepository;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationService.java
	 * 
	 * this method Save dashboard information.
	 * @param dashboardInformation the dashboard information
	 */
	public void saveDashboardInformation(DashboardInformation dashboardInformation) {
		dashboardInformationRepository.save(dashboardInformation);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationService.java
	 * 
	 * Find searching job.
	 * @param date the date
	 * @return the int
	 */
	public int findSearchingJob(String date) {
		return dashboardInformationRepository.findSearchingJob(date);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationService.java
	 * 
	 * Find suggested searchs.
	 * @param date the date
	 * @return the int
	 */
	public int findSuggestedSearchs(@Param("date") String date) {
		return dashboardInformationRepository.findSuggestedSearchs(date);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationService.java
	 * 
	 * Find failed searchs.
	 * @param date the date
	 * @return the int
	 */
	public int findFailedSearchs(@Param("date") String date) {
		return dashboardInformationRepository.findFailedSearchs(date);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationService.java
	 * 
	 * Find open applypage.
	 * @param date the date
	 * @return the int
	 */
	public int findOpenApplypage(@Param("date") String date) {
		return dashboardInformationRepository.findOpenApplypage(date);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: DashboardInformationService.java
	 * 
	 * Find ignored dashboard information by id candidate and date.
	 * @param date the date
	 * @param id the id
	 * @return the dashboard information
	 */
	public DashboardInformation findIgnoredDashboardInformationByIdCandidateAndDate(Date date, int id) {
		return dashboardInformationRepository.findIgnoredDashboardInformationByIdCandidateAndDate(date, id);
	}

}
