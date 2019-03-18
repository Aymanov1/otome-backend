package com.hrdatabank.otome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.domain.NearestStationOtome;
import com.hrdatabank.otome.repositories.NearestStationOtomeRepository;

/**
 * The Class NearestStationOtomeService.
 */
@Service
public class NearestStationOtomeService {

	/** The nearest station otome repository. */
	@Autowired
	private NearestStationOtomeRepository nearestStationOtomeRepository;

	/**
	 * Find nearest station by id.
	 *
	 * @param idNearestStationOtome
	 *            the id nearest station otome
	 * @return the optional
	 */
	public Optional<NearestStationOtome> findNearestStationById(int idNearestStationOtome) {
		return nearestStationOtomeRepository.findById(idNearestStationOtome);
	}

	/**
	 * Find all nearest stations.
	 *
	 * @return the list
	 */
	public List<NearestStationOtome> findAllNearestStations() {
		return nearestStationOtomeRepository.findAll();
	}

	/**
	 * Delete nearest station.
	 *
	 * @param nearestStationOtome
	 *            the nearest station otome
	 */
	public void deleteNearestStation(NearestStationOtome nearestStationOtome) {
		nearestStationOtomeRepository.delete(nearestStationOtome);
	}

	/**
	 * Save nearest station.
	 *
	 * @param nearestStationOtome
	 *            the nearest station otome
	 * @return the nearest station otome
	 */
	public NearestStationOtome saveNearestStation(NearestStationOtome nearestStationOtome) {
		return nearestStationOtomeRepository.saveAndFlush(nearestStationOtome);
	}

	public NearestStationOtome getNearStationByIdLineCD(int i) {
		return nearestStationOtomeRepository.getNearStationByIdLineCD(i);
	}
}
