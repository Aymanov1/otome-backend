package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.LineStation;
import com.hrdatabank.mtproject.repositories.LineStationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class LineStationService.
 */
@Service
public class LineStationService {

	/** The line station repository. */
	@Autowired
	private LineStationRepository lineStationRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: LineStationService.java
	 * 
	 *         Sets the line station repository.
	 * @param lineStationRepository
	 *            the new line station repository
	 */
	public void setLineStationRepository(LineStationRepository lineStationRepository) {
		this.lineStationRepository = lineStationRepository;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: LineStationService.java
	 * 
	 *         List all line stations.
	 * @return the iterable
	 */
	public List<LineStation> listAllLineStations() {
		return lineStationRepository.findAll();
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: LineStationService.java
	 * 
	 *         Gets the line station by id.
	 * @param id
	 *            the id
	 * @return the line station by id
	 */
	public Optional<LineStation> getLineStationById(long id) {
		return lineStationRepository.findById(id);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: LineStationService.java
	 * 
	 *         Gets the line station by id line CD.
	 * @param idCD
	 *            the id CD
	 * @return the line station by id line CD
	 */
	public LineStation getLineStationByIdLineCD(int idCD) {
		return lineStationRepository.getLineStationByIdLineCD(idCD);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: LineStationService.java
	 * 
	 *         Save line station.
	 * @param lineStation
	 *            the line station
	 * @return the line station
	 */
	public LineStation saveLineStation(LineStation lineStation) {
		return lineStationRepository.save(lineStation);
	}

}
