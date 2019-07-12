package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class CandidateAdminRelationPK.
 */
@Embeddable

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
 * Class Name: CandidateAdminRelationPK.java
 * 
 * Instantiates a new candidate admin relation PK.
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
 * Class Name: CandidateAdminRelationPK.java
 * 
 * Instantiates a new candidate admin relation PK.
 * @param idCandidate the id candidate
 * @param idAdmin the id admin
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
public class CandidateAdminRelationPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id candidate. */
	private int idCandidate;

	/** The id admin. */
	private int idAdmin;

}
