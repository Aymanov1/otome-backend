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

/**
 * The Class ShopCandidateRelation.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
	@JoinColumn(name = "idShop", referencedColumnName = "idShop", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "shopCandidateRelations, jobCandidateRelations", "candidate", "jobs", "staffs" })
	private Shop shop;

}
