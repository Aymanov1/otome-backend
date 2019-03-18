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

/**
 * The Class ChatMessage.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
