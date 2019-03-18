package com.hrdatabank.mtproject.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Embeddable
@Builder
@Data
public class JobTagRelationPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The id job. */
	private int idJob;

	/** The id tag. */
	private int idTag;

}
