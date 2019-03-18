package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class StaffShopRelationPK.
 */
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StaffShopRelationPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id shop. */
	private int idShop;

	/** The id staff. */
	private int idStaff;

}
