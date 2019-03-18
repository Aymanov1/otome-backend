package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class ShopCandidateRelationPK.
 */
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopCandidateRelationPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id shop. */
	private int idShop;

	/** The id candidate. */
	private int idCandidate;

}
