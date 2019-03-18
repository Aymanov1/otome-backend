package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.AffiliateApplication;
import com.hrdatabank.mtproject.repositories.AffiliateApplicationRepository;

@Service
public class AffiliateApplicationService {

	@Autowired
	AffiliateApplicationRepository affiliateApplicationRepository;

	/**
	 * @author Wala ben Amor
	 * @return
	 */
	public Iterable<AffiliateApplication> listAllAffiliateApplications() {
		return affiliateApplicationRepository.findAll();
	}

	public Optional<AffiliateApplication> getAffiliateApplicationById(long idAffiliateApplication) {
		return affiliateApplicationRepository.findById(idAffiliateApplication);
	}

	public void deleteAffiliateApplication(long idAffiliateApplication) {
		affiliateApplicationRepository.deleteById(idAffiliateApplication);
	}

	public AffiliateApplication saveAffiliateApplication(AffiliateApplication affiliateApplication) {
		return affiliateApplicationRepository.saveAndFlush(affiliateApplication);
	}

	public AffiliateApplication getAffiliateApplication(String referrer) {
		return affiliateApplicationRepository.getAffiliateApplication(referrer);
	}

	public long getAffiliateApplicationByDate() {
		return affiliateApplicationRepository.getAffiliateApplicationByDate();
	}

}
