package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.ChatLineAdmin;
import com.hrdatabank.mtproject.repositories.ChatLineAdminRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatLineAdminService.
 */
@Service
public class ChatLineAdminService {

	/** The chat line admin repository. */
	@Autowired
	private ChatLineAdminRepository chatLineAdminRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatLineAdminService.java
	 * 
	 *         Sets the chat line chat line admin repository.
	 * @param chatLineAdminRepository
	 *            the new chat line chat line admin repository
	 */
	public void setChatLineChatLineAdminRepository(ChatLineAdminRepository chatLineAdminRepository) {
		this.chatLineAdminRepository = chatLineAdminRepository;
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
	 *         Class Name: ChatLineAdminService.java
	 * 
	 *         List all chat line admins.
	 * @return the list
	 */
	public List<ChatLineAdmin> listAllChatLineAdmins() {
		return chatLineAdminRepository.findAll();
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
	 *         Class Name: ChatLineAdminService.java
	 * 
	 *         Gets the chat line admin by id.
	 * @param id
	 *            the id
	 * @return the chat line admin by id
	 */
	public Optional<ChatLineAdmin> getChatLineAdminById(long id) {
		return chatLineAdminRepository.findById(id);
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
	 *         Class Name: ChatLineAdminService.java
	 * 
	 *         Save chat line admin.
	 * @param chatLineAdmin
	 *            the chat line admin
	 * @return the chat line admin
	 */
	public ChatLineAdmin saveChatLineAdmin(ChatLineAdmin chatLineAdmin) {
		return chatLineAdminRepository.save(chatLineAdmin);
	}

}
