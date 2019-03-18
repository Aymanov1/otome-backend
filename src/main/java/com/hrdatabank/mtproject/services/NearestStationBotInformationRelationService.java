package com.hrdatabank.mtproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.NearestStationBotInformationRelation;
import com.hrdatabank.mtproject.repositories.NearestStationBotInformationRelationRepository;

@Service
public class NearestStationBotInformationRelationService {

	@Autowired
	NearestStationBotInformationRelationRepository nearestStationBotInformationRelationRepository;

	public void setNearestStationBotInformationRelationRepository(
			NearestStationBotInformationRelationRepository nearestStationBotInformationRelationRepository) {
		this.nearestStationBotInformationRelationRepository = nearestStationBotInformationRelationRepository;
	}

	public List<NearestStationBotInformationRelation> getAllNearestStationBotInformationRelations() {
		return nearestStationBotInformationRelationRepository.findAll();
	}

	public NearestStationBotInformationRelation saveNearestStationBotInformationRelation(
			NearestStationBotInformationRelation nearestStationBotInformationRelation) {
		return nearestStationBotInformationRelationRepository.saveAndFlush(nearestStationBotInformationRelation);
	}

	public List<Integer> getBotInformationListHavingStation(List<Integer> stations, String dateFrom, String dateTo) {
		return nearestStationBotInformationRelationRepository.getBotInformationListHavingStation(stations, dateFrom,
				dateTo);
	}
}
