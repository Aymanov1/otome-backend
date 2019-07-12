package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatLineAdmin.
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
 * Class Name: ChatLineAdmin.java
 * 
 * Instantiates a new chat line admin.
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
 * Class Name: ChatLineAdmin.java
 * 
 * Instantiates a new chat line admin.
 * @param idChatLineAdmin the id chat line admin
 * @param chatMessageLines the chat message lines
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
@Table(name="chat_line_admin")
public class ChatLineAdmin implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id chat line admin. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idChatLineAdmin;

	/** The chat message lines. */
	@OneToMany(mappedBy = "chatLineAdmin")
	@JsonIgnoreProperties({ "chatLineAdmin", "candidate" })
	private List<ChatMessageLine> chatMessageLines;

}
