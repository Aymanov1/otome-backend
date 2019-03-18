package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Notification.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Notification implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id notification. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNotification;

	/** The notification text. */
	private String notificationText;

	/** The notification date. */
	@Temporal(TemporalType.DATE)
	private Date notificationDate;

	/** The read. */
	@Builder.Default
	private boolean read = false;

	/** The admin. */
	@ManyToOne
	@JoinColumn(name = "idAdmin", referencedColumnName = "id_user")
	@JsonIgnoreProperties({ "notifications", "lineBotAdmin", "candidateAdminRelations" })
	private Admin admin;

}
