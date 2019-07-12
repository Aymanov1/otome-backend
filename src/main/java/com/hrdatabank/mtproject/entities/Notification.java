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

// TODO: Auto-generated Javadoc
/**
 * The Class Notification.
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
 * Class Name: Notification.java
 * 
 * Instantiates a new notification.
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
 * Class Name: Notification.java
 * 
 * Instantiates a new notification.
 * @param idNotification the id notification
 * @param notificationText the notification text
 * @param notificationDate the notification date
 * @param read the read
 * @param admin the admin
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
