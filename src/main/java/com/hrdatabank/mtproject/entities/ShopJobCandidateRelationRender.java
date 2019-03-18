package com.hrdatabank.mtproject.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class ShopJobCandidateRelationRender.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ShopJobCandidateRelationRender {

	/** The shop. */
	private Shop shop;

	/** The apply count. */
	private int applyCount;

}
