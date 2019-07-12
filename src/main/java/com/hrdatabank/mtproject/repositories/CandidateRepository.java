package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Candidate;
import com.hrdatabank.mtproject.model.CandidateDto;

// TODO: Auto-generated Javadoc
/**
 * The Interface CandidateRepository.
 */
@Repository
@RepositoryRestResource
public interface CandidateRepository extends JpaRepository<Candidate, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Gets the candidate list by id admin paginated.
	 * @param idAdmin
	 *            the id admin
	 * @param candName
	 *            the cand name
	 * @param pageable
	 *            the pageable
	 * @return the candidate list by id admin paginated
	 */
	@Query(value = "select s from Candidate s where (s.idPersonInCharge=:idAdmin or s.botInformation.pendingBot = true) and lower(CONCAT('%',s.userName,'%')) like lower(CONCAT('%',:candName,'%')) ORDER BY s.botInformation.lastActionDate DESC", countQuery = "select count(*) from Candidate s where (s.idPersonInCharge=:idAdmin or s.botInformation.pendingBot = true) and lower(CONCAT('%',s.userName,'%')) like lower(CONCAT('%',:candName,'%'))")
	public Page<Candidate> getCandidateListByIdAdminPaginated(@Param("idAdmin") int idAdmin,
			@Param("candName") String candName, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Gets the candidate list paginated.
	 * @param candName
	 *            the cand name
	 * @param pageable
	 *            the pageable
	 * @return the candidate list paginated
	 */
	@Query(value = "select NEW com.hrdatabank.mtproject.model.CandidateDto(s.idUser,s.botInformation.idBotInformation,s.botInformation.languageBot,s.userName,s.phone,s.jLPT,s.durationInJapan,s.email,s.profilePicture,s.birthday,s.candidateFB,s.userNameKatakana)  from Candidate s where s.botInformation.pendingBot = true and (lower(CONCAT('%',s.userName,'%')) like lower(CONCAT('%',:candName,'%')) or lower(CONCAT('%',s.idUser,'%')) like lower(CONCAT('%',:candName,'%'))) ORDER BY s.botInformation.lastActionDate DESC", countQuery = "select count(*) from Candidate s where s.botInformation.pendingBot = true and (lower(CONCAT('%',s.userName,'%')) like lower(CONCAT('%',:candName,'%')) or lower(CONCAT('%',s.idUser,'%')) like lower(CONCAT('%',:candName,'%')))")
	public Page<CandidateDto> getCandidateListPaginated(@Param("candName") String candName, Pageable pageable);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the list candidate by id.
	 * @param idCand the id cand
	 * @return the list candidate by id
	 */
	@Query(value = "select s from Candidate s where idUser>= :idCand")
	public List<Candidate> getListCandidateById(@Param("idCand") int idCand);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Search by cand name paginated.
	 * @param candName
	 *            the cand name
	 * @param pageable
	 *            the pageable
	 * @return the page
	 */
	@Query(value = "select NEW com.hrdatabank.mtproject.model.CandidateDto(s.idUser,s.botInformation.idBotInformation,s.botInformation.languageBot,s.userName,s.phone,s.jLPT,s.durationInJapan,s.email,s.profilePicture,s.birthday,s.candidateFB,s.userNameKatakana)  from Candidate s where lower(CONCAT('%',s.userName,'%')) like  lower(CONCAT('%',:candName,'%')) or lower(CONCAT('%',s.idUser,'%')) like  lower(CONCAT('%',:candName,'%')) or CONCAT('%',s.userNameKatakana,'%') like CONCAT('%',:candName,'%') or lower(CONCAT('%',s.phone,'%')) like  lower(CONCAT('%',:candName,'%')) ORDER BY s.botInformation.lastActionDate DESC", countQuery = "select count(*) from Candidate s where  lower(CONCAT('%',s.userName,'%')) like lower(CONCAT('%',:candName,'%')) or lower(CONCAT('%',s.idUser,'%')) like  lower(CONCAT('%',:candName,'%'))  or CONCAT('%',s.userNameKatakana,'%') like CONCAT('%',:candName,'%') or lower(CONCAT('%',s.phone,'%')) like  lower(CONCAT('%',:candName,'%'))")
	public Page<CandidateDto> searchByCandNamePaginated(@Param("candName") String candName, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Find by user line id.
	 * @param lineID
	 *            the line ID
	 * @return the candidate
	 */
	@Query(value = "select s from Candidate s where s.userLineId =:lineID")
	public Candidate findByUserLineId(@Param("lineID") String lineID);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Find candidate by id bot information.
	 * @param idBotInformation
	 *            the id bot information
	 * @return the candidate
	 */
	@Query(value = "select c from Candidate c where c.botInformation.idBotInformation =:idBotInformation")
	public Candidate findCandidateByIdBotInformation(@Param("idBotInformation") int idBotInformation);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Search by list and name paginated.
	 * @param candName
	 *            the cand name
	 * @param listNumber
	 *            the list number
	 * @param pageable
	 *            the pageable
	 * @return the page
	 */
	@Query(value = "select s from Candidate s where lower(CONCAT('%',s.userName,'%')) like  lower(CONCAT('%',:candName,'%') ) and s.botInformation.listNumber like  :list", countQuery = "select count(*) from Candidate s where lower(CONCAT('%',s.userName,'%')) like  lower(CONCAT('%',:candName,'%'))  and s.botInformation.listNumber like  :list")
	public Page<Candidate> searchByListAndNamePaginated(@Param("candName") String candName,
			@Param("list") String listNumber, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Gets the all candidates ordered by last action date.
	 * @param pageable
	 *            the pageable
	 * @return the all candidates ordered by last action date
	 */
	@Query(value = "select s from Candidate s  ORDER BY s.botInformation.lastActionDate DESC", countQuery = "select count(*) from Candidate s")
	public Page<Candidate> getAllCandidatesOrderedByLastActionDate(Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Gets the all candidates between date from and date to.
	 * @param pageable
	 *            the pageable
	 * @param dateFrom
	 *            the date from
	 * @param dateTo
	 *            the date to
	 * @return the all candidates between date from and date to
	 */
	@Query(value = "select s from Candidate s where (s.botInformation.lastActionDate >:dateFrom and s.botInformation.lastActionDate <:dateTo) ORDER BY s.botInformation.lastActionDate DESC ", countQuery = "select count(*) from Candidate s where (s.botInformation.lastActionDate >:dateFrom and s.botInformation.lastActionDate <:dateTo)")
	public Page<Candidate> getAllCandidatesBetweenDateFromAndDateTo(Pageable pageable, @Param("dateFrom") Date dateFrom,
			@Param("dateTo") Date dateTo);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Gets the all candidates after date from.
	 * @param pageable
	 *            the pageable
	 * @param dateFrom
	 *            the date from
	 * @return the all candidates after date from
	 */
	@Query(value = "select s from Candidate s where (s.botInformation.lastActionDate >:dateFrom) ORDER BY s.botInformation.lastActionDate DESC ", countQuery = "select count(*) from Candidate s where (s.botInformation.lastActionDate >:dateFrom)")
	public Page<Candidate> getAllCandidatesAfterDateFrom(Pageable pageable, @Param("dateFrom") Date dateFrom);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Gets the all candidates before date to.
	 * @param pageable
	 *            the pageable
	 * @param dateTo
	 *            the date to
	 * @return the all candidates before date to
	 */
	@Query(value = "select s from Candidate s where (s.botInformation.lastActionDate <:dateTo) ORDER BY s.botInformation.lastActionDate DESC ", countQuery = "select count(*) from Candidate s where (s.botInformation.lastActionDate <:dateTo)")
	public Page<Candidate> getAllCandidatesBeforeDateTo(Pageable pageable, @Param("dateTo") Date dateTo);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Check phone candidate.
	 * @param phone
	 *            the phone
	 * @param idUser
	 *            the id user
	 * @return true, if successful
	 */
	@Query(value = "select count(s)>0 from Candidate s where s.idUser=:idUser and  s.phone=:phone ")
	public boolean checkPhoneCandidate(@Param("phone") String phone, @Param("idUser") int idUser);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         Gets the candidate dto byid.
	 * @param idUser
	 *            the id user
	 * @return the candidate dto byid
	 */
	@Query(value = "select NEW com.hrdatabank.mtproject.model.CandidateDto(s.idUser,s.botInformation.idBotInformation,s.botInformation.languageBot,s.userName,s.phone,s.jLPT,s.durationInJapan,s.email,s.profilePicture,s.birthday,s.candidateFB,s.userNameKatakana,s.guest) from Candidate s where s.idUser=:idUser ")
	public CandidateDto getCandidateDtoByid(@Param("idUser") int idUser);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Find FB candidate by id user FB.
	 * @param idUserFB the id user FB
	 * @return the candidate
	 */
	@Query(value = "select s from Candidate s where s.idUserFB =:idUserFB")
	public Candidate findFBCandidateByIdUserFB(@Param("idUserFB") String idUserFB);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Find candidates by register date.
	 * @param registerDate the register date
	 * @param page the page
	 * @return the page
	 */
	@Query(value = "select NEW com.hrdatabank.mtproject.model.CandidateDto(c.idUser, c.botInformation.idBotInformation, c.botInformation.languageBot, c.userName, c.phone, c.jLPT, c.durationInJapan, c.email, c.profilePicture, c.userLineId, c.firstNameFB, c.lastNameFB, c.timeZoneFB, c.localFB, c.idUserFB, c.birthday, c.registerDate, c.candidateFB, c.botInformation) from Candidate c where c.registerDate >=:registerDate", countName = "select count(*) from Candidate c where c.registerDate >=:registerDate")
	public Page<CandidateDto> findCandidatesByRegisterDate(@Param("registerDate") Date registerDate, Pageable page);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the all facebook user ids.
	 * @return the all facebook user ids
	 */
	@Query(value = "select c.idUserFB from Candidate c where c.idUserFB IS NOT NULL")
	public List<String> getAllFacebookUserIds();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the candidate by phone number.
	 * @param phone the phone
	 * @return the candidate by phone number
	 */
	@Query(value = "select s from Candidate s where s.phone =:phone and s.guest=false")
	public Candidate getCandidateByPhoneNumber(@Param("phone") String phone);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the candidate guest by phone number.
	 * @param phone the phone
	 * @return the candidate guest by phone number
	 */
	@Query(value = "select s from Candidate s where s.phone =:phone and s.guest=true")
	public Candidate getCandidateGuestByPhoneNumber(@Param("phone") String phone);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the candidate by phone number and source.
	 * @param phone the phone
	 * @param source the source
	 * @return the candidate by phone number and source
	 */
	@Query(value = "select s from Candidate s where s.phone =:phone and s.candidateFB =:source and  s.guest=false")
	public Candidate getCandidateByPhoneNumberAndSource(@Param("phone") String phone, @Param("source") boolean source);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Find near station by station name.
	 * @param stationEn the station en
	 * @param stationJp the station jp
	 * @param stationEnF the station en F
	 * @param stationJpF the station jp F
	 * @return the list
	 */
	@Query("SELECT c FROM Candidate c where  c.botInformation.addressToSearch = :stationJp OR  c.botInformation.addressToSearch = :stationEng OR c.botInformation.addressToSearch = :stationJpF OR  c.botInformation.addressToSearch = :stationEngF")
	public List<Candidate> findNearStationByStationName(@Param("stationEng") String stationEn,
			@Param("stationJp") String stationJp, @Param("stationEngF") String stationEnF,
			@Param("stationJpF") String stationJpF);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the candidate list having bot information.
	 * @param ids the ids
	 * @return the candidate list having bot information
	 */
	@Query("SELECT c FROM Candidate c where c.botInformation.idBotInformation IN :ids ")
	public List<Candidate> getCandidateListHavingBotInformation(@Param("ids") List<Integer> ids);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the line or FB candidate list having bot information.
	 * @param ids the ids
	 * @param candidateFB the candidate FB
	 * @return the line or FB candidate list having bot information
	 */
	@Query("SELECT c FROM Candidate c where c.botInformation.idBotInformation IN :ids and c.candidateFB=:candidateFB")
	public List<Candidate> getLineOrFBCandidateListHavingBotInformation(@Param("ids") List<Integer> ids,
			@Param("candidateFB") boolean candidateFB);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the job canidate relation by id candidate limit.
	 * @param idCandidateStart the id candidate start
	 * @param idCandidateEnd the id candidate end
	 * @return the job canidate relation by id candidate limit
	 */
	@Query("SELECT c FROM Candidate c where c.idUser>=:idCandidateStart and  c.idUser<=:idCandidateEnd")
	public List<Candidate> getJobCanidateRelationByIdCandidateLimit(@Param("idCandidateStart") int idCandidateStart,
			@Param("idCandidateEnd") int idCandidateEnd);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Checks if is staff account exist by email.
	 * @param email the email
	 * @return true, if is staff account exist by email
	 */
	@Query("SELECT Count(c)>0 FROM Staff c where c.email=:email")
	public boolean isStaffAccountExistByEmail(@Param("email") String email);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateRepository.java
	 * 
	 * Gets the id bot information by id candidate.
	 * @param idCandidate the id candidate
	 * @return the id bot information by id candidate
	 */
	@Query(value = "SELECT u.id_bot_information FROM user_information u where u.id_user=:idCandidate", nativeQuery = true)
	public int getIdBotInformationByIdCandidate(@Param("idCandidate") int idCandidate);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateRepository.java
	 * 
	 *         get all Candidates that are Missing Informations in UserInformation
	 * @return Candidates List
	 */
	@Query("SELECT c FROM Candidate c WHERE c.idUser IN (SELECT jc.jobCandidateRelationPK.idCandidate FROM JobCandidateRelation jc WHERE jc.candidateJLPT IS NOT NULL AND jc.candidatePhone IS NOT NULL AND jc.candidateBirthday IS NOT NULL) AND c.jLPT IS NULL AND c.phone IS NULL AND c.birthday IS NULL")
	public List<Candidate> getCandidatesMissingInformations();
}
