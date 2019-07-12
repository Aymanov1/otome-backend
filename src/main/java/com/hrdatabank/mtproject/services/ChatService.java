package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Chat;
import com.hrdatabank.mtproject.repositories.ChatRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatService.
 */
@Service
public class ChatService {

	/** The chat repository. */
	@Autowired
	private ChatRepository chatRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatService.java
	 * 
	 *         Sets the chat repository.
	 * @param chatRepository
	 *            the new chat repository
	 */
	public void setChatRepository(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
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
	 *         Class Name: ChatService.java
	 * 
	 *         List all chats.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @return the page
	 */
	public Page<Chat> listAllChats(int page, int size) {
		return chatRepository.findAll(PageRequest.of(page, size));
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
	 *         Class Name: ChatService.java
	 * 
	 *         Gets the chat by id.
	 * @param id
	 *            the id
	 * @return the chat by id
	 */
	public Optional<Chat> getChatById(long id) {
		return chatRepository.findById(id);
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
	 *         Class Name: ChatService.java
	 * 
	 *         Save chat.
	 * @param chat
	 *            the chat
	 * @return the chat
	 */
	public Chat saveChat(Chat chat) {
		return chatRepository.save(chat);
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
	 *         Class Name: ChatService.java
	 * 
	 *         this method Delete chat.
	 * @param idChat
	 *            the id chat
	 */
	public void deleteChat(long idChat) {
		chatRepository.deleteById(idChat);
	}

}
