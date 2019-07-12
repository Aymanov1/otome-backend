package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class AffiliateApplication.
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
 * Class Name: AffiliateApplication.java
 * 
 * Instantiates a new affiliate application.
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
 * Class Name: AffiliateApplication.java
 * 
 * Instantiates a new affiliate application.
 * @param idAffiliateApplication the id affiliate application
 * @param programName the program name
 * @param affilPayment the affil payment
 * @param referrer the referrer
 * @param device the device
 * @param clickDate the click date
 * @param orderDate the order date
 * @param approvalDate the approval date
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
@Table(name = "affiliate_application")
public class AffiliateApplication implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id AffiliateApplication. */
	@Id
	@SequenceGenerator(name = "affiliateapplicationidentifier", sequenceName = "AFFILAPPLICATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "affiliateapplicationidentifier")
	private int idAffiliateApplication;
	/** The program Name. */
	private String programName;
	/** The affilPayment. */
	private String affilPayment;
	/** The referrer. */
	private String referrer;
	/** The device. */
	private String device;
	/** The click Date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date clickDate;
	/** The order Date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	/** The approval Date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date approvalDate;

}
