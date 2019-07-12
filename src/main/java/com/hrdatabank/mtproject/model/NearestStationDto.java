package com.hrdatabank.mtproject.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import com.hrdatabank.mtproject.entities.Candidate;
import com.hrdatabank.mtproject.entities.NearestStation;

// TODO: Auto-generated Javadoc
/**
 * The Class NearestStationDto.
 */
public class NearestStationDto {

	/** The id nearest station. */
	private int idNearestStation;

	/** The search number. */
	// total number of search of the station
	@Column(columnDefinition = "int default 0")
	private int searchNumber;

	/** The candidate number. */
	// total number of search per candidate
	@Column(columnDefinition = "int default 0")
	private int candidateNumber;

	/** The checked. */
	@Column(columnDefinition = "boolean default false", nullable = true)
	private boolean checked = false;

	/** The address station. */
	private String addressStation;
	
	/** The line name japanese. */
	private String lineNameJapanese;
	
	/** The japanese station. */
	private String japaneseStation;
	
	/** The english station. */
	private String englishStation;

	/** The candidate dtos. */
	private List<CandidateDto> candidateDtos;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the id nearest station.
	 * @return the id nearest station
	 */
	public int getIdNearestStation() {
		return idNearestStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the id nearest station.
	 * @param idNearestStation the new id nearest station
	 */
	public void setIdNearestStation(int idNearestStation) {
		this.idNearestStation = idNearestStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the address station.
	 * @return the address station
	 */
	public String getAddressStation() {
		return addressStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the address station.
	 * @param addressStation the new address station
	 */
	public void setAddressStation(String addressStation) {
		this.addressStation = addressStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the line name japanese.
	 * @return the line name japanese
	 */
	public String getLineNameJapanese() {
		return lineNameJapanese;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the line name japanese.
	 * @param lineNameJapanese the new line name japanese
	 */
	public void setLineNameJapanese(String lineNameJapanese) {
		this.lineNameJapanese = lineNameJapanese;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the japanese station.
	 * @return the japanese station
	 */
	public String getJapaneseStation() {
		return japaneseStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the japanese station.
	 * @param japaneseStation the new japanese station
	 */
	public void setJapaneseStation(String japaneseStation) {
		this.japaneseStation = japaneseStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Candidate cand dto.
	 * @param candidate the candidate
	 * @return the candidate dto
	 */
	public static CandidateDto candidateCandDto(Candidate candidate) {
		CandidateDto CandidateDto = new CandidateDto(candidate.getIdUser(), candidate.getUserLineId(),
				candidate.getIdUserFB(), candidate.isCandidateFB(), candidate.getBotInformation().getLanguageBot());
		return CandidateDto;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * To nearest station dto.
	 * @param nearestStation the nearest station
	 * @param candidates the candidates
	 * @return the nearest station dto
	 */
	public static NearestStationDto toNearestStationDto(NearestStation nearestStation, List<Candidate> candidates) {
		List<CandidateDto> candidateDtos;
		candidateDtos = candidates.stream().map(cand -> candidateCandDto(cand)).collect(Collectors.toList());

		NearestStationDto NearestStationDto = new NearestStationDto(nearestStation.getIdNearestStation(),
				nearestStation.getAddressStation(), nearestStation.getLineStation().getLineNameJapanese(),
				nearestStation.getJapaneseStation(), nearestStation.getJapaneseRomajiStation(), candidateDtos.size(),
				candidateDtos);

		return NearestStationDto;

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
	 * Class Name: NearestStationDto.java
	 * 
	 * Instantiates a new nearest station dto.
	 * @param idNearestStation the id nearest station
	 * @param addressStation the address station
	 * @param lineNameJapanese the line name japanese
	 * @param japaneseStation the japanese station
	 * @param englishStation the english station
	 * @param searchNumber the search number
	 * @param candidateDtos the candidate dtos
	 */
	public NearestStationDto(int idNearestStation, String addressStation, String lineNameJapanese,
			String japaneseStation, String englishStation, int searchNumber, List<CandidateDto> candidateDtos) {
		super();
		this.idNearestStation = idNearestStation;
		this.addressStation = addressStation;
		this.lineNameJapanese = lineNameJapanese;
		this.japaneseStation = japaneseStation;
		this.englishStation = englishStation;
		this.searchNumber = searchNumber;
		this.candidateDtos = candidateDtos;

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
	 * Class Name: NearestStationDto.java
	 * 
	 * Instantiates a new nearest station dto.
	 * @param idNearestStation the id nearest station
	 * @param addressStation the address station
	 * @param japaneseStation the japanese station
	 * @param englishStation the english station
	 */
	public NearestStationDto(int idNearestStation, String addressStation, String japaneseStation,
			String englishStation) {
		super();
		this.idNearestStation = idNearestStation;
		this.addressStation = addressStation;
		this.japaneseStation = japaneseStation;
		this.englishStation = englishStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Instantiates a new nearest station dto.
	 * @param idNearestStation the id nearest station
	 * @param searchNumber the search number
	 * @param candidateNumber the candidate number
	 * @param addressStation the address station
	 * @param lineNameJapanese the line name japanese
	 * @param japaneseStation the japanese station
	 * @param englishStation the english station
	 */
	public NearestStationDto(int idNearestStation, long searchNumber, long candidateNumber, String addressStation,
			String lineNameJapanese, String japaneseStation, String englishStation) {
		super();
		this.idNearestStation = idNearestStation;
		this.searchNumber = Integer.valueOf(String.valueOf(searchNumber));

		System.out.println("***************************");
		System.out.println("******CCCCCCCCCCCCCCCC: " + candidateNumber);

		this.candidateNumber = Integer.valueOf(String.valueOf(candidateNumber));
		this.addressStation = addressStation;
		this.lineNameJapanese = lineNameJapanese;
		this.japaneseStation = japaneseStation;
		this.englishStation = englishStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the search number.
	 * @return the search number
	 */
	public int getSearchNumber() {
		return searchNumber;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the search number.
	 * @param searchNumber the new search number
	 */
	public void setSearchNumber(int searchNumber) {
		this.searchNumber = searchNumber;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Checks if is checked.
	 * @return true, if is checked
	 */
	public boolean isChecked() {
		return checked;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the checked.
	 * @param checked the new checked
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the candidate dtos.
	 * @return the candidate dtos
	 */
	public List<CandidateDto> getCandidateDtos() {
		return candidateDtos;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the candidate dtos.
	 * @param candidateDtos the new candidate dtos
	 */
	public void setCandidateDtos(List<CandidateDto> candidateDtos) {
		this.candidateDtos = candidateDtos;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the english station.
	 * @return the english station
	 */
	public String getEnglishStation() {
		return englishStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the english station.
	 * @param englishStation the new english station
	 */
	public void setEnglishStation(String englishStation) {
		this.englishStation = englishStation;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Gets the candidate number.
	 * @return the candidate number
	 */
	public int getCandidateNumber() {
		return candidateNumber;
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
	 * Class Name: NearestStationDto.java
	 * 
	 * Sets the candidate number.
	 * @param candidateNumber the new candidate number
	 */
	public void setCandidateNumber(int candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

}
