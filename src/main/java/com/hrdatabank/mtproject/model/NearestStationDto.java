package com.hrdatabank.mtproject.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import com.hrdatabank.mtproject.entities.Candidate;
import com.hrdatabank.mtproject.entities.NearestStation;

public class NearestStationDto {

	private int idNearestStation;

	// total number of search of the station
	@Column(columnDefinition = "int default 0")
	private int searchNumber;

	// total number of search per candidate
	@Column(columnDefinition = "int default 0")
	private int candidateNumber;

	@Column(columnDefinition = "boolean default false", nullable = true)
	private boolean checked = false;

	private String addressStation;
	private String lineNameJapanese;
	private String japaneseStation;
	private String englishStation;

	private List<CandidateDto> candidateDtos;

	public int getIdNearestStation() {
		return idNearestStation;
	}

	public void setIdNearestStation(int idNearestStation) {
		this.idNearestStation = idNearestStation;
	}

	public String getAddressStation() {
		return addressStation;
	}

	public void setAddressStation(String addressStation) {
		this.addressStation = addressStation;
	}

	public String getLineNameJapanese() {
		return lineNameJapanese;
	}

	public void setLineNameJapanese(String lineNameJapanese) {
		this.lineNameJapanese = lineNameJapanese;
	}

	public String getJapaneseStation() {
		return japaneseStation;
	}

	public void setJapaneseStation(String japaneseStation) {
		this.japaneseStation = japaneseStation;
	}

	public static CandidateDto candidateCandDto(Candidate candidate) {
		CandidateDto CandidateDto = new CandidateDto(candidate.getIdUser(), candidate.getUserLineId(),
				candidate.getIdUserFB(), candidate.isCandidateFB(), candidate.getBotInformation().getLanguageBot());
		return CandidateDto;
	}

	public static NearestStationDto toNearestStationDto(NearestStation nearestStation, List<Candidate> candidates) {
		List<CandidateDto> candidateDtos;
		candidateDtos = candidates.stream().map(cand -> candidateCandDto(cand)).collect(Collectors.toList());

		NearestStationDto NearestStationDto = new NearestStationDto(nearestStation.getIdNearestStation(),
				nearestStation.getAddressStation(), nearestStation.getLineStation().getLineNameJapanese(),
				nearestStation.getJapaneseStation(), nearestStation.getJapaneseRomajiStation(), candidateDtos.size(),
				candidateDtos);

		return NearestStationDto;

	}

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

	public NearestStationDto(int idNearestStation, String addressStation, String japaneseStation,
			String englishStation) {
		super();
		this.idNearestStation = idNearestStation;
		this.addressStation = addressStation;
		this.japaneseStation = japaneseStation;
		this.englishStation = englishStation;
	}

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

	public int getSearchNumber() {
		return searchNumber;
	}

	public void setSearchNumber(int searchNumber) {
		this.searchNumber = searchNumber;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<CandidateDto> getCandidateDtos() {
		return candidateDtos;
	}

	public void setCandidateDtos(List<CandidateDto> candidateDtos) {
		this.candidateDtos = candidateDtos;
	}

	public String getEnglishStation() {
		return englishStation;
	}

	public void setEnglishStation(String englishStation) {
		this.englishStation = englishStation;
	}

	public int getCandidateNumber() {
		return candidateNumber;
	}

	public void setCandidateNumber(int candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

}
