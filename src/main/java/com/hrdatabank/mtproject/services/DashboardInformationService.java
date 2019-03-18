package com.hrdatabank.mtproject.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.DashboardInformation;
import com.hrdatabank.mtproject.repositories.DashboardInformationRepository;

@Service
public class DashboardInformationService {

	@Autowired
	DashboardInformationRepository dashboardInformationRepository;

	public void saveDashboardInformation(DashboardInformation dashboardInformation) {
		dashboardInformationRepository.save(dashboardInformation);
	}

	public int findSearchingJob(String date) {
		return dashboardInformationRepository.findSearchingJob(date);
	}

	public int findSuggestedSearchs(@Param("date") String date) {
		return dashboardInformationRepository.findSuggestedSearchs(date);
	}

	public int findFailedSearchs(@Param("date") String date) {
		return dashboardInformationRepository.findFailedSearchs(date);
	}

	public int findOpenApplypage(@Param("date") String date) {
		return dashboardInformationRepository.findOpenApplypage(date);
	}

	public DashboardInformation findIgnoredDashboardInformationByIdCandidateAndDate(Date date, int id) {
		return dashboardInformationRepository.findIgnoredDashboardInformationByIdCandidateAndDate(date, id);
	}

}
