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

/**
 * The Class ChatLineAdmin.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
