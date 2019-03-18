package com.hrdatabank.mtproject.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Candidate;
import com.hrdatabank.mtproject.entities.NearestStation;
import com.hrdatabank.mtproject.model.NearestStationDto;
import com.hrdatabank.mtproject.repositories.CandidateRepository;
import com.hrdatabank.mtproject.repositories.NearestStationRepository;
import com.hrdatabank.mtproject.specifications.NearestStationSpec;
import com.hrdatabank.mtproject.specifications.SearchCriteria;

/**
 * The Class NearestStationService.
 */
@Service
public class NearestStationService {

	/** The nearest station repository. */
	@Autowired
	private NearestStationRepository nearestStationRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NearestStationService.java
	 * 
	 *         Sets the nearest station repository.
	 * @param nearestStationRepository
	 *            the new nearest station repository
	 */
	public void setNearestStationRepository(NearestStationRepository nearestStationRepository) {
		this.nearestStationRepository = nearestStationRepository;
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
	 *         Class Name: NearestStationService.java
	 * 
	 *         List all nearest stations.
	 * @return the iterable
	 */
	public Iterable<NearestStation> listAllNearestStations() {
		return nearestStationRepository.findAll();
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
	 *         Class Name: NearestStationService.java
	 * 
	 *         Gets the nearest station by id.
	 * @param id
	 *            the id
	 * @return the nearest station by id
	 */
	public Optional<NearestStation> getNearestStationById(long id) {
		return nearestStationRepository.findById(id);
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
	 *         Class Name: NearestStationService.java
	 * 
	 *         Save nearest station.
	 * @param nearestStation
	 *            the nearest station
	 * @return the nearest station
	 */
	public NearestStation saveNearestStation(NearestStation nearestStation) {
		return nearestStationRepository.save(nearestStation);
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
	 *         Class Name: NearestStationService.java
	 * 
	 *         Gets the near station by id line CD.
	 * @param idCD
	 *            the id CD
	 * @return the near station by id line CD
	 */
	public NearestStation getNearStationByIdLineCD(int idCD) {
		return nearestStationRepository.getNearStationByIdLineCD(idCD);
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
	 *         Class Name: NearestStationService.java
	 * 
	 *         Gets the all nearest stations.
	 * @return the all nearest stations
	 */
	public List<NearestStation> getAllNearestStations() {
		return nearestStationRepository.findAll();
	}

	public Page<NearestStation> findNearestStationByStationLevenshtein(String station, int page, int size) {
		return nearestStationRepository.findNearestStationByStationLevenshtein(station, PageRequest.of(page, size));
	}

	public NearestStation findStationByNameAndLine(String stationName, String lineName) {
		return nearestStationRepository.findStationByNameAndLine(stationName, lineName);
	}

	public List<NearestStation> findStationByLineID(int lineId) {
		return nearestStationRepository.findStationByLineID(lineId);
	}

	public Page<NearestStation> findNearestStationByStation(String station, int page, int size) {
		return nearestStationRepository.findNearestStationByStation(station, PageRequest.of(page, size));
	}

	/**
	 * 
	 * @author Djo (first impl)
	 * @author rihabkallel (changed)
	 * 
	 *         method to get near stations dtos searched and not searched ordered by
	 *         most searched
	 * 
	 * @param pageable
	 * @param listIDStation
	 * @param keyword
	 * @return
	 */
	public Page<NearestStationDto> getPageNearestStationDto(Pageable pageable, List<Integer> listIDStation,
			String keyword, String dateFrom, String dateTo) {
		return nearestStationRepository.getPageNearestStationForGroupMessage(pageable, listIDStation, keyword, dateFrom,
				dateTo);
	}

	@SuppressWarnings("deprecation")
	public Long getPageNearestStationSpec(Pageable pageable, List<Integer> listIDStation, String keyword, Date date) {

		NearestStationSpec specIdNearestStation = new NearestStationSpec(
				new SearchCriteria<>("idNearestStation", "<>", listIDStation));

		NearestStationSpec specKeyword = new NearestStationSpec(new SearchCriteria<>(
				Arrays.asList("japaneseStation", "japaneseStation", "japaneseHiraganaStation", "japaneseRomajiStation"),
				"OR", keyword));

		NearestStationSpec count = new NearestStationSpec(new SearchCriteria<>("idNearestStation", "Join", date));

		return nearestStationRepository.count(Specifications.where(count));

		// return
		// nearestStationRepository.findAll(Specifications.where(specIdNearestStation).and(specKeyword),
		// pageable);
	}

	public NearestStation findNearStationByIdNearestStationCD(int idNearestStationCD) {
		return nearestStationRepository.findNearStationByIdNearestStationCD(idNearestStationCD);
	}

	public NearestStationDto getStationSearchDetail(NearestStation nearestStation) {

		System.out.println("******************11111******************" + nearestStation.getJapaneseRomajiStation()
				+ " | " + nearestStation.getLineStation().getLineNameJapanese());
		System.out.println("******************2222222******************" + nearestStation.getJapaneseStation() + " | "
				+ nearestStation.getLineStation().getLineNameJapanese());

		List<Candidate> candidates = candidateRepository.findNearStationByStationName(
				nearestStation.getJapaneseRomajiStation() + "| "
						+ nearestStation.getLineStation().getLineNameJapanese(),
				nearestStation.getJapaneseStation() + "| " + nearestStation.getLineStation().getLineNameJapanese(),
				nearestStation.getJapaneseRomajiStation() + " | "
						+ nearestStation.getLineStation().getLineNameJapanese(),
				nearestStation.getJapaneseStation() + " | " + nearestStation.getLineStation().getLineNameJapanese());

		NearestStationDto nearestStationDto = NearestStationDto.toNearestStationDto(nearestStation, candidates);
		System.out.println("************************************" + nearestStationDto.getSearchNumber());
		return nearestStationDto;

	}

	public CandidateRepository getCandidateRepository() {
		return candidateRepository;
	}

	public void setCandidateRepository(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}

	public NearestStation getNearestStationByLatitudeAndLongitude(Double latitude, Double longitude) {
		return nearestStationRepository.getNearestStationByLatitudeAndLongitude(latitude, longitude);
	}

	public long getCandidateNumberForGroupMessage(List<Integer> idStations) {
		return nearestStationRepository.getCandidateNumberForGroupMessage(idStations);
	}

}
