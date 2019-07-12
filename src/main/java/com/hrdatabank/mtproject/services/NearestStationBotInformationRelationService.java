package com.hrdatabank.mtproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.NearestStationBotInformationRelation;
import com.hrdatabank.mtproject.repositories.NearestStationBotInformationRelationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class NearestStationBotInformationRelationService.
 */
@Service
public class NearestStationBotInformationRelationService {

	/** The nearest station bot information relation repository. */
	@Autowired
	NearestStationBotInformationRelationRepository nearestStationBotInformationRelationRepository;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: NearestStationBotInformationRelationService.java
	 * 
	 * Sets the nearest station bot information relation repository.
	 * @param nearestStationBotInformationRelationRepository the new nearest station bot information relation repository
	 */
	public void setNearestStationBotInformationRelationRepository(
			NearestStationBotInformationRelationRepository nearestStationBotInformationRelationRepository) {
		this.nearestStationBotInformationRelationRepository = nearestStationBotInformationRelationRepository;
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
	 * Class Name: NearestStationBotInformationRelationService.java
	 * 
	 * Gets the all nearest station bot information relations.
	 * @return the all nearest station bot information relations
	 */
	public List<NearestStationBotInformationRelation> getAllNearestStationBotInformationRelations() {
		return nearestStationBotInformationRelationRepository.findAll();
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
	 * Class Name: NearestStationBotInformationRelationService.java
	 * 
	 * Save nearest station bot information relation.
	 * @param nearestStationBotInformationRelation the nearest station bot information relation
	 * @return the nearest station bot information relation
	 */
	public NearestStationBotInformationRelation saveNearestStationBotInformationRelation(
			NearestStationBotInformationRelation nearestStationBotInformationRelation) {
		return nearestStationBotInformationRelationRepository.saveAndFlush(nearestStationBotInformationRelation);
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
	 * Class Name: NearestStationBotInformationRelationService.java
	 * 
	 * Gets the bot information list having station.
	 * @param stations the stations
	 * @param dateFrom the date from
	 * @param dateTo the date to
	 * @return the bot information list having station
	 */
	public List<Integer> getBotInformationListHavingStation(List<Integer> stations, String dateFrom, String dateTo) {
		return nearestStationBotInformationRelationRepository.getBotInformationListHavingStation(stations, dateFrom,
				dateTo);
	}
}
