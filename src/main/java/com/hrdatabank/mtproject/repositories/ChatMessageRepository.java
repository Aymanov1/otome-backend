package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.ChatMessage;

// TODO: Auto-generated Javadoc
/**
 * The Interface ChatMessageRepository.
 */
@Repository
@RepositoryRestResource
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ChatMessageRepository.java
	 * 
	 *         List all chat messages by id chat.
	 * @param idChat
	 *            the id chat
	 * @return the iterable
	 */
	@Query("Select cm from ChatMessage cm where cm.chat.idChat=:idChat ORDER BY cm.messageDate ASC")
	public Iterable<ChatMessage> listAllChatMessagesByIdChat(@Param("idChat") int idChat);

}
