package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.NearestStationBotInformationRelation;

// TODO: Auto-generated Javadoc
/**
 * The Interface NearestStationBotInformationRelationRepository.
 */
@Repository
@RepositoryRestResource
public interface NearestStationBotInformationRelationRepository
		extends JpaRepository<NearestStationBotInformationRelation, Serializable> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: NearestStationBotInformationRelationRepository.java
	 * 
	 * Gets the bot information list having station.
	 * @param stations the stations
	 * @param dateFrom the date from
	 * @param dateTo the date to
	 * @return the bot information list having station
	 */
	@Query("SELECT DISTINCT(n.nearestStationBotInformationRelationPK.idBotInformation) FROM NearestStationBotInformationRelation n where n.nearestStationBotInformationRelationPK.idNearestStation IN :stations "
			+ "and (to_timestamp(to_char( n.nearestStationBotInformationRelationPK.searchDate, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_timestamp(:dateFrom , 'yyyy-MM-dd'))"
			+ "and (to_timestamp(to_char( n.nearestStationBotInformationRelationPK.searchDate, 'yyyy-MM-dd'), 'yyyy-MM-dd') <= to_timestamp(:dateTo , 'yyyy-MM-dd'))")
	public List<Integer> getBotInformationListHavingStation(@Param("stations") List<Integer> stations,
			@Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo);

}
