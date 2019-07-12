package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatMessage.
 */
@Entity

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: ChatMessage.java
 * 
 * Instantiates a new chat message.
 */
@NoArgsConstructor

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: ChatMessage.java
 * 
 * Instantiates a new chat message.
 * @param idChatMessage the id chat message
 * @param messageDirection the message direction
 * @param messageText the message text
 * @param messageDate the message date
 * @param readState the read state
 * @param chat the chat
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(callSuper = false)
@Table(name="chat_message")
public class ChatMessage implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id chat message. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idChatMessage;

	/** The message direction. */
	private int messageDirection;

	/** The message text. */
	private String messageText;

	/** The message date. */
	private Date messageDate;

	/** The read state. */
	private boolean readState;

	/** The chat. */
	@ManyToOne
	@JoinColumn(name = "idChat", referencedColumnName = "idChat")
	private Chat chat;

}
