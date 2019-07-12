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
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Alert.
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
 * Class Name: Alert.java
 * 
 * Instantiates a new alert.
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
 * Class Name: Alert.java
 * 
 * Instantiates a new alert.
 * @param idNotification the id notification
 * @param notificationDate the notification date
 * @param checked the checked
 * @param personInCharge the person in charge
 * @param candidate the candidate
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
public class Alert implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id notification. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNotification;

	/** The notification date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date notificationDate;

	/** The checked. */
	@Builder.Default
	private boolean checked = false;

	/** The person in charge. */
	@ManyToOne
	@JoinColumn(name = "pic", referencedColumnName = "id_user")
	@JsonIgnoreProperties({ "alerts", "lineBotAdmin", "candidateAdminRelations", "notifications" })
	private Admin personInCharge;

	/** The candidate. */
	@ManyToOne
	@JoinColumn(name = "candidate", referencedColumnName = "id_user")
	@JsonIgnoreProperties({ "alerts", "lineBotAdmin", "chatLineAdmin", "candidateAdminRelations",
			"shopCandidateRelations", "jobCandidateRelations", "notifications", "botInformation" })
	private Candidate candidate;

}
