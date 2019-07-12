package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Alert;
import com.hrdatabank.mtproject.repositories.AlertRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AlertService.
 */
@Service
public class AlertService {

	/** The alert repository. */
	@Autowired
	private AlertRepository alertRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: AlertService.java
	 * 
	 *         Sets the alert repository.
	 * @param alertRepository
	 *            the new alert repository
	 */
	public void setalertRepository(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
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
	 *         Class Name: AlertService.java
	 * 
	 *         List all alerts.
	 * @return the iterable
	 */
	public Iterable<Alert> listAllAlerts() {
		return alertRepository.findAll();
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
	 *         Class Name: AlertService.java
	 * 
	 *         Gets the alert by id.
	 * @param id
	 *            the id
	 * @return the alert by id
	 */
	public Optional<Alert> getAlertById(long id) {
		return alertRepository.findById(id);
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
	 *         Class Name: AlertService.java
	 * 
	 *         this method Delete alert.
	 * @param idAlert
	 *            the id alert
	 */
	public void deleteAlert(long idAlert) {
		alertRepository.deleteById(idAlert);
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
	 *         Class Name: AlertService.java
	 * 
	 *         Save alert.
	 * @param alert
	 *            the alert
	 * @return the alert
	 */
	public Alert saveAlert(Alert alert) {
		return alertRepository.save(alert);
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
	 *         Class Name: AlertService.java
	 * 
	 *         Gets the alert list.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the alert list
	 */
	public Page<Alert> getAlertList(int page, int size) {
		return alertRepository.getAlertList(PageRequest.of(page, size));
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
	 *         Class Name: AlertService.java
	 * 
	 *         Gets the alert list by type.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param type
	 *            the type
	 * @return the alert list by type
	 */
	public Page<Alert> getAlertListByType(int page, int size, boolean type) {
		return alertRepository.getAlertListByType(PageRequest.of(page, size), type);
	}

}
