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

import com.hrdatabank.mtproject.entities.ChatMessageLine;

// TODO: Auto-generated Javadoc
/**
 * The Interface ChatMessageLineRepository.
 */
@Repository
@RepositoryRestResource
public interface ChatMessageLineRepository extends JpaRepository<ChatMessageLine, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineRepository.java
	 * 
	 *         List all chat messages by id chat admin.
	 * @param idChatLineAdmin
	 *            the id chat line admin
	 * @return the list
	 */
	@Query("Select cm from ChatMessageLine cm where cm.chatLineAdmin.idChatLineAdmin=:idChatLineAdmin ORDER BY cm.messageDate ASC")
	public List<ChatMessageLine> listAllChatMessagesByIdChatAdmin(@Param("idChatLineAdmin") int idChatLineAdmin);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: ChatMessageLineRepository.java
	 * 
	 * Count all chat messages by id chat admin.
	 * @param idChatLineAdmin the id chat line admin
	 * @return the long
	 */
	@Query("Select count(cm) from ChatMessageLine cm where cm.chatLineAdmin.idChatLineAdmin=:idChatLineAdmin")
	public long countAllChatMessagesByIdChatAdmin(@Param("idChatLineAdmin") int idChatLineAdmin);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: ChatMessageLineRepository.java
	 * 
	 * Gets the paginatedhat messages by id chat admin.
	 * @param idChatLineAdmin the id chat line admin
	 * @param pageable the pageable
	 * @return the paginatedhat messages by id chat admin
	 */
	@Query("Select cm from ChatMessageLine cm where cm.chatLineAdmin.idChatLineAdmin=:idChatLineAdmin ORDER BY cm.messageDate DESC")
	public List<ChatMessageLine> getPaginatedhatMessagesByIdChatAdmin(@Param("idChatLineAdmin") int idChatLineAdmin,
			Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineRepository.java
	 * 
	 *         Gets the last chat message line by id chat admin.
	 * @param idChatLineAdmin
	 *            the id chat line admin
	 * @return the last chat message line by id chat admin
	 */
	@Query("Select cm from ChatMessageLine cm where cm.chatLineAdmin.idChatLineAdmin=:idChatLineAdmin ORDER BY cm.messageDate DESC")
	public ChatMessageLine getLastChatMessageLineByIdChatAdmin(int idChatLineAdmin);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineRepository.java
	 * 
	 *         Gets the last chat message line by id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the last chat message line by id candidate
	 */
	@Query("Select max(cm.messageDate) from ChatMessageLine cm where cm.messageDirection =:idCandidate")
	public Date getLastChatMessageLineByIdCandidate(@Param("idCandidate") int idCandidate);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineRepository.java
	 * 
	 *         Gets the candidates ids from chat message line by last action date.
	 * @param dateFrom
	 *            the date from
	 * @param dateTo
	 *            the date to
	 * @param pageable
	 *            the pageable
	 * @return the candidates ids from chat message line by last action date
	 */
	@Query(value = "Select Distinct(cm.messageDirection) from ChatMessageLine cm where (cm.messageDate >:dateFrom and cm.messageDate <:dateTo)", countQuery = "select count(*) from ChatMessageLine cm where (cm.messageDate >:dateFrom and cm.messageDate <:dateTo)")
	public Page<Integer> getCandidatesIdsFromChatMessageLineByLastActionDate(@Param("dateFrom") Date dateFrom,
			@Param("dateTo") Date dateTo, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineRepository.java
	 * 
	 *         Gets the candidates ids from chat message line by last action date
	 *         from.
	 * @param dateFrom
	 *            the date from
	 * @param pageable
	 *            the pageable
	 * @return the candidates ids from chat message line by last action date from
	 */
	@Query(value = "Select Distinct(cm.messageDirection) from ChatMessageLine cm where (cm.messageDate >:dateFrom)", countQuery = "select count(*) from ChatMessageLine cm where (cm.messageDate >:dateFrom)")
	public Page<Integer> getCandidatesIdsFromChatMessageLineByLastActionDateFrom(@Param("dateFrom") Date dateFrom,
			Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineRepository.java
	 * 
	 *         Gets the candidates ids from chat message line by last action date
	 *         to.
	 * @param dateTo
	 *            the date to
	 * @param pageable
	 *            the pageable
	 * @return the candidates ids from chat message line by last action date to
	 */
	@Query(value = "Select Distinct(cm.messageDirection) from ChatMessageLine cm where cm.messageDate <:dateTo", countQuery = "select count(*) from ChatMessageLine cm where cm.messageDate <:dateTo")
	public Page<Integer> getCandidatesIdsFromChatMessageLineByLastActionDateTo(@Param("dateTo") Date dateTo,
			Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Houaoui Awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineRepository.java
	 * 
	 *         Gets All the ChatMessageLine Between DateFrom And DateTo.
	 * @param dateFrom
	 *            the date from
	 * @param dateTo
	 *            the date to
	 * @return ChatMessageLine list
	 */
	@Query(value = "SELECT cm FROM ChatMessageLine cm WHERE (to_timestamp(to_char(cm.messageDate, 'yyyy-MM-dd'), 'yyyy-MM-dd') BETWEEN to_timestamp(:dateFrom, 'yyyy-MM-dd') AND to_timestamp(:dateTo, 'yyyy-MM-dd'))")
	public List<ChatMessageLine> getAllChatMessageLineBetweenDateFromAndDateTo(@Param("dateFrom") String dateFrom,
			@Param("dateTo") String dateTo);

}