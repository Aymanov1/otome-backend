package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.AffiliateApplication;
import com.hrdatabank.mtproject.repositories.AffiliateApplicationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AffiliateApplicationService.
 */
@Service
public class AffiliateApplicationService {

	/** The affiliate application repository. */
	@Autowired
	AffiliateApplicationRepository affiliateApplicationRepository;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * @return the iterable
	 */
	public Iterable<AffiliateApplication> listAllAffiliateApplications() {
		return affiliateApplicationRepository.findAll();
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
	 * Class Name: AffiliateApplicationService.java
	 * 
	 * Gets the affiliate application by id.
	 * @param idAffiliateApplication the id affiliate application
	 * @return the affiliate application by id
	 */
	public Optional<AffiliateApplication> getAffiliateApplicationById(long idAffiliateApplication) {
		return affiliateApplicationRepository.findById(idAffiliateApplication);
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
	 * Class Name: AffiliateApplicationService.java
	 * 
	 * this method Delete affiliate application.
	 * @param idAffiliateApplication the id affiliate application
	 */
	public void deleteAffiliateApplication(long idAffiliateApplication) {
		affiliateApplicationRepository.deleteById(idAffiliateApplication);
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
	 * Class Name: AffiliateApplicationService.java
	 * 
	 * Save affiliate application.
	 * @param affiliateApplication the affiliate application
	 * @return the affiliate application
	 */
	public AffiliateApplication saveAffiliateApplication(AffiliateApplication affiliateApplication) {
		return affiliateApplicationRepository.saveAndFlush(affiliateApplication);
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
	 * Class Name: AffiliateApplicationService.java
	 * 
	 * Gets the affiliate application.
	 * @param referrer the referrer
	 * @return the affiliate application
	 */
	public AffiliateApplication getAffiliateApplication(String referrer) {
		return affiliateApplicationRepository.getAffiliateApplication(referrer);
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
	 * Class Name: AffiliateApplicationService.java
	 * 
	 * Gets the affiliate application by date.
	 * @return the affiliate application by date
	 */
	public long getAffiliateApplicationByDate() {
		return affiliateApplicationRepository.getAffiliateApplicationByDate();
	}

}
