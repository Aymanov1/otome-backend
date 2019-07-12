package com.hrdatabank.mtproject.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Candidate;
import com.hrdatabank.mtproject.model.CandidateDto;
import com.hrdatabank.mtproject.repositories.CandidateRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CandidateService.
 */
@Service
public class CandidateService {

	/** The candidate repository. */
	@Autowired
	private CandidateRepository candidateRepository;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateService.java
	 * 
	 * Gets the all candidates.
	 * @return the all candidates
	 */
	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();

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
	 *         Class Name: CandidateService.java
	 * 
	 *         Sets the candidate repository.
	 * @param candidateRepository
	 *            the new candidate repository
	 */
	public void setCandidateRepository(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
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
	 *         Class Name: CandidateService.java
	 * 
	 *         List all candidates.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param candName
	 *            the cand name
	 * @return the page
	 */
	public Page<CandidateDto> listAllCandidates(int page, int size, String candName) {
		return candidateRepository.searchByCandNamePaginated(candName, PageRequest.of(page, size));
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
	 *         Class Name: CandidateService.java
	 * 
	 *         List candidates by admin.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param idAdmin
	 *            the id admin
	 * @param candName
	 *            the cand name
	 * @return the page
	 */
	public Page<CandidateDto> listCandidatesByAdmin(int page, int size, int idAdmin, String candName) {
		return candidateRepository.getCandidateListPaginated(candName, PageRequest.of(page, size));
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Gets the candidate by id.
	 * @param id
	 *            the id
	 * @return the candidate by id
	 */
	public Optional<Candidate> getCandidateById(int id) {
		return candidateRepository.findById(id);
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the candidate by phone number.
	 * @param phoneNumber the phone number
	 * @return the candidate by phone number
	 */
	public Candidate getCandidateByPhoneNumber(String phoneNumber) {
		return candidateRepository.getCandidateByPhoneNumber(phoneNumber);
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the candidate guest by phone number.
	 * @param phoneNumber the phone number
	 * @return the candidate guest by phone number
	 */
	public Candidate getCandidateGuestByPhoneNumber(String phoneNumber) {
		return candidateRepository.getCandidateGuestByPhoneNumber(phoneNumber);
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the candidate by phone number and source.
	 * @param phoneNumber the phone number
	 * @param source the source
	 * @return the candidate by phone number and source
	 */
	public Candidate getCandidateByPhoneNumberAndSource(String phoneNumber, boolean source) {
		return candidateRepository.getCandidateByPhoneNumberAndSource(phoneNumber, source);
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the ats list candidate by id.
	 * @param id the id
	 * @return the ats list candidate by id
	 */
	public List<Candidate> getAtsListCandidateById(int id) {
		return candidateRepository.getListCandidateById(id);
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Gets the candidate dto byid.
	 * @param id
	 *            the id
	 * @return the candidate dto byid
	 */
	public CandidateDto getCandidateDtoByid(int id) {
		return candidateRepository.getCandidateDtoByid(id);
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Save candidate.
	 * @param candidate
	 *            the candidate
	 * @return the candidate
	 */
	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
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
	 *         Class Name: CandidateService.java
	 * 
	 *         this method Delete candidate.
	 * @param idCandidate
	 *            the id candidate
	 */
	public void deleteCandidate(int idCandidate) {
		candidateRepository.deleteById(idCandidate);
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
	 *         Class Name: CandidateService.java
	 * 
	 *         List all candidates.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the page
	 */
	public Page<Candidate> listAllCandidates(int page, int size) {
		return candidateRepository.findAll(PageRequest.of(page, size));
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Gets the all candidates by list and name paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param candName
	 *            the cand name
	 * @param list
	 *            the list
	 * @return the all candidates by list and name paginated
	 */
	public Page<Candidate> getAllCandidatesByListAndNamePaginated(int page, int size, String candName, String list) {
		return candidateRepository.searchByListAndNamePaginated(candName, list, PageRequest.of(page, size));
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Gets the all candidates ordered by last action date.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the all candidates ordered by last action date
	 */
	public Page<Candidate> getAllCandidatesOrderedByLastActionDate(int page, int size) {
		return candidateRepository.getAllCandidatesOrderedByLastActionDate(PageRequest.of(page, size));
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Gets the all candidates between date from and date to.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param dateFrom
	 *            the date from
	 * @param dateTo
	 *            the date to
	 * @return the all candidates between date from and date to
	 */
	public Page<Candidate> getAllCandidatesBetweenDateFromAndDateTo(int page, int size, Date dateFrom, Date dateTo) {
		return candidateRepository.getAllCandidatesBetweenDateFromAndDateTo(PageRequest.of(page, size), dateFrom,
				dateTo);
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Gets the all candidates after date from.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param dateFrom
	 *            the date from
	 * @return the all candidates after date from
	 */
	public Page<Candidate> getAllCandidatesAfterDateFrom(int page, int size, Date dateFrom) {
		return candidateRepository.getAllCandidatesAfterDateFrom(PageRequest.of(page, size), dateFrom);
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Gets the all candidates before date to.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param dateTo
	 *            the date to
	 * @return the all candidates before date to
	 */
	public Page<Candidate> getAllCandidatesBeforeDateTo(int page, int size, Date dateTo) {
		return candidateRepository.getAllCandidatesBeforeDateTo(PageRequest.of(page, size), dateTo);
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
	 *         Class Name: CandidateService.java
	 * 
	 *         Check phone candidate.
	 * @param phone
	 *            the phone
	 * @param idUser
	 *            the id user
	 * @return true, if successful
	 */
	public boolean checkPhoneCandidate(String phone, int idUser) {
		return candidateRepository.checkPhoneCandidate(phone, idUser);
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
	 * Class Name: CandidateService.java
	 * 
	 * Find FB candidate by id user FB.
	 * @param idUserFB the id user FB
	 * @return the candidate
	 */
	public Candidate findFBCandidateByIdUserFB(String idUserFB) {
		return candidateRepository.findFBCandidateByIdUserFB(idUserFB);
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
	 * Class Name: CandidateService.java
	 * 
	 * Find candidates by register date.
	 * @param registerDate the register date
	 * @param pageable the pageable
	 * @return the page
	 */
	public Page<CandidateDto> findCandidatesByRegisterDate(Date registerDate, Pageable pageable) {
		return candidateRepository.findCandidatesByRegisterDate(registerDate, pageable);
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the all facebook user ids.
	 * @return the all facebook user ids
	 */
	public List<String> getAllFacebookUserIds() {
		return candidateRepository.getAllFacebookUserIds();
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the candidate list having bot information.
	 * @param botInfos the bot infos
	 * @return the candidate list having bot information
	 */
	public List<Candidate> getCandidateListHavingBotInformation(List<Integer> botInfos) {
		return candidateRepository.getCandidateListHavingBotInformation(botInfos);
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the line or FB candidate list having bot information.
	 * @param botInfos the bot infos
	 * @param candidateFB the candidate FB
	 * @return the line or FB candidate list having bot information
	 */
	public List<Candidate> getLineOrFBCandidateListHavingBotInformation(List<Integer> botInfos, boolean candidateFB) {
		return candidateRepository.getLineOrFBCandidateListHavingBotInformation(botInfos, candidateFB);
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
	 * Class Name: CandidateService.java
	 * 
	 * Gets the job canidate relation by id candidate limit.
	 * @param idCandidateStart the id candidate start
	 * @param idCandidateEnd the id candidate end
	 * @return the job canidate relation by id candidate limit
	 */
	public List<Candidate> getJobCanidateRelationByIdCandidateLimit(int idCandidateStart, int idCandidateEnd) {
		return candidateRepository.getJobCanidateRelationByIdCandidateLimit(idCandidateStart, idCandidateEnd);
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
	 * Class Name: CandidateService.java
	 * 
	 * Find candidate by id bot information.
	 * @param idBotInformation the id bot information
	 * @return the candidate
	 */
	public Candidate findCandidateByIdBotInformation(int idBotInformation) {
		return candidateRepository.findCandidateByIdBotInformation(idBotInformation);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * @return the candidates missing informations
	 */
	public List<Candidate> getCandidatesMissingInformations() {
		return candidateRepository.getCandidatesMissingInformations();
	}

}
