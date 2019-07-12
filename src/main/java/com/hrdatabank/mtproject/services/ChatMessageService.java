package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.ChatMessage;
import com.hrdatabank.mtproject.repositories.ChatMessageRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatMessageService.
 */
@Service
public class ChatMessageService {

	/** The chat message repository. */
	@Autowired
	private ChatMessageRepository chatMessageRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageService.java
	 * 
	 *         Sets the chat message repository.
	 * @param chatMessageRepository
	 *            the new chat message repository
	 */
	public void setChatMessageRepository(ChatMessageRepository chatMessageRepository) {
		this.chatMessageRepository = chatMessageRepository;
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
	 *         Class Name: ChatMessageService.java
	 * 
	 *         List all chat messages.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the page
	 */
	public Page<ChatMessage> listAllChatMessages(int page, int size) {
		return chatMessageRepository.findAll(PageRequest.of(page, size));
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
	 *         Class Name: ChatMessageService.java
	 * 
	 *         Gets the chat message by id.
	 * @param id
	 *            the id
	 * @return the chat message by id
	 */
	public Optional<ChatMessage> getChatMessageById(long id) {
		return chatMessageRepository.findById(id);
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
	 *         Class Name: ChatMessageService.java
	 * 
	 *         Save chat message.
	 * @param chatMessage
	 *            the chat message
	 * @return the chat message
	 */
	public ChatMessage saveChatMessage(ChatMessage chatMessage) {
		return chatMessageRepository.save(chatMessage);
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
	 *         Class Name: ChatMessageService.java
	 * 
	 *         List all chat messages by id chat.
	 * @param idChat
	 *            the id chat
	 * @return the iterable
	 */
	public Iterable<ChatMessage> listAllChatMessagesByIdChat(int idChat) {
		return chatMessageRepository.listAllChatMessagesByIdChat(idChat);
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
	 *         Class Name: ChatMessageService.java
	 * 
	 *         this method Delete chat message.
	 * @param idChatMessage
	 *            the id chat message
	 */
	public void deleteChatMessage(long idChatMessage) {
		chatMessageRepository.deleteById(idChatMessage);
	}

}
