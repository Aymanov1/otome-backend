package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardInformation.
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
 * Class Name: DashboardInformation.java
 * 
 * Instantiates a new dashboard information.
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
 * Class Name: DashboardInformation.java
 * 
 * Instantiates a new dashboard information.
 * @param idDashboardInformation the id dashboard information
 * @param idCandidate the id candidate
 * @param idJob the id job
 * @param category the category
 * @param status the status
 * @param time the time
 * @param dateOfSet the date of set
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
@Table(name = "dashboard_information")
public class DashboardInformation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id dashboard information. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDashboardInformation;

	/** The id candidate. */
	@Column(columnDefinition = "int default 0")
	private int idCandidate;

	/** The id job. */
	@Column(columnDefinition = "int default 0")
	private int idJob;

	/** The category. */
	private String category;
	
	/** The status. */
	private String status;
	
	/** The time. */
	private String time;

	/** The date of set. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfSet;

}
