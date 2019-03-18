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

/**
 * The Class ChatMessageLine.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
