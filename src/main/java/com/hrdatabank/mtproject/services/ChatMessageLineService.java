package com.hrdatabank.mtproject.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.ChatMessageLine;
import com.hrdatabank.mtproject.repositories.ChatMessageLineRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatMessageLineService.
 */
@Service
public class ChatMessageLineService {

	/** The chat message line repository. */
	@Autowired
	private ChatMessageLineRepository chatMessageLineRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Sets the chat message line repository.
	 * @param chatMessageLineRepository
	 *            the new chat message line repository
	 */
	public void setChatMessageLineRepository(ChatMessageLineRepository chatMessageLineRepository) {
		this.chatMessageLineRepository = chatMessageLineRepository;
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         List all line chat messages.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the page
	 */
	public Page<ChatMessageLine> listAllLineChatMessages(int page, int size) {
		return chatMessageLineRepository.findAll(PageRequest.of(page, size));
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Gets the chat message line by id.
	 * @param id
	 *            the id
	 * @return the chat message line by id
	 */
	public Optional<ChatMessageLine> getChatMessageLineById(long id) {
		return chatMessageLineRepository.findById(id);
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Save chat message line.
	 * @param chatMessageLine
	 *            the chat message line
	 * @return the chat message line
	 */
	public ChatMessageLine saveChatMessageLine(ChatMessageLine chatMessageLine) {
		return chatMessageLineRepository.save(chatMessageLine);
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         this method Delete chat message line.
	 * @param idChatMessage
	 *            the id chat message
	 */
	public void deleteChatMessageLine(long idChatMessage) {
		chatMessageLineRepository.deleteById(idChatMessage);
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         List all chat messages by id chat admin.
	 * @param idChatLineAdmin
	 *            the id chat line admin
	 * @return the list
	 */
	public List<ChatMessageLine> listAllChatMessagesByIdChatAdmin(int idChatLineAdmin) {
		return chatMessageLineRepository.listAllChatMessagesByIdChatAdmin(idChatLineAdmin);
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         List all chat messages by id chat admin.
	 * @param idChatLineAdmin            the id chat line admin
	 * @param page the page
	 * @param size the size
	 * @return the list
	 */
	public List<ChatMessageLine> getPaginatedhatMessagesByIdChatAdmin(int idChatLineAdmin, int page, int size) {
		return chatMessageLineRepository.getPaginatedhatMessagesByIdChatAdmin(idChatLineAdmin,
				PageRequest.of(page, size));
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
	 * Class Name: ChatMessageLineService.java
	 * 
	 * Count all chat messages by id chat admin.
	 * @param idChatLineAdmin the id chat line admin
	 * @return the long
	 */
	public long countAllChatMessagesByIdChatAdmin(int idChatLineAdmin) {
		return chatMessageLineRepository.countAllChatMessagesByIdChatAdmin(idChatLineAdmin);
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Gets the last chat message line by id chat admin.
	 * @param idChatLineAdmin
	 *            the id chat line admin
	 * @return the last chat message line by id chat admin
	 */
	public ChatMessageLine getLastChatMessageLineByIdChatAdmin(int idChatLineAdmin) {
		return chatMessageLineRepository.getLastChatMessageLineByIdChatAdmin(idChatLineAdmin);
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Gets the last chat message line by id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the last chat message line by id candidate
	 */
	public Date getLastChatMessageLineByIdCandidate(int idCandidate) {
		return chatMessageLineRepository.getLastChatMessageLineByIdCandidate(idCandidate);
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Gets the candidates ids from chat message line by last action date.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param dateFrom
	 *            the date from
	 * @param dateTo
	 *            the date to
	 * @return the candidates ids from chat message line by last action date
	 */
	public Page<Integer> getCandidatesIdsFromChatMessageLineByLastActionDate(int page, int size, Date dateFrom,
			Date dateTo) {
		return chatMessageLineRepository.getCandidatesIdsFromChatMessageLineByLastActionDate(dateFrom, dateTo,
				PageRequest.of(page, size));
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Gets the candidates ids from chat message line by last action date
	 *         from.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param dateFrom
	 *            the date from
	 * @return the candidates ids from chat message line by last action date from
	 */
	public Page<Integer> getCandidatesIdsFromChatMessageLineByLastActionDateFrom(int page, int size, Date dateFrom) {
		return chatMessageLineRepository.getCandidatesIdsFromChatMessageLineByLastActionDateFrom(dateFrom,
				PageRequest.of(page, size));
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
	 *         Class Name: ChatMessageLineService.java
	 * 
	 *         Gets the candidates ids from chat message line by last action date
	 *         to.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param dateTo
	 *            the date to
	 * @return the candidates ids from chat message line by last action date to
	 */
	public Page<Integer> getCandidatesIdsFromChatMessageLineByLastActionDateTo(int page, int size, Date dateTo) {
		return chatMessageLineRepository.getCandidatesIdsFromChatMessageLineByLastActionDateTo(dateTo,
				PageRequest.of(page, size));
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Houaoui Awatef
	 * 
	 *         Gets All the ChatMessageLine Between DateFrom And DateTo.
	 * @param dateFrom            the date from
	 * @param dateTo            the date to
	 * @return ChatMessageLine list
	 */
	public List<ChatMessageLine> getAllChatMessageLineBetweenDateFromAndDateTo(String dateFrom, String dateTo) {
		return chatMessageLineRepository.getAllChatMessageLineBetweenDateFromAndDateTo(dateFrom, dateTo);
	}

}
