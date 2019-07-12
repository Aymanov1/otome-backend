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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatMessageLine.
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
 * Class Name: ChatMessageLine.java
 * 
 * Instantiates a new chat message line.
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
 * Class Name: ChatMessageLine.java
 * 
 * Instantiates a new chat message line.
 * @param idChatMessageLine the id chat message line
 * @param messageDirection the message direction
 * @param messageText the message text
 * @param adminName the admin name
 * @param messageDate the message date
 * @param readState the read state
 * @param chatLineAdmin the chat line admin
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
@Table(name="chat_message_line")
public class ChatMessageLine implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id chat message line. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idChatMessageLine;

	/** The message direction. */
	private int messageDirection;

	/** The message text. */
	private String messageText;

	/** The message text. */
	private String adminName;

	/** The message date. */
	private Date messageDate;

	/** The read state. */
	private boolean readState;

	/** The chat line admin. */
	@ManyToOne
	@JoinColumn(name = "idChatLineAdmin", referencedColumnName = "idChatLineAdmin")
	@JsonIgnoreProperties("chatMessageLines")
	private ChatLineAdmin chatLineAdmin;
}
