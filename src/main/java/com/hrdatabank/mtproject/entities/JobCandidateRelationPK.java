package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class JobCandidateRelationPK.
 */
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class JobCandidateRelationPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id job. */
	private int idJob;

	/** The id candidate. */
	private int idCandidate;

}
