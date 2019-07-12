package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Memo.
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
 * Class Name: Memo.java
 * 
 * Instantiates a new memo.
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
 * Class Name: Memo.java
 * 
 * Instantiates a new memo.
 * @param idMemo the id memo
 * @param memoText the memo text
 * @param memoDate the memo date
 * @param candidateAdminRelation the candidate admin relation
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
public class Memo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id memo. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMemo;

	/** The memo text. */
	private String memoText;

	/** The memo date. */
	private Date memoDate;

	/** The candidate admin relation. */
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "idCandidate", referencedColumnName = "idCandidate"),
			@JoinColumn(name = "idAdmin", referencedColumnName = "idAdmin") })
	@JsonIgnoreProperties({ "memos" })
	CandidateAdminRelation candidateAdminRelation;

}
