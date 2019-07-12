package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
 * The Class ShopCandidateRelation.
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
 * Class Name: ShopCandidateRelation.java
 * 
 * Instantiates a new shop candidate relation.
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
 * Class Name: ShopCandidateRelation.java
 * 
 * Instantiates a new shop candidate relation.
 * @param shopCandidateRelationPK the shop candidate relation PK
 * @param askInterviewCounter the ask interview counter
 * @param passedInterviewMessageCounter the passed interview message counter
 * @param remindInterviewCounter the remind interview counter
 * @param askForReasonCounter the ask for reason counter
 * @param progress the progress
 * @param interviewPlace the interview place
 * @param confirmedInterview the confirmed interview
 * @param askInterviewDate the ask interview date
 * @param passedInterviewMessageDate the passed interview message date
 * @param interviewDateShop the interview date shop
 * @param candidate the candidate
 * @param shop the shop
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
@Table(name = "shop_candidate_relation")
public class ShopCandidateRelation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The shop candidate relation PK. */
	@EmbeddedId
	private ShopCandidateRelationPK shopCandidateRelationPK;

	/** The ask interview counter. */
	@Column(columnDefinition = "int default 0")
	private int askInterviewCounter;

	/** The passed interview message counter. */
	@Column(columnDefinition = "int default 0")
	private int passedInterviewMessageCounter;

	/** The remind interview counter. */
	@Column(columnDefinition = "int default 0")
	private int remindInterviewCounter;

	/** The ask for reason counter. */
	@Column(columnDefinition = "int default 0")
	private int askForReasonCounter;

	/** The progress. */
	private String progress;

	/** The interview place. */
	private String interviewPlace;

	/** The confirmed interview. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean confirmedInterview;

	/** The ask interview date. */
	private Date askInterviewDate;

	/** The passed interview message date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date passedInterviewMessageDate;

	/** The interview date shop. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date interviewDateShop;

	/** The candidate. */
	@ManyToOne
	@JoinColumn(name = "idCandidate", referencedColumnName = "id_user", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "shopCandidateRelations, jobCandidateRelations", "shop", "jobs", "staffs" })
	private Candidate candidate;

	/** The shop. */
	@ManyToOne
	@JoinColumn(name = "idShop", referencedColumnName = "id_Shop", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "shopCandidateRelations, jobCandidateRelations", "candidate", "jobs", "staffs" })
	private Shop shop;

}
