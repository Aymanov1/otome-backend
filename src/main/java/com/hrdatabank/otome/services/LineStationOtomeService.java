package com.hrdatabank.otome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.domain.LineStationOtome;
import com.hrdatabank.otome.repositories.LineStationOtomeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class LineStationOtomeService.
 */
@Service
public class LineStationOtomeService {

	/** The line station otome repository. */
	@Autowired
	private LineStationOtomeRepository lineStationOtomeRepository;

	/**
	 * Find line station by id.
	 *
	 * @param idLineStationOtome the id line station otome
	 * @return the optional
	 */
	public Optional<LineStationOtome> findLineStationById(long idLineStationOtome) {
		return lineStationOtomeRepository.findById(idLineStationOtome);
	}

	/**
	 * Find all line stations.
	 *
	 * @return the list
	 */
	public List<LineStationOtome> findAllLineStations() {
		return lineStationOtomeRepository.findAll();
	}

	/**
	 * Delete line station.
	 *
	 * @param lineStationOtome the line station otome
	 */
	public void deleteLineStation(LineStationOtome lineStationOtome) {
		lineStationOtomeRepository.delete(lineStationOtome);
	}

	/**
	 * Save line station.
	 *
	 * @param lineStation the line station
	 * @return the line station otome
	 */
	public LineStationOtome saveLineStation(LineStationOtome lineStation) {
		return lineStationOtomeRepository.saveAndFlush(lineStation);
	}
}
