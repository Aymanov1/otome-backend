package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class CandidateAdminRelationPK.
 */
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateAdminRelationPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id candidate. */
	private int idCandidate;

	/** The id admin. */
	private int idAdmin;

}
